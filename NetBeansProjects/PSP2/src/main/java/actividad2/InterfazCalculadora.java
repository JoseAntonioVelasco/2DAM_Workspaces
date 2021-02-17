/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package javarmi;
package actividad2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author JoseAntonioVelasco
 */
public interface InterfazCalculadora extends Remote{
    //metodos que va a tener la calculadora
    public Integer suma(Integer n1,Integer n2) throws RemoteException;
    public Integer resta(Integer n1,Integer n2) throws RemoteException;
    public Integer multp(Integer n1,Integer n2) throws RemoteException;
    public Double div(Double n1,Double n2) throws RemoteException;
}
