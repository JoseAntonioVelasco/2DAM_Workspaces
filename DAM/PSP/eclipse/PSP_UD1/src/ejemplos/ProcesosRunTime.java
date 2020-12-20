package ejemplos;
import java.io.IOException;

public class ProcesosRunTime {
	public static void main(String[] args) throws IOException{
		String comando="C:\\Windows\\notepad.exe";
		
		Runtime r = Runtime.getRuntime();
		try {
			Process p = r.exec(comando);
		} catch(IOException e) {
			System.err.println("Capturada excepcion de E/S");
			System.exit(-1);
		}
	}
	
	
}
