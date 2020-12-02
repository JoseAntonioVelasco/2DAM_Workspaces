/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class ClienteBasico {
    public static void main(String[] args) throws IOException{
        String host = "localhost";
        int puerto = 6000;
        
        Socket cliente = new Socket(host,puerto);
        
        InetAddress i = cliente.getInetAddress();
        System.out.println("Informacion");
        System.out.println(cliente.getLocalPort());
    }
}
