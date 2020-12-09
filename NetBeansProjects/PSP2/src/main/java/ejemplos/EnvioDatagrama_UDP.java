/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author ADMIN
 */
public class EnvioDatagrama_UDP {
    public static void main(String[] argv) throws UnknownHostException, SocketException{
        int port = 12345;
        InetAddress destino = InetAddress.getLocalHost();
        
        byte[] mensaje = new byte[1024];
        String cadena = "Mensaje UDP";
        mensaje = cadena.getBytes();
        
        DatagramPacket envio = new DatagramPacket(mensaje,mensaje.length,destino, port);
        
        DatagramSocket socket = new DatagramSocket(34567);
        socke
        
    }

        
    
}
