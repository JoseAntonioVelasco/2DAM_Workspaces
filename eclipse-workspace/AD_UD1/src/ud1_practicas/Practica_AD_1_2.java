package ud1_practicas;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Practica_AD_1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ficheros en el directorio actual: ");
		File f = new File(".");
		File[] archivos = f.listFiles();
		try {
			recursionFicheros(archivos,0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void sacarDatos(File fich,Integer profundidad) {
		String tabulaciones="";
		for(int i=0;i<profundidad;i++) {
			tabulaciones=tabulaciones+"\t";
		}
		//nombre
		System.out.println(tabulaciones+fich.getName());
		//se puede ejecutar? canExecute()
		System.out.println(tabulaciones+"\tSe puede ejecutar: "+fich.canExecute());
		//se puede leer? canRead() 
		System.out.println(tabulaciones+"\tSe puede leer: "+fich.canRead());
		//se puede escribir? canWrite()
		System.out.println(tabulaciones+"\tSe puede escribir: "+fich.canWrite());
		//absulete path 
		System.out.println(tabulaciones+"\tRuta absoluta: "+fich.getAbsolutePath());
		//ultima modificacion
		Date d = new Date(fich.lastModified());
		System.out.println(tabulaciones+"\tultima modificacion: "+d);
		//el fichero pesa?
		System.out.println(tabulaciones+"\tEspacio que ocupa: "+fich.length() +"bytes");
	}
	public static void recursion(File[] archivos,Integer profundidad) {
		for(int i=0; i<archivos.length;i++) {
			
			
			if(archivos[i].isDirectory()) {
		
				sacarDatos(archivos[i],profundidad);
				System.out.print("\n");
				recursion(archivos[i].listFiles(),profundidad+1);
				
			}
			else {
				sacarDatos(archivos[i],profundidad);
			}
			
		}
	}
	public static void recursionFicheros(File[] archivos,Integer profundidad) throws IOException, InterruptedException {
        for(int i=0; i<archivos.length;i++) {



			if(archivos[i].isDirectory()) {
				//String[] arch = fich.list();
		                        //File[] arrayFicheros = fich.listFiles();
		                        File[] arrayFicheros = archivos[i].listFiles();
				sacarDatos(archivos[i],profundidad);
				System.out.print("\n");
		                        profundidad++;
				recursionFicheros(arrayFicheros,profundidad);
				profundidad--;
			}
			else {
				sacarDatos(archivos[i],profundidad);
			}

        }
	}
}
