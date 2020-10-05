package ejemplos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LlamarProcesoJava {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		File directorio = new File("C:\\Users\\USER\\eclipse-workspace\\Comunicacion_entre_procesos\\bin\\comunicacion");
		ProcessBuilder pb = new ProcessBuilder("Java","LecturaSalidaProcesos");
		pb.directory(directorio);
		
		Process p = pb.start();
		
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
	}
}
