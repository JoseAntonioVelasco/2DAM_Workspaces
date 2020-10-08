package ud1_practica21;

import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ParserSAX {
	public ArrayList parseXml(InputStream inputS) {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			ManejadorAlumnos handler = new ManejadorAlumnos();
			
			XMLReader parser = XMLReaderFactory.createXMLReader();
			parser.setContentHandler(handler);
			InputSource documento = new InputSource(inputS);
			
			parser.parse(documento);
			alumnos = handler.getAlumnos();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alumnos;
	}
}
