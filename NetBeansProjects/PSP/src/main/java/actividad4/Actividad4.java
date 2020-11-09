/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author JoseAntonioVelasco
 */


class Cliente extends Thread{
    private Semaphore semaforo;
    private int bebido=0;
    private int id;
    
    Cliente(int id,Semaphore s){
        this.id=id;
        this.semaforo=s;
    }
    
    @Override
    public void run(){
        try{ 
            semaforo.acquire();
            System.out.println("Entra cliente: "+id +" Aforo Disponible = "+(semaforo.availablePermits()));
            for(int i=0;i<5;i++){
                //System.out.print("sleep"+id+" ");
                bebido=bebido+20;
                System.out.println(id+": "+bebido +" ");
                 Thread.sleep(1000);
             }
            semaforo.release();
            System.out.println("Sale cliente: "+id +" Aforo Disponible= "+(semaforo.availablePermits()));
        }catch(InterruptedException e){
            e.printStackTrace();
        }  
    }
}

public class Actividad4 {
    private static Cliente clientes[];
    private static Semaphore semaforo = new Semaphore(5);// aforo = 5
    
    public static void main(String[] args){
        int max = 12; 
        int min = 8; 
        int range = max - min + 1; 
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
