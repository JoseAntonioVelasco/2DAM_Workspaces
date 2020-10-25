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
public class SuspensionSegura {
    private boolean suspendido;
    
    public synchronized void set(boolean b){
        suspendido = b;
        notifyAll();
    }
    public synchronized void esperaActiva() throws InterruptedException{
        while(suspendido){
            wait();
        }
    }
}
