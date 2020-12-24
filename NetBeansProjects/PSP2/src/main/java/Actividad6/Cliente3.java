/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author JoseAntonioVelasco
 */
public class Cliente3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        System.out.print("Introduce el numero de puerto al que conectarse (puerto del servidor 2 -cliente1-): "); //6001
        Scanner sc = new Scanner(System.in);
        int puerto = sc.nextInt();
        Socket cliente3 = new Socket(InetAddress.getLocalHost(),puerto);
        
        System.out.println("Esperando los datos de conexion del servidor 3, que me los tiene que enviar el servidor 2...");
        
        //obtenemos los datos del servidor2
        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente3.getInputStream());
        DatosConexion datosConexion = (DatosConexion)flujoEntrada.readObject();
        System.out.println("\t Recibidos datos de la conexion con el cliente 2, me los mnada el servidor2: ");
        System.out.println("\t\t InetAddress: "+datosConexion.getHost());
        System.out.println("\t\t Puerto: "+datosConexion.getNumPuerto());
        //cerramos
        System.out.println("Cerrando flujo de entrada en el cliente 3...");
        flujoEntrada.close();
        cliente3.close();
        
        System.out.println("Ya tengo los datos del servidor 3 (cliente2). Voy a mandarle un mensaje y terminara la practica.");
        Socket cliente3_aServer3 = new Socket(datosConexion.getHost(),datosConexion.getNumPuerto());
        DataOutputStream flujoSalida = new DataOutputStream(cliente3_aServer3.getOutputStream());
	flujoSalida.writeUTF("Este es el mensaje de fin de la practica, el cliente 3 saluda al servidor 3(que tambien es el cliente 2)");
        System.out.println("Cerrando flujo de salida en el cliente 3...");
        flujoSalida.close();
        System.out.println("Cerrando el cliente 3...");
        cliente3_aServer3.close();
    }
}
