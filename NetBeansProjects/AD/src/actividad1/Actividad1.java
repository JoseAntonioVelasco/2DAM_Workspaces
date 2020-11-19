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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        private static String ruta_destino;
	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SAXException, ParserConfigurationException {
            sc =new Scanner(System.in);
            /*PARTE 1*/
            System.out.println("Escribe la ruta donde quieres que se guarden los ficheros: ");
            ruta_destino = sc.nextLine();


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
            }
            /*PARTE 1*/
            
            /*PARTE 2*/
            leerFicheros(new File(ruta_destino));
            try {
                crearBBDD();
                conectarBBDD();
                crearTablas();
                anadirDatos();
                buscarDatos();
            } catch (SQLException ex) {
                //Logger.getLogger(Actividad1.class.getName()).log(Level.SEVERE, null, ex);
                muestraErrorSQL(ex);
            }
            /*PARTE 2*/
            sc.close();
	}
        /**
         * Reccorre de manera recursiva un directorio moviendo los ficheros de un origen a un destino
         * @param archivos los ficheros que hay dentro del archivo
         * @param ruta_destino la ruta donde se van a guardar los ficheros seleccionados
         * @param ruta_origen la ruta de donde va a sacar los ficheros
         * @param log  el fichero donde va a guardar los cambios ocurridos
         */
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
        /**
         * Consigue el formato de un fichero
         * @param file fichero del que queremos sacar la extension
         * @return retorna la extension del fichero
         */
	private static String getFileExtension(File file) {
            String fileName = file.getName();
            if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
            else return "";
	}
	/**
         * para registrar los cambios ocurridos
         * @param name_filemoved nombre del fichero que se ha movido
         * @param origen donde estaba el fichero
         * @param destino donde se ha movido el fichero
         */
	private static void logTo(String name_filemoved,String origen,String destino) {
            try { 
                  myWriter.append(name_filemoved+" copiado a "+destino+". \nEliminado con exito de "+origen+"\n"); 
                } catch (IOException e) {
                  e.printStackTrace();
                } 
	}
	/**
         * si la clase que se ha intentado renombrar falla se le da un nuevo nombre
         * @param archivo fichero que ha fallado el renombrar
         * @param ruta_destino destino de donde lo vamos a meter
         * @param num numero que aparecera en el archivo renombrado
         */
	private static void failedRename(File archivo,String ruta_destino,int num) {
	
            if(!(archivo.renameTo(new File(ruta_destino+"/"+stripExtension(archivo.getName())+"("+num+")"+"."+getFileExtension(archivo))))) {
                    failedRename(archivo,ruta_destino,num+1);
            }
	}
	
	//nota la libreria "org.apache.commons.io.FilenameUtils" tiene unos metodos muy utiles para este ejercicio
	//funcion copiada de: https://stackoverflow.com/questions/924394/how-to-get-the-filename-without-the-extension-in-java
        /**
         * saca de un string la extension que tenga ej: "cadena.exe" retorna exe
         * @param str la cadena de la que queremos obtener la extension
         * @return la extension del string
         */
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
        /**
         * Crea la Base de datos en mysql
         * @throws SQLException 
         */
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
        /**
         * Conecta a la bbdd
         * @throws SQLException 
         */
        private static void conectarBBDD() throws SQLException{
            c = DriverManager.getConnection(urlConnection, user, pwd);
            System.out.println("Conexion realizada");
        }
        /**
         * Crea las tablas
         * @throws SQLException 
         */
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
        /**
         * guarda los errores en un fichero de erroresSQL en la ruta_destino
         * @param e 
         */
        private static void muestraErrorSQL(SQLException e){           
            try {
                FileWriter myWriter = new FileWriter(ruta_destino+"//erroresSQL.txt");
                myWriter.append("SQL Estado: "+e.getSQLState()+"\n");
                myWriter.append("SQL codigo especifico: "+e.getErrorCode()+"\n");
                myWriter.append("SQL ERROR mensaje: "+e.getMessage()+"\n");
                myWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Actividad1.class.getName()).log(Level.SEVERE, null, ex);
            } 
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
            public Boolean comparar(Alumno al){
                return this.nombre.equals(al.nombre) && this.apellidos.equals(al.apellidos);
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
            public Boolean comparar(Modulo mod){
                return this.nombreCompleto.equals(mod.getNombreCompleto())
                        &&this.curso==mod.getCurso()
                        &&this.ciclo.equals(mod.getCiclo())
                        &&this.ECTS==mod.getECTS();
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
        /**
         * Para obtener los alumnos de un fichero xml
         * @param f fichero del que queremos obtener los alumnos
         * @return
         * @throws SAXException
         * @throws ParserConfigurationException
         * @throws IOException 
         */
        private static ArrayList<Alumno> obtenerAlumnosXML(File f) throws SAXException, ParserConfigurationException, IOException{
              
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
                        if(preguntarDescartar_objetoIncompleto("Alumno")){
                            id=(Integer)objetoIncompleto("Alumno","id");
                        } else{continue;}
                    }
                    try{
                         nombre = elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent();
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Alumno")){
                            nombre=(String)objetoIncompleto("Alumno","nombre");
                        }else{continue;}
                    }
                    try{
                         apellidos = elementoAlumno.getElementsByTagName("apellidos").item(0).getTextContent();
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Alumno")){
                            apellidos=(String)objetoIncompleto("Alumno","apellidos");
                        }else{continue;}
                    }
                    Alumno al = new Alumno(id,nombre,apellidos);
                    if(!repetido(al)){
                        alumnos.add(al);
                    }
                                 
                }
            }

            return alumnos;         
        }
       /**
         * Para obtener los alumnos de un fichero xml
         * @param f fichero del que queremos obtener los modulos
         * @return
         * @throws SAXException
         * @throws ParserConfigurationException
         * @throws IOException 
         */
        private static ArrayList<Modulo> obtenerModulosXML(File f) throws SAXException, ParserConfigurationException, IOException{
            
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
                    
                    try{
                        id=Integer.parseInt(elementoModulo.getElementsByTagName("id").item(0).getTextContent());
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Modulo")){
                            id=(Integer)objetoIncompleto("Modulo","id");
                        }else{continue;}
                    }
                    
                    try{
                        nombreCompleto=elementoModulo.getElementsByTagName("nombreCompleto").item(0).getTextContent();
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Modulo")){
                            nombreCompleto=(String)objetoIncompleto("Modulo","nombre");
                        }else{continue;}
                    }
                    
                    try{
                        ciclo=elementoModulo.getElementsByTagName("ciclo").item(0).getTextContent();
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Modulo")){
                            ciclo=(String)objetoIncompleto("Modulo","ciclo");
                        }else{continue;}
                    }
                    
                    try{
                        curso=Integer.parseInt(elementoModulo.getElementsByTagName("curso").item(0).getTextContent());
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Modulo")){
                            curso=(Integer)objetoIncompleto("Modulo","curso");
                        }else{continue;}
                    }
                    
                    try{
                        ECTS=Integer.parseInt(elementoModulo.getElementsByTagName("ECTS").item(0).getTextContent());
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Modulo")){
                            ECTS=(Integer)objetoIncompleto("Modulo","ECTS");
                        }else{continue;}
                    }
                    
                    Modulo mod = new Modulo(id,nombreCompleto,ciclo,curso,ECTS);
                    if(!repetido(mod)){
                        modulos.add(mod);
                    }else{continue;}

                }
            }
             return modulos;
        }
         /**
         * Para obtener los alumnos de un fichero xml
         * @param f fichero del que queremos obtener las notas
         * @return
         * @throws SAXException
         * @throws ParserConfigurationException
         * @throws IOException 
         */
        private static ArrayList<Nota> obtenerNotasXML(File f) throws SAXException, ParserConfigurationException, IOException{
            
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
                    try{
                        idAlumno=Integer.parseInt(elementoNota.getElementsByTagName("idAlumno").item(0).getTextContent());
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Nota")){
                            idAlumno=(Integer)objetoIncompleto("Nota","idAlumno");
                        }else{continue;}
                    }
                    
                    try{
                        idModulo=Integer.parseInt(elementoNota.getElementsByTagName("idModulo").item(0).getTextContent());
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Nota")){
                            idModulo=(Integer)objetoIncompleto("Nota","idModulo");
                        }else{continue;}
                    }
                     
                    try{
                        calificacion=Double.parseDouble(elementoNota.getElementsByTagName("calificacion").item(0).getTextContent());
                    }catch(Exception e){
                        if(preguntarDescartar_objetoIncompleto("Nota")){
                            calificacion=(Double)objetoIncompleto("Nota","calificacion");
                        }else{continue;}
                    }

                    Nota nota = new Nota(idAlumno,idModulo,calificacion);
                    if(!repetido(nota)){
                        notas.add(nota);
                    }
                  
                }
            }
            return notas;
        }
        /**
         * lee todos los ficheros xml y dat del que se encuentren en ese lugar y obtiene todos los alumnos, modulos y notas
         * 
         * @param f lugar del que queremos leer todos los ficheros
         * @throws SAXException
         * @throws ParserConfigurationException
         * @throws IOException
         * @throws ClassNotFoundException 
         */
        private static void leerFicheros(File f) throws SAXException, ParserConfigurationException, IOException, ClassNotFoundException{
            File[] files =f.listFiles();
            alumnos=new ArrayList<>();
            modulos=new ArrayList<>();
            notas=new ArrayList<>();
            
            //recorremos todos los ficheros que hay
            for(int i=0; i<files.length; i++){
                if(getFileExtension(files[i]).equals("xml")){
                    //AQUI XML
                    //obtenemos todos los objetos del xml y los metemos en sus respectivos arrays
                    obtenerAlumnosXML(files[i]);
                    obtenerModulosXML(files[i]);
                    obtenerNotasXML(files[i]);
                }else if(getFileExtension(files[i]).equals("dat")){
                    //AQUI DAT
                    ObjectInputStream objetoIS = null;
                    objetoIS = new ObjectInputStream(new FileInputStream(files[i]));

                    Object object = null;
                    while((object = objetoIS.readObject()) != null) {
                        if(object instanceof Alumno){
                            Alumno al = (Alumno) object;
                            if(!repetido(al)){
                                alumnos.add(al);
                            }
                        }else if(object instanceof Modulo){
                            Modulo mod = (Modulo) object;
                            if(!repetido(mod)){
                                modulos.add(mod);
                            }
                        }else{
                            Nota nota = (Nota) object;
                            if(!repetido(nota)){
                                notas.add(nota);
                            }
                        }
                    }
                    objetoIS.close();
                }
            }
        }
        /**
         * pregunta si quiere descartar un tipo de objeto
         * @param tipo nombre de la clase que quiere descartar
         * @return true -> completar false -> descartar
         */
        private static Boolean preguntarDescartar_objetoIncompleto(String tipo){
            System.out.println(tipo+" incompleto. Desea completarlo?");
            System.out.println("1)Si");
            System.out.println("2)No");
            System.out.print("Opcion: ");
            Integer opcion = sc.nextInt();sc.nextLine();
            if(opcion==1){
                return true;
            }else{
                return false;
            }
        }
        /**
         * Si encuentra un objeto incompleto preguntara los datos que le falten
         * @param tipoObjeto nombre de la clase de la que faltan datos
         * @param atributo atributo de la clase de la que faltan datos
         * @return lo que falta de la clase
         */
        private static Object objetoIncompleto(String tipoObjeto,String atributo){
            
            switch (tipoObjeto) {
                case "Alumno" -> {
                    if(atributo.equals("id")){
                        System.out.print("id: ");
                        Integer id = sc.nextInt();sc.nextLine();
                        return id;
                    }else if(atributo.equals("nombre")){
                        System.out.print("nombre: ");
                        return sc.nextLine();
                    }else{
                        System.out.print("apellidos: ");
                        return sc.nextLine();
                    }

                }
                case "Modulo" -> {
                    if(atributo.equals("id")){
                        System.out.print("id: ");
                        Integer id = sc.nextInt();sc.nextLine();
                        return id;
                    }else if(atributo.equals("nombre")){
                        System.out.print("nombre: ");
                        return sc.nextLine();
                    }else if(atributo.equals("ciclo")){
                        System.out.print("ciclo: ");
                        return sc.nextLine();
                    }else if(atributo.equals("curso")){
                        System.out.print("curso: ");
                        Integer id = sc.nextInt();sc.nextLine();
                        return id;
                    }else{
                        System.out.print("ECTS: ");
                        Integer id = sc.nextInt();sc.nextLine();
                        return id;
                    }
                }
                default -> {
                    if(atributo.equals("idAlumno")){
                        System.out.print("id alumno: ");
                        Integer id = sc.nextInt();sc.nextLine();
                        return id;
                    }else if(atributo.equals("idModulo")){
                        System.out.print("id modulo: ");
                        return sc.nextInt();
                    }else{
                        System.out.print("calificacion: ");
                        Double id = sc.nextDouble();sc.nextLine();
                        return id;
                    }
                }
            }
    
        }
        /**
         * comprueba si el objeto esta repetido en su respectivo arraylist
         * @param objeto
         * @return true->repetido false->sin repetir
         * @throws IOException 
         */
        private static Boolean repetido(Object objeto) throws IOException{
            if(objeto instanceof Alumno){
                Alumno al = (Alumno)objeto;
                for(int i=0;i<alumnos.size();i++){
                    if(al.getIdAlumno()==alumnos.get(i).getIdAlumno()){
                        //CONFLICTO alumnos con mismo id
                        duplicadoAlumno(alumnos.get(i),al);
                        return true;
                    }
                    if(al.comparar(alumnos.get(i))){
                        //CONFLICTO alumnos con distinto id pero misma informacion
                        duplicadoAlumno(alumnos.get(i),al);
                        return true;
                    }
                }
            }else if(objeto instanceof Modulo){
                Modulo mod = (Modulo)objeto;
                for(int i=0;i<modulos.size();i++){
                    if(mod.getIdModulo()==modulos.get(i).getIdModulo()){
                        //CONFLICTO alumnos con mismo id
                        duplicadoModulo(modulos.get(i),mod);
                        return true;
                    }
                    if(mod.comparar(modulos.get(i))){
                        //CONFLICTO alumnos con distinto id pero misma informacion
                        duplicadoModulo(modulos.get(i),mod);
                        return true;
                    }
                }
            }else{
                Nota nota = (Nota)objeto;
                for(int i=0;i<notas.size();i++){
                    if(nota.getIdModulo()==notas.get(i).getIdModulo() && nota.getIdAlumno()==notas.get(i).getIdAlumno()){
                       //CONFLICTO un alumno no puede tener tener dos notas en el mismo modulo
                       duplicadoNota(notas.get(i),nota);
                       return true;
                    }
                }
            }
            return false;
        }
        /**
         * muestra el mensaje de conflicto por alumno duplicado y da a elegir, y guarda el descartado en un fichero txt
         * @param ali alumno 1 del conflicto
         * @param alj alumno 2 del conflicto
         * @throws IOException 
         */
        private static void duplicadoAlumno(Alumno ali,Alumno alj) throws IOException{
            System.out.println("Conflicto alumno: misma id // mismos datos");
            System.out.println("- - -ALUMNO 1- - -");
            System.out.println("Id: "+ali.getIdAlumno());
            System.out.println("nombre: "+ali.getNombre());
            System.out.println("Apellidos: "+ali.getApellidos());
            System.out.println("- - -ALUMNO 2- - -");
            System.out.println("Id: "+alj.getIdAlumno());
            System.out.println("nombre: "+alj.getNombre());
            System.out.println("Apellidos: "+alj.getApellidos());
            System.out.print("Elije que alumno guardar: ");
            Integer opcion = sc.nextInt();sc.nextLine();
            if(opcion == 1){
                guardarDuplicadosDescartados(ruta_destino,alj);
            }else{
                alumnos.remove(ali);
                alumnos.add(alj);
                guardarDuplicadosDescartados(ruta_destino,ali);    
            }
        }
         /**
         * muestra el mensaje de conflicto por modulo duplicado y da a elegir, y guarda el descartado en un fichero txt
         * @param ali modulo 1 del conflicto
         * @param alj modulo 2 del conflicto
         * @throws IOException 
         */
        private static void duplicadoModulo(Modulo ali,Modulo alj) throws IOException{
            System.out.println("Conflicto modulo: misma id // mismos datos");
            System.out.println("- - -MODULO 1- - -");
            System.out.println("Id: "+ali.getIdModulo());
            System.out.println("nombre: "+ali.getNombreCompleto());
            System.out.println("ciclo: "+ali.getCiclo());
            System.out.println("curso: "+ali.getCurso());
            System.out.println("ECTS: "+ali.getECTS());
            System.out.println("- - -MODULO 2- - -");
            System.out.println("Id: "+alj.getIdModulo());
            System.out.println("nombre: "+alj.getNombreCompleto());
            System.out.println("ciclo: "+alj.getCiclo());
            System.out.println("curso: "+alj.getCurso());
            System.out.println("ECTS: "+alj.getECTS());
            System.out.print("Elije que modulo guardar: ");
            Integer opcion = sc.nextInt();
            if(opcion == 1){
                guardarDuplicadosDescartados(ruta_destino,alj);
            }else{
                modulos.remove(ali);
                modulos.add(alj);
                guardarDuplicadosDescartados(ruta_destino,ali);    
            }
        }
        /**
         * muestra el mensaje de conflicto por nota duplicado y da a elegir, y guarda el descartado en un fichero txt
         * @param ali nota 1 del conflicto
         * @param alj nota 2 del conflicto
         * @throws IOException 
         */
         private static void duplicadoNota(Nota ali,Nota alj) throws IOException{
            System.out.println("Conflicto alumno: misma id // mismos datos");
            System.out.println("- - -NOTA 1- - -");
            System.out.println("Id alumno: "+ali.getIdAlumno());
            System.out.println("Id modulo: "+ali.getIdModulo());
            System.out.println("calificacion: "+ali.getCalificacion());
            System.out.println("- - -NOTA2 2- - -");
            System.out.println("Id alumno: "+alj.getIdAlumno());
            System.out.println("Id modulo: "+alj.getIdModulo());
            System.out.println("calificacion: "+alj.getCalificacion());
            System.out.print("Elije que nota guardar: ");
            Integer opcion = sc.nextInt();sc.nextLine();
            if(opcion == 1){
                guardarDuplicadosDescartados(ruta_destino,alj);
            }else{
                notas.remove(ali);
                notas.add(alj);
                guardarDuplicadosDescartados(ruta_destino,ali);    
            }
        }
         /**
          * para guardar el objeto duplicado en el fichero txt
          * @param ruta_destino
          * @param objeto
          * @throws IOException 
          */
        private static void guardarDuplicadosDescartados(String ruta_destino,Object objeto) throws IOException{
            FileWriter myWriter = new FileWriter(ruta_destino+"//duplicadosDescartados.txt",true);
            if(objeto instanceof Alumno){
                Alumno al = (Alumno)objeto;
                myWriter.append("Alumno: "+al.getIdAlumno()+", "+al.getNombre()+", "+al.getApellidos()+"\n");
            }else if(objeto instanceof Modulo){
                Modulo mod = (Modulo)objeto;
                myWriter.append("Modulo: "+mod.getIdModulo()+", "+mod.getNombreCompleto()+", "+mod.getCiclo()+", "+mod.getCurso()+", "+mod.getECTS()+"\n");
            }else{
                Nota nota = (Nota)objeto;
                myWriter.append("Nota: "+nota.getIdAlumno()+", "+nota.getIdModulo()+", "+nota.getCalificacion()+"\n");
            }
            myWriter.close();
        
        }
        /**
         * Inserta los datos contenidos en los arraylist en la base de datos
         * @throws SQLException 
         */
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
        /**
         * Consulta que inserta un alumno a la bbdd
         * @param al alumno que queremos insertar
         * @throws SQLException 
         */
        private static void insertAlumno(Alumno al) throws SQLException{
            PreparedStatement s = c.prepareStatement("INSERT INTO Alumno (id_alumno,nombre,apellidos) VALUES (?,?,?)");
            s.setInt(1, al.getIdAlumno());
            s.setString(2, al.getNombre());
            s.setString(3, al.getApellidos());
            s.executeUpdate();
        }
        /**
         * Consulta que inserta un modulo a la bbdd
         * @param al modulo que queremos insertar
         * @throws SQLException 
         */
        private static void insertModulo(Modulo mod) throws SQLException{
            PreparedStatement s = c.prepareStatement("INSERT INTO Modulo (id_modulo,nombreCompleto,ciclo,curso,ECTS) VALUES (?,?,?,?,?)");
            s.setInt(1, mod.getIdModulo());
            s.setString(2, mod.getNombreCompleto());
            s.setString(3, mod.getCiclo());
            s.setInt(4,mod.getCurso());
            s.setInt(5,mod.getECTS());
            s.executeUpdate();
        }
        /**
         * Consulta que inserta un nota a la bbdd
         * @param al nota que queremos insertar
         * @throws SQLException 
         */
        private static void insertNota(Nota nota) throws SQLException{
            PreparedStatement s = c.prepareStatement("INSERT INTO Notas (id_modulo,id_alumno,calificacion) VALUES (?,?,?)");
            s.setInt(1, nota.getIdModulo());
            s.setInt(2, nota.getIdAlumno());
            s.setDouble(3, nota.getCalificacion());
            s.executeUpdate();
        }
        /**
         * Menu que nos permite buscar datos en la base de datos
         * @throws SQLException 
         */
        private static void buscarDatos() throws SQLException{
            Boolean salir = false;
            while(!salir){
                System.out.println("1)Buscar por campos.");
                System.out.println("2)Mostrar todos los datos de la tabla.");
                System.out.print("Opcion: ");
                Integer option = sc.nextInt();sc.nextLine();

                if(option ==1){
                    System.out.println("En que tabla quieres buscar: ");
                    System.out.println("1)Alumnos");
                    System.out.println("2)Modulos");
                    System.out.println("3)Notas");         
                    System.out.print("Opcion: ");
                    Integer opcion = sc.nextInt();sc.nextLine();
                    switch (opcion) {
                        case 1 -> {
                            System.out.println("Por que campo quieres buscar");
                            System.out.println("1)Id");
                            System.out.println("2)Nombre");
                            System.out.println("3)Apellidos");    
                            System.out.print("Opcion: ");
                            Integer opcion1 = sc.nextInt();
                            switch (opcion1) {
                                case 1 -> {
                                    System.out.print("Introduce id: ");
                                    Integer id = sc.nextInt();sc.nextLine();
                                    buscarAlumnos_porID(id);
                                }
                                case 2 -> {
                                    System.out.print("Introduce nombre: ");
                                    String nombre = sc.nextLine();
                                    buscarAlumnos_porNombre(nombre);
                                }
                                default -> {
                                    System.out.print("Introduce apellidos: ");
                                    String nombre = sc.nextLine();
                                    buscarAlumnos_porApellidos(nombre);
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("Por que campo quieres buscar");
                            System.out.println("1)Id");
                            System.out.println("2)Nombre completo");
                            System.out.println("3)Ciclo");
                            System.out.println("4)Curso"); 
                            System.out.println("5)ECTS"); 
                            System.out.print("Opcion: ");
                            Integer opcion2 = sc.nextInt();sc.nextLine();
                            switch (opcion2) {
                                case 1 -> {
                                    System.out.print("Introduce id: ");
                                    Integer id = sc.nextInt();sc.nextLine();
                                    buscarModulos_porID(id);
                                }
                                case 2 -> {
                                    System.out.print("Introduce nombre completo: ");
                                    String nombre = sc.nextLine();
                                    buscarModulos_porNombre(nombre);
                                }
                                case 3 -> {
                                    System.out.print("Introduce ciclo: ");
                                    String nombre = sc.nextLine();
                                    buscarModulos_porCiclo(nombre);
                                }
                                case 4 -> {
                                    System.out.print("Introduce curso: ");
                                    Integer id = sc.nextInt();sc.nextLine();
                                    buscarModulos_porCurso(id);
                                }
                                default -> {
                                    System.out.print("Introduce ECTS: ");
                                    Integer id = sc.nextInt();sc.nextLine();
                                    buscarModulos_porECTS(id);
                                }
                            }
                        }
                        default -> {
                            System.out.println("Por que campo quieres buscar");
                            System.out.println("1)Id alumno");
                            System.out.println("2)Id modulo");
                            System.out.println("3)Calificacion");    
                            System.out.print("Opcion: ");
                            Integer opcion3 = sc.nextInt();sc.nextLine();
                            switch (opcion3) {
                                case 1 -> {
                                    System.out.print("Introduce id alumno: ");
                                    Integer id = sc.nextInt();sc.nextLine();
                                    buscarNotas_porIdAlumno(id);
                                }
                                case 2 -> {
                                    System.out.print("Introduce id modulo: ");
                                    Integer id = sc.nextInt();sc.nextLine();
                                    buscarNotas_porIdModulo(id);
                                }
                                default -> {
                                    System.out.print("Introduce calificacion: ");
                                    Double id = sc.nextDouble();sc.nextLine();
                                    buscarNotas_porCalificacion(id);
                                }
                            }
                        }
                    }
                }else{
                    System.out.println("1)Tabla alumnos");
                    System.out.println("2)Tabla modulos");
                    System.out.println("3)Tabla notas");
                    System.out.print("Opcion: ");
                    Integer opcion = sc.nextInt();sc.nextLine();
                    switch (opcion) {
                        case 1 -> {
                            mostrarTablaAlumnos();
                        }
                        case 2 -> {
                            mostrarTablaModulos();
                        }
                        default -> {
                            mostrarTablaNotas();
                        }
                    }
                }
                System.out.println("Salir?: ");
                System.out.println("1)Si");
                System.out.println("2)No");
                Integer opcion = sc.nextInt();sc.nextLine();
                if(opcion==1){
                    salir=true;
                }else{
                    salir=false;
                }
            }
        }
        /**
         * Muestra todos los datos en la tabla alumnos
         * @throws SQLException 
         */
        private static void mostrarTablaAlumnos() throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM alumnos");
            
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_alumno"));
                System.out.println("nombre: "+rs.getString("nombre"));
                System.out.println("apellidos: "+rs.getString("apellidos"));
            }
        }
        /**
         * Busca todos los alumnos que tengan esa id
         * @throws SQLException 
         */
        private static void buscarAlumnos_porID(Integer id) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM alumnos WHERE id_alumno=?");
            s.setInt(1, id);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_alumno"));
                System.out.println("nombre: "+rs.getString("nombre"));
                System.out.println("apellidos: "+rs.getString("apellidos"));
            }
            
        }
        /**
         * Busca todos los alumnos que tengan esa nombre
         * @throws SQLException 
         */
        private static void buscarAlumnos_porNombre(String nombre) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM alumnos WHERE nombre=?");
            s.setString(1, nombre);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_alumno"));
                System.out.println("nombre: "+rs.getString("nombre"));
                System.out.println("apellidos: "+rs.getString("apellidos"));
            }
        }
        /**
         * Busca todos los alumnos que tengan esa apellidos
         * @throws SQLException 
         */
        private static void buscarAlumnos_porApellidos(String apellidos) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM alumnos WHERE apellidos=?");
            s.setString(1, apellidos);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_alumno"));
                System.out.println("nombre: "+rs.getString("nombre"));
                System.out.println("apellidos: "+rs.getString("apellidos"));
            }
        }
        
         /**
         * Muestra todos los datos en la tabla modulos
         * @throws SQLException 
         */
        private static void mostrarTablaModulos() throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM modulos");
            
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_modulo"));
                System.out.println("nombre: "+rs.getString("nombreCompleto"));
                System.out.println("ciclo: "+rs.getString("ciclo"));
                System.out.println("curso: "+rs.getString("curso"));
                System.out.println("ECTS: "+rs.getString("ECTS"));
            }
        }
         /**
         * Busca todos los modulos que tengan esa id
         * @throws SQLException 
         */
        private static void buscarModulos_porID(Integer id) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM modulos WHERE id = ?");
            s.setInt(1, id);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_modulo"));
                System.out.println("nombre: "+rs.getString("nombreCompleto"));
                System.out.println("ciclo: "+rs.getString("ciclo"));
                System.out.println("curso: "+rs.getString("curso"));
                System.out.println("ECTS: "+rs.getString("ECTS"));
            }
            
        }
        /**
         * Busca todos los modulos que tengan esa nombre
         * @throws SQLException 
         */
        private static void buscarModulos_porNombre(String nombre) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM modulos WHERE nombreCompleto = ?");
            s.setString(1, nombre);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_modulo"));
                System.out.println("nombre: "+rs.getString("nombreCompleto"));
                System.out.println("ciclo: "+rs.getString("ciclo"));
                System.out.println("curso: "+rs.getString("curso"));
                System.out.println("ECTS: "+rs.getString("ECTS"));
            }
        }
        /**
         * Busca todos los modulos que tengan esa ciclo
         * @throws SQLException 
         */
        private static void buscarModulos_porCiclo(String ciclo) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM modulos WHERE ciclo = ?");
            s.setString(1, ciclo);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_modulo"));
                System.out.println("nombre: "+rs.getString("nombreCompleto"));
                System.out.println("ciclo: "+rs.getString("ciclo"));
                System.out.println("curso: "+rs.getString("curso"));
                System.out.println("ECTS: "+rs.getString("ECTS"));
            }
        }
        /**
         * Busca todos los modulos que tengan esa curso
         * @throws SQLException 
         */
        private static void buscarModulos_porCurso(Integer curso) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM modulos WHERE curso = ?");
            s.setInt(1, curso);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_modulo"));
                System.out.println("nombre: "+rs.getString("nombreCompleto"));
                System.out.println("ciclo: "+rs.getString("ciclo"));
                System.out.println("curso: "+rs.getString("curso"));
                System.out.println("ECTS: "+rs.getString("ECTS"));
            }
        }
        /**
         * Busca todos los modulos que tengan esa ECTS
         * @throws SQLException 
         */
        private static void buscarModulos_porECTS(Integer ECTS) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM modulos WHERE ECTS = ?");
            s.setInt(1, ECTS);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id: "+rs.getString("id_modulo"));
                System.out.println("nombre: "+rs.getString("nombreCompleto"));
                System.out.println("ciclo: "+rs.getString("ciclo"));
                System.out.println("curso: "+rs.getString("curso"));
                System.out.println("ECTS: "+rs.getString("ECTS"));
            }
        }
        
        /**
         * Muestra todos los datos en la tabla alumnos
         * @throws SQLException 
         */
        private static void mostrarTablaNotas() throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM notas");
            
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id alumno: "+rs.getString("id_alumno"));
                System.out.println("Id modulo: "+rs.getString("id_modulo"));
                System.out.println("calificacion: "+rs.getString("calificacion"));
            }
        }
        /**
         * Busca todos los notas que tengan esa id alumno
         * @throws SQLException 
         */
        private static void buscarNotas_porIdAlumno(Integer idAlumno) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM notas WHERE id_alumno = ?");
            s.setInt(1, idAlumno);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id alumno: "+rs.getString("id_alumno"));
                System.out.println("Id modulo: "+rs.getString("id_modulo"));
                System.out.println("calificacion: "+rs.getString("calificacion"));
            }
        }
        /**
         * Busca todos los notas que tengan esa id modulo
         * @throws SQLException 
         */
        private static void buscarNotas_porIdModulo(Integer idModulo) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM notas WHERE id_modulo = ?");
            s.setInt(1, idModulo);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id alumno: "+rs.getString("id_alumno"));
                System.out.println("Id modulo: "+rs.getString("id_modulo"));
                System.out.println("calificacion: "+rs.getString("calificacion"));
            }
        }
        /**
         * Busca todos los notas que tengan esa calificacion
         * @throws SQLException 
         */
        private static void buscarNotas_porCalificacion(Double calificacion) throws SQLException{
            PreparedStatement s = c.prepareStatement("SELECT * FROM notas WHERE calificacion = ?");
            s.setDouble(1, calificacion);
            ResultSet rs=s.executeQuery();
            
            int i = 1;
            while(rs.next()){
                System.out.println("[" +(i++) +"]");
                System.out.println("Id alumno: "+rs.getString("id_alumno"));
                System.out.println("Id modulo: "+rs.getString("id_modulo"));
                System.out.println("calificacion: "+rs.getString("calificacion"));
            }
        }
}
