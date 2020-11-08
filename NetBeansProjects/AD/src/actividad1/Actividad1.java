/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


/**
 *
 * @author JoseAntonioVelasco
 */
public class Actividad1 {
	static FileWriter myWriter = null;
	public static void main(String[] args) throws SQLException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escribe la ruta donde quieres que se guarden los ficheros: ");
            String ruta_destino = sc.nextLine();


            File directorio = new File(ruta_destino);
            if(! directorio.exists()) {
                    directorio.mkdir();
            }

            System.out.println("Escribe la ruta donde hay que buscar ficheros: ");
            String ruta_origen = sc.nextLine();

            //crear el log de cambios
            File log = new File(ruta_destino+"/gestionFicheros.txt");
            try {
                    log.createNewFile();
                    myWriter = new FileWriter(log);
            } catch (IOException e) {
                    e.printStackTrace();
            }


            File arch_origen = new File(ruta_origen);
            File[] archivos = arch_origen.listFiles();
            recursion(archivos,ruta_destino,ruta_origen,log);
            sc.close();
            try {
                    myWriter.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }
            
            //crearBBDD();
            //conectarBBDD();
            //crearTablas();
            //anadirDatos();
	}
	public static void recursion(File[] archivos,String ruta_destino,String ruta_origen,File log) {
            for(int i=0; i<archivos.length;i++) {

                    if(archivos[i].isDirectory()) {
                            recursion(archivos[i].listFiles(),ruta_destino,ruta_origen,log);	
                    }else {
                            //checkar si es .dat o .xml
                            if(getFileExtension(archivos[i]).equals("xml") || getFileExtension(archivos[i]).equals("dat")) {
                                    //mover a la ruta destino
                                    if(!(archivos[i].renameTo(new File(ruta_destino+"/"+archivos[i].getName())))) {
                                            failedRename(archivos[i],ruta_destino,2);
                                    }
                                    logTo(archivos[i].getName(),archivos[i].getAbsolutePath(),ruta_destino);
                            }
                    }

            }
	}
	
	//funcion copiada de: https://www.journaldev.com/842/java-get-file-extension
	private static String getFileExtension(File file) {
            String fileName = file.getName();
            if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
            else return "";
	}
	
	private static void logTo(String name_filemoved,String origen,String destino) {
            try { 
                  myWriter.append(name_filemoved+" copiado a "+destino+". \nEliminado con exito de "+origen+"\n"); 
                } catch (IOException e) {
                  e.printStackTrace();
                } 
	}
	
	private static void failedRename(File archivo,String ruta_destino,int num) {
	
            if(!(archivo.renameTo(new File(ruta_destino+"/"+stripExtension(archivo.getName())+"("+num+")"+"."+getFileExtension(archivo))))) {
                    failedRename(archivo,ruta_destino,num+1);
            }
	}
	
	//nota la libreria "org.apache.commons.io.FilenameUtils" tiene unos metodos muy utiles para este ejercicio
	//funcion copiada de: https://stackoverflow.com/questions/924394/how-to-get-the-filename-without-the-extension-in-java
	private static String stripExtension (String str) {
            // Handle null case specially.
            if (str == null) return null;
            // Get position of last '.'.
            int pos = str.lastIndexOf(".");
            // If there wasn't any '.' just return the string as is.
            if (pos == -1) return str;
            // Otherwise return the string, up to the dot.
            return str.substring(0, pos);
	}
        
        /*PARTE 2*/
        
        /*crear bbdd*/
        static final String DRIVER_JDBC="com.mysql.jdbc.Driver";
        static final String URL_DB="jdbc:mysql://localhost";
        static final String USUARIO="root";
        static final String PASSWORD="root";
        /*crear bbdd*/
        
        /*conectar bbdd*/
        static final String basedatos  = "calificaciones";
        static final String host = "localhost";
        static final String port = "3306";
        static final String info = "";
        static final String urlConnection = "jdbc:mysql://" +host+ ":" +port +"/" +basedatos + info;
        static final String user = "root";
        static final String pwd = "root";
        /*conectar bbdd*/
        
        static Connection c = null;
        
        private static void crearBBDD() throws SQLException{
            Connection c = null;
            Statement s = null;

            c = DriverManager.getConnection(URL_DB, USUARIO, PASSWORD);
            s = c.createStatement();
            // s.executeUpdate("SET GLOBAL time_zone = '+2:00'");

            String consultaSQL ="create database calificaciones";
            s.executeUpdate(consultaSQL);

            s.close();
            c.close();
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
        private static void crearTablas() throws SQLException{
            Statement s = c.createStatement();
     
            //Tabla Alumno
            s.execute("CREATE TABLE Alumno (id_alumno INTEGER, nombre VARCHAR(20) NOT NULL,"
            +" apellidos VARCHAR(20) NOT NULL, PRIMARY KEY (id_alumno));");
            
            //Tabla Modulo
            s.execute("CREATE TABLE Modulo (id_modulo INTEGER, nombreCompleto VARCHAR(100) NOT NULL,"
            +" ciclo VARCHAR(100) NOT NULL, curso INTEGER NOT NULL, ECTS INTEGER NOT NULL,"
            +" PRIMARY KEY (id_modulo));");
            
            //Tabla Notas
            s.execute("CREATE TABLE Notas (id_alumno INTEGER, id_modulo INTEGER,"
            +" calificacion DOUBLE NOT NULL, PRIMARY KEY (id_alumno,id_modulo),"
                    + " FOREIGN KEY (id_alumno) REFERENCES Alumno(id_alumno), "
                    + " FOREIGN KEY (id_modulo) REFERENCES Modulo(id_modulo));");
            s.close();
        }
        private static void muestraErrorSQL(SQLException e){
            System.err.println("SQL ERROR mensaje: "+e.getMessage());
            System.err.println("SQL Estado: "+e.getSQLState());
            System.err.println("SQL codigo especifico: "+e.getErrorCode());
        }
        
        static class Alumno{
            private String nombre;
            private String apellidos;
            private Double notaAD;
            private Double notaPSP;
            private Double notaSGE;

            public Alumno(String nombre, String apellidos, Double notaAD, Double notaPSP, Double notaSGE) {
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.notaAD = notaAD;
                this.notaPSP = notaPSP;
                this.notaSGE = notaSGE;
            }
            
            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public String getApellidos() {
                return apellidos;
            }

            public void setApellidos(String apellidos) {
                this.apellidos = apellidos;
            }

            public Double getNotaAD() {
                return notaAD;
            }

            public void setNotaAD(Double notaAD) {
                this.notaAD = notaAD;
            }

            public Double getNotaPSP() {
                return notaPSP;
            }

            public void setNotaPSP(Double notaPSP) {
                this.notaPSP = notaPSP;
            }

            public Double getNotaSGE() {
                return notaSGE;
            }

            public void setNotaSGE(Double notaSGE) {
                this.notaSGE = notaSGE;
            }
            
        }
        static class Modulo{
            private String nombreCompleto;
            private String ciclo;
            private Integer curso;
            private Integer ECTS;

            public Modulo(String nombreCompleto, String ciclo, Integer curso, Integer ECTS) {
                this.nombreCompleto = nombreCompleto;
                this.ciclo = ciclo;
                this.curso = curso;
                this.ECTS = ECTS;
            }

            public String getNombreCompleto() {
                return nombreCompleto;
            }

            public void setNombreCompleto(String nombreCompleto) {
                this.nombreCompleto = nombreCompleto;
            }

            public String getCiclo() {
                return ciclo;
            }

            public void setCiclo(String ciclo) {
                this.ciclo = ciclo;
            }

            public Integer getCurso() {
                return curso;
            }

            public void setCurso(Integer curso) {
                this.curso = curso;
            }

            public Integer getECTS() {
                return ECTS;
            }

            public void setECTS(Integer ECTS) {
                this.ECTS = ECTS;
            }
        }
        static class Nota{
            private Modulo modulo;
            private Double calificacion;

            public Nota(Modulo modulo, Double calificacion) {
                this.modulo = modulo;
                this.calificacion = calificacion;
            }

            public Modulo getModulo() {
                return modulo;
            }

            public void setModulo(Modulo modulo) {
                this.modulo = modulo;
            }

            public Double getCalificacion() {
                return calificacion;
            }

            public void setCalificacion(Double calificacion) {
                this.calificacion = calificacion;
            }
            
        }
        private static ArrayList<Alumno> obtenerObjetosXML(File f) throws SAXException, ParserConfigurationException, IOException{
            ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(f);

            NodeList listaAlumnos = documento.getElementsByTagName("alumno");

            for(int i=0; i<listaAlumnos.getLength();i++) {
                Node nodoAlumno = listaAlumnos.item(i);
                if(nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoAlumno = (Element) nodoAlumno;
                    //System.out.println("Nombre: "+elementoAlumno.getAttribute("nombre"));
                    Alumno al = new Alumno(
                    elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent(),
                    elementoAlumno.getElementsByTagName("apellidos").item(0).getTextContent(),
                    Double.parseDouble(elementoAlumno.getElementsByTagName("nota_AD").item(0).getTextContent()),
                    Double.parseDouble(elementoAlumno.getElementsByTagName("nota_PSP").item(0).getTextContent()),
                    Double.parseDouble(elementoAlumno.getElementsByTagName("nota_SGE").item(0).getTextContent()));

                    alumnos.add(al);
                    //si no encuentra algun dato saltara una exception
                }
            }
            return alumnos;         
        }
        private static ArrayList<Alumno> obtenerObjetosDAT(File f) throws FileNotFoundException, IOException, ClassNotFoundException{
            ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
            ObjectInputStream objetoIS = null;
            objetoIS = new ObjectInputStream(new FileInputStream(f));

            Alumno al;

            while((al=(Alumno) objetoIS.readObject()) != null) {
                    /*System.out.println("nombre: "+al.getNombre());
                    System.out.println("apellidos: "+al.getApellidos());
                    System.out.println("nota AD: "+al.getNotaAD());
                    System.out.println("nota PSP: "+al.getNotaPSP());
                    System.out.println("nota SGE: "+al.getNotaSGE());*/
                    alumnos.add(al);
            }

            objetoIS.close();
            
            return alumnos;
	}
        private static void anadirDatos(){
            //TODO se addean todos los datos de los ficheros xml y dat a las tablas de bbdd
                //obtener los arraylists de alumnos, modulos, etc..
                //meter todos los datos obtenidos a la bbdd
        }
        
        private static void insertAlumno(Alumno al){
            //TODO
        }
        private static void insertModulo(Modulo mod){
            //TODO
        }
        private static void insertNota(Nota nota){
            //TODO
        }
        
}
