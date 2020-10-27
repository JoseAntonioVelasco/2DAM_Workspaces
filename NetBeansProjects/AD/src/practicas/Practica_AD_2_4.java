/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;
import java.sql.*;
/**
 *
 * @author JoseAntonioVelasco
 */
public class Practica_AD_2_4 {
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
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
            
            
            ResultSet rs = s.executeQuery("SELECT * FROM CLIENTES");
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("DNI: "+rs.getString("DNI"));
                System.out.println("Apellidos: "+rs.getString("APELLIDOS"));
                System.out.println("CP: "+rs.getString("CP"));
            }
            
           
            System.out.println("------Al reves---------");
            ResultSet rs1 = s.executeQuery("SELECT * FROM CLIENTES ");
            
            rs1.last();
            int i1 = 1;
            while(rs1.previous()){
                if(i1==1){/*Resuelto de manera sucia pero valida*/
                    rs1.last();
                }
                System.out.println("[" +(i1++) +"]");
                System.out.println("DNI: "+rs1.getString("DNI"));
                System.out.println("Apellidos: "+rs1.getString("APELLIDOS"));
                System.out.println("CP: "+rs1.getString("CP"));
            }
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
}
