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
public class MatarHilo extends Thread{
    private boolean pararHilo = false;
    
    public void pararHilo(){
        pararHilo = true;
    }
    public void run(){
        while(!pararHilo){
            System.out.println("Dentro del hilo");
            System.out.println("Dentro del hilo "+System.currentTimeMillis());
        }
    }
    
    public static void main(String[] args){
        MatarHilo h = new MatarHilo();
        h.start();
        for(int i = 0; i<3000000; i++){
            
        }
        h.pararHilo();
    }
}
