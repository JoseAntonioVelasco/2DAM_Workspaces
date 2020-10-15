package actividad1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Hijos {
	public static void main(String[] args) throws IOException,InterruptedException {

		//Creamos dos procesos, 1 ejecutara el comando dir en el directorio que se encuentra
		// el 2 ejecutara el comando find "bi"
		ProcessBuilder h1 = new ProcessBuilder("CMD","/C","dir");
		ProcessBuilder h2 = new ProcessBuilder("CMD","/C","find \"bi\"");
		Process p1 = h1.start(); Process p2 = h2.start();
		
		//Cojemos la entrada del proceso 2 y le vamos metiendo caracter a caracter la salida del proceso1
		OutputStream os = p2.getOutputStream();
		InputStream is = p1.getInputStream();
		int c;
		while((c= is.read()) != -1) {
			//System.out.print((char) c);
			os.write((char) c);
		}
		os.flush();os.close();
		is.close();
		
		
		//leemos la salida del proceso 2
		InputStream is2 = p2.getInputStream();
		while((c= is2.read()) != -1) {
			System.out.print((char) c);
		}
		is2.close();
		
		
	}
}
