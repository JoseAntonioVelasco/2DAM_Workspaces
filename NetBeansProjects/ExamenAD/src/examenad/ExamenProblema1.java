/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenad;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author JoseAntonioVelasco
 */

public class ExamenProblema1 {
    //variables para crear y conectarse a la bbdd
    private static String URL = "jdbc:mysql://localhost:3306";
    private static String URLDB = "jdbc:mysql://localhost:3306/baloncesto";
    private static String USER = "root";
    private static String PASSWD = "root";      
    
    public static void main(String[] args) throws InterruptedException {
        creacionBBDD("baloncesto");
        Thread.sleep(2000);
        conexionBBDD();
        Thread.sleep(2000);
        crearTablas();
        Thread.sleep(2000);
        poblacionBBDD();
        incluirDatos();
        Thread.sleep(2000);
        actualizarDatos();
        Thread.sleep(2000);
        mediaEdadesEquipos();
        Thread.sleep(2000);
        informacionEquipos();

    }

    public static void muestraErrorSQL(SQLException e) {
        //muestra el error
       e.printStackTrace();
       System.out.println("Se ha producido un error. El codigo es: "+e.getErrorCode());
    }

    public static void creacionBBDD(String nombreBBDD) {
        try {
            //conectamos al server mysql y creamos la bbdd
            Connection c = DriverManager.getConnection(URL, USER, PASSWD);
            Statement s = c.createStatement();
            s.executeUpdate("create database "+nombreBBDD);
            c.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ExamenProblema1.class.getName()).log(Level.SEVERE, null, ex);
            muestraErrorSQL(ex);
        }
      
    }

    public static void conexionBBDD() {




    }

    public static void crearTablas() {

        String sqlCreacionEquipos = "create table equipos ("
                + "  idEquipo int not null,"
                + "  nombre varchar(50) not null,"
                + "  abreviatura varchar(50) not null,"
                + "  ciudad varchar(50) not null,"
                + "  primary key(idEquipo)"
                + ");";
        String sqlCreacionJugadores = "create table jugadores ("
                + "  idJugador int not null,"
                + "  idEquipo int not null,"
                + "  nombre varchar(50) not null,"
                + "  apellido varchar(50) not null,"
                + "  edad int not null,"
                + "  primary key (idJugador,idEquipo),"
                + "  foreign key (idEquipo) references equipos(idEquipo)"
                + ");";
        String sqlCreacionPartidos = "create table partidos ("
                + "  idPartido int not null,"
                + "  idLocal int not null,"
                + "  idVisitante int not null,"
                + "  marcadorLocal int not null,"
                + "  marcadorVisitante int not null,"
                + "  primary key (idPartido)"
                + ");";
        String sqlCreacionValoraciones = "create table valoraciones ("
                + "  idJugador int not null,"
                + "  idEquipo int not null,"
                + "  idPartido int not null,"
                + "  valoracion int not null,"
                + "  primary key (idJugador,idEquipo,idPartido),"
                + "  foreign key (idJugador) references jugadores(idJugador),"
                + "  foreign key (idEquipo) references equipos(idEquipo),"
                + "  foreign key (idPartido) references partidos(idPartido)"
                + ");";
        
         try {
             //aqui nos conectamos dentro del server a la bbdd y creamos las tablas
            Connection c = DriverManager.getConnection(URLDB, USER, PASSWD);
            Statement s = c.createStatement();
            s.executeUpdate(sqlCreacionEquipos);
            s.executeUpdate(sqlCreacionJugadores);
            s.executeUpdate(sqlCreacionPartidos);
            s.executeUpdate(sqlCreacionValoraciones);
            c.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ExamenProblema1.class.getName()).log(Level.SEVERE, null, ex);
            muestraErrorSQL(ex);
        }

    }

    public static void poblacionBBDD() {
        /*
        NO TOCAR DESDE AQUÍ
         */
        String[] nombresArray = {"Abel", "Marcos", "Pepe", "Pedro", "Javier", "Miguel", "Carlos",
            "David", "Hugo", "Jorge", "Favila", "Lourdes", "Jose", "Rodrigo", "Ángel", "Pablo", "Luis Ángel", "Marlon",};
        String[] apellidosArray = {"Álvarez", "Bombín", "Casado", "Abascal", "Sánchez", "Iglesias", "Rojo", "Blanco", "Zapatero",
            "Pelayo", "Zaplana", "Aznar", "Rodríguez"};

        ArrayList<String> nombres = new ArrayList<String>();
        for (int i = 0; i < nombresArray.length; i++) {
            nombres.add(nombresArray[i]);
        }

        ArrayList<String> apellidos = new ArrayList<String>();
        for (int i = 0; i < apellidosArray.length; i++) {
            apellidos.add(apellidosArray[i]);
        }

        ArrayList<Equipo> listaEquiposArray = new ArrayList<Equipo>();
        listaEquiposArray = listaEquipos();

        ArrayList<Jugador> listaJugadoresArray = new ArrayList<Jugador>();
        for (int i = 0; i < listaEquiposArray.size(); i++) {
            ArrayList<Jugador> listaTemp = new ArrayList<Jugador>();
            listaTemp = listaJugadores(listaEquiposArray.get(i).getIdEquipo(), nombres, apellidos);
            for (int j = 0; j < listaTemp.size(); j++) {
                listaJugadoresArray.add(listaTemp.get(j));
            }
        }

        ArrayList<Partido> listaPartidosArray = new ArrayList<Partido>();
        listaPartidosArray = listaPartidos(listaEquiposArray);
        for (int i = 0; i < listaPartidosArray.size(); i++) {
            listaPartidosArray.get(i).setIdPartido(i);
        }
        ArrayList<Valoracion> listaValoracionesArray = new ArrayList<Valoracion>();
        listaValoracionesArray = listaValoraciones(listaPartidosArray, listaJugadoresArray);
        /*
        NO TOCAR HASTA AQUÍ
         */

         /*  ^^^^^^^^ INDICACIONES ^^^^^^^^
        Las listas con los datos se generan en las siguientes variables:
        - listaEquiposArray
        - listaJugadoresArray
        - listaPartidosArray
        - listaValoracionesArray
        Que son objetos de tipo ArrayList<TIPO_DE_DATO>.

        Para recorrer un ArrayList el código es este:
        for (int i = 0; i < NOMBRE_ARRAY.size(); i++) {
            NOMBRE_ARRAY.get(i); --> esto devuelve el objeto del array en la posición i
        }
         */


        //A CONTINUACIÓN INTRODUCE EL CÓDIGO NECESARIO PARA RELLENAR LA BASE DE
        //DATOS CON LOS DATOS QUE SE GENERAN EN LOS ARRAYLIST MENCIONADOS ANTERIORMENTE


         try {
             //Introducirmos los datos a la bbdd con PreparedStatement
            Connection c = DriverManager.getConnection(URLDB, USER, PASSWD);
            //EQUIPOS
            PreparedStatement ps1 = c.prepareStatement("INSERT INTO equipos(idEquipo,nombre,abreviatura,ciudad) VALUES (?,?,?,?)");
            for(int i=0; i<listaEquiposArray.size();i++){
                ps1.setInt(1, listaEquiposArray.get(i).getIdEquipo());
                ps1.setString(2, listaEquiposArray.get(i).getNombreEquipo());
                ps1.setString(3, listaEquiposArray.get(i).getAbreviatura());
                ps1.setString(4, listaEquiposArray.get(i).getCiudad());
                ps1.execute();
            }
            //JUGADORES
            PreparedStatement ps2 = c.prepareStatement("INSERT INTO jugadores(idJugador,idEquipo,nombre,apellido,edad) VALUES (?,?,?,?,?)");
            for(int i=0; i<listaJugadoresArray.size();i++){
                ps2.setInt(1,listaJugadoresArray.get(i).getIdJugador() );
                ps2.setInt(2,listaJugadoresArray.get(i).getIdEquipo() );
                ps2.setString(3,listaJugadoresArray.get(i).getNombre() );
                ps2.setString(4,listaJugadoresArray.get(i).getApellidos());
                ps2.setInt(5,listaJugadoresArray.get(i).getEdad());
                ps2.execute();
            }
            //PARTIDOS
            PreparedStatement ps3 = c.prepareStatement("INSERT INTO partidos (idPartido,idLocal,idVisitante,marcadorLocal,marcadorVisitante) VALUES (?,?,?,?,?)");
            for(int i=0; i<listaPartidosArray.size();i++){
                ps3.setInt(1,listaPartidosArray.get(i).getIdPartido());
                ps3.setInt(2,listaPartidosArray.get(i).getIdLocal());
                ps3.setInt(3,listaPartidosArray.get(i).getIdVisitante());
                ps3.setInt(4,listaPartidosArray.get(i).getMarcadorLocal());
                ps3.setInt(5,listaPartidosArray.get(i).getMarcadorVisitante());
                ps3.execute();
            }
            //VALORACIONES
            PreparedStatement ps4 = c.prepareStatement("INSERT INTO valoraciones (idJugador,idEquipo,idPartido,valoracion) VALUES (?,?,?,?)");
            for(int i=0; i<listaValoracionesArray.size();i++){
                ps4.setInt(1,listaValoracionesArray.get(i).getIdJugador());
                ps4.setInt(2,listaValoracionesArray.get(i).getIdEquipo());
                ps4.setInt(3,listaValoracionesArray.get(i).getIdPArtido());
                ps4.setInt(4,listaValoracionesArray.get(i).getValoracion());
                ps4.execute();
            }
      
            c.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ExamenProblema1.class.getName()).log(Level.SEVERE, null, ex);
            muestraErrorSQL(ex);
        }





    }

    public static void incluirDatos() {
        try {
            //Incluimos estos dos equipos adicionales
            Connection c = DriverManager.getConnection(URLDB, USER, PASSWD);
            Statement s = c.createStatement();
            int fil=s.executeUpdate("INSERT INTO equipos(idEquipo,nombre,abreviatura,ciudad) VALUES "
                    + "(10,'Club para eliminar 1','elim 1','Madrid'),"
                    + "(11,'Club para eliminar 2','elim 2','Barcelona');");
            System.out.println("Se han añadido "+fil+" nuevos a la base de datos");
            c.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ExamenProblema1.class.getName()).log(Level.SEVERE, null, ex);
            muestraErrorSQL(ex);
        }

    }

    public static void actualizarDatos() {
        try{        
            Connection c = DriverManager.getConnection(URLDB, USER, PASSWD);
            Statement sConsulta = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Actualizar datos equipos
            ResultSet rs=sConsulta.executeQuery("SELECT * FROM equipos");
            while(rs.next()){
                if(rs.getString("ciudad").equals("Burgos")){
                    rs.updateString("ciudad", "Soria");
                }
            }
            System.out.println("Modificados datos de los equipos");
            



            //actualizar datos jugadores
            ResultSet rs1=sConsulta.executeQuery("SELECT * FROM jugadores");
            while(rs1.next()){
                if(rs1.getString("apellido").equals("Rojo")){
                    rs1.updateString("apellido", "Verde");
                }
            }
            System.out.println("Modificados datos de los jugadores");
            



            //Eliminar los dos últimos equipos
            ResultSet rs2=sConsulta.executeQuery("SELECT * FROM equipos");
            //vamos al final
            rs2.last();
            //eliminamos la ultima fila
            rs2.deleteRow();
            //borramos la penultima
            rs2.deleteRow();
            System.out.println("Eliminados últimos dos equipos de la tabla.");
        } catch (SQLException ex) {
            //Logger.getLogger(ExamenProblema1.class.getName()).log(Level.SEVERE, null, ex);
            muestraErrorSQL(ex);
        }
//INSERT INTO tablename(columnas) VALUES (valores)

    }

    public static void mediaEdadesEquipos() {
         try {
            Connection c = DriverManager.getConnection(URLDB, USER, PASSWD);
            Statement s = c.createStatement();
            ResultSet rs=s.executeQuery("SELECT idEquipo FROM equipos");
            while(rs.next()){
                int equipo =rs.getInt("idEquipo");
                Statement s1 = c.createStatement();
                ResultSet rs1=s1.executeQuery("SELECT edad FROM jugadores WHERE idEquipo="+rs.getInt("idEquipo"));
                Double sumatorio = 0.0;
                Double i=0.0;
                while(rs1.next()){
                    i++;
                    sumatorio=rs1.getDouble("edad")+sumatorio;
                }
                Double media = sumatorio/i;
                System.out.println("La media de edad del equipo con ID "+equipo+" es "+media);
            }
       
            c.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ExamenProblema1.class.getName()).log(Level.SEVERE, null, ex);
            muestraErrorSQL(ex);
        }



    }

    public static void informacionEquipos() {
        try {
            Connection c = DriverManager.getConnection(URLDB, USER, PASSWD);
            Statement s = c.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM equipos");
            while(rs.next()){
                System.out.println("Informacion del equipo "+rs.getInt("idEquipo"));
                System.out.println("Nombre "+rs.getString("nombre"));
                System.out.println("Abreviatura "+rs.getString("abreviatura"));
                System.out.println("Ciudad "+rs.getString("ciudad"));
                System.out.println("Informacion de sus jugadores: ");
                Statement s1 = c.createStatement();
                //System.out.println("SELECT * FROM jugadores WHERE idEquipo="+rs.getInt("idEquipo"));
                ResultSet rs1=s1.executeQuery("SELECT * FROM jugadores WHERE idEquipo="+rs.getInt("idEquipo"));
                while(rs1.next()){
                    System.out.println("\tID jugador: "+rs1.getInt("idJugador"));
                    System.out.println("\tNombre completo jugador: "+rs1.getString("nombre")+" "+rs1.getString("apellido"));
                    System.out.println("\tEdad: "+rs1.getInt("Edad"));
                }
            }
     
        
            c.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ExamenProblema1.class.getName()).log(Level.SEVERE, null, ex);
            muestraErrorSQL(ex);
        }


    }

    public static ArrayList<Equipo> listaEquipos() {
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        Equipo e1 = new Equipo(0, "CB Valladolid", "CBV", "Valladolid");
        Equipo e2 = new Equipo(1, "CB Parquesol", "Parque", "Valladolid");
        Equipo e3 = new Equipo(2, "CB San Viator", "CBSV", "Valladolid");
        Equipo e4 = new Equipo(3, "CB Palencia", "CBP", "Palencia");
        Equipo e5 = new Equipo(4, "CB Palencia 2000", "CBP2", "Palencia");
        Equipo e6 = new Equipo(5, "CB Burgos", "CBB", "Burgos");
        Equipo e7 = new Equipo(6, "CB Burgos Juvenil", "CBBJ", "Burgos");
        Equipo e8 = new Equipo(7, "CB Segovia", "CBS", "Segovia");
        equipos.add(e1);
        equipos.add(e2);
        equipos.add(e3);
        equipos.add(e4);
        equipos.add(e5);
        equipos.add(e6);
        equipos.add(e7);
        equipos.add(e8);
        return equipos;
    }

    public static ArrayList<Jugador> listaJugadores(int idEquipo, ArrayList<String> nombres, ArrayList<String> apellidos) {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < 12; i++) {
            int nombreAleatorio = new Random().nextInt(nombres.size());
            int apellidoAleatorio = new Random().nextInt(apellidos.size());
            int edadAleatoria = new Random().nextInt(10) + 20;
            Jugador j = new Jugador();
            j.setIdJugador(i);
            j.setIdEquipo(idEquipo);
            j.setNombre(nombres.get(nombreAleatorio));
            j.setApellidos(apellidos.get(apellidoAleatorio));
            j.setEdad(edadAleatoria);
            jugadores.add(j);
        }
        return jugadores;
    }

    public static ArrayList<Partido> listaPartidos(ArrayList<Equipo> equipos) {
        ArrayList<Partido> partidos = new ArrayList<Partido>();
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = 0; j < equipos.size(); j++) {
                if (i != j) {
                    int marcadorLocal = new Random().nextInt(60) + 30;
                    int marcadorVisitante = new Random().nextInt(60) + 30;
                    Partido p = new Partido(0, equipos.get(i).getIdEquipo(), equipos.get(j).getIdEquipo(), marcadorLocal, marcadorVisitante);
                    partidos.add(p);
                }
            }
        }
        return partidos;
    }

    public static ArrayList<Valoracion> listaValoraciones(ArrayList<Partido> partidos, ArrayList<Jugador> jugadores) {
        ArrayList<Valoracion> valoraciones = new ArrayList<Valoracion>();
        for (int i = 0; i < partidos.size(); i++) {
            int idL = partidos.get(i).getIdLocal();
            int idV = partidos.get(i).getIdVisitante();
            for (int j = 0; j < jugadores.size(); j++) {
                if ((jugadores.get(j).getIdEquipo() == idL) || (jugadores.get(j).getIdEquipo() == idV)) {
                    int valoracionTemp = new Random().nextInt(11);
                    Valoracion v = new Valoracion(jugadores.get(j).getIdJugador(), jugadores.get(j).getIdEquipo(), partidos.get(i).getIdPartido(), valoracionTemp);
                    valoraciones.add(v);
                }
            }
        }
        return valoraciones;
    }


}