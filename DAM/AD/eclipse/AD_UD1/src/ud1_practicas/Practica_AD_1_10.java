package ud1_practicas;
import java.io.*;
/**
 * 
 * @author Jose Antonio Velasco 
 *
 */
public class Practica_AD_1_10 {

	public static void main(String[] args) {
		BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
		String ruta = null;
		System.out.println("Introduce la ruta absoluta al fichero");
		try {
			ruta = entradaEstandar.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Has escrito: \""+ ruta +"\"");
		
		File fich = new File(ruta);
		BufferedReader readFile = null;
		try {
			readFile = new BufferedReader(new FileReader(fich));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String linea;
		int i=1;
		try {
			while((linea = readFile.readLine()) != null) {
				System.out.println("Linea "+i+": "+linea);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			readFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
