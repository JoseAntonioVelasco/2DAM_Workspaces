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
public class HiloInterrupcion extends Thread{
    
    public void run(){
        while(!isInterrupted()){
            System.out.println("Dentro del hilo "+System.currentTimeMillis());
        }
        System.out.println("Ha ocurrido una interrupcion");
    }
    public void interrumpir(){
        interrupt();
    }
    public static void main(String[] args){
        HiloInterrupcion h = new HiloInterrupcion();
        h.start();
        for(int i = 0; i< 100000; i++){
            
        }
        h.interrumpir();
    }
}
