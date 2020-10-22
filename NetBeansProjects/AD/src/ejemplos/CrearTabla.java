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
public class CrearTabla {
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
            s.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL,"
            +" APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5),"
            +" PRIMARY KEY (DNI));");
            
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
}
