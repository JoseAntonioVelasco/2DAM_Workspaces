/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ADMIN
 */
class Contador3 {
    public static int cuenta = 0;
}

class HiloSemaforos extends Thread{
    private int cuentaHilo;
    private Semaphore semaforo;
    
    HiloSemaforos(int fin,int id,Semaphore s){
        this.cuentaHilo = fin;
        this.semaforo=s;
    }
    
    public void incremento(){
        Contador3.cuenta++;
    }
    
    //
    public void run(){
        for(int i=0; i<cuentaHilo; i++){
            try{
                semaforo.acquire();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            incremento();
            semaforo.release();
        }
    }
}
public class SemaforoSimple{
    private static HiloSemaforos hilos[];
    private static Semaphore semaforo = new Semaphore(1);
    
    public static void main(String[] args){
        int totalHilos = 12;
        hilos = new HiloSemaforos[totalHilos];
        
        //todos los hilos cuentan hasta 1000000 pero solo 1 a la vez
        for(int i=0; i<totalHilos; i++){
            hilos[i] = new HiloSemaforos(2,i,semaforo);
            hilos[i].start();
        }
        
        //esperamos a que todos los hilos mueran
        for(int i=0; i<totalHilos; i++){
            try{
                hilos[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        System.out.println("Contador: "+Contador3.cuenta);
    }
}
