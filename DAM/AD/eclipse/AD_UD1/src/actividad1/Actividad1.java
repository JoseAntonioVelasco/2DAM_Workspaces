package actividad1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad1 {
	static FileWriter myWriter = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe la ruta donde quieres que se guarden los ficheros: ");
		String ruta_destino = sc.nextLine();
		
		
		File directorio = new File(ruta_destino);
		if(! directorio.exists()) {
			directorio.mkdir();
		}
		
		System.out.println("Escribe la ruta donde hay que buscar ficheros: ");
		String ruta_origen = sc.nextLine();
		
		//crear el log de cambios
		File log = new File(ruta_destino+"/gestionFicheros.txt");
		try {
			log.createNewFile();
			myWriter = new FileWriter(log);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File arch_origen = new File(ruta_origen);
		File[] archivos = arch_origen.listFiles();
		recursion(archivos,ruta_destino,ruta_origen,log);
		sc.close();
		try {
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void recursion(File[] archivos,String ruta_destino,String ruta_origen,File log) {
		for(int i=0; i<archivos.length;i++) {
				
			if(archivos[i].isDirectory()) {
				recursion(archivos[i].listFiles(),ruta_destino,ruta_origen,log);	
			}else {
				//checkar si es .dat o .xml
				if(getFileExtension(archivos[i]).equals("xml") || getFileExtension(archivos[i]).equals("dat")) {
					//mover a la ruta destino
					if(!(archivos[i].renameTo(new File(ruta_destino+"/"+archivos[i].getName())))) {
						failedRename(archivos[i],ruta_destino,2);
					}
					logTo(archivos[i].getName(),archivos[i].getAbsolutePath(),ruta_destino);
				}
			}
			
		}
	}
	
	//funcion copiada de: https://www.journaldev.com/842/java-get-file-extension
	private static String getFileExtension(File file) {
	        String fileName = file.getName();
	        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
	        return fileName.substring(fileName.lastIndexOf(".")+1);
	        else return "";
	}
	
	private static void logTo(String name_filemoved,String origen,String destino) {
		try { 
		      myWriter.append(name_filemoved+" copiado a "+destino+". \nEliminado con exito de "+origen+"\n"); 
		    } catch (IOException e) {
		      e.printStackTrace();
		    } 
	}
	
	private static void failedRename(File archivo,String ruta_destino,int num) {
	
		if(!(archivo.renameTo(new File(ruta_destino+"/"+stripExtension(archivo.getName())+"("+num+")"+"."+getFileExtension(archivo))))) {
			failedRename(archivo,ruta_destino,num+1);
		}
	}
	
	//nota la libreria "org.apache.commons.io.FilenameUtils" tiene unos metodos muy utiles para este ejercicio
	//funcion copiada de: https://stackoverflow.com/questions/924394/how-to-get-the-filename-without-the-extension-in-java
	private static String stripExtension (String str) {
	        // Handle null case specially.

	        if (str == null) return null;

	        // Get position of last '.'.

	        int pos = str.lastIndexOf(".");

	        // If there wasn't any '.' just return the string as is.

	        if (pos == -1) return str;

	        // Otherwise return the string, up to the dot.

	        return str.substring(0, pos);
	    }

}
