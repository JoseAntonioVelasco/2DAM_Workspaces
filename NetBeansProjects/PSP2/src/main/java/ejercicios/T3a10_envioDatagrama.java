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
public class T3a10_envioDatagrama {
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
        socket.send(envio);
        socket.close();
    }
}
