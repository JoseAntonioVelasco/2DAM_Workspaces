import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Practica_AD_1_6 {
	public static void main(String[] args)throws IOException{
		File leer = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica6\\src\\leer.txt");
		FileReader fic = new FileReader(leer);
		File escrib = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica6\\src\\escrib.txt");
		FileWriter fic2 = new FileWriter(escrib);
		int i;
		while((i = fic.read()) != -1) {
			//System.out.print((char) i);
			fic2.write((char) i);
			
		}
		fic.close();
		fic2.close();
	}
}
