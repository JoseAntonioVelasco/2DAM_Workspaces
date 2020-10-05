package sax;

import java.io.FileInputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class RecorrerXMLconSAX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(new ManejadorEjemplo());
			reader.parse(new InputSource(new FileInputStream("libro.xml")));
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
