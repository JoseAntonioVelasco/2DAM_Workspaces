/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cagan
 */
public class HiloSuspender extends Thread{
    
    public SuspensionSegura s = new SuspensionSegura();
    
    public void SuspenderHilo(){
        s.set(true);
    }
    public void Reanudar(){
        s.set(false);
    }
    public void run(){
        try{
            for(int i = 0; i<10; i++){
                System.out.println("Hilo en ejecucion... "+i);
                s.esperaActiva();
            }
        }catch(InterruptedException ex){
            Logger.getLogger(HiloSuspender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]){
        HiloSuspender hilo = new HiloSuspender();
        hilo.start();
        System.out.println("Hilo iniciado");
        hilo.SuspenderHilo();
        System.out.println("Hilo suspendido");
        hilo.Reanudar();
        System.out.println("Hilo reanudado");
    }
    
}
