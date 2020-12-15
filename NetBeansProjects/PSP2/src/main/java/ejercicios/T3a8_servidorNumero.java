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
public class T3a8_servidorNumero {
    public static void main(String[] arg) throws IOException{
        //creamos el servidor
        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clienteConectado = null;
        //esperamos a que se conecte un cliente
        System.out.println("Esperando al cliente.....");
        clienteConectado = servidor.accept();
        
        //creamos un canal de entrada de informacion para recibir informacion del cliente
        InputStream entrada = null;
        entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        int num = flujoEntrada.read();
        //recibimos el numero del cliente
        System.out.println("Recibiendo mensaje del cliente:\t"+num);
        
        
        //metemos la tabla de multiplicar en un string
        String tabla_mult ="";
        for(int i=0; i<=10; i++){
            tabla_mult += i+" x "+num+" = "+num*i+"\n";
        }
        
        //le pasamos la tabla al cliente
        OutputStream salida = null;
        salida = clienteConectado.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        
        flujoSalida.writeUTF(tabla_mult);
        
        //cerramos
        salida.close();
        flujoSalida.close();
        entrada.close();
        flujoEntrada.close();
        clienteConectado.close();
        servidor.close();
    }
}
