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
public class T3a5_serv5cli {
    public static void main(String[] args) throws IOException{
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando");
        //creamos un server con capacidad para 5 clientes
        for(int i=0; i<5; i++){
            Socket cliente = servidor.accept();
            System.out.println("SERVIDOR");
            System.out.println("Puerto Local: "+cliente.getLocalPort());
            System.out.println("Puerto Remoto: "+cliente.getPort());
        }
        servidor.close();
    }
}
