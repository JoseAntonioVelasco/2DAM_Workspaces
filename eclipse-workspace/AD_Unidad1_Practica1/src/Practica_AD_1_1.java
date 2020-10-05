import java.io.File;
import java.util.Date;

public class Practica_AD_1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ficheros en el directorio actual: ");
		File f = new File(".");
		String[] archivos = f.list();
		for(int i=0; i<archivos.length;i++) {
			System.out.println(archivos[i]);//nombre
			File fich = new File(archivos[i]);
			
			//se puede ejecutar? canExecute()
			System.out.println("\tSe puede ejecutar: "+fich.canExecute());
			//se puede leer? canRead() 
			System.out.println("\tSe puede leer: "+fich.canRead());
			//se puede esvribir? canWrite()
			System.out.println("\tSe puede escribir: "+fich.canWrite());
			//absulete path 
			System.out.println("\tRuta absoluta: "+fich.getAbsolutePath());
			//ultima modificacion
			Date d = new Date(fich.lastModified());
			System.out.println("\tultima modificacion: "+d);
			//el fichero pesa?
			System.out.println("\tEspacio que ocupa: "+fich.length() +"bytes");
	
			
		}
	}

}

