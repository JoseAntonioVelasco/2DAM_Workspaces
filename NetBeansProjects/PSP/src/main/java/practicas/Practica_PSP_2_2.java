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
public class Practica_PSP_2_2 extends Thread{
    public Practica_PSP_2_2(String nombre){
        super(nombre);
    }
    @Override
    public void run(){
        System.out.println("Nombre: "+getName());
        System.out.println("ID: "+getId());
        System.out.println("Prioridad: "+getPriority());
        System.out.println("Vivo?: "+isAlive());
    }
     public static void main(String[] args) throws InterruptedException{
        Practica_PSP_2_2 h1 = new Practica_PSP_2_2("Hilo1");
        Practica_PSP_2_2 h2 = new Practica_PSP_2_2("Hilo2");
        Practica_PSP_2_2 h3 = new Practica_PSP_2_2("Hilo3");
        
        h1.start();
        h1.join();
        System.out.println("------------------------------------");
        
        h2.start();
        h2.join();
        System.out.println("------------------------------------");
        
        h3.start();
        h3.join();
        
    }
}
