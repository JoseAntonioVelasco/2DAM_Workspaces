package t10propiedades_ejemplo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties; //libreria de propiedades

public class Propiedades {
	private Properties props = null;
	
	public Propiedades() {
		Properties porDefecto = new Properties(); 
		//cuando se instancia la clase propiedades se pone por defecto el idioma en ingles
		porDefecto.setProperty("idioma", "ingles");
		props = new Properties(porDefecto);
	}
	
	public static void main(String[] args) {
		Propiedades p = new Propiedades(); //se intancia
		FileOutputStream fos = null; //fos=FileOutputStream
		FileInputStream fis = null; //fis=FileInputStream
		File ruta = new File("props.xml"); //ruta de donde se va a generar el fichero
		
		System.out.println("\nValores predertminados:\n");
		p.getProps().list(System.out);
		//muestra las propiedades
		p.getProps().setProperty("idioma","frances");
		System.out.println("\nTras el primer cambio\n");
		p.getProps().list(System.out);
		//muestra las propiedades tras el primer cambio
		System.out.println("\nGuardo la modificacion del primer cambio en disco\n");
		try {
			fos=new FileOutputStream(ruta);
			p.getProps().storeToXML(fos,"Listado de propiedades");
			//storeToXML guarda la configuracion y se ha añadido el comentario Listado de propiedades
			fos.close();
		}
		catch(Exception e) {
			System.out.println("Error al guardar las propiedades");
		}
		
		p.getProps().setProperty("idioma","ingles");
		System.out.println("Tras el segundo cambio");
		p.getProps().list(System.out);
		
		System.out.println("\nEl segundo cambio no lo guardo en disco...");
		System.out.println("Con lo que si vuelvo a leer la configuracion guardada...\n");
		
		try {
			fis=new FileInputStream(ruta);
			p.getProps().loadFromXML(fis);// se cargan las properties guardadas
			fis.close();
		}
		catch(Exception e) {
			System.out.println("Error al cargar las propiedades");
		}
		
		p.getProps().list(System.out);//se muestran las properties cargadas
	}
	
	public Properties getProps() {return props;}
	public void setProps(Properties props) {this.props = props;}
}
