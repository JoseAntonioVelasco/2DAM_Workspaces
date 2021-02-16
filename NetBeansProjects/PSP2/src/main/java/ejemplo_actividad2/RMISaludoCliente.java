/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package javarmi;
package ejemplo_actividad2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelrojorevenga
 */
public class RMISaludoCliente {
    public static void main (String[] args) {
        RMISaludoInterface saludo = null;
        
        System.out.println("Localizando el registro de objetos remotos...");
        
        try {
            Registry r = LocateRegistry.getRegistry("localhost",6000);
            System.out.println("Obteniendo el objeto remoto...");
            
            saludo = (RMISaludoInterface) r.lookup("Mensajero");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        if (saludo !=null){
            try {
                System.out.println("Saludo 1: "+saludo.saludo("Hola", "Miguel"));
                System.out.println("Saludo 2: "+saludo.saludo("Que tal", "Miguel"));
                System.out.println("Saludo 3: "+saludo.saludo("Adios", "Miguel"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
