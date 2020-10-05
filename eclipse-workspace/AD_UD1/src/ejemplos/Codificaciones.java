package ejemplos;
import java.io.*;

public class Codificaciones {

	public static void main(String[] args)throws IOException {
		InputStreamReader inputSR = new InputStreamReader(new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\AccesoDatos\\src\\pruebas.txt"),"UTF-8");
		InputStreamReader inputSR_2 = new InputStreamReader(new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\AccesoDatos\\src\\pruebas.txt"),"ISO-8859-7");
		System.out.println("Codificacion primer fichero: "+ inputSR.getEncoding());
		System.out.println("Codificacion segundo fichero: "+inputSR_2.getEncoding());
		System.out.println("Primer fichero");
		int i;
		
		while((i = inputSR.read()) != -1) {
			System.out.print((char) i);
		}
		System.out.println("Segundo fichero:");
		int j;
		while((j = inputSR_2.read()) != -1) {
			System.out.print((char) j);
		}
		inputSR.close();
		inputSR_2.close();
	}

}
