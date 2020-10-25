/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

/**
 *
 * @author JoseAntonioVelasco
 */
public class HiloSimple_Thread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i<4; i++){
            System.out.println("Soy un hilo que solo escribe lineas de texto.");
        }
    }
    public static void main(String args[]) {
        HiloSimple_Thread hilo = new HiloSimple_Thread();
        hilo.start();
    }
}
