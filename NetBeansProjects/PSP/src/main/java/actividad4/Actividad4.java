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
            System.out.print(bebido +" ");
            Thread.sleep(1000);
        }
    }
    
    public void sale(){
        ContadorAforo.aforo--;
        System.out.println("\nSale cliente: "+id +" Aforo = "+ContadorAforo.aforo);
        //si hay alguien en la cola entra el primero
        if(!ContadorAforo.cola.isEmpty()){
            ContadorAforo.cola.get(0).entra(); 
            ContadorAforo.cola.remove(0);
        }
    }
    public boolean entra(){
        //si el aforo esta lleno espera a la cola
        if(ContadorAforo.aforo==5){ 
            return false;
        }else{
            ContadorAforo.aforo++;
            System.out.println("Entra cliente: "+id +" Aforo = "+ContadorAforo.aforo);
            return true;
        }
    }
    
    @Override
    public void run(){
        try{  
            semaforo.acquire();
            boolean haEntrado=entra();
            if(!haEntrado){
                ContadorAforo.cola.add(this);
            }
            semaforo.release();
            while(!haEntrado){
                if(ContadorAforo.aforo<5){
                    entra();
                }
            }
            
            if(haEntrado){
                bebe();   
            }  
            
            
            semaforo.acquire();
            if(haEntrado){
                sale();
            }    
            semaforo.release();
        }catch(InterruptedException e){
            e.printStackTrace();
        }  
    }
}

public class Actividad4 {
    private static Cliente clientes[];
    private static Semaphore semaforo = new Semaphore(1);
    
    public static void main(String[] args){
        int totalClientes = 12;
        clientes = new Cliente[totalClientes];
        
      
        for(int i=0; i<totalClientes; i++){
            //se generan todos los clientes y todos quieren entrar a la vez    
            clientes[i] = new Cliente(i,semaforo);
            clientes[i].start();
        }
        
        
        
        //esperamos a que todos los hilos mueran
        for(int i=0; i<totalClientes; i++){
            try{
                clientes[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
       
    }
}
