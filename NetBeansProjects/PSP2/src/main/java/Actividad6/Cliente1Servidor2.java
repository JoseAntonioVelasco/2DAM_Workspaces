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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author JoseAntonioVelasco
 */
public class Cliente1Servidor2 {
     public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Preparamos Server
        System.out.print("Introduce el numero de puerto para actuar como servidor: "); //6001
        Scanner sc = new Scanner(System.in);
        int puertoServer = sc.nextInt();
        ServerSocket servidor = new ServerSocket(puertoServer);
        
        
        
        //Actua como cliente mandando info a un server
        //Conectamos con Servidor1
        int puertoConectar = 6000; 
        String hostConectar = InetAddress.getLocalHost().getHostName();
        Socket cliente = new Socket(hostConectar,puertoConectar);
        //Le pasamos DatosConexion a Servidor1
        DatosConexion datosConexion = new DatosConexion(InetAddress.getLocalHost(),puertoServer);
        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
        System.out.println("\tEnvio datos de la conexion desde el cliente 1 al servidor: ");
        System.out.println("\t\tInetAddress: "+datosConexion.getHost());
        System.out.println("\t\tPuerto: "+datosConexion.getNumPuerto());
        flujoSalida.writeObject(datosConexion);
        //Cerramos cliente
        System.out.println("Cerrando flujo de salida en el cliente 1...");
        flujoSalida.close();
        cliente.close();
        
        
        
        //Se queda actuando como server
        System.out.println("Cliente 1 escuchando como servidor 2 en el puerto: "+puertoServer);
        Socket cliente1 = servidor.accept();
        System.out.println("Esperando los datos de conexion del cliente 2, que me los tiene que enviar el servidor 3...");
        //recibimos los datos de conexion a servidor 3
        InputStream entrada = null;
        entrada = cliente1.getInputStream();
        ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
        DatosConexion datosConexion_aServer3 = (DatosConexion)flujoEntrada.readObject();
        //mostramos los datos que nos pasa
        System.out.println("\tRecibidos datos de la conexion con el cliente 2, me los manda el servidor 3:");
        System.out.println("\t\tInetAddress: "+datosConexion_aServer3.getHost());
        System.out.println("\t\tPuerto: "+datosConexion_aServer3.getNumPuerto());
        
        
        //Pasamos al cliente 3 los para conectarse al server 3
        Socket cliente3 = servidor.accept();
        
        ObjectOutputStream flujoSalida2 = new ObjectOutputStream(cliente3.getOutputStream());
        System.out.println("\tEnvio datos de la conexion desde el servidor 2 al cliente 3: ");
        System.out.println("\t\tInetAddress: "+datosConexion_aServer3.getHost());
        System.out.println("\t\tPuerto: "+datosConexion_aServer3.getNumPuerto());
        flujoSalida2.writeObject(datosConexion_aServer3);
        
        
        //cerramos
        System.out.println("Cerrando flujo de salida en el servidor 2...");
        flujoSalida2.close();
        System.out.println("Cerrando el servidor 2...");
        servidor.close();
    }
}
