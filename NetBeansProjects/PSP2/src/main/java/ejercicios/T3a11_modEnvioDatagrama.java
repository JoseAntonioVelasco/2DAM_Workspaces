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
 * @author JoseAntoniVelasco
 */
public class T3a11_modEnvioDatagrama {
    //Modificacion para enviar solo los bytes del 10 al 20
    public static void main(String[] argv) throws UnknownHostException, SocketException, IOException{
        //preparamos datos de envio del datagrama
        int port = 12345;
        InetAddress destino = InetAddress.getLocalHost();
        
        byte[] mensaje = new byte[1024];
        String cadena = "Mensaje UDP alargando el mensaje para que pille los bytes";
        mensaje = cadena.getBytes();
        
        //cojemos solo los bytes del 10 al 20
        byte[] mensaje_acortado = new byte[10];
        System.out.println("len: "+mensaje.length);
        for(int i=10, j=0; i<20 && j<10; i++,j++){
            mensaje_acortado[j] = mensaje[i];
        }
        
        //preparamos el paquete con la informacion
        DatagramPacket envio = new DatagramPacket(mensaje_acortado,mensaje_acortado.length,destino, port);
        
        //enviamos el paquete
        DatagramSocket socket = new DatagramSocket(34567);
        socket.send(envio);
        socket.close();
    }
}
