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
public class HiloSimple_Thread2 extends Thread{
    private int iteraciones;
    
    HiloSimple_Thread2(int n){
        this.iteraciones = n;
    }
    public void run(){
        for(int i = 0; i < iteraciones; i++){
            System.out.println("Soy un hilo que solo escribe lineas de texto.");
        }
    }
    
    public static void main(String args[]){
        HiloSimple_Thread2 hilo = new HiloSimple_Thread2(10);
        hilo.start();
    }
}
