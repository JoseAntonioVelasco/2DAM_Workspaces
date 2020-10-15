package actividad1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class PadreConsola {
	public static void main(String[] args) throws IOException,InterruptedException {
		//Creamos un proceso que ejecute el binario de Hijos
		File directorio = new File("C:\\Users\\cagan\\Documents\\GitHub\\2DAM_Workspaces\\eclipse-workspace\\PSP_UD1\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","HijosConsola");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		
		//leemos por la entrada el comando 1
		System.out.println("Introduce comando 1: ");
		Scanner scan = new Scanner(System.in);
		String comando1= scan.nextLine();
		comando1=comando1+"\n";
		
		//leemos por la entrada el comando 2
		System.out.println("Introduce comando 2: ");
		String comando2= scan.nextLine();
		
		//pasamos al proceso que ejecuta el binario de Hijos los comandos a ejecutar
		OutputStream os = p.getOutputStream();
		os.write(comando1.getBytes());
		os.write(comando2.getBytes());
		os.flush();os.close();
		
		//leemos la salida del proceso que ejecuto el binario de Hijos
		InputStream is = p.getInputStream();
		int c;
		while((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	
		scan.close();
		
	}
}
