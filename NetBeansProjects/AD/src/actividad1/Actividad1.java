/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


/**
 *
 * @author JoseAntonioVelasco
 */
public class Actividad1{
	static FileWriter myWriter = null;
        private static Scanner sc;
        private static ArrayList<Alumno> alumnos;
        private static ArrayList<Modulo> modulos;
        private static ArrayList<Nota> notas;
	public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
            sc =new Scanner(System.in);
            /*PARTE 1*/
            /*System.out.println("Escribe la ruta donde quieres que se guarden los ficheros: ");
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
           
            try {
                    myWriter.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }*/
            /*PARTE 1*/
            
            /*PARTE 2*/
            //crearBBDD();
            //conectarBBDD();
            //crearTablas();
            //leerFicheros(new File(ruta_destino));
            leerFicheros(new File("C:\\Users\\cagan\\Desktop\\Nueva carpeta"));
            System.out.println("finish");
            quitarDuplicados();
            anadirDatos();
            
            /*PARTE 2*/
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
        
        static class Alumno implements Serializable{
            private Integer idAlumno;
            private String nombre;
            private String apellidos;

            public Alumno(Integer idAlumno, String nombre, String apellidos) {
                this.idAlumno = idAlumno;
                this.nombre = nombre;
                this.apellidos = apellidos;
            }

            public Integer getIdAlumno() {
                return idAlumno;
            }

            public void setIdAlumno(Integer idAlumno) {
                this.idAlumno = idAlumno;
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
            
            
        }
        static class Modulo implements Serializable{
            private Integer idModulo;
            private String nombreCompleto;
            private String ciclo;
            private Integer curso;
            private Integer ECTS;

            public Modulo(Integer idModulo, String nombreCompleto, String ciclo, Integer curso, Integer ECTS) {
                this.idModulo = idModulo;
                this.nombreCompleto = nombreCompleto;
                this.ciclo = ciclo;
                this.curso = curso;
                this.ECTS = ECTS;
            }

            public Integer getIdModulo() {
                return idModulo;
            }

            public void setIdModulo(Integer idModulo) {
                this.idModulo = idModulo;
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
        static class Nota implements Serializable{
            private Integer idAlumno;
            private Integer idModulo;
            private Double calificacion;

            public Nota(Integer idAlumno, Integer idModulo, Double calificacion) {
                this.idAlumno = idAlumno;
                this.idModulo = idModulo;
                this.calificacion = calificacion;
            }

            public Integer getIdAlumno() {
                return idAlumno;
            }

            public void setIdAlumno(Integer idAlumno) {
                this.idAlumno = idAlumno;
            }

            public Integer getIdModulo() {
                return idModulo;
            }

            public void setIdModulo(Integer idModulo) {
                this.idModulo = idModulo;
            }

            public Double getCalificacion() {
                return calificacion;
            }

            public void setCalificacion(Double calificacion) {
                this.calificacion = calificacion;
            }
 
            
        }
              
        private static ArrayList<Alumno> obtenerAlumnosXML(File f) throws SAXException, ParserConfigurationException, IOException{
            ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
              
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(f);
            
            //Obtenemos los alumnos
            NodeList listaAlumnos = documento.getElementsByTagName("alumno");

            for(int i=0; i<listaAlumnos.getLength();i++) {
                Node nodoAlumno = listaAlumnos.item(i);
                if(nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoAlumno = (Element) nodoAlumno;
                    Integer id=null; String nombre=null; String apellidos=null;
                    try{
                        id = Integer.parseInt(elementoAlumno.getElementsByTagName("id").item(0).getTextContent());
                    }catch(Exception e){
                        id=(Integer)objetoIncompleto("Alumno","id");
                    }
                    try{
                         nombre = elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent();
                    }catch(Exception e){
                        nombre=(String)objetoIncompleto("Alumno","nombre");
                    }
                    try{
                         apellidos = elementoAlumno.getElementsByTagName("apellidos").item(0).getTextContent();
                    }catch(Exception e){
                       apellidos=(String)objetoIncompleto("Alumno","apellidos");
                    }
                    Alumno al = new Alumno(id,nombre,apellidos);
                    alumnos.add(al);                          
                }
            }

            return alumnos;         
        }
        private static ArrayList<Modulo> obtenerModulosXML(File f) throws SAXException, ParserConfigurationException, IOException{
            ArrayList<Modulo> modulos = new ArrayList<Modulo>();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(f);
            //obtenemos los modulos
            NodeList listaModulos = documento.getElementsByTagName("modulo");

            for(int i=0; i<listaModulos.getLength();i++) {
                Node nodoModulo = listaModulos.item(i);
                if(nodoModulo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoModulo = (Element) nodoModulo;
                    Integer id=null; String nombreCompleto=null; String ciclo=null;
                    Integer curso=null;Integer ECTS=null;
                    
                    //TODO try-catch
                    id=Integer.parseInt(elementoModulo.getElementsByTagName("id").item(0).getTextContent());
                    nombreCompleto=elementoModulo.getElementsByTagName("nombreCompleto").item(0).getTextContent();
                    ciclo=elementoModulo.getElementsByTagName("ciclo").item(0).getTextContent();
                    curso=Integer.parseInt(elementoModulo.getElementsByTagName("curso").item(0).getTextContent());
                    ECTS=Integer.parseInt(elementoModulo.getElementsByTagName("ECTS").item(0).getTextContent());
                    
                    Modulo mod = new Modulo(id,nombreCompleto,ciclo,curso,ECTS);
                    modulos.add(mod);
                    //si no encuentra algun dato saltara una exception
                }
            }
             return modulos;
        }
        private static ArrayList<Nota> obtenerNotasXML(File f) throws SAXException, ParserConfigurationException, IOException{
            ArrayList<Nota> notas = new ArrayList<Nota>();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(f);
            //obtenemos las notas
            NodeList listaNotas = documento.getElementsByTagName("nota");

            for(int i=0; i<listaNotas.getLength();i++) {
                Node nodoNota = listaNotas.item(i);
                if(nodoNota.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoNota = (Element) nodoNota;
                    Integer idAlumno=null; Integer idModulo=null; Double calificacion=null;
                    
                    //TODO try-catch
                    idAlumno=Integer.parseInt(elementoNota.getElementsByTagName("idAlumno").item(0).getTextContent());
                    idModulo=Integer.parseInt(elementoNota.getElementsByTagName("idModulo").item(0).getTextContent());
                    calificacion=Double.parseDouble(elementoNota.getElementsByTagName("calificacion").item(0).getTextContent());
                
                    
                    Nota nota = new Nota(idAlumno,idModulo,calificacion);
                    notas.add(nota);
                    //si no encuentra algun dato saltara una exception
                }
            }
            return notas;
        }
        private static void leerFicheros(File f) throws SAXException, ParserConfigurationException, IOException, ClassNotFoundException{
            File[] files =f.listFiles();
            alumnos=new ArrayList<Alumno>();
            modulos=new ArrayList<Modulo>();
            notas=new ArrayList<Nota>();
            
            ArrayList<Alumno> alumnos_aux;
            ArrayList<Modulo> modulos_aux;
            ArrayList<Nota> notas_aux;

            for(int i=0; i<files.length; i++){
                if(getFileExtension(files[i]).equals("xml")){
                    alumnos_aux=obtenerAlumnosXML(files[i]);
                    modulos_aux=obtenerModulosXML(files[i]);
                    notas_aux=obtenerNotasXML(files[i]);
                    
                    alumnos.addAll(alumnos_aux);
                    modulos.addAll(modulos_aux);
                    notas.addAll(notas_aux);
                }else{
                    ObjectInputStream objetoIS = null;
                    objetoIS = new ObjectInputStream(new FileInputStream(files[i]));

                    Object object = null;
                    while((object = objetoIS.readObject()) != null) {
                        if(object instanceof Alumno){
                            Alumno al = (Alumno) object;
                            alumnos.add(al);
                        }else if(object instanceof Modulo){
                            Modulo mod = (Modulo) object;
                            modulos.add(mod);
                        }else{
                            Nota nota = (Nota) object;
                            notas.add(nota);
                        }

                    }
                    objetoIS.close();
                }
            }
        }
        private static Object objetoIncompleto(String tipoObjeto,String atributo){
            System.out.println("Objeto incompleto. Desea completarlo?");
            
            switch (tipoObjeto) {
                case "Alumno" -> {
                    
                    if(atributo.equals("nombre")){
                        System.out.println("nombre: ");
                        String nombre = sc.nextLine();
                        return nombre;
                    }else{
                        System.out.println("apellidos: ");
                        String apellidos = sc.nextLine();
                        return apellidos;
                    }
                   
                }
                case "Modulo" -> {
                    Modulo mod = new Modulo(1,"","",1,1);
                    return mod;
                }
                default -> {
                    Nota nota = new Nota(1,1,1.0);
                    return nota;
                }
            }
        }
        
        private static void quitarDuplicados(){
            //TODO esto no funciona bien
            LinkedHashSet<Alumno> hashSet = new LinkedHashSet<>(alumnos);
            alumnos = new ArrayList<>(hashSet);
            LinkedHashSet<Modulo> hashSet2 = new LinkedHashSet<>(modulos);
            modulos = new ArrayList<>(hashSet2);
            LinkedHashSet<Nota> hashSet3 = new LinkedHashSet<>(notas);
            notas = new ArrayList<>(hashSet3);
        }
        private static void anadirDatos() throws SQLException{
            for(int i=0; i<alumnos.size(); i++){
                insertAlumno(alumnos.get(i));
            }
            for(int i=0; i<modulos.size(); i++){
                insertModulo(modulos.get(i));
            }
            for(int i=0; i<notas.size(); i++){
                insertNota(notas.get(i));
            }
        }
        
        private static void insertAlumno(Alumno al) throws SQLException{
            PreparedStatement s = c.prepareStatement("INSERT INTO Alumno (id_alumno,nombre,apellidos) VALUES (?,?,?)");
            s.setInt(1, al.getIdAlumno());
            s.setString(2, al.getNombre());
            s.setString(3, al.getApellidos());
            s.executeUpdate();
        }
        private static void insertModulo(Modulo mod) throws SQLException{
            PreparedStatement s = c.prepareStatement("INSERT INTO Modulo (id_modulo,nombreCompleto,ciclo,curso,ECTS) VALUES (?,?,?,?,?)");
            s.setInt(1, mod.getIdModulo());
            s.setString(2, mod.getNombreCompleto());
            s.setString(3, mod.getCiclo());
            s.setInt(4,mod.getCurso());
            s.setInt(5,mod.getECTS());
            s.executeUpdate();
        }
        private static void insertNota(Nota nota) throws SQLException{
            PreparedStatement s = c.prepareStatement("INSERT INTO Notas (id_modulo,id_alumno,calificacion) VALUES (?,?,?)");
            s.setInt(1, nota.getIdModulo());
            s.setInt(2, nota.getIdAlumno());
            s.setDouble(3, nota.getCalificacion());
            s.executeUpdate();
        }
        
}
