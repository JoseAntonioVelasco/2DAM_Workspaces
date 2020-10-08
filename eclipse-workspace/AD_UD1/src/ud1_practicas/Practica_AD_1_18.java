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

public class Practica_AD_1_18 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		File ficheroXML = new File("C:\\Users\\USER\\Desktop\\Nueva carpeta\\alumnos.xml");
		leerRecurXML(ficheroXML);
	}

	public static void leerRecurXML(File f) throws ParserConfigurationException, SAXException, IOException {
		//Creamos DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document documento = builder.parse(f);
		
		//Paso 1: obtener la raizdel fichero
		Element raiz = documento.getDocumentElement();
		System.out.println("El nodo raiz es: "+raiz.getNodeName());
		
		//Paso 2: obrengo los nodos de un determinado tipo
		NodeList listaAlumnos = documento.getElementsByTagName("alumno");
		
		compruebaNodo(listaAlumnos,0);
	}
	public static void compruebaNodo(NodeList listaAlumnos,int prof) throws ParserConfigurationException, SAXException, IOException {
		
		for(int i=0; i<listaAlumnos.getLength();i++) {
			
			Node nodoAlumno = listaAlumnos.item(i);
			if(nodoAlumno.getNodeType() == Node.ELEMENT_NODE) {
				
				String tabulaciones="";
				for(int j=0;j<prof;j++) {
					tabulaciones=tabulaciones+"\t";
				}
				
				//System.out.println(tabulaciones+"nom: "+nodoAlumno.getNodeName()+
				//" val: "+nodoAlumno.getTextContent());
				
				System.out.println(tabulaciones+"nom: "+nodoAlumno.getNodeName()+
						" val: "+nodoAlumno.getFirstChild().getNodeValue());
				
			}
			if(nodoAlumno.hasChildNodes()) {
				compruebaNodo(nodoAlumno.getChildNodes(),prof+1);
			}
			
			
		}
				
	}
}
