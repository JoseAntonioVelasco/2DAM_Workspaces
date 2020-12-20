package actividad1;
import java.io.*;


public class Padre {

	public static void main(String[] args) throws IOException,InterruptedException {
		//Creamos un proceso que ejecute el binario de Hijos
		File directorio = new File("C:\\Users\\cagan\\Documents\\GitHub\\2DAM_Workspaces\\eclipse-workspace\\PSP_UD1\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Hijos");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		
		//leemos la salida del proceso que ejecuto los Hijos
		InputStream is = p.getInputStream();
		int c;
		while((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	
		
		
	}

}
