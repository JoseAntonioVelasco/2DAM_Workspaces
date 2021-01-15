/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a14_server {
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        Persona p1 = new Persona("Merlin","Caba",1235,"12345678A");
        Persona p2 = new Persona("Gina","Garcia",4548,"23456789B");
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(p1);personas.add(p2);
        
        int numeroPuerto=6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente.....");
        Socket cliente = servidor.accept();
        

        
        BufferedReader clienteEntrante = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        String dniEntrante = clienteEntrante.readLine();
        
        System.out.println("Recibo: "+dniEntrante);
        
        Persona p = new Persona();
        for(int i=0; i<personas.size(); i++){
            if(personas.get(i).getDni().equals(dniEntrante)){
                p = personas.get(i);
                break;
            }
        }
        
        ObjectOutputStream personaSaliente = new ObjectOutputStream(cliente.getOutputStream());
        personaSaliente.writeObject(p);
        System.out.println("Envio: "+p.getNombre());
        
        
        personaSaliente.close();
        clienteEntrante.close();
        cliente.close();
        servidor.close();
    }
}
