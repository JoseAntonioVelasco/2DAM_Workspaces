import java.io.IOException;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */
public class Practica_PSP_1_2 {
	public static void main(String[] args) throws IOException{
		
		String comando="C:\\Windows\\notepad.exe";
		Runtime r = Runtime.getRuntime();
		try {
			Process p = r.exec(comando);
			try {
				Thread.sleep(5000);
				p.destroy();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch(IOException e) {
			System.err.println("Capturada excepcion de E/S");
			System.exit(-1);
		}
	}
}
