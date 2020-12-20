package ud1_practicas;
import java.io.IOException;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */
public class Practica_PSP_1_1 {
	public static void main(String[] args) throws IOException{
		if(args.length!=1) {
			System.err.println("num de args erroneo");
			System.exit(-1);
		}
		String comando=args[0];
		Runtime r = Runtime.getRuntime();
		try {
			Process p = r.exec(comando);
		} catch(IOException e) {
			System.err.println("Capturada excepcion de E/S");
			System.exit(-1);
		}
	}
}
