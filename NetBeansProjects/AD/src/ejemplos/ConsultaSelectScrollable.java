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
public class ConsultaSelectScrollable {
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
            Connection c = DriverManager.getConnection(urlConnection,user,pwd);
            Statement sConsulta = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = sConsulta.executeQuery("SELECT * FROM Clientes WHERE Cp IS NOT null");
            
            c.setAutoCommit(false);
            
            //modificamos el ultimo elmento
            rs.last();
            rs.updateString("CP", "00000");
            rs.updateRow();
            
            //accedemos al anterior, es decir, el penultimo y lo eliminamos
            rs.previous();
            rs.deleteRow();
            
            //insertamos una nueva fila
            rs.moveToInsertRow();
            rs.updateString("DNI", "MIGUEL");
            rs.updateString("APELLIDOS", "ROJO");
            rs.updateString("CP", "11111");
            rs.insertRow();
            
            c.commit();
            
           
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("DNI: "+rs.getString("DNI"));
                System.out.println("Apellidos: "+rs.getString("APELLIDOS"));
                System.out.println("CP: "+rs.getString("CP"));
            }
            
            sConsulta.close();
            c.close();
        }catch(SQLException e){
            muestraErrorSQL(e);
        }
    }
}
