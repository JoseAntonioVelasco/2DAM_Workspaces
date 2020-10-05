import java.io.File;

public class Practica_AD_1_4 {
	public static void main(String[] args) {
		String path1="C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica3\\src\\DIR_1";
		
		File fich2 = new File(path1+"\\fichero2.txt");
		fich2.delete();
		
	}
}
