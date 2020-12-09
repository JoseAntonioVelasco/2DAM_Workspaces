/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class T3a8_servidorNumero {
    public static void main(String[] arg) throws IOException{
        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clienteConectado = null;
        System.out.println("Esperando al cliente.....");
        clienteConectado = servidor.accept();
        
        InputStream entrada = null;
        entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        int num = flujoEntrada.read();
        System.out.println("Recibiendo mensaje del cliente:\t"+num);
        
        for(int i=0; i<=10; i++){
            System.out.println(i+" x "+num+" = "+num*i);
        }
        
        entrada.close();
        flujoEntrada.close();
        clienteConectado.close();
        servidor.close();
    }
}
