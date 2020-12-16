/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a12_modEnvioDatagrama {
    public static void main(String[] argv) throws UnknownHostException, SocketException, IOException{
        //preparamos datos de envio del datagrama
        int port = 12345;
        InetAddress destino = InetAddress.getLocalHost();
        
        byte[] mensaje = new byte[1024];
        String cadena = "Mensaje UDP";
        mensaje = cadena.getBytes();
        
        //preparamos el paquete con la informacion
        DatagramPacket envio = new DatagramPacket(mensaje,mensaje.length,destino, port);
        
        //enviamos el paquete
        DatagramSocket socket = new DatagramSocket(34567);
        
        //mostramos la informacion de a donde hemos enviado el paquete
        System.out.println("Puerto destino del mensaje: "+port);
        System.out.println("Host de destino: "+InetAddress.getLocalHost());
        System.out.println("IP de destino: "+InetAddress.getLocalHost().getHostAddress());
        System.out.println("Puerto del socket: "+ socket.getLocalPort());
        
        
        socket.send(envio);
        socket.close();
    }
}
