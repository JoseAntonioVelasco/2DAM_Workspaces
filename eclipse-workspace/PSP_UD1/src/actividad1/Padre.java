package actividad1;
import java.io.*;

public class Padre {

	public static void main(String[] args) throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		File directorio = new File("C:\\Users\\cagan\\eclipse-workspace\\PSP_UD1_Practicas\\bin");
		ProcessBuilder h1 = new ProcessBuilder("java","Hijo1");
		ProcessBuilder h2 = new ProcessBuilder("java","Hijo2");
		h1.directory(directorio);h2.directory(directorio);
		Process p1 = h1.start(); Process p2 = h2.start();
		
		
		
		//esperamos a que termine el p1
		p1.waitFor();
		
		//lo leemos
		InputStream is = p1.getInputStream();
		int c,i;
		char[] array1 = new char[5];
		i=0;
		while((c= is.read()) != -1) {
			System.out.print((char) c);
			//array1[i]=(char) c;
			//i++;
		}
		/*String str_num1 = String.valueOf(array1);
		Double num1 = Double.parseDouble(str_num1); 
		System.out.println("Numero del hijo 1: "+num1);
		
		p2.waitFor();
		
		is = p2.getInputStream();
		i=0;
		char[] array2 = new char[5];
		while((c= is.read()) != -1) {
			//System.out.print((char) c);
			array2[i]=(char) c;
			i++;
		}
		is.close();
		
		String str_num2 = String.valueOf(array2);
		Double num2 = Double.parseDouble(str_num2);
		System.out.println("Numero del hijo 2: "+num2);
		
		
		System.out.println("Su suma: "+(num2+num1));*/
		
		
	}

}
