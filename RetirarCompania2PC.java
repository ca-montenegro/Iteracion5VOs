package jms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;


import vos.VOFuncion;
import vos.VORentabilidad;

public class TwoPhaseCommit {

	Hashtable<String, String> env;
	InitialContext context;
	DataSource ds1;
	DataSource ds2;
	DataSource ds3;
	Connection conn1;
	Connection conn2;
	Connection conn3;

	public TwoPhaseCommit() throws NamingException {
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

			try {
				
				Statement st=conn2.createStatement();
				String sql = "UPDATE COMPANIA_TEATRO SET ESTADO = 0";
				sql += " WHERE ID = " + idCompania;
				System.out.println(sql);
				int num=st.executeUpdate(sql);
				System.out.println("Se modificaron "+num+" tuplas-ConexiÃ³n 2");
				st.close();

				String sql2 = "SELECT * FROM BOLETA BOL INNER JOIN (SELECT * FROM (SELECT ID AS IDFUN  FROM(SELECT ID_ESPECTACULO FROM COMPANIA_ESPECTACULO E WHERE E.ID_COMPANIA = 1) "
						+ "NATURAL JOIN FUNCION E)IDFUN ) ON BOL.ID_FUNCION= IDFUN";
				Statement prepStmt2 = conn2.createStatement();
				ResultSet rs =prepStmt2.executeQuery(sql2);
				System.out.println(sql2);
				try{
					while (rs.next()) {
						long codigo = 1;
						long idLocalidad = rs.getLong("ID_LOCALIDAD");
						long idUbicacion = rs.getLong("UBICACION");
						long idFuncion = rs.getLong("ID_FUNCION");
						long idCliente = rs.getLong("ID_CLIENTE");

						String sql3 = "UPDATE BOLETA SET ESTADO = 3";
						sql3 += " WHERE UBICACION ='" + idUbicacion+"'";
						sql3 += " AND ID_LOCALIDAD = " + idLocalidad;
						sql3 += " AND ID_FUNCION = " + idFuncion;

						Statement prepStmt3 = conn2.createStatement();
						
						prepStmt3.executeQuery(sql3);
						prepStmt3.close();
					}
				} catch (SQLException e) {
				utx.setRollbackOnly();
			}
		}catch (SQLException e) {
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
		
	}

	
	public List<VOFuncion> getFunciones() {
		List<VOFuncion> funciones = new ArrayList<VOFuncion>();
		
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
					VOFuncion funcion = new VOFuncion();
					funcion.setId(Long.parseLong(result.getString("FID")));
					funcion.setNombreEspectaculo(result.getString("ENOMBRE"));
					funcion.setFecha((result.getString("FFECHA")));
					
					funcion.setNombreSitio( result.getString("SNOMBRE"));

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
				String sql="select id_compa, id_funcion from compania natural join"
						+ "(select * from funcion inner join espectaculo on "
						+ "funcion.id_espectaculo  = espectaculo.id_espec) where id_compa = " + idCompania;
				System.out.println(sql);
				ResultSet rst = st.executeQuery(sql);
				int num = 0;
				while (rst.next())
				{
					Long idFuncion = Long.parseLong(rst.getString("id_funcion"));

					ArrayList<String> idsBoletas = new ArrayList<>();

					String sql2 = "select * from boleta where id_funcion = " + idFuncion + " order by id_boleta";
					System.out.println("SQL stmt: " + sql2);

					ResultSet rs = st.executeQuery(sql2);
					while(rs.next())
					{
						Long idBoleta = Long.parseLong(rs.getString("ID_BOLETA"));
						Long idCliente = Long.parseLong(rs.getString("ID_CLIENTE"));
						idsBoletas.add(idBoleta + ","+idCliente);	
					}
					for(String idBoletaCliente: idsBoletas)
					{
						Long idBoleta = Long.parseLong(idBoletaCliente.split(",")[0]);
						Long idUsuario = Long.parseLong(idBoletaCliente.split(",")[1]);
						String sql3 = "update boleta set estado = 'D' where id_boleta = "+idBoleta;
						System.out.println("SQL stmt: "+ sql3);

						st.executeUpdate(sql3);
						String sql4 = "insert into devolucion values((devolucion_seq2.nextval), "  + idBoleta + "," + idUsuario +")";
						String key[] = {"ID_DEVOLUCION"};
						Statement prepStmt2 = conn3.prepareStatement(sql4,key);
						prepStmt2.executeUpdate(sql4);
						System.out.println("SQL stmt:" + sql4);
						ResultSet rsInsert = prepStmt2.getGeneratedKeys();
						Long idDevolucion = null;
						if (rsInsert.next()) {
							idDevolucion = rsInsert.getLong(1);
							System.out.println(idDevolucion);
							num++;
						}

					}
				}
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
	
	public List<VORentabilidad> consultarRentabilidad(String nombreCompania) {
		List<VORentabilidad> rentabilidad = new ArrayList<VORentabilidad>();
		
		try {
			UserTransaction utx = (UserTransaction) context.lookup("/UserTransaction");
			try{
			iniciarConexiones();
			utx.begin();
			
			
			
			try {
				Statement st=conn1.createStatement();
				
				String sql = "";
				VORentabilidad consul= new VORentabilidad();

				sql = "SELECT ID, NOMBRE FROM COMPANIASTEATRO WHERE NOMBRE="+nombreCompania;
				System.out.println(sql);

				ResultSet res = st.executeQuery(sql);
				
				if(!res.next())throw new Exception("La compa��a especificada no existe");
				
				Long id=res.getLong("ID");
				

				sql = "SELECT E.ID, E.NOMBRE, COUNT(VENDIDO) AS ASISTOT "
						+"FROM (((COMPANIASTEATRO C INNER JOIN PRESENTAN P ON C.ID=P.IDCOMPANIA)"
						+"INNER JOIN ESPECTACULOS E ON P.IDESPECTACULO=E.ID) "
						+"INNER JOIN FUNCIONES F ON E.ID=F.IDESPECTACULO) "
						+"INNER JOIN BOLETAS B ON B.IDFUNCION = F.ID WHERE VENDIDO='Y' AND C.ID= "+id.toString()
						+" GROUP BY (E.ID,E.NOMBRE) ORDER BY E.ID";
				
				System.out.println(sql);				
				ResultSet asisTotal = st.executeQuery(sql);

				sql = "SELECT E.ID, E.NOMBRE, COUNT(VENDIDO) AS REGISTRADOS "
						+"FROM (((COMPANIASTEATRO C INNER JOIN PRESENTAN P ON C.ID=P.IDCOMPANIA)"
						+"INNER JOIN ESPECTACULOS E ON P.IDESPECTACULO=E.ID) "
						+"INNER JOIN FUNCIONES F ON E.ID=F.IDESPECTACULO) "
						+"INNER JOIN BOLETAS B ON B.IDFUNCION = F.ID WHERE VENDIDO='Y' AND B.IDUSUARIO IS NOT NULL AND C.ID = "+id.toString()
						+" GROUP BY (E.ID,E.NOMBRE)ORDER BY E.ID";
				
				System.out.println(sql);
				ResultSet asisRegistrados = st.executeQuery(sql);

				sql = "SELECT E.ID, E.NOMBRE, SUM(PRECIO) AS GENERADO "
						+"FROM ((((COMPANIASTEATRO C INNER JOIN PRESENTAN P ON C.ID=P.IDCOMPANIA)"
						+"INNER JOIN ESPECTACULOS E ON P.IDESPECTACULO=E.ID)" 
						+"INNER JOIN FUNCIONES F ON E.ID=F.IDESPECTACULO)" 
						+"INNER JOIN BOLETAS B ON B.IDFUNCION = F.ID)"
						+"INNER JOIN LOCALIDADES L ON L.ID=B.IDLOCALIDAD WHERE VENDIDO='Y' AND C.ID = "+id.toString()
						+" GROUP BY (E.ID, E.NOMBRE)ORDER BY E.ID";
			
				System.out.println(sql);
				ResultSet generado = st.executeQuery(sql);

				sql = "CREATE VIEW TOTAL AS (SELECT E.ID, E.NOMBRE AS NOMESP, S.ID AS IDSITIO, S.NOMBRE, B.VENDIDO "
						+"FROM (((((COMPANIASTEATRO C INNER JOIN PRESENTAN P ON C.ID=P.IDCOMPANIA)"
						+"INNER JOIN ESPECTACULOS E ON P.IDESPECTACULO=E.ID))"
						+"INNER JOIN FUNCIONES F ON E.ID=F.IDESPECTACULO)"
						+"INNER JOIN BOLETAS B ON B.IDFUNCION = F.ID) " 
						+"INNER JOIN SITIOS S ON S.ID=F.IDSITIO WHERE C.ID = "+id.toString()+")";
				
				System.out.println(sql);
				st.executeUpdate(sql);

				sql = "SELECT TOTAL.ID, TOTAL.IDSITIO,TOTAL.NOMESP, TOTAL.NOMBRE, "
						+"(COUNT(VENDIDO)/(CASE WHEN (SELECT COUNT(*) FROM TOTAL)=0 THEN 1 "
						+"ELSE (SELECT COUNT(*) FROM TOTAL) END)) AS PORCENTAJE FROM TOTAL WHERE VENDIDO='Y' " 
						+"GROUP BY (TOTAL.ID, TOTAL.IDSITIO,TOTAL.NOMESP, TOTAL.NOMBRE)ORDER BY TOTAL.ID ";

				System.out.println(sql);
				ResultSet porcentaje = st.executeQuery(sql);

				sql = "DROP VIEW TOTAL";
				
				System.out.println(sql);
				st.executeUpdate(sql);

				while(asisTotal.next()){
					espectaculo.setId(asisTotal.getLong("ID"));
					espectaculo.setNombre(asisTotal.getString("NOMBRE"));
					espectaculo.setAsistTotal(asisTotal.getInt("ASISTOT"));

					if(!asisRegistrados.next())throw new Exception("Something went wrong");
					espectaculo.setAsistRegistrados(asisRegistrados.getInt("REGISTRADOS"));

					if(!generado.next())throw new Exception("Something went wrong");
					espectaculo.setDineroRecaudado(generado.getDouble("GENERADO"));

					consul.addEspectaculo(espectaculo);
				}

				List<CompaniaEspectaculo> esp = consul.getEspectaculos();
				int i = 0;
				while(porcentaje.next())
				{
					if(esp.get(i).getNombre().equals(porcentaje.getString("NOMESP")))
						esp.get(i).addSitio(new CompaniaSitio(porcentaje.getLong("IDSITIO"),porcentaje.getString("NOMBRE"),porcentaje.getDouble("PORCENTAJE")));
					else if(esp.get(++i).getNombre().equals(porcentaje.getString("NOMESP")))
						esp.get(i).addSitio(new CompaniaSitio(porcentaje.getLong("IDSITIO"),porcentaje.getString("NOMBRE"),porcentaje.getDouble("PORCENTAJE")));
					else throw new Exception("Something went wrong");
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
		
		return rentabilidad;
		
	}
	
	private void cerrarConexiones() throws SQLException {
		conn1.close();
		conn2.close();
		conn3.close();
		
	}

}
