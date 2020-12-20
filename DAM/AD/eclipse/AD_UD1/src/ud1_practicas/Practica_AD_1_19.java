package ud1_practicas;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Practica_AD_1_19 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Document documento = builder.newDocument();
		documento.setXmlVersion("1.0");
		
		Element elementoAlumnosRaiz = documento.createElement("asignaturas");
		documento.appendChild(elementoAlumnosRaiz);
		
		
		/*Asignatura*/
		Element elementoAlumno = documento.createElement("asignatura");
		elementoAlumno.setAttribute("nombre", "Acceso a Datos");
		
		Element elementoNombre = documento.createElement("horas");
		elementoNombre.appendChild(documento.createTextNode("126"));
		elementoAlumno.appendChild(elementoNombre);
		
		elementoNombre = documento.createElement("profesor");
		elementoNombre.appendChild(documento.createTextNode("Miguel"));
		elementoAlumno.appendChild(elementoNombre);
		/*Asignatura*/
		
		/*Asignatura*/
		Element elementoAlumno1 = documento.createElement("asignatura");
		elementoAlumno1.setAttribute("nombre", "Empresa e iniciativa emprendedora");
		
		Element elementoNombre1 = documento.createElement("horas");
		elementoNombre1.appendChild(documento.createTextNode("63"));
		elementoAlumno1.appendChild(elementoNombre1);
		
		elementoNombre1 = documento.createElement("profesor");
		elementoNombre1.appendChild(documento.createTextNode("Juanma"));
		elementoAlumno1.appendChild(elementoNombre1);
		/*Asignatura*/
		
		/*Asignatura*/
		Element elementoAlumno2 = documento.createElement("asignatura");
		elementoAlumno2.setAttribute("nombre", "Sistemas de Gestion Empresarial");
		
		Element elementoNombre2 = documento.createElement("horas");
		elementoNombre2.appendChild(documento.createTextNode("126"));
		elementoAlumno2.appendChild(elementoNombre2);
		
		elementoNombre2 = documento.createElement("profesor");
		elementoNombre2.appendChild(documento.createTextNode("Miguel"));
		elementoAlumno2.appendChild(elementoNombre2);
		/*Asignatura*/
		 
		
		elementoAlumnosRaiz.appendChild(elementoAlumno);
		elementoAlumnosRaiz.appendChild(elementoAlumno1);
		elementoAlumnosRaiz.appendChild(elementoAlumno2);
		
		
		DOMSource fuenteDOM = new DOMSource(documento);
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
		
		StringWriter stringWriter = new StringWriter();
		StreamResult streamResult = new StreamResult(stringWriter);
		try {
			transformer.transform(fuenteDOM, streamResult);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(stringWriter.toString());
	}
}
