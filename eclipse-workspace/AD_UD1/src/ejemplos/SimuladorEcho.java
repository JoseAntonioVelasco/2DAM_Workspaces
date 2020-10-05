package ejemplos;
import java.io.*;

public class SimuladorEcho {

	public static void main(String[] args) throws IOException {
		BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
		String teclado;
		System.out.println("Escribe lo que quieras");
		teclado = entradaEstandar.readLine();
		System.out.println("Has escrito: \""+ teclado +"\"");

	}

}
