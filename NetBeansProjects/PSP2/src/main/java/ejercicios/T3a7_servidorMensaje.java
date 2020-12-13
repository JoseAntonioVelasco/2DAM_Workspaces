/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a7_servidorMensaje {
    public static void main(String[] arg) throws IOException{
        //creamos servidor
        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clienteConectado = null;
        //esperamos a que se conecte un cliente
        System.out.println("Esperando al cliente.....");
        clienteConectado = servidor.accept();
        
        //iniciamos canal de entrada de informacion del cliente
        InputStream entrada = null;
        entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        //mensaje del cliente
        System.out.println("Recibiendo mensaje del cliente:\t"+flujoEntrada.readUTF().toLowerCase());
        
        
        //cerramos
        entrada.close();
        flujoEntrada.close();
        clienteConectado.close();
        servidor.close();
    }
}
