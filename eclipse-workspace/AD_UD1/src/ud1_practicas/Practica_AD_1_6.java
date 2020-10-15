package ud1_practicas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Practica_AD_1_6 {
	public static void main(String[] args){
		File leer = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica6\\src\\leer.txt");
		FileReader fic = null;
		try {
			fic = new FileReader(leer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File escrib = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica6\\src\\escrib.txt");
		FileWriter fic2 = null;
		try {
			fic2 = new FileWriter(escrib);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i;
		try {
			while((i = fic.read()) != -1) {
				//System.out.print((char) i);
				fic2.write((char) i);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fic.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fic2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
