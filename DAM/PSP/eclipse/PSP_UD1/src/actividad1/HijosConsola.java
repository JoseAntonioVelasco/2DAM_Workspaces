package actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class HijosConsola {
	public static void main(String[] args) throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		
		//entrada de los comandos a ejecutar
		String comando1 = null,comando2 = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		comando1 = reader.readLine();
		comando2 = reader.readLine();
                 
		
		//creamos los procesos con los comandos recibidos
		ProcessBuilder h1 = new ProcessBuilder("CMD","/C",comando1);
		ProcessBuilder h2 = new ProcessBuilder("CMD","/C",comando2);
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
		
		
		//System.out.println("Ha llegado el comando1: "+comando1);
		//System.out.println("Ha llegado el comando2: "+comando2);
	}
}
