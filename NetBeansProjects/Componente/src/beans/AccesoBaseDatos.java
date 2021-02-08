package beans;

import java.sql.*;
import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JoseAntonioVelasco
 */
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
    
    public void insertaProducto(Producto p){
        String sql = "INSERT INTO producto VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(2, p.getDescripcion());
            ps.setInt(1, p.getIdProducto());
            ps.setInt(3, p.getStockActual());
            ps.setInt(4, p.getStockMinimo());
            ps.setFloat(5, p.getPvp());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
