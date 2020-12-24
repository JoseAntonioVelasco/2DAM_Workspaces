/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad6;

import java.io.DataInputStream;
import java.io.IOException;
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
public class Cliente2Servidor3 {
   public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Preparamos Server
        System.out.print("Introduce el numero de puerto para actuar como servidor: "); //6002
        Scanner sc = new Scanner(System.in);
        int puertoServer = sc.nextInt();
        ServerSocket servidor = new ServerSocket(puertoServer);
        
        
        //Conectamos a servidor1
        int puertoConectar = 6000; 
        String hostConectar = InetAddress.getLocalHost().getHostName();
        Socket cliente = new Socket(hostConectar,puertoConectar);
        System.out.println("Esperando los datos de conexion del cliente 1, que me los tiene que enviar el servidor original...");
        //obtenemos los datos del servidor1
        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
        DatosConexion datosConexion = (DatosConexion)flujoEntrada.readObject();
        System.out.println("\t Recibidos datos de la conexion con el cliente 1, me los mnada el servidor: ");
        System.out.println("\t\t InetAddress: "+datosConexion.getHost());
        System.out.println("\t\t Puerto: "+datosConexion.getNumPuerto());
        //cerramos conexion con servidor1
        flujoEntrada.close();
        cliente.close();
        
        
        
        
        //Conectamos a servidor2
        Socket cliente2 = new Socket(datosConexion.getHost(),datosConexion.getNumPuerto());
        //Le pasamos DatosConexion a Servidor1
        DatosConexion datosConexion_server3 = new DatosConexion(InetAddress.getLocalHost(),puertoServer);
        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente2.getOutputStream());
        System.out.println("\t Envio datos de la conexion desde el cliente 2 al servidor2: ");
        System.out.println("\t\t InetAddress: "+datosConexion_server3.getHost());
        System.out.println("\t\t Puerto: "+datosConexion_server3.getNumPuerto());
        flujoSalida.writeObject(datosConexion_server3);
        
        cliente2.close();
        flujoSalida.close();
        
        System.out.println("Cliente 2 escuchando como servidor 3 en el puerto: "+puertoServer);
        Socket cliente3 = servidor.accept();
        
        DataInputStream flujoEntrada2 = new DataInputStream(cliente3.getInputStream());
	System.out.println("Recibiendo mensaje del cliente 3: \t"+flujoEntrada2.readUTF());
        
        //cerramos
        cliente3.close();
        flujoEntrada2.close();
        servidor.close();
    }
}
