/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a17_server {
    
    public static void main(String args[]) throws IOException{
        ServerSocket servidor;
        servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");

        while(true){
            Socket cliente = new Socket();
            cliente = servidor.accept();
            
            //añado este println adicional para mostrar los datos del cliente y el puerto
            System.out.println("Ha entrado un cliente con ip: "+cliente.getInetAddress().getHostAddress()+ " y con puerto: "+cliente.getPort());
            T3a17_hiloServidorMod hilo = new T3a17_hiloServidorMod(cliente);
            hilo.start();
        }
    }
}
