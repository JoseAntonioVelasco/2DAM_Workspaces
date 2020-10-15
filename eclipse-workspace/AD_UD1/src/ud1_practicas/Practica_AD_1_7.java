package ud1_practicas;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 
 * @author Jose Antonio Velasco Monje
 *
 */
public class Practica_AD_1_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fich1 = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica7\\src\\fich1.txt");
		File fich2 = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica7\\src\\fich2.txt");
		
		System.out.println(comparaContenidoFicheros(fich1,fich2));
		
		File fich3 = new File("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica7\\src\\fich3.txt");
		try {
			fich3.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		copiaContenidoFicheros(fich1,fich3);
		

	}
	
	public static boolean comparaContenidoFicheros(File f1, File f2)  {
		boolean iguales = false;
		
		try {
			FileInputStream is_f1 = new FileInputStream(f1);
			FileInputStream is_f2 = new FileInputStream(f2);
			
			if(f1.length()== f2.length()) {
				iguales = true;
				System.out.println("mismo tam");
				int byteF1 = 0;
				int byteF2 = 0;
				
				while(iguales) {
					try {
						byteF1 = is_f1.read();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						byteF2 = is_f2.read();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					/*if(byteF1 != byteF2) {
						iguales = false;
					}*/
					iguales = byteF1 == byteF2;
					if((byteF1==byteF2)&&(byteF1 == -1)) {
						try {
							is_f1.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							is_f2.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return iguales;
					}
				}
				
			}
			try {
				is_f1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				is_f2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return iguales;
	}
	public static void copiaContenidoFicheros(File origen, File destino) {
		FileInputStream fic = null;
		try {
			fic = new FileInputStream(origen);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream foc = null;
		try {
			foc = new FileOutputStream(destino);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i;
		try {
			while((i = fic.read()) != -1) {
				//System.out.print((char) i);
				foc.write(i);
				
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
			foc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
