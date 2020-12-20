package ejemplos;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeeFicheroTexto {
	public static void main(String[] args)throws IOException{
		File fichero = new File("C:\\Users\\USER\\eclipse-workspace\\LeerFicheroTexto\\src\\fichero.txt");
		FileReader fic = new FileReader(fichero);
		
		int i;
		while((i = fic.read()) != -1) {
			System.out.print((char) i);
			
		}
		fic.close();
	}
}
