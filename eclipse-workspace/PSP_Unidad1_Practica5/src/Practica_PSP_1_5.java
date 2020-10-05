import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */
public class Practica_PSP_1_5 {
	//args = dir /B   ls => dir
	public static void main(String[] args) throws IOException{
		Process proceso = new ProcessBuilder("CMD","/C",args[0],args[1]).start();//crea un Process llamado proceso al que se le pasan esos argumentos para que ejecute ese comando en el cmd de windows
		//Process proceso = new ProcessBuilder(args).start();
		InputStream inputS = proceso.getInputStream();//cojemos el flujo de entrada del proceso
		InputStreamReader inputSR = new InputStreamReader(inputS);//utilizamos esta clase para pasar de flujo de bytes a flujo de caracteres.
		BufferedReader bufferedR = new BufferedReader(inputSR);//utilizamos esta clase para poder leer de manera eficiente caracteres, arrays, lineas mediante un buffer
		String salida;// instanciamos un String que se llama salida
		
		System.out.println("Ejecutando el proceso: "+Arrays.toString(args) + ". Salida: ");//imprime que argumentos se le pasa al proceso que escribe en el cmd
		while((salida = bufferedR.readLine()) != null) {// mientras que salida no sea null va leyendo linea a linea el output del comando de windows que se puso en el cmd
			System.out.println(salida);//imprime la linea leida
		}
		

	}

}
