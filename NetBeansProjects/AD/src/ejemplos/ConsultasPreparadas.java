/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author JoseAntonioVelasco
 */
public class ConsultasPreparadas {
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
        
        //Intento de SQL injection
        
        //SELECT * FROM Clientes WHERE apellidos = "" or "1" = "1"; esta es la query que voy a intentar
        try(
            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
            PreparedStatement sInsert = c.prepareStatement("SELECT * FROM Clientes WHERE apellidos = ?")){
            
            System.out.println("(PreparedStatement)Que cliente quieres buscar (busca por apellido): ");
            Scanner sc = new Scanner(System.in);
            //Si introducimos eso deberia de mostrar todos los clientes
            //" or "1" = "1
            //' or '1' = '1
            String apellido = sc.nextLine();
            
            sInsert.setString(1, apellido);
            
   
            ResultSet rs=sInsert.executeQuery();
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("DNI: "+rs.getString("DNI"));
                System.out.println("Apellidos: "+rs.getString("APELLIDOS"));
                System.out.println("CP: "+rs.getString("CP"));
            }
            //Ahora lo hago sin el PreparedStatement
            System.out.println("(Statement)Que cliente quieres buscar (busca por apellido): ");
            apellido = sc.nextLine();
            
            Statement s = c.createStatement();
            ResultSet rs1 = s.executeQuery("SELECT * FROM CLIENTES WHERE apellidos='"+apellido+"'");
            
            int i1 = 1;
            while(rs1.next()){
                System.out.println("[" +(i1++) +"]");
                System.out.println("DNI: "+rs1.getString("DNI"));
                System.out.println("Apellidos: "+rs1.getString("APELLIDOS"));
                System.out.println("CP: "+rs1.getString("CP"));
            }
        }
        
        //codigo Real
        /*try(
            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
            PreparedStatement sInsert = c.prepareStatement("INSERT INTO CLIENTES(DNI,APELLIDOS,CP) VALUES(?,?,?)")){
            
            sInsert.setString(1, "78901234X");
            sInsert.setString(2, "NADALES");
            sInsert.setInt(3, 44126);
            
            sInsert.executeUpdate();
            
            
            int i = 1;
            sInsert.setString(i++, "89012345E");
            sInsert.setString(i++, "ROJAS");
            sInsert.setNull(i++, Types.INTEGER);
            
            sInsert.executeUpdate();
            
            
            sInsert.setString(i=1, "56789012B");
            sInsert.setString(i++, "SAMPER");
            sInsert.setInt(i++, 29730);
            
            sInsert.executeUpdate();
        }*/catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    } 
}
