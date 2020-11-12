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
public class Practica_AD_2_6 {
    
    /*Crear bbdd*/
    static final String DRIVER_JDBC="com.mysql.jdbc.Driver";
    static final String URL_DB="jdbc:mysql://localhost";
    static final String USUARIO="root";
    static final String PASSWORD="root";
    /*Crear bbdd*/
    
    /*Conectar bbdd*/
    static final String basedatos  = "bbdd_pract6";
    static final String host = "localhost";
    static final String port = "3306";
    static final String info = "";
    static final String urlConnection = "jdbc:mysql://" +host+ ":" +port +"/" +basedatos + info;
    static final String user = "root";
    static final String pwd = "root";
    /*Conectar bbdd*/
    
    
    static Connection c = null;
    
    public static void main(String[] args) throws SQLException{
       // crearBBDD();
        conectarBBDD();
        //crearTablas();
        
        /*consultas*/
        System.out.println("------Consulta1------");
        consulta1();
        System.out.println("------Consulta2------");
        consulta2();
        System.out.println("------Consulta3------");
        consulta3();
        System.out.println("------Consulta4------");
        consulta4();
        System.out.println("------Consulta5------");
        consulta5();
        System.out.println("------Consulta6------");
        consulta6();
        System.out.println("------Consulta7------");
        consulta7();
        System.out.println("------Consulta8------");
        consulta8();
        System.out.println("------Consulta9------");
        consulta9();
        System.out.println("------Consulta10------");
        consulta10();
        /*consultas*/
        
        c.close();
    }
    private static void crearBBDD()throws SQLException{
        Statement s;
        c = DriverManager.getConnection(URL_DB, USUARIO, PASSWORD);
        s = c.createStatement();
        // s.executeUpdate("SET GLOBAL time_zone = '+2:00'");
        String consultaSQL ="create database bbdd_pract6";
        s.executeUpdate(consultaSQL);
        
        s.close();
    }
    private static void conectarBBDD(){
        try{
            c = DriverManager.getConnection(urlConnection, user, pwd);
            System.out.println("Conexion realizada");
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void crearTablas(){
     
        try(Statement s = c.createStatement()){
            
            //Tabla Clientes
            s.execute("CREATE TABLE clientes (idC INTEGER, nombre VARCHAR(50) NOT NULL,"
            +" apellidos VARCHAR(50) NOT NULL, telefono VARCHAR(9) NOT NULL,"
            +" PRIMARY KEY (idC));");
            
            //Tabla Oficina
            s.execute("CREATE TABLE oficina (idO INTEGER, calle VARCHAR(50) NOT NULL,"
            +" localidad VARCHAR(50) NOT NULL, provincia VARCHAR(50) NOT NULL,"
            +" PRIMARY KEY (idO));");
            
            //Tabla Empleados
            s.execute("CREATE TABLE empleados (idE INTEGER, nombre VARCHAR(50) NOT NULL,"
            +" apellidos VARCHAR(50) NOT NULL, antiguedad DATE NOT NULL,"
            +" idOficina INTEGER NOT NULL, PRIMARY KEY (idE), FOREIGN KEY (idOficina) REFERENCES oficina(idO));");
             
            //Tabla Ventas
            s.execute("CREATE TABLE ventas (idV INTEGER, concepto VARCHAR(50) NOT NULL,"
            +" idVendedor INTEGER, idCliente INTEGER, PRIMARY KEY (idV),"
                    + " FOREIGN KEY (idVendedor) REFERENCES empleados(idE), "
                    + " FOREIGN KEY (idCliente) REFERENCES clientes(idC));");
            s.close();
            
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void muestraErrorSQL(SQLException e){
        System.err.println("SQL ERROR mensaje: "+e.getMessage());
        System.err.println("SQL Estado: "+e.getSQLState());
        System.err.println("SQL codigo especifico: "+e.getErrorCode());
    }
    
    private static void consulta1(){
        //Introducir datos en la base de datos (al menos 5 oficinas, 15 empleados, 30 ventas y 10 clientes).
        /*http://www.generatedata.com/?lang=es*/
        try(Statement s = c.createStatement()){
            //5 oficinas
            s.executeUpdate("INSERT INTO oficina (idO,calle,localidad,provincia) VALUES "
            +"('1','C/Me falta un tornillo','Cigales','Valladolid'),"
            +"('2','C/Los tres','Palencia','Palencia'),"
            +"('3','C/Venus','Leon','Leon'),"
            +"('4','C/Tierra','Burgos','Burgos'),"
            +"('5','C/General','Valladolid','Valladolid');");
            //15 empleados
            s.executeUpdate("INSERT INTO empleados (idE,nombre,apellidos,antiguedad,idOficina) VALUES "
            +"(1,'Edward','Matthews','2019/01/22',1),"
            +"(2,'Barry','Tillman','2019/02/22',1),"
            +"(3,'Austin','Riddle','2019/03/21',2),"
            +"(4,'William','Robertson','2018/04/15',3),"
            +"(5,'Kenyon','Pennington','2017/03/13',4),"
            +"(6,'Price','Parsons','2016/06/14',5),"
            +"(7,'Kato','Campos','2018/06/15',1),"
            +"(8,'Nathan','Dudley','2019/11/15',2),"
            +"(9,'Drake','Peck','2019/12/20',2),"
            +"(10,'Kenneth','Dodson','2018/10/21',4),"
            +"(11,'Driscoll','Gamble','2018/08/11',5),"
            +"(12,'Hammett','Copeland','2017/07/10',5),"
            +"(13,'Hilel','Norton','2014/02/04',2),"
            +"(14,'Samson','Campbell','2015/03/03',3),"
            +"(15,'Jamal','Patton','2017/06/14',3);");
            //10 clientes
            s.executeUpdate("INSERT INTO clientes (idC,nombre,apellidos,telefono) VALUES "
            +"(1,'Deacon','Patrick','925735101'),"
            + "(2,'Blake','Miranda','483069334'),"
            + "(3,'Lars','Stout','437040714'),"
            + "(4,'Jesse','Woodward','237227126'),"
            + "(5,'Blake','Anthony','462175268'),"
            + "(6,'Dustin','Hopkins','448092580'),"
            + "(7,'Dolan','Ruiz','050590986'),"
            + "(8,'Acton','Cummings','974086828'),"
            + "(9,'William','Willis','491797541'),"
            + "(10,'Uriah','Hinton','519060369');");
            //30 ventas
            s.executeUpdate("INSERT INTO ventas (idV,concepto,idVendedor,idCliente) VALUES "
            +"(1,'libero.',12,6),"
            + "(2,'quis',9,6),"
            + "(3,'eu',12,5),"
            + "(4,'vitae,',2,1),"
            + "(5,'parturient',10,9),"
            + "(6,'amet',13,2),"
            + "(7,'mauris',12,6),("
            + "8,'congue,',1,8),"
            + "(9,'nec',4,6),"
            + "(10,'malesuada',10,6),"
            + "(11,'ipsum',4,10),"
            + "(12,'risus.',8,3),"
            + "(13,'velit',14,6),"
            + "(14,'non',11,6),"
            + "(15,'tortor.',14,5),"
            + "(16,'Cum',11,4),"
            + "(17,'Duis',14,8),"
            + "(18,'non',11,5),"
            + "(19,'libero',11,6),"
            + "(20,'eget,',6,9),"
            + "(21,'purus,',13,10),"
            + "(22,'mi',5,7),"
            + "(23,'ante.',8,3),"
            + "(24,'metus.',3,6),"
            + "(25,'molestie',14,6),"
            + "(26,'Morbi',5,7),"
            + "(27,'eleifend',4,6),"
            + "(28,'non,',11,9),"
            + "(29,'Pellentesque',9,6),"
            + "(30,'faucibus',8,6);");
            
            s.close();
        }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void consulta2(){
         try(Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery("SELECT * FROM Oficina");
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("ID oficina: "+rs.getString("idO"));
                System.out.println("Calle: "+rs.getString("calle"));
                System.out.println("Localidad: "+rs.getString("localidad"));
                System.out.println("Provincia: "+rs.getString("provincia"));
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void consulta3(){
         try(Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery("SELECT COUNT(idV) FROM ventas");
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Numero total de ventas: "+rs.getString(1));
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void consulta4(){
         try(Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery("SELECT o.idO,o.calle,o.localidad,o.provincia,COUNT(e.idE)as num FROM Oficina o " +
                                            "INNER JOIN Empleados e ON o.idO = e.idOficina GROUP BY o.idO; ");
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("ID oficina: "+rs.getString("idO"));
                System.out.println("Calle: "+rs.getString("calle"));
                System.out.println("Localidad: "+rs.getString("localidad"));
                System.out.println("Provincia: "+rs.getString("provincia"));
                System.out.println("Nº de empleados: "+rs.getString("num"));
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void consulta5(){
         try(Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery("SELECT o.idO,o.calle,o.localidad,o.provincia,COUNT(e.idE)as ventas FROM Oficina o " +
                                            "INNER JOIN Empleados e ON o.idO = e.idOficina " +
                                            "INNER JOIN Ventas v ON v.idVendedor = e.idE  GROUP BY o.idO; ");
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("ID oficina: "+rs.getString("idO"));
                System.out.println("Calle: "+rs.getString("calle"));
                System.out.println("Localidad: "+rs.getString("localidad"));
                System.out.println("Provincia: "+rs.getString("provincia"));
                System.out.println("Nº de ventas: "+rs.getString("ventas"));
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void consulta6(){
        try(Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery(" SELECT e.nombre,e.apellidos,COUNT(v.idVendedor) as ventas FROM Empleados e" +
                                            " INNER JOIN Ventas v ON v.idVendedor = e.idE GROUP BY e.idE ORDER BY ventas DESC");
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Nombre: "+rs.getString("nombre"));
                System.out.println("Apellido: "+rs.getString("apellidos"));
                System.out.println("Ventas: "+rs.getString("ventas"));
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void consulta7(){
         try(Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery("SELECT e.idE,e.nombre,e.apellidos FROM Empleados e" );
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("IdVendedor: "+rs.getInt("idE"));
                System.out.println("Nombre: "+rs.getString("nombre"));
                System.out.println("Apellido: "+rs.getString("apellidos"));
                
                ResultSet rs1 = s.executeQuery("SELECT idV,concepto FROM Ventas v WHERE idVendedor="+rs.getInt("idE"));
                while(rs1.next()){
                    System.out.println("[" +(i++) +"]");
                    System.out.println("IdVenta: "+rs.getInt("idV"));
                    System.out.println("Concepto: "+rs.getString("concepto"));
                }
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
   
    private static void consulta8(){
         try(Statement s = c.createStatement()){
            ResultSet rs = s.executeQuery(" SELECT c.idC,c.nombre,c.apellidos,c.telefono,COUNT(v.idCliente)as compras FROM Clientes c" +
                                            " INNER JOIN Ventas v ON v.idCliente = c.idC GROUP BY c.idC ORDER BY compras DESC;");
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Nombre: "+rs.getString("nombre"));
                System.out.println("Apellido: "+rs.getString("apellidos"));
                System.out.println("Telefono: "+rs.getString("telefono"));
                System.out.println("Compras: "+rs.getString("compras"));
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void consulta9(){
         try(Statement s = c.createStatement()){
            PreparedStatement ps = c.prepareStatement("SELECT o.calle,o.localidad,o.provincia FROM Oficina o WHERE localidad=?;");
            String localidad = "Palencia";
            ps.setString(1, localidad);
            ResultSet rs=ps.executeQuery();
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Calle: "+rs.getString("calle"));
                System.out.println("Localidad: "+rs.getString("localidad"));
                System.out.println("Provincia: "+rs.getString("provincia"));
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    private static void consulta10(){
         try(Statement s = c.createStatement()){
             ResultSet rs = s.executeQuery("SELECT idE FROM Empleados e");
      
            //int i = 1;
            while(rs.next()){
                PreparedStatement ps = c.prepareStatement("SELECT * FROM Empleados e WHERE e.idE = ?;");
                ps.setInt(1, rs.getInt("idE"));
                ResultSet rs1=ps.executeQuery();
                int i = 1;
                while(rs1.next()){
                    System.out.println("[" +(i++) +"]");
                    System.out.println("idEmpleado: "+rs1.getString("idE"));
                    System.out.println("nombre: "+rs1.getString("nombre"));
                    System.out.println("apellidos: "+rs1.getString("apellidos"));
                    System.out.println("antiguedad: "+rs1.getString("antiguedad"));
                    System.out.println("idOficina: "+rs1.getString("idOficina"));
                }
            }
           s.close();
         }catch(SQLException e){
            muestraErrorSQL(e);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }

}
