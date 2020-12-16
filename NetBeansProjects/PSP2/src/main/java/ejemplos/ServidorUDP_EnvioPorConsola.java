/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author ADMIN
 */
public class ServidorUDP_EnvioPorConsola {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket(12345);
        
        System.out.println("Servidor esperando mensaje...");
        DatagramPacket recibo;
        
        byte[] bufer = new byte[1024];
        recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);
        
        String mensaje = new String(recibo.getData()).trim();
        
        System.out.println("Servidor recibe el siguiente mensaje: "+mensaje);
        
        int contador=0;
        for(int i= 0; i<mensaje.length(); i++){
            if(mensaje.charAt(i) == 'a'){contador++;}
        }
        
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();
        
        System.out.println("Enviando numero de apariciones de la letra a: "+contador);
        byte b = (byte) contador;
        byte[] enviados = new byte[2];
        enviados[0] = b;
        
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
        socket.send(envio);
        
        System.out.println("Cerrando conexion...");
        socket.close();
    }
}
