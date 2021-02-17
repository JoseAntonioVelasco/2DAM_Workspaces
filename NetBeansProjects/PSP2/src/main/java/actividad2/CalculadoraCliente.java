/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package javarmi;
package actividad2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoseAntonioVelasco
 */
public class CalculadoraCliente {
    public static void main (String[] args) {
        InterfazCalculadora calculos = null;
        
        System.out.println("Localizando el registro de objetos remotos...");
        
        try {
            //Conectamos al registro local con puerto 6000
            Registry r = LocateRegistry.getRegistry("localhost",6000);
            System.out.println("Obteniendo el objeto remoto...");
            //Sacamos las funciones implementadas y las metemos en nuestra interfaz sin implementar
            calculos = (InterfazCalculadora) r.lookup("Calculadora");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //si no se han conseguido sacar los metodos implementados no entra
        if (calculos !=null){
            try {
                //probamos los metodos implementados se han sacado del servidor
                System.out.println("Suma(1+2): "+calculos.suma(1, 2));
                System.out.println("Resta(1-2): "+calculos.resta(1, 2));
                System.out.println("Multiplicacion(1*2): "+calculos.multp(1, 2));
                System.out.println("Division(1/2): "+calculos.div(1.0, 2.0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
