import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
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
		//System.out.println("Has escrito: \""+ ruta +"\"");
	
		File fich = new File(ruta);
		File temp_fich = File.createTempFile("temp", null);
		
		//copiamos al fichero temporal
		BufferedReader readFile_origi = new BufferedReader(new FileReader(fich));
		BufferedWriter writeFile_temp = new BufferedWriter(new FileWriter(temp_fich,true));
		
		
		String linea;
		while((linea = readFile_origi.readLine()) != null) {
			writeFile_temp.append(linea);
			System.out.println(linea);
		}
		
		readFile_origi.close();
		writeFile_temp.close();
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		//hacemos modificacion en el fichero temp
		RandomAccessFile fichRAF = new RandomAccessFile(temp_fich,"rw");
		int i;
		while((i = fichRAF.read()) != -1) {
			System.out.print((char) i);
			if(Character.isWhitespace((char) i)) {
				fichRAF.writeChars("");
				//System.out.println("Ha entrado");
			}
			if(Character.isLowerCase((char) i)) {
				fichRAF.writeChar(Character.toUpperCase((char) i));
			}
			
		}
		fichRAF.close();
		
		//copiamos lo que hay en el fichero temp devuelta al fich original
		BufferedReader readFile_temp = new BufferedReader(new FileReader(fich));
		BufferedWriter writeFile_origi = new BufferedWriter(new FileWriter(temp_fich,true));
		
		String linea2;
		while((linea2 = readFile_temp.readLine()) != null) {
			writeFile_origi.append("\n"+linea2);
			//System.out.println(linea2);
		}
		
		readFile_temp.close();
		writeFile_origi.close();
		
		temp_fich.deleteOnExit();
		
		
		

	}

}
