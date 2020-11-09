/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.util.concurrent.Semaphore;

/**
 * @author JoseAntonioVelasco
 */

class Cliente extends Thread{
    private Semaforo semaforo;
    private int bebido=0;
    private int id;
    
    Cliente(int id,Semaforo s){
        this.id=id;
        this.semaforo=s;
    }
    
    @Override
    public void run(){
        try{ 
            semaforo.acquire(id);
            //System.out.println("Entra cliente: "+id +" Aforo Disponible = "+(semaforo.availablePermits()));
            for(int i=0;i<5;i++){
                //System.out.print("sleep"+id+" ");
                bebido=bebido+20;
                System.out.println(id+": "+bebido +"% ");
                Thread.sleep(1000);
             }
            semaforo.release(id);
            //System.out.println("Sale cliente: "+id +" Aforo Disponible = "+(semaforo.availablePermits()));
        }catch(InterruptedException e){
            e.printStackTrace();
        }  
    }
}

public class Actividad4 {
    private static Cliente clientes[];
    private static Semaforo semaforo = new Semaforo(5);
    //"5" number of permits "green lights" , only 5 threads will be active simultaneously
    public static void main(String[] args){
        int max = 12; 
        int min = 8; 
        int range = max - min + 1; 
        //the number of customers generated will be between 8 and 12
        int totalClientes = (int)(Math.random() * range) + min;
        System.out.println("Total clientes: "+totalClientes);
        clientes = new Cliente[totalClientes];
        
        for(int i=0; i<totalClientes; i++){
            //creates all the customers and all wants to enter at the same time
            clientes[i] = new Cliente(i,semaforo);
            clientes[i].start();
        }
        
             
       //waiting for all threads(customers) to die
       for(int i=0; i<totalClientes; i++){
            try{
                clientes[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
       
    }
}

class Semaforo extends Semaphore{
    
    public Semaforo(int permits) {
        super(permits);
    }
    @Override
    public void acquire(int id) throws InterruptedException{
        super.acquire();
        System.out.println("Entra cliente: "+id +" Aforo Disponible = "+(this.availablePermits()));
    }
    @Override
    public void release(int id){
        super.release();
        System.out.println("Sale cliente: "+id +" Aforo Disponible = "+(this.availablePermits()));
    }
}
