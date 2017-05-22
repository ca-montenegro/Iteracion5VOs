package jms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

public class RetirarCompania2PC {

	Hashtable<String, String> env;
	InitialContext context;
	DataSource ds1;
	DataSource ds2;
	DataSource ds3;
	Connection conn1;
	Connection conn2;
	Connection conn3;

	public RetirarCompania2PC() throws NamingException {
		env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jmp.interfaces");
		context = new InitialContext(env);
		

	}
	
	public void iniciarConexiones() throws NamingException, SQLException{
		ds1 = (DataSource) context.lookup("java:XAChie1");
		ds2 = (DataSource) context.lookup("java:XAChie2");
		ds3 = (DataSource) context.lookup("java:XAChie3");
		conn1 = ds1.getConnection();
		conn2=ds2.getConnection();
		conn3=ds3.getConnection();
	}

	public void RetirarCompania(Long idCompania) {
		try {
			UserTransaction utx = (UserTransaction) context.lookup("/UserTransaction");
			try{
			iniciarConexiones();
			utx.begin();
			
			
				/*
				*Primera conexión con l bd 1
				*/
			
			try {
				Statement st=conn1.createStatement();
				
				int num=0;
				
				String sql="SELECT F.ID FROM COMPANIASTEATRO JOIN PRESENTAN P ON (C.ID=P.IDCOMPANIA) "
						+ "JOIN ESPECTACULOS E ON (E.ID=P.IDESPECTACULO) "
						+ "JOIN FUNCIONES F ON F.IDESPECTACULO=E.ID "
						+ "WHERE C.ID="+idCompania;
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
				Long id=rs.getLong("ID");
				
				sql="SELECT B.ID AS ID, B.IDUSUARIO, B.IDABONAMIENTO, L.PRECIO FROM BOLETAS B JOIN LOCALIDADES L ON B.IDLOCALIDAD=L.ID WHERE idFuncion="+id;
				 rs = st.executeQuery(sql);
				
	
				boolean exist=false;
				while(rs.next()){
					exist=true;
					if(rs.getString("IDUSUARIO")!=null &&  rs.getString("IDUSUARIO")!="NULL"){
						if(rs.getString("IDABONAMIENTO")!="NULL"){
							sql="INSERT INTO CERTIFICADOSDEDEVOLUCION (ID,IDUSUARIO,IDBOLETA,VALOR) VALUES (IDCERTIFICADOSDEDEVOLUCION.NEXTVAL,"+rs.getString("IDUSUARIO")+  ",NULL,"+(rs.getDouble("PRECIO")*0.8)+" )";

						}
						else{
							sql="INSERT INTO CERTIFICADOSDEDEVOLUCION (ID,IDUSUARIO,IDBOLETA,VALOR) VALUES (IDCERTIFICADOSDEDEVOLUCION.NEXTVAL,"+rs.getString("IDUSUARIO")+  ",NULL,"+(rs.getString("PRECIO"))+" )";

						}
						System.out.println(sql);
						num+=st.executeUpdate(sql);
					}

				}
				if (!exist) throw new Exception("La funci�n no existe o ya fue realizada.");
				sql="DELETE FROM BOLETAS WHERE idFuncion="+id;
				System.out.println(sql);
				num+=st.executeUpdate(sql);

				sql="DELETE FROM FUNCIONES WHERE id="+id;
				System.out.println(sql);
				
				num+=st.executeUpdate(sql);
				
				}
				
				sql="DELETE FROM COMPANIASTEATRO WHERE ID="+idCompania;
				System.out.println(sql);
				num+=st.executeUpdate(sql);
		
				System.out.println("Se modificaron "+num+" tuplas-Conexión 1");
				st.close();
	
				
			} catch (SQLException e) {
				utx.setRollbackOnly();
			}
				/*
				*Segunda conexión con la bd 2
				*/

			try {
				Statement st=conn2.createStatement();
				String sql="";
				System.out.println(sql);
				int num=st.executeUpdate(sql);
				System.out.println("Se modificaron "+num+" tuplas-Conexión 2");
				st.close();
				
			} catch (SQLException e) {
				utx.setRollbackOnly();
			}

				/*
				*Tercera conexión con la bd 3
				*/
			try {
				Statement st=conn3.createStatement();
				String sql="";
				System.out.println(sql);
				int num=st.executeUpdate(sql);
				System.out.println("Se modificaron "+num+" tuplas-Conexión 3");
				st.close();
				
			} catch (SQLException e) {
				utx.setRollbackOnly();
			}
			
			utx.commit();
			cerrarConexiones();
			
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public List<Funcion> getFunciones() {
		List<Funcion> funciones = new ArrayList<Funcion>();
		
		try {
			UserTransaction utx = (UserTransaction) context.lookup("/UserTransaction");
			try{
			iniciarConexiones();
			utx.begin();
			
			
			
			try {
				Statement st=conn1.createStatement();
				
				int num=0;
				
				String sql="SELECT F.ID AS FID, E.ID AS EID, E.NOMBRE AS ENOMBRE, E.DURACION AS EDURACION,E.IDIOMA AS EIDIOMA, E.COSTO AS ECOSTO, E.DESCRIPCION AS EDESCRIPCION, "
						+ "F.FECHA AS FFECHA, F.REALIZADO AS FREALIZADO, S.ID AS SID, S.NOMBRE AS SNOMBRE, S.ABIERTO AS SABIERTO "
						+ " FROM (FUNCIONES F LEFT JOIN ESPECTACULOS E ON (F.IDESPECTACULO=E.ID) "
						+ "LEFT JOIN PRESENTAN PRE ON PRE.IDESPECTACULO=E.ID "
						+ "LEFT JOIN COMPANIASTEATRO C ON PRE.IDCOMPANIA=C.ID "
						+ "LEFT JOIN REQUIERE REQ ON REQ.IDESPECTACULO=E.ID "
						+ "LEFT JOIN REQUERIMIENTOSTECNICOS R ON REQ.IDREQUERIMIENTO=R.ID "
						+ "LEFT JOIN HACEPARTE H ON H.IDESPECTACULO= E.ID "
						+ "LEFT JOIN CATEGORIAs CAT ON CAT.ID=H.IDCATEGORIA "
						+ "LEFT JOIN SITIOS S ON S.ID=F.IDSITIO "
						+ "LEFT JOIN ESPARA ON ESPARA.IDSITiO=S.ID "
						+ "LEFT JOIN APTOS ON APTOS.ID=ESPARA.IDAPTOS) ";
				ResultSet result = st.executeQuery(sql);
				while (result.next()){
					Funcion funcion = new Funcion();
					funcion.setId(Long.parseLong(result.getString("FID")));
					funcion.setEspectaculo(new Espectaculo(Long.parseLong(result.getString("EID")),result.getString("ENOMBRE"), Integer.parseInt(result.getString("EDURACION")),  result.getString("EIDIOMA"),  Double.parseDouble(result.getString("ECOSTO")),  result.getString("EDESCRIPCION"), null,  null,  null));
					funcion.setFecha((result.getString("FFECHA")));
					funcion.setRealizado(result.getString("FREALIZADO")=="V");
					funcion.setSitio(new Sitio( Long.parseLong(result.getString("SID")), result.getString("SNOMBRE"), result.getString("SABIERTO")=="V", null, null, null, null, null, null, null, null));

					funciones.add(funcion);
				}
				
				
				st.close();
	
				
			} catch (SQLException e) {
				utx.setRollbackOnly();
			}

			try {
				Statement st=conn2.createStatement();
				String sql="";
				System.out.println(sql);
				int num=st.executeUpdate(sql);
				System.out.println("Se modificaron "+num+" tuplas-Conexión 2");
				st.close();
				
			} catch (SQLException e) {
				utx.setRollbackOnly();
			}

			try {
				Statement st=conn3.createStatement();
				String sql="";
				System.out.println(sql);
				int num=st.executeUpdate(sql);
				System.out.println("Se modificaron "+num+" tuplas-Conexión 3");
				st.close();
				
			} catch (SQLException e) {
				utx.setRollbackOnly();
			}
			
			utx.commit();
			cerrarConexiones();
			
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		
		return funciones;
		
	}

	private void cerrarConexiones() throws SQLException {
		conn1.close();
		conn2.close();
		conn3.close();
		
	}

}
