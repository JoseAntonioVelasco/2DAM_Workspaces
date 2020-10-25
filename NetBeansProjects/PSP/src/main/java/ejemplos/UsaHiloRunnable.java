/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

/**
 *
 * @author cagan
 */
public class UsaHiloRunnable {
    public static void main(String[] args){
        HiloRunnable hilo1 = new HiloRunnable();
        new Thread(hilo1).start();
        
        HiloRunnable hilo2 = new HiloRunnable();
        Thread hilo = new Thread(hilo2);
        hilo.start();
        
        new Thread(new HiloRunnable()).start();
    }
}
