/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a14_cliente {
     public static void main(String[] arg) throws IOException, ClassNotFoundException{
        String Host = "localhost";
        int Puerto = 6000;
        
        System.out.println("PROGRAMA CLIENTE INICIADO.....");
        Socket cliente = new Socket(Host,Puerto);
        
        String dniBuscar = "12345678A";
        
        
        BufferedWriter alumnoSaliente = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
        alumnoSaliente.write(dniBuscar);
        System.out.println("Envio: "+dniBuscar);
        
        
        ObjectInputStream personaEntrante = new ObjectInputStream(cliente.getInputStream());
        
        Persona persona = (Persona) personaEntrante.readObject();
        System.out.println("Recibo: "+persona.getNombre());
        
        personaEntrante.close();
        alumnoSaliente.close();
        cliente.close();
    }
}
