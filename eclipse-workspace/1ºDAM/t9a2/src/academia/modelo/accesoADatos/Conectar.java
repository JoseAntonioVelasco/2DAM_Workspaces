package academia.modelo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conectar {
	final private String driver = "com.postgresql.cj.jdbc.Driver";
	final private String host = "localhost";
	final private String user = "postgres";
	final private String passwd = "qwerty";
	private Connection connect;
	private Statement statement;
	
	public Conectar() {
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection("jdbc:postgresql://"+host+"progt9a2"+"user="+user+"&password="+passwd);
			statement = connect.createStatement();
		}catch(Exception e) {
			System.out.println("Error al crear la conexion: "+e.getLocalizedMessage());
		}
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	public void cerrarConexion(ResultSet resulSet,Connection connect, Statement statement) {
		try {
			if(resulSet != null) {
				resulSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}

	
}