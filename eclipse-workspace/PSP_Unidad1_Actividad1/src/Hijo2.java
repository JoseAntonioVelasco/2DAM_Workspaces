import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Hijo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Process proceso = new ProcessBuilder(/*salida_del_ls -l*/,"|","grep","cadena").start();
		
		
		InputStream inputS = proceso.getInputStream();
		InputStreamReader inputSR = new InputStreamReader(inputS);
		BufferedReader bufferedR = new BufferedReader(inputSR);
		String salida;
		
		//System.out.println("Ejecutando el proceso: "+Arrays.toString(args) + ". Salida: ");
		while((salida = bufferedR.readLine()) != null) {
			System.out.println(salida);
		}
	}

}
