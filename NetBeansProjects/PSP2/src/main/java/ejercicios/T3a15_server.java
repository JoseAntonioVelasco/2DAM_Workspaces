/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a15_server {
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        
        //creamos el server
        int numeroPuerto=6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente.....");
        Socket cliente = servidor.accept();
        

        //recibimos el numero
        ObjectInputStream alumnoEntrante = new ObjectInputStream(cliente.getInputStream());
        
        Numero dni = (Numero) alumnoEntrante.readObject();
        System.out.println("Recibo: "+dni.getValor());
        
        //rellenamos ese objeto
        dni.setCuadrado(dni.getValor()*dni.getValor());
        dni.setCubo(dni.getValor()*dni.getValor()*dni.getValor());
        
        //devolvemos el objeto rellenado
        ObjectOutputStream personaSaliente = new ObjectOutputStream(cliente.getOutputStream());
        personaSaliente.writeObject(dni);
        System.out.println("Envio: "+dni.getValor());
        
        //cerramos
        personaSaliente.close();
        alumnoEntrante.close();
        cliente.close();
        servidor.close();
    }
}
