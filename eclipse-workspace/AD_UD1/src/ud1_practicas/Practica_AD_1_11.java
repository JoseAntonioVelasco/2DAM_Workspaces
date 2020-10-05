package ud1_practicas;
import java.io.*;
/**
 * 
 * @author Jose Antonio Velasco 
 *
 */
public class Practica_AD_1_11 {

	public static void main(String[] args)throws IOException {
		BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce la ruta absoluta al fichero: ");
		String ruta = entradaEstandar.readLine();
		//System.out.println("Has escrito: \""+ ruta +"\"");
		System.out.println("Introduce lo que quieres anadir al final del fichero: ");
		String texto = entradaEstandar.readLine();
		
		
		File fich = new File(ruta);
		/*BufferedReader readFile = new BufferedReader(new FileReader(fich));
		
		String linea;
		int i=1;
		while((linea = readFile.readLine()) != null) {
			System.out.println("Linea "+i+": "+linea);
			i++;
		}
		
		readFile.close();*/
		
		
		BufferedWriter writeFile = new BufferedWriter(new FileWriter(fich,true));
		writeFile.append("\n"+texto);
		writeFile.close();
	}

}
