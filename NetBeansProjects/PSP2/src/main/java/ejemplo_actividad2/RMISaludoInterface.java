/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package javarmi;
package ejemplo_actividad2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author miguelrojorevenga
 */
public interface RMISaludoInterface extends Remote{
    public String saludo(String mensaje, String destinatario) throws RemoteException;    
}
