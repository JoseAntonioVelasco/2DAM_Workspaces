package ud1_practica21;

import java.util.ArrayList;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorAlumnos extends DefaultHandler{
	private ArrayList listaAlumnos = new ArrayList();
	private Stack pilaElementos = new Stack();
	private Stack pilaAlumnos = new Stack();
	
	public void startDocument() throws SAXException{
		
	}
	public void endDocument() throws SAXException{
		
	}
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.pilaElementos.push(qName);
		
		if("alumno".equals(qName)) {
			Alumno alumno = new Alumno();
			if(attributes != null && attributes.getLength() ==1) {
				//alumno.setNombre(attributes.getValue(0));
			}
			this.pilaAlumnos.push(alumno);
		}

	}
	public void endElement(String uri, String localName, String qName) {
		this.pilaElementos.pop();
		if("alumno".equals(qName)) {
			Alumno alum = (Alumno) this.pilaAlumnos.pop();
			this.listaAlumnos.add(alum);
		}
	}
	public void characters(char[] ch, int start, int length)throws SAXException {
		String value = new String(ch,start,length).trim();
		
		if(value.length()==0) {
			return;
		}
		if("nombre".equals(currentElement())) {
			Alumno alumno = (Alumno) this.pilaAlumnos.peek();
			alumno.setNombre(value);
		}else if("apellidos".equals(currentElement())) {
			Alumno alumno = (Alumno) this.pilaAlumnos.peek();
			alumno.setApellidos(value);
		}else if("nota_AD".equals(currentElement())) {
			Alumno alumno = (Alumno) this.pilaAlumnos.peek();
			alumno.setNotaAD(Integer.valueOf(value));
		}else if("nota_PSP".equals(currentElement())) {
			Alumno alumno = (Alumno) this.pilaAlumnos.peek();
			alumno.setNotaPSP(Integer.valueOf(value));
		}else if("nota_SGE".equals(currentElement())) {
			Alumno alumno = (Alumno) this.pilaAlumnos.peek();
			alumno.setNotaSGE(Integer.valueOf(value));
		}
		
	}
	private String currentElement() {
		return (String) this.pilaElementos.peek();
	}
	public ArrayList getAlumnos() {
		return listaAlumnos;
	}
}
