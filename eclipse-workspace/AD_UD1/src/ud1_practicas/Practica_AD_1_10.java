package ud1_practicas;
import java.io.*;
/**
 * 
 * @author Jose Antonio Velasco 
 *
 */
public class Practica_AD_1_10 {

	public static void main(String[] args)throws IOException {
		BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
		String ruta;
		System.out.println("Introduce la ruta absoluta al fichero");
		ruta = entradaEstandar.readLine();
		//System.out.println("Has escrito: \""+ ruta +"\"");
		
		File fich = new File(ruta);
		BufferedReader readFile = new BufferedReader(new FileReader(fich));
		
		String linea;
		int i=1;
		while((linea = readFile.readLine()) != null) {
			System.out.println("Linea "+i+": "+linea);
			i++;
		}
		
		readFile.close();
		

	}

}
