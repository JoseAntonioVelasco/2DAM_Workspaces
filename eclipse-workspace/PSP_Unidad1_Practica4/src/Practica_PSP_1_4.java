import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */

public class Practica_PSP_1_4 {

	public static void main(String[] args)throws IOException {
		Process p;
		p = new ProcessBuilder("CMD","/C","DATE").start();
		
		
		OutputStream os = p.getOutputStream();
		os.write("01-12-17".getBytes());
		os.flush();
		
		InputStream is = p.getInputStream();
		int c;
		while((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
		
		int salida;
		try {
			salida = p.waitFor();
			System.out.println("Valor de Salida: "+salida);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
