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
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a16_cliente {
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        //conectamos
        DatagramSocket clientSocket = new DatagramSocket();
        
        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345;
        
        //creamos el alumno 
        Alumno alumno = new Alumno("Pepe",10);
        
        //pasamos el objeto a bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(alumno);
        oos.close();
        byte[] bytes = baos.toByteArray();
        
        //le pasamos los bytes del objeto al server
        DatagramPacket envio = new DatagramPacket(bytes, bytes.length, IPServidor, puerto);
        clientSocket.send(envio);
        
        
        //recibimos el paquete del objeto modificado en bytes
        byte[] bytesRecibidos = new byte[1024];
        DatagramPacket paqueteRecibido = new DatagramPacket(bytesRecibidos, bytesRecibidos.length);
        clientSocket.receive(paqueteRecibido);
        
        //convertimos los bytes a un objeto
        ByteArrayInputStream bais = new ByteArrayInputStream(bytesRecibidos);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Alumno alu = (Alumno)ois.readObject();
        ois.close();
        
        //mostramos por pantalla el objeto recibido
        System.out.println("Nombre: "+alu.getNombre());
        System.out.println("Edad: "+alu.getEdad());
      
        //cerramos
        clientSocket.close();
    }
}
