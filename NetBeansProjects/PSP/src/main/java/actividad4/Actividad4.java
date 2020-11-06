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
            System.out.print(id+": "+bebido +" ");
            //Thread.sleep(1000);
        }
    }
    
    public void sale() throws InterruptedException{
        semaforo.acquire();
        ContadorAforo.aforo--;
        System.out.println("\nSale cliente: "+id +" Aforo = "+ContadorAforo.aforo);
        semaforo.release();
        
    }
    public boolean entra() throws InterruptedException{
        //si el aforo esta lleno espera a la cola
        semaforo.acquire();
        if(ContadorAforo.aforo==5){ 
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
            //intenta entrar
                //comprueba si hay menos de 5 personas, entra ...acquire +1 al foro release...
                //si hay mas de 5 espera a la cola
            boolean haEntrado=entra();
            if(haEntrado){
                bebe();
                sale();
            }  
            if(!ContadorAforo.cola.isEmpty()){
                ContadorAforo.cola.get(0).entra(); 
                ContadorAforo.cola.remove(0);
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
