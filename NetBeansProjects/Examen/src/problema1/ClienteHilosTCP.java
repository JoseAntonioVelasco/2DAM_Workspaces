package problema1;

import java.io.*;
import java.net.*;
/**
 *
 * @author JoseAntonioVelasco
 */
public class ClienteHilosTCP {
  public static void main(String[] args) throws IOException {
	String Host = "localhost";
	int Puerto = 6000;
	Socket Cliente = new Socket(Host, Puerto);
        Integer contador_mensajes = 0; //contador añadido para que solo pueda enviar 3 mensajes el cliente

	PrintWriter fsalida = new PrintWriter (Cliente.getOutputStream(), true);
	BufferedReader fentrada =  new BufferedReader
	     (new InputStreamReader(Cliente.getInputStream()));

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String cadena, respuesta="";
        
	while(contador_mensajes < 3){
		System.out.print("Introduce cadena: ");
		cadena = in.readLine();
		fsalida.println(cadena);
		respuesta=fentrada.readLine();
		System.out.println("  -> Respuesta : "+respuesta);
                contador_mensajes = contador_mensajes +1;
	}

	fsalida.close();
	fentrada.close();
	System.out.println("Fin del envío... ");
	in.close();
	Cliente.close();
	}
}
