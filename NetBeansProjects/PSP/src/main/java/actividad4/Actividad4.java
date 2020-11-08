/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author JoseAntonioVelasco
 */

class ContadorAforo {
    //this are the SHARED VARIABLES in the threads.
    
    //Warning: everytime that you have to modify these variables
    //you must acquire the "green light" from the Semaphore
    //and realease after you finish.
    
    public static ArrayList<Cliente> cola = new ArrayList<Cliente>();
    public static int aforo = 0;
}
class Cliente extends Thread{
    private Semaphore semaforo;
    private int bebido=0;
    private int id;
    
    Cliente(int id,Semaphore s){
        this.id=id;
        this.semaforo=s;
    }
    
    public void bebe() throws InterruptedException{
        for(int i=0; i<5; i++){
            bebido=bebido+20;
            System.out.print(id+": "+bebido +" ");
            //Thread.sleep(1000);
        }
    }
    
    public void sale() throws InterruptedException{
        semaforo.acquire();
        ContadorAforo.aforo--;
        System.out.println("\nSale cliente: "+id +" Aforo = "+ContadorAforo.aforo);
        semaforo.release();
        
        //when leaving, notify the first in the queue
        if(!ContadorAforo.cola.isEmpty()){
            Cliente siguiente = ContadorAforo.cola.get(0);
            ContadorAforo.cola.remove(0);
            siguiente.run();
        }
        
    }
    public boolean entra() throws InterruptedException{
        //if the capacity is at its limit it waits in the queue
        semaforo.acquire();
        if(ContadorAforo.aforo==5){
            //if the customer is already in the queue we dont add him
            if(ContadorAforo.cola.contains(this)){
                semaforo.release();
                return false;
            }
            //if it isn`t in the queue we add him
            ContadorAforo.cola.add(this);
            semaforo.release();
            return false;
        }
        
        ContadorAforo.aforo++;
        System.out.println("Entra cliente: "+id +" Aforo = "+ContadorAforo.aforo);
        semaforo.release();
        return true;
        
    }
    
    @Override
    public void run(){
        try{  
            //tries to enter, if it enters drinks and then leaves
            if(entra()){
                bebe();
                sale();
            } 
        }catch(InterruptedException e){
            e.printStackTrace();
        }  
    }
}

public class Actividad4 {
    private static Cliente clientes[];
    private static Semaphore semaforo = new Semaphore(1);
    
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
