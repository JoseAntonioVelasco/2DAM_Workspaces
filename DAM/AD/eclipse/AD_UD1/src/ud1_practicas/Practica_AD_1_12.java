package ud1_practicas;

import java.io.*;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */
public class Practica_AD_1_12 {
	public static void main(String[] args){
		BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce la ruta absoluta al fichero: ");
		String ruta = null;
		try {
			ruta = entradaEstandar.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		File fich = new File(ruta);
		File temp_fich = null;
		try {
			temp_fich = File.createTempFile("temp", null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.print(temp_fich.getAbsolutePath());
		
		
		FileReader readFile_origi = null;
		try {
			readFile_origi = new FileReader(fich);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileWriter writeFile_temp = null;
		try {
			writeFile_temp = new FileWriter(temp_fich,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//copiamos al fichero temporal haciendo las modificaciones
		int c;
		try {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writeFile_temp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			readFile_origi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//copiamos lo que hay en el fichero temp devuelta al fich original
		FileWriter writeFile_origi = null;
		try {
			writeFile_origi = new FileWriter(fich);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileReader readFile_temp = null;
		try {
			readFile_temp = new FileReader(temp_fich);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while((c = readFile_temp.read()) != -1) {
				writeFile_origi.write((char) c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			readFile_temp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writeFile_origi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		temp_fich.deleteOnExit();
			

	}
}
