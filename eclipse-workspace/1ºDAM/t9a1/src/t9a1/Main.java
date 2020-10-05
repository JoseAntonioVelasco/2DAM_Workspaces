package t9a1;

import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			realizarEjemplo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void realizarEjemplo() throws Exception{
		Conectar dao = new Conectar();
		ResultSet resultSet = null;
		try {
			 resultSet = dao.getStatement().executeQuery("select * from profes");
			
			while(resultSet.next()) {
				for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++) {
					System.out.print(resultSet.getString(i)+" | ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Error al realizar la consulta: "+e.getLocalizedMessage());
		} finally {
			try {
				dao.cerrarConexion(resultSet, dao.getConnect(), dao.getStatement());
			}catch(Exception e) {
				System.out.println("Error al cerrar las conexiones: "+e.getLocalizedMessage());
			}
		}
	}

}
