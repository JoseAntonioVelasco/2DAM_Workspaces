package ud1_practicas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Practica_AD_1_20 {
	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document documento = builder.newDocument();
		documento.setXmlVersion("1.0");
		
		Element elementoAlumnosRaiz = documento.createElement("alumnos");
		documento.appendChild(elementoAlumnosRaiz);
		
		
		/*Alumno*/
		Element elementoAlumno = documento.createElement("alumno");
		
		Element elementoNombre = documento.createElement("nombre");
		elementoNombre.appendChild(documento.createTextNode("Pepe"));
		elementoAlumno.appendChild(elementoNombre);
		
		elementoNombre = documento.createElement("apellidos");
		elementoNombre.appendChild(documento.createTextNode("Perez"));
		elementoAlumno.appendChild(elementoNombre);
		
		elementoNombre = documento.createElement("nota_AD");
		elementoNombre.appendChild(documento.createTextNode("1"));
		elementoAlumno.appendChild(elementoNombre);
		
		elementoNombre = documento.createElement("nota_PSP");
		elementoNombre.appendChild(documento.createTextNode("2"));
		elementoAlumno.appendChild(elementoNombre);
		
		elementoNombre = documento.createElement("nota_SGE");
		elementoNombre.appendChild(documento.createTextNode("3"));
		elementoAlumno.appendChild(elementoNombre);
		/*Alumno*/
		
		
		/*Alumno*/
		Element elementoAlumno1 = documento.createElement("alumno");
		
		Element elementoNombre1 = documento.createElement("nombre");
		elementoNombre1.appendChild(documento.createTextNode("Ana"));
		elementoAlumno1.appendChild(elementoNombre1);
		
		elementoNombre1 = documento.createElement("apellidos");
		elementoNombre1.appendChild(documento.createTextNode("Alvarez"));
		elementoAlumno1.appendChild(elementoNombre1);
		
		elementoNombre1 = documento.createElement("nota_AD");
		elementoNombre1.appendChild(documento.createTextNode("4"));
		elementoAlumno1.appendChild(elementoNombre1);
		
		elementoNombre1 = documento.createElement("nota_PSP");
		elementoNombre1.appendChild(documento.createTextNode("5"));
		elementoAlumno1.appendChild(elementoNombre1);
		
		elementoNombre1 = documento.createElement("nota_SGE");
		elementoNombre1.appendChild(documento.createTextNode("6"));
		elementoAlumno1.appendChild(elementoNombre1);
		/*Alumno*/
		
		
		elementoAlumnosRaiz.appendChild(elementoAlumno);
		elementoAlumnosRaiz.appendChild(elementoAlumno1);
		
		
		DOMSource fuenteDOM = new DOMSource(documento);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
		
		StringWriter stringWriter = new StringWriter();
		StreamResult streamResult = new StreamResult(stringWriter);
		transformer.transform(fuenteDOM, streamResult);
		System.out.println(stringWriter.toString());
		
		File fich_xml = new File("fich_alumnos.xml");
		fich_xml.createNewFile();
		
		FileWriter myWriter = new FileWriter(fich_xml);
		myWriter.write(stringWriter.toString());
		myWriter.close();
		
	}
}
