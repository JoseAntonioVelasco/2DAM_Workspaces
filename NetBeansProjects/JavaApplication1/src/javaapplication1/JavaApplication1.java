/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.*;

/**
 *
 * @author cagan
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws SQLException{
        String basedatos = "ventas"; String host = "localhost";
        String port="3306"; String user="root"; String pwd="root";
        String urlConnection = "jdbc:mysql://" +host+ ":" +port +"/" +basedatos;
        Connection c = DriverManager.getConnection(urlConnection, user, pwd);
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM CLIENTES");
        
        Statement s1 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        c.setAutoCommit(false); rs.last(); c.commit();
        
        PreparedStatement sInsert = c.prepareStatement("SELECT * FROM Clientes WHERE apellidos = ?");
            
         
            
      
    } 
    
}
