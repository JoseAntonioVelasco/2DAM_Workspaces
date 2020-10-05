package ud1_practicas;
import java.io.*;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */
public class Practica_AD_1_8 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fich1 = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica7\\src\\fich1.txt");
		File fich2 = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica7\\src\\fich2.txt");
		
		System.out.println(comparaContenidoFicheros(fich1,fich2));
		
		File fich3 = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica7\\src\\fich3.txt");
		fich3.createNewFile();
		copiaContenidoFicheros(fich1,fich3);
		

	}
	
	public static boolean comparaContenidoFicheros(File f1, File f2) throws IOException {
		boolean iguales = false;
		
		try {
			FileReader is_f1 = new FileReader(f1);
			FileReader is_f2 = new FileReader(f2);
			
			if(f1.length()== f2.length()) {
				iguales = true;
				System.out.println("mismo tam");
				int byteF1 = 0;
				int byteF2 = 0;
				
				while(iguales) {
					byteF1 = is_f1.read();
					byteF2 = is_f2.read();
					
					/*if(byteF1 != byteF2) {
						iguales = false;
					}*/
					iguales = byteF1 == byteF2;
					if((byteF1==byteF2)&&(byteF1 == -1)) {
						is_f1.close();
						is_f2.close();
						return iguales;
					}
				}
				
			}
			is_f1.close();
			is_f2.close();
	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return iguales;
	}
	public static void copiaContenidoFicheros(File origen, File destino) throws IOException {
		FileReader fic = new FileReader(origen);
		FileWriter foc = new FileWriter(destino);
		int i;
		while((i = fic.read()) != -1) {
			//System.out.print((char) i);
			foc.write(i);
			
		}
		fic.close();
		foc.close();
	}
}
