package actividad1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Hijos {
	public static void main(String[] args) throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		ProcessBuilder h1 = new ProcessBuilder("CMD","/C","dir");
		ProcessBuilder h2 = new ProcessBuilder("CMD","/C","find \"bi\"");
		Process p1 = h1.start(); Process p2 = h2.start();
		
		//esperamos a que termine el p1
		p1.waitFor();
		
		OutputStream os = p2.getOutputStream();
		InputStream is = p1.getInputStream();
		int c;
		while((c= is.read()) != -1) {
			//System.out.print((char) c);
			os.write((char) c);
		}
		os.flush();os.close();
		is.close();
		
		InputStream is2 = p2.getInputStream();
		while((c= is2.read()) != -1) {
			System.out.print((char) c);
		}
		is2.close();
		
		
	}
}
