/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad6;



import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class Servidor1 {
    //servidor escuchando en el puerto...6000
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor escuchando en el puerto..."+puerto);
        
        //Cliente 1
        System.out.println("Esperando los datos de la conexion con el cliente 1: ");
        Socket cliente1 = servidor.accept();
        //Flujo de entrada para los datos del cliente1
        InputStream entrada = null;
        entrada = cliente1.getInputStream();
        ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
        DatosConexion datosConexion = (DatosConexion)flujoEntrada.readObject();
        //mostramos los datos que nos pasa
        System.out.println("\tRecibidos datos de la conexion con el cliente1:");
        System.out.println("\t\tInetAddress: "+datosConexion.getHost());
        System.out.println("\t\tPuerto: "+datosConexion.getNumPuerto());
        //cerramos
        System.out.println("Cerrando flujo de entrada...");
        flujoEntrada.close();
        entrada.close();
        System.out.println("Cerando conexion con el cliente 1...");
        cliente1.close();
        
        
        
        //Cliente 2
        System.out.println("Abriendo conexion con el cliente 2 para enviarle los datos del cliente 1...");
        Socket cliente2 = servidor.accept();
        
        //le pasamos al cliente 2 los datos para conectarse al otro servidor
        OutputStream salida = null;
        salida = cliente2.getOutputStream();
        ObjectOutputStream flujoSalida = new ObjectOutputStream(salida);
        System.out.println("\t Envio datos de la conexion desde el servidor al cliente 2: ");
        System.out.println("\t\t InetAddress: "+datosConexion.getHost());
        System.out.println("\t\t Puerto: "+datosConexion.getNumPuerto());
        flujoSalida.writeObject(datosConexion);
        
        //cerramos conexion con el cliente2
        System.out.println("Cerrando flujo de salida");
        salida.close();
        flujoSalida.close();
        System.out.println("Cerrando conexion con el cliente 2...");
        cliente2.close();
        System.out.println("Cerrando el servidor original");
        servidor.close();
    }
}
