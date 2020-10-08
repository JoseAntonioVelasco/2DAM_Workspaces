package ud1_practicas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Practica_AD_1_16 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		File ficheroXML = new File("C:\\Users\\USER\\Desktop\\Nueva carpeta\\alumnos.xml");
		//leerXML(ficheroXML);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos = obtenerObjetosAlumno(ficheroXML);
		for(int i=0;i<alumnos.size();i++) {
			System.out.println(alumnos.get(i).getApellidos());
		}
		
		//leerRecurXML(ficheroXML);
	}
	public static void leerXML(File f) throws ParserConfigurationException, SAXException, IOException {
		//Creamos DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document documento = builder.parse(f);
		
		//Paso 1: obtener la raizdel fichero
		Element raiz = documento.getDocumentElement();
		System.out.println("El nodo raiz es: "+raiz.getNodeName());
		
		//Paso 2: obrengo los nodos de un determinado tipo
		NodeList listaAlumnos = documento.getElementsByTagName("alumno");
		
		
		//forma 1
		/*
		for(int i=0; i<listaAlumnos.getLength();i++) {
			Node nodoAlumno = listaAlumnos.item(i);
			
			NodeList listaHijos = nodoAlumno.getChildNodes();
			//System.out.println(nodoAlumno.getNodeName());
			for(int j=0;j<listaHijos.getLength();j++) {
				Node nodoHijo = listaHijos.item(j);
				System.out.println("Nombre: "+nodoHijo.getNodeName());
				System.out.println("Contenido: "+nodoHijo.getTextContent());
			}
		}
		*/
		
		//forma 2
		for(int i=0; i<listaAlumnos.getLength();i++) {
			Node nodoAlumno = listaAlumnos.item(i);
			if(nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoAlumno = (Element) nodoAlumno;
				//System.out.println("Nombre: "+elementoAlumno.getAttribute("nombre"));
				
				System.out.println("Nombre: "+elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent());
				System.out.println("Apellidos: "+elementoAlumno.getElementsByTagName("apellidos").item(0).getTextContent());
				System.out.println("nota AD: "+elementoAlumno.getElementsByTagName("nota_AD").item(0).getTextContent());
				System.out.println("nota PSP: "+elementoAlumno.getElementsByTagName("nota_PSP").item(0).getTextContent());
				System.out.println("nota SGE: "+elementoAlumno.getElementsByTagName("nota_SGE").item(0).getTextContent());
				System.out.println("");
					
			}
			
		}
		
	}
	public static ArrayList<Alumno> obtenerObjetosAlumno(File f) throws SAXException, IOException, ParserConfigurationException{
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		//Creamos DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document documento = builder.parse(f);
		
		NodeList listaAlumnos = documento.getElementsByTagName("alumno");
		
		for(int i=0; i<listaAlumnos.getLength();i++) {
			Node nodoAlumno = listaAlumnos.item(i);
			if(nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoAlumno = (Element) nodoAlumno;
				//System.out.println("Nombre: "+elementoAlumno.getAttribute("nombre"));
				//
				Alumno al = new Alumno(
				elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent(),
				elementoAlumno.getElementsByTagName("apellidos").item(0).getTextContent(),
				Integer.parseInt(elementoAlumno.getElementsByTagName("nota_AD").item(0).getTextContent()),
				Integer.parseInt(elementoAlumno.getElementsByTagName("nota_PSP").item(0).getTextContent()),
				Integer.parseInt(elementoAlumno.getElementsByTagName("nota_SGE").item(0).getTextContent()));
			
				alumnos.add(al);
			}
			
		}
		//Bucle FOR para recorrer la lista --> NODOS
		
			//Bucle for para recorrer los elementos de cada nodo
		
				//Con la informacion de los elementos contruo el objeto
				//de tipo Alumno
		
		return alumnos;
		
	}

		
	
}
