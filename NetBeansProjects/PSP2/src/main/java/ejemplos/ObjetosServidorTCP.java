/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class ObjetosServidorTCP {
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        int numeroPuerto=6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente.....");
        Socket cliente = servidor.accept();
        
        ObjectOutputStream alumnoSaliente = new ObjectOutputStream(cliente.getOutputStream());
        Alumno alumnoServidor = new Alumno("Pepe",20);
        alumnoSaliente.writeObject(alumnoServidor);
        System.out.println("Envio: "+alumnoServidor.getNombre()+"*"+alumnoServidor.getEdad());
        
        ObjectInputStream alumnoEntrante = new ObjectInputStream(cliente.getInputStream());
        Alumno dato = (Alumno) alumnoEntrante.readObject();
        System.out.println("Recibo: "+dato.getNombre()+"*"+dato.getEdad());
        
        alumnoSaliente.close();
        alumnoEntrante.close();
        cliente.close();
        servidor.close();
    }
}
