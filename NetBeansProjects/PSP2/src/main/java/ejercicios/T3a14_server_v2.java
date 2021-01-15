/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author JoseAntonioVelasco
 */
class Persona implements Serializable{
    private String nombre;
    private String apellidos;
    private Integer telefono;
    private String dni;

    public Persona(String nombre, String apellidos, Integer telefono, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.dni = dni;
    }
    public Persona(){
        
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
public class T3a14_server_v2 {
        public static void main(String[] arg) throws IOException, ClassNotFoundException{
            //creamos las personas y las metemos al arraylist
        Persona p1 = new Persona("Merlin","Caba",1235,"12345678A");
        Persona p2 = new Persona("Gina","Garcia",4548,"23456789B");
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(p1);personas.add(p2);
        
        //creamos el server
        int numeroPuerto=6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente.....");
        Socket cliente = servidor.accept();
        

        //recibimos el dni
        ObjectInputStream alumnoEntrante = new ObjectInputStream(cliente.getInputStream());
        
        String dni = (String) alumnoEntrante.readObject();
        System.out.println("Recibo: "+dni);
        
        //obtenemos la persona que tenga ese dni
        Persona p = new Persona();
        for(int i=0; i<personas.size(); i++){
            if(personas.get(i).getDni().equals(dni)){
                p = personas.get(i);
                break;
            }
        }
        
        //devolvemos la persona que tiene ese dni al cliente
        ObjectOutputStream personaSaliente = new ObjectOutputStream(cliente.getOutputStream());
        personaSaliente.writeObject(p);
        System.out.println("Envio: "+p.getNombre());
        
        //cerramos
        personaSaliente.close();
        alumnoEntrante.close();
        cliente.close();
        servidor.close();
    }
}
