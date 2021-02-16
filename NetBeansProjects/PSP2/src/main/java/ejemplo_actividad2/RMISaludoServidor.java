/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package javarmi;
package ejemplo_actividad2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelrojorevenga
 */
public class RMISaludoServidor implements RMISaludoInterface {

    @Override
    public String saludo(String mensaje, String destinatario) throws RemoteException {
        System.out.println("Generando saludo...");
        String saludo = "Mensaje para " + destinatario + ": " + mensaje;
        return saludo;
    }

    public static void main(String[] args) {
        System.out.println("Creando el registro de objetos remotos...");
        
        Registry r = null;
        
        try {
            r = LocateRegistry.createRegistry(6000);
        } catch (RemoteException ex) {
            System.out.println("Error, no se ha podido crear el registro.");
            ex.printStackTrace();
        }
        System.out.println("Creo el objeto servidor y lo incluyo en el registro...");
        RMISaludoServidor objetoS = new RMISaludoServidor();
        try {
            r.bind("Mensajero", (RMISaludoInterface) UnicastRemoteObject.exportObject(objetoS, 0));
            
        } catch (Exception e) {
            System.out.println("Error, no se ha podido incluir el objeto en el registro");
            e.printStackTrace();
        }
        
        
        
    }

}
