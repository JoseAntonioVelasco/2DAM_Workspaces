/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;
import java.sql.*;
/**
 *
 * @author Jose Antonio Velasco
 * 
 * - (‘78901234X’,’NADALES’,’44126’)
- (‘89012345E’,’ROJAS’,null)
- (‘56789012B’,’SAMPER’,’29730’)
 */
public class Practica_AD_2_1 {
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
            
            int nFil = s.executeUpdate("DELETE FROM CLIENTES WHERE dni = '09876543K';");
            s.executeUpdate("UPDATE clientes SET apellidos = 'ROJAS' WHERE dni = '89012345E';");
            //borrar lamiquiz
            //update hojas a rojas
            System.out.println(nFil + " Filas borradas");
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    } 
}
