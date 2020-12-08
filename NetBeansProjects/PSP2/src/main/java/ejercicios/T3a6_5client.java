/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a6_5client {
    public static void main(String[] args) throws IOException{
        String host = "localhost";
        int puerto = 6000;
            
        Socket cliente=null;
        //creamos 5 clientes que se conectan al server
        for(int a=0; a<5;a++){
            cliente = new Socket(host,puerto);
            InetAddress i = cliente.getInetAddress();
            System.out.println("Informacion");
            System.out.println("Puerto Local: "+cliente.getLocalPort());
            System.out.println("Puerto Remoto: "+cliente.getPort());
            System.out.println("Ip: "+cliente.getRemoteSocketAddress());
        }
        
    }
}
