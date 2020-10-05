import java.io.IOException;
import java.io.InputStream;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */

public class Practica_PSP_1_3 {
	public static void main(String[] args) throws IOException {
		Process p = new ProcessBuilder("CMD","/C","DIR").start();
		// El argumento "/C" permite ejecutar un comando en Windows y despues finalizar el proceso CMD
		// Si queremos dejar el interprete de comandos abierto hay que sustituirlo por "/K"
		try {
			InputStream is = p.getInputStream();//consigue el flujo de entrada del proceso
			int c; //creamos una variable de tipo entero llamada c
			while((c = is.read()) != -1) { //lee y guarda en la var c , si c == -1 sale del bucle
				System.out.print((char)c);//haciendo un cast imprime por pantalla el los caracteres leidos 
			}
			is.close();// cerramos el flujo de entrada
		}catch(Exception e) {//si ocurre una exception entra aqui
			e.printStackTrace();//imprime el error ocurrido
		}
		
		int salida;//crea una variable de tipo entero llamada salida
		try {
			salida = p.waitFor();//esperamos a que acabe el proceso p y guarda en la variable salida el retorno del proceso
			System.out.println("Codigo de salida: "+salida);// imprime el retorno del proceso que en este caso es 0 dando a entender que ha funcionado correctamente
		}catch(InterruptedException e) {// si ocurre algun error entraria aqui
			e.printStackTrace();//imprime el error ocurrido
		}
	}
}
