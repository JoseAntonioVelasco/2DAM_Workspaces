package sax;

import java.io.FileInputStream;


import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class SAX_Libro {
	public static void main(String[] args) {
		try {
			Libro libro = new Libro();
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(new ManejadorLibro(libro));
			reader.parse(new InputSource(new FileInputStream("libro.xml")));
			System.out.println(libro.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
