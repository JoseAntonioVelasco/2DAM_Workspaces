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
public class Practica_AD_2_2 {
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
        
        try{
            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
            Statement s = c.createStatement();
            
            
            ResultSet rs1 = s.executeQuery("SELECT * FROM CLIENTES WHERE cp='44126'");
            
            int i1 = 1;
            while(rs1.next()){
                System.out.println("[" +(i1++) +"]");
                System.out.println("DNI: "+rs1.getString("DNI"));
                System.out.println("Apellidos: "+rs1.getString("APELLIDOS"));
                System.out.println("CP: "+rs1.getString("CP"));
            }
            
            ResultSet rs2 = s.executeQuery("SELECT * FROM CLIENTES WHERE cp='29730'");
            
            int i2 = 1;
            while(rs2.next()){
                System.out.println("[" +(i2++) +"]");
                System.out.println("DNI: "+rs2.getString("DNI"));
                System.out.println("Apellidos: "+rs2.getString("APELLIDOS"));
                System.out.println("CP: "+rs2.getString("CP"));
            }
            
            ResultSet rs3 = s.executeQuery("SELECT * FROM CLIENTES WHERE cp='null'");
            
            int i3 = 1;
            while(rs3.next()){
                System.out.println("[" +(i3++) +"]");
                System.out.println("DNI: "+rs3.getString("DNI"));
                System.out.println("Apellidos: "+rs3.getString("APELLIDOS"));
                System.out.println("CP: "+rs3.getString("CP"));
            }
            
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    } 
}