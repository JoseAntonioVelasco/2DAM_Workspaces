/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ServidorHilosTCP {
    public static void main(String args[]) throws IOException{
        ServerSocket servidor;
        servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");
        
        while(true){
            Socket cliente = new Socket();
            cliente = servidor.accept();
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
        }
    }
}
