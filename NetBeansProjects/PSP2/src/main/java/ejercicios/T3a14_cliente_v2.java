/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a14_cliente_v2 {
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        //conectamos a el server indicado
        String Host = "localhost";
        int Puerto = 6000;
        
        System.out.println("PROGRAMA CLIENTE INICIADO.....");
        Socket cliente = new Socket(Host,Puerto);
        
        //le pasamos el dni de la persona que queremos buscar
        String dniBuscar = "12345678A";
        
        ObjectOutputStream alumnoSaliente = new ObjectOutputStream(cliente.getOutputStream());
        alumnoSaliente.writeObject(dniBuscar);
        System.out.println("Envio: "+dniBuscar);
        
        
        //nos devuelve la persona que tiene ese dni
        ObjectInputStream alumnoEntrante = new ObjectInputStream(cliente.getInputStream());
        
        Persona p = (Persona) alumnoEntrante.readObject();
        System.out.println("Recibo: "+p.getNombre()+"*"+p.getDni());
        
        
        //cerramos
        alumnoEntrante.close();
        alumnoSaliente.close();
        cliente.close();
    }
}
