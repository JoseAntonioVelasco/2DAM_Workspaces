/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package javarmi;
package actividad2;

import ejemplo_actividad2.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoseAntonioVelasco
 */
public class CalculadoraServidor implements InterfazCalculadora {
    
    /**
     * Funcion que suma dos enteros 
     * @param n1 numero 1
     * @param n2 numero 2
     * @return la suma de los dos enteros
     * @throws RemoteException 
     */
    @Override
    public Integer suma(Integer n1,Integer n2) throws RemoteException {
        Integer suma = n1 + n2;
        return suma;
    }
    /**
     * Funcion que resta el numero 1 con el numero 2
     * @param n1 numero 1
     * @param n2 numero 2
     * @return la resta de los dos enteros
     * @throws RemoteException 
     */
    @Override
    public Integer resta(Integer n1,Integer n2) throws RemoteException {
        Integer resta = n1 - n2;
        return resta;
    }
    /**
     * Funcion que multiplica los dos enteros
     * @param n1 numero 1
     * @param n2 numero 2
     * @return la multiplicacion de ambos numeros
     * @throws RemoteException 
     */
    @Override
    public Integer multp(Integer n1,Integer n2) throws RemoteException {
        Integer multp = n1 * n2;
        return multp;
    }
    /**
     * Funcion que divide numeros Double 
     * @param n1 numero1
     * @param n2 numero2
     * @return la division de n1 entre n2
     * @throws RemoteException 
     */
    @Override
    public Double div(Double n1,Double n2) throws RemoteException {
        Double div = n1 / n2;
        return div;
    }

    public static void main(String[] args) {
        
        System.out.println("Creando el registro de objetos remotos...");
        
        
        Registry r = null;
        
        try {
            //creamos el registro local en el puerto 6000
            r = LocateRegistry.createRegistry(6000);
        } catch (RemoteException ex) {
            System.out.println("Error, no se ha podido crear el registro.");
            ex.printStackTrace();
        }
        System.out.println("Creo el objeto servidor y lo incluyo en el registro...");
        CalculadoraServidor objetoS = new CalculadoraServidor();
        try {
            //exportamos las funciones de esta clase bajo el nombre "Calculadora"
            //Las funciones de esta clase son las implementadas de la interfaz
            r.bind("Calculadora", (InterfazCalculadora) UnicastRemoteObject.exportObject(objetoS, 0));
            
        } catch (Exception e) {
            System.out.println("Error, no se ha podido incluir el objeto en el registro");
            e.printStackTrace();
        }
        
    }

}
