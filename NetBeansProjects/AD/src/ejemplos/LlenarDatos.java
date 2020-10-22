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
public class LlenarDatos {
     public static void muestraErrorSQL(SQLException e){
        System.err.println("SQL ERROR mensaje: "+e.getMessage());
        System.err.println("SQL Estado: "+e.getSQLState());
        System.err.println("SQL codigo especifico: "+e.getErrorCode());
    }
       public static void main(String[] args){
        String basedatos  = "ventas";
        String host = "localhost";
        String port = "3306";
        String info = "";
        String urlConnection = "jdbc:mysql://" +host+ ":" +port +"/" +basedatos + info;
        String user = "root";
        String pwd = "root";
        
        try(
            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
            Statement s = c.createStatement()){
            
            int nFil = s.executeUpdate("INSERT INTO CLIENTES (DNI,APELLIDOS,CP) VALUES "
            +"('78901234X','NADALES','44126'),"
            +"('89012345E','HOJAS',null),"
            +"('56789012B','SAMPER','29730'),"
            +"('09876543K','LAMIQUIZ',null);");
            
            System.out.println(nFil + " Filas insertadas");
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    } 
}
