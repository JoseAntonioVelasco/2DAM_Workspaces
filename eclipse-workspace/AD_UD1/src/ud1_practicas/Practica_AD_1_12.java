package ud1_practicas;

import java.io.*;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */
public class Practica_AD_1_12 {
	public static void main(String[] args)throws IOException {
		BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce la ruta absoluta al fichero: ");
		String ruta = entradaEstandar.readLine();

	
		File fich = new File(ruta);
		File temp_fich = File.createTempFile("temp", null);
		//System.out.print(temp_fich.getAbsolutePath());
		
		
		FileReader readFile_origi = new FileReader(fich);
		FileWriter writeFile_temp = new FileWriter(temp_fich,true);
		
		
		//copiamos al fichero temporal haciendo las modificaciones
		int c;
		while((c = readFile_origi.read()) != -1) {
			if(Character.isWhitespace(c)) {
				writeFile_temp.write("");
			}
			if(Character.isLowerCase(c)) {
				writeFile_temp.write(Character.toUpperCase(c));
			}else {
				writeFile_temp.write((char) c);
			}
		}
		writeFile_temp.close();
		readFile_origi.close();
		
		//copiamos lo que hay en el fichero temp devuelta al fich original
		FileWriter writeFile_origi = new FileWriter(fich);
		FileReader readFile_temp = new FileReader(temp_fich);
		
		while((c = readFile_temp.read()) != -1) {
			writeFile_origi.write((char) c);
		}
		
		readFile_temp.close();
		writeFile_origi.close();
		
		temp_fich.deleteOnExit();
			

	}
}
