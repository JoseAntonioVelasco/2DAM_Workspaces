package ud1_practicas;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Practica_AD_1_15{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		File ficheroXML = new File("C:\\Users\\USER\\Documents\\GitWorkspaces\\2DAM_Workspaces\\eclipse-workspace\\AD_UD1\\src\\ud1_practicas");
		leerXML(ficheroXML);
	}
	public static void leerXML(File f){
		//Creamos DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Document documento = null;
		try {
			documento = builder.parse(f);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		System.out.println("Version: "+documento.getXmlVersion());
		System.out.println("Encoding: "+documento.getXmlEncoding());
		
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

}