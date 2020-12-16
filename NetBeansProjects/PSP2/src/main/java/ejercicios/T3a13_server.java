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

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a13_server {
     public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket(12345);
        
        System.out.println("Servidor esperando mensaje...");
        DatagramPacket recibo;
        
        byte[] bufer = new byte[1024];
        recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);
        
        String mensaje = new String(recibo.getData());
        
        System.out.println("Servidor recibe el siguiente mensaje: "+mensaje);
        
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();
        
        //mando de vuelta el mensaje en mayusculas
        byte[] enviados = new byte[1024];
        enviados = mensaje.toUpperCase().getBytes();
        
        System.out.println("envio: "+mensaje.toUpperCase());
        
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
        socket.send(envio);
        
        System.out.println("Cerrando conexion...");
        socket.close();
    }
}
