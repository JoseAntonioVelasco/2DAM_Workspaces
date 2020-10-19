/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbbdd;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class CreacionBBDD {
    static final String DRIVER_JDBC="com.mysql.jdbc.Driver";
    static final String URL_DB="jdbc:mysql://localhost";
    
    static final String USUARIO="root";
    static final String PASSWORD="root";
    
    public static void main(String[] args) throws SQLException{
        Connection c = null;
        Statement s = null;
        
        c = DriverManager.getConnection(URL_DB, USUARIO, PASSWORD);
        s = c.createStatement();
        // s.executeUpdate("SET GLOBAL time_zone = '+2:00'");
        
        String consultaSQL ="create database ventas";
         
        s.executeUpdate(consultaSQL);
        
        s.close();
        c.close();
    }
}
