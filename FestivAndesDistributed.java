package dtm;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.QueueConnectionFactory;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.rabbitmq.jms.admin.RMQConnectionFactory;

import jms.AllAbonamientosMDB;
import jms.GetFuncionesMDB;
import jms.NonReplyException;
import jms.RetirarCompaniaMDB;
import tm.FestivAndesMaster;
import vos.Funcion;
import vos.VOAbonamiento;
import vos.VOBoleta;
import vos.VOFuncion;

public class FestivAndesDistributed {
	private final static String QUEUE_NAME = "java:global/RMQAppQueue";
	private final static String MQ_CONNECTION_NAME = "java:global/RMQClient";

	private static FestivAndesDistributed instance;

	private FestivAndesMaster tm;

	private QueueConnectionFactory queueFactory;

	private TopicConnectionFactory factory;

	private RetirarCompaniaMDB retirarMQ;
	
	private GetFuncionesMDB getFuncionesMQ;
	
	private AllAbonamientosMDB allAbonamientosMQ;

	private static String path;

	private FestivAndesDistributed() throws NamingException, JMSException {
		InitialContext ctx = new InitialContext();
		factory = (RMQConnectionFactory) ctx.lookup(MQ_CONNECTION_NAME);
		retirarMQ = new RetirarCompaniaMDB(factory, ctx);
		retirarMQ.start();
		
		getFuncionesMQ=new GetFuncionesMDB(factory, ctx);
		retirarMQ.start();
		
		allAbonamientosMQ = new AllAbonamientosMDB(factory, ctx);
		allAbonamientosMQ.start();

	}

	public void stop() throws JMSException {
		retirarMQ.close();
	}

	/**
	 * MÃ©todo que retorna el path de la carpeta WEB-INF/ConnectionData en el
	 * deploy actual dentro del servidor.
	 * 
	 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
	 */
	public static void setPath(String p) {
		path = p;
	}

	public void setUpTransactionManager(FestivAndesMaster tm) {
		this.tm = tm;
	}

	private static FestivAndesDistributed getInst() {
		return instance;
	}

	public static FestivAndesDistributed getInstance(FestivAndesMaster tm) {
		if (instance == null) {
			try {
				instance = new FestivAndesDistributed();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (JMSException e) {
				
				e.printStackTrace();
			}
		}
		instance.setUpTransactionManager(tm);
		return instance;
	}

	public static FestivAndesDistributed getInstance() {
		if (instance == null) {
			FestivAndesMaster tm = new FestivAndesMaster(path);
			return getInstance(tm);
		}
		if (instance.tm != null) {
			return instance;
		}
		FestivAndesMaster tm = new FestivAndesMaster(path);
		return getInstance(tm);
	}
	/*
	 * public ListaVideos getLocalVideos() throws Exception { return
	 * tm.darVideosLocal(); }
	 * 
	 * public ListaVideos getRemoteVideos() throws JsonGenerationException,
	 * JsonMappingException, JMSException, IOException, NonReplyException,
	 * InterruptedException, NoSuchAlgorithmException { return
	 * allVideosMQ.getRemoteVideos(); }
	 * 
	 */

	

	public void retirarCompaniaLocal(Long idCompania) throws Exception {
		tm.retirarCompania(idCompania);
	}

	public void retirarCompaniaGlobal(Long idCompania) throws Exception {
		
		retirarMQ.retirar(idCompania);
	}

	public List<VOFuncion> getFuncionesLocal() throws SQLException{
		List<Funcion> funciones = tm.getFunciones(null, null, null, null, null, null, null);
		List<VOFuncion> ret= new ArrayList<VOFuncion>();
		for (Iterator iterator = funciones.iterator(); iterator.hasNext();) {
			Funcion funcion = (Funcion) iterator.next();
			VOFuncion Vfuncion = new VOFuncion();
			Vfuncion.setFecha(funcion.getFecha());
			Vfuncion.setId(funcion.getId());
			Vfuncion.setNombreEspectaculo(funcion.getEspectaculo().getNombre());
			Vfuncion.setNombreSitio(funcion.getSitio().getNombre());
			ret.add(Vfuncion);
		}
		return ret;
	}
	public List<VOFuncion> getFuncionesGlobal() throws JsonGenerationException, JsonMappingException, NoSuchAlgorithmException, JMSException, IOException, NonReplyException, InterruptedException, SQLException{
		
		List<VOFuncion> funciones =getFuncionesMQ.getFunciones();
		return funciones;
		
	}
	
	public ArrayList<VOBoleta> getAbonamientosGlobal(VOAbonamiento abonamiento) {
		// TODO Auto-generated method stub
		ArrayList<VOBoleta> res = new ArrayList<>();
		try {
			res = allAbonamientosMQ.getRemoteAbonamiento(abonamiento);
		} catch (NoSuchAlgorithmException | JMSException | IOException | NonReplyException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public  ArrayList<VOBoleta> getLocalAbonamientos(Long idUsuario, VOAbonamiento abonamiento) throws Exception
	{
		return tm.crearAbonamientoGlobal(idUsuario, abonamiento);
	}


	
	
	}
