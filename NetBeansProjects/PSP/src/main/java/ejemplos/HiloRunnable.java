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
public class HiloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Soy un hilo Runnable");
    }
    
}
