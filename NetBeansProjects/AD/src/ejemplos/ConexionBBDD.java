/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;
import java.sql.*;


/**
 *
 * @author ADMIN
 */
public class ConexionBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String basedatos  = "ventas";
        String host = "localhost";
        String port = "3306";
        String info = "";
        String urlConnection = "jdbc:mysql://" +host+ ":" +port +"/" +basedatos + info;
        String user = "root";
        String pwd = "root";
        
        try(Connection c = DriverManager.getConnection(urlConnection, user, pwd)){
            System.out.println("Conexion realizada");
            
        }catch(SQLException e){
            System.out.println("SQL mensaje: "+e.getMessage());
            System.out.println("SQL Estado: "+e.getSQLState());
            System.out.println("SQL codigo especifico: "+e.getErrorCode());
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    
}