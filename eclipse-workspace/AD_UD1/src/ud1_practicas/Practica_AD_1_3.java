package ud1_practicas;
import java.io.File;
import java.io.IOException;

public class Practica_AD_1_3 {
	
	public static void main(String[] args) {
		String path1="C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica3\\src\\DIR_1";
		String path2="C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica3\\src\\DIR_2";
		
		File carp = new File(path1);
		carp.mkdir();
		File carp2 = new File(path2);
		carp2.mkdir();
		
		File fich1 = new File(path1+"\\fichero1.txt");
		File fich2 = new File(path1+"\\fichero2.txt");
		try {
			fich1.createNewFile();
			fich2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
