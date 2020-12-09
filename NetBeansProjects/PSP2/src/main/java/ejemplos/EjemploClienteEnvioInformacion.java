/**
 * 
 */
package ejemplos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ADMIN
 *
 */
public class EjemploClienteEnvioInformacion {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String Host = "localhost";
		int Puerto = 6000;
		
		System.out.println("Iniciando el cliente");
		Socket Cliente = new Socket(Host,Puerto);
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
		
		flujoSalida.writeUTF("El cliente saluda al servidor");
		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
		System.out.println("Recibiendo mensaje del servidor:\t"+flujoEntrada.readUTF());
		
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();
	
	}

}
