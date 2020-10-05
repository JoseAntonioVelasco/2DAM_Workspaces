package lecturaSalidaProcesos;

import java.io.IOException;
import java.io.InputStream;

public class LecturaSalidaProcesos {

	public static void main(String[] args) throws IOException, InterruptedException{
		Process p = new ProcessBuilder("CMD","/C","dir").start();
		
		try {
			InputStream is = p.getInputStream();
			int c;
			while((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		int salida;
		try {
			salida = p.waitFor();
			System.out.println("Codigo de Salida: "+salida);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

}
