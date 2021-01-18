/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import ejemplos.Alumno;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a16_server {
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        //creamos server
        byte[] bufer = new byte[1024];
        DatagramSocket socket = new DatagramSocket(12345);
        
        //esperamos a que llegue el paquete
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        System.out.println("Esperando el mensaje...");
        socket.receive(recibo);
        
        //recibimos los bytes del objeto y lo transformamos a un alumno
        ByteArrayInputStream bais = new ByteArrayInputStream(recibo.getData());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Alumno alumno = (Alumno)ois.readObject();
        ois.close();
        
        //mostramos el alumno que ha llegado
        System.out.println("Ha llegado est alumno: ");
        System.out.println("Nombre: "+alumno.getNombre());
        System.out.println("Edad: "+alumno.getEdad());
        
        //modificamos el objeto
        alumno.setEdad(43);
        alumno.setNombre("Castro");
        
        
        //convertimos el objeto a bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(alumno);
        oos.close();
        byte[] bytes = baos.toByteArray();
        
        
        //enviamos el objeto en bytes de vuelta al cliente
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();
        DatagramPacket envio = new DatagramPacket(bytes, bytes.length, IPOrigen, puerto);
        socket.send(envio);
        
        
        //cerramos servidor
        socket.close();
    }
}
