/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class ObjetosClienteTCP {
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        String Host = "localhost";
        int Puerto = 6000;
        
        System.out.println("PROGRAMA CLIENTE INICIADO.....");
        Socket cliente = new Socket(Host,Puerto);
        
        ObjectInputStream alumnoEntrante = new ObjectInputStream(cliente.getInputStream());
        
        Alumno alumno = (Alumno) alumnoEntrante.readObject();
        System.out.println("Recibo: "+alumno.getNombre()+"*"+alumno.getEdad());
        
        alumno.setNombre("Pepe Perez");
        alumno.setEdad(22);
        
        ObjectOutputStream alumnoSaliente = new ObjectOutputStream(cliente.getOutputStream());
        alumnoSaliente.writeObject(alumno);
        System.out.println("Envio: "+alumno.getNombre()+ "*" + alumno.getEdad());
        
        alumnoEntrante.close();
        alumnoSaliente.close();
        cliente.close();
    }
}
