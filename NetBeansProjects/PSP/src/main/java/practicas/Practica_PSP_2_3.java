/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

/**
 *
 * @author JoseAntonioVelasco
 */
public class Practica_PSP_2_3 extends Thread{
    public Practica_PSP_2_3(ThreadGroup group,String nombre){
        super(group,nombre);
    }
    @Override
    public void run(){
        System.out.println("ID: "+getId());
        System.out.println("Grupo: "+getThreadGroup().getName());
    }
     public static void main(String[] args) throws InterruptedException{
        /*Esto se podria haber hecho en un bucle para no repetir tanto codigo*/ 
        ThreadGroup grupo1 = new ThreadGroup("Grupo1");
        ThreadGroup grupo2 = new ThreadGroup("Grupo2"); 
        ThreadGroup grupo3 = new ThreadGroup("Grupo3");
        
        Practica_PSP_2_3 h1_g1 = new Practica_PSP_2_3(grupo1,"Hilo1");
        Practica_PSP_2_3 h2_g1 = new Practica_PSP_2_3(grupo1,"Hilo2");
        Practica_PSP_2_3 h3_g1 = new Practica_PSP_2_3(grupo1,"Hilo3");
        
        Practica_PSP_2_3 h1_g2 = new Practica_PSP_2_3(grupo2,"Hilo1");
        Practica_PSP_2_3 h2_g2 = new Practica_PSP_2_3(grupo2,"Hilo2");
        Practica_PSP_2_3 h3_g2 = new Practica_PSP_2_3(grupo2,"Hilo3");
        
        Practica_PSP_2_3 h1_g3 = new Practica_PSP_2_3(grupo3,"Hilo1");
        Practica_PSP_2_3 h2_g3 = new Practica_PSP_2_3(grupo3,"Hilo2");
        Practica_PSP_2_3 h3_g3 = new Practica_PSP_2_3(grupo3,"Hilo3");
        
         
        h1_g1.start();
        h1_g1.join();
        System.out.println("------------------------------------");
        
        h2_g1.start();
        h2_g1.join();
        System.out.println("------------------------------------");
        
        h3_g1.start();
        h3_g1.join();
        System.out.println("------------------------------------");
        
        
        
        
        h1_g2.start();
        h1_g2.join();
        System.out.println("------------------------------------");
        
        h2_g2.start();
        h2_g2.join();
        System.out.println("------------------------------------");
        
        h3_g2.start();
        h3_g2.join();
        System.out.println("------------------------------------");
        
        
        
        
        
        h1_g3.start();
        h1_g3.join();
        System.out.println("------------------------------------");
        
        h2_g3.start();
        h2_g3.join();
        System.out.println("------------------------------------");
        
        h3_g3.start();
        h3_g3.join();
        System.out.println("------------------------------------");
        
    }
}
