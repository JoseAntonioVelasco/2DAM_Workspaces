package alarmAPP.modelo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 
 *Clase que sirve para conectar a cualquier base de datos de postgresql,
 *por defecto en los atributos host, user y passwd viene: localhost postgres y qwerty,
 *para conectarte a tu base de datos sera necesario cambiar esos datos por los que tu tengas
 */
public class Conectar {
	final private String driver = "org.postgresql.Driver";
	final private String host = "localhost"; //aqui seria como se llame tu host
	final private String user = "postgres"; //  "	"	" 	"	"	"	"	user
	final private String passwd = "qwerty"; //	"	"	"	"	"	"	" contraseña
	private Connection connect;
	private Statement statement;
	
	public Conectar() {
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection("jdbc:postgresql://"+host+"/"+"fase4?"+"user="+user+"&password="+passwd);
			
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