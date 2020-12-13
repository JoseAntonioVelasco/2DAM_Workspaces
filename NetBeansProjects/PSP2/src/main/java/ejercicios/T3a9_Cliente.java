/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a9_Cliente {
    public static void main(String[] args) throws IOException{
        String host = "localhost";
        int puerto = 6000;
            
        Socket cliente=null;
        //creamos 5 clientes que se conectan al server
        for(int a=0; a<5;a++){
            //los clientes se conectan al mismo servidor
            cliente = new Socket(host,puerto);
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            //el servidor les devuelve que numero de cliente son
            System.out.println("Mi numero de cliente es:\t"+flujoEntrada.read());
            flujoEntrada.close();
        }
        
    }
}
