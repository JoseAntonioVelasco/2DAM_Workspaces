import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Practica_AD_1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero= new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica5\\src\\nombres.txt");
		try {
			RandomAccessFile fic = new RandomAccessFile(fichero, "rw");
			try {
				fic.seek(10);
				for(int i=0;i<5;i++) {
					char c=(char) fic.read();
					System.out.print(c);
				}
				fic.seek(20);
				String hola= "holamundo";
				fic.write(hola.getBytes());
				fic.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
