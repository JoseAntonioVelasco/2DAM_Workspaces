package problema1;

import java.io.*;
import java.net.*;
/**
 *
 * @author JoseAntonioVelasco
 */
public class HiloServidor extends Thread {
	
	BufferedReader fentrada;
	PrintWriter fsalida;
	Socket socket = null;
        Integer contador_mensajes = 0; //contador para que solo permita 3 mensajes
	public HiloServidor(Socket s) throws IOException {
		socket = s;
		fsalida = new PrintWriter(socket.getOutputStream(), true);
		fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public void run() {
		String cadena = "";
		System.out.println("Estableciendo comunicación con ... " + socket.toString());

		while (contador_mensajes < 3) {
			try {
				cadena = fentrada.readLine();
                                System.out.println("Mensaje "+(contador_mensajes+1)+" recibido de puerto: "+socket.getPort()+" y ip: "+socket.getInetAddress().getHostAddress());
                                System.out.println(cadena);
                                contador_mensajes = contador_mensajes +1;
			} catch (IOException e) {
				e.printStackTrace();
			}
                        //condicion para que cuando le quede solo 1 mensaje muestre el 2º aviso
                        if(contador_mensajes < 3){
                            fsalida.println("Solo puede enviar "+(-contador_mensajes+3)+" mensajes mas. Despues se cerrara la conexion con el servidor.");
                        }else{
                            fsalida.println("Ya no puede enviar mas mensajes. Se va a proceder a cerrar la conexion con el servidor.");
                        }
			
		}

		System.out.println("Terminando comunicación con ... " + socket.toString());

		fsalida.close();
		try {
			fentrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
