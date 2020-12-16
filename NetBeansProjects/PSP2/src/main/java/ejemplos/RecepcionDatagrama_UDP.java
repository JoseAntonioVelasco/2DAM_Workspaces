/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class RecepcionDatagrama_UDP {
    public static void main(String[] argv) throws Exception{
        byte[] bufer = new byte[1024];
        
        DatagramSocket socket = new DatagramSocket(12345);
        
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        System.out.println("Esperando el mensaje...");
        
        socket.receive(recibo);
        int bytesRec = recibo.getLength();
        
        String paquete = new String(recibo.getData());
        
        System.out.println("Bytes recibidos: "+bytesRec);
        System.out.println("Contenido del paquete: "+paquete.trim());
        System.out.println("Puerto origen del mensaje: "+recibo.getPort());
        System.out.println("IP de origen: "+recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje: "+ socket.getLocalPort());
        
        socket.close();
    }
}
