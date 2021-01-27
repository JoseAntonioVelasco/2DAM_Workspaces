package problema1;

import java.io.*;
import java.net.*;
/**
 *
 * @author JoseAntonioVelasco
 */
public class ServidorHilosTCP {

    public static void main(String args[]) throws IOException {
        ServerSocket servidor;
        servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");

        while (true) {
            Socket cliente = new Socket();
            cliente = servidor.accept();
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
        }
    }
}
