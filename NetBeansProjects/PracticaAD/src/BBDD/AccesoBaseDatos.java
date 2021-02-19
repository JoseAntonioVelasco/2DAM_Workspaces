package BBDD;

import DAO.*;
import DTO.*;
import java.io.Serializable;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoBaseDatos implements Serializable{
    static String urlConnection="jdbc:mysql://localhost:3306/prueba_componente";
    static String usuario="root";
    static String contra="root";
    static Connection conexion;
    
    public AccesoBaseDatos(){
        try {
            this.conexion = DriverManager.getConnection(urlConnection,usuario,contra);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConexion(){
        return AccesoBaseDatos.conexion;
    }
    
    public static void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
