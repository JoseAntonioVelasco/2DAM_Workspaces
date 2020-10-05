package ejemplos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscribeFicheroFileWriter {
	public static void main(String[] args) throws IOException{
		File fichero = new File("C:\\Users\\USER\\eclipse-workspace\\escribeFicheroFileWriter\\src\\filewriter.txt");
		fichero.createNewFile();
		FileWriter fw = new FileWriter(fichero,true);
		
		//fw.write("Hola \n mundo");
		fw.append("aa");
		fw.close();
		//fw.flush();
		
		FileReader fic = new FileReader(fichero);
		
		int i;
		while((i = fic.read()) != -1) {
			System.out.print((char) i);
			
		}
		fic.close();
		//fw.close();
	}
}
