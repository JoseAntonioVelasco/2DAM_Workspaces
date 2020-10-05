package academia.modelo.accesoADatos;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase encargada de hacer la conexion con la base de datos.
 * @author Raul Rubio
 */
public class Conectar {
    
    public static Connection conn;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/academia";
    
    public Conectar(){
        conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexion establecida");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar" + e);
        }
    }
    public Connection getConexion (){
        return conn;
    }
    
    public void desconectar(){
        conn = null;
        if (conn == null){
            System.out.println("Conexion terminada");
        }
    }
}
