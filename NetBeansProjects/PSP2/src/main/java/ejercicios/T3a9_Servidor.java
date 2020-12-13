/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a9_Servidor {
     public static void main(String[] args) throws IOException{
        //creamos un servidor
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando");
        //definimos la capacidad de este servidor
        System.out.println("Introduce para cuantos clientes: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        //creamos el espacio para los clientes
        for(int i=0; i<num; i++){
            //esperamos que se conecte un cliente
            Socket cliente = servidor.accept();
            OutputStream salida = null;
            //iniciamos un canal de comunicacion server->cliente
            salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
            //le pasamos al cliente su numero de cliente
            flujoSalida.write(i);
            
            //ceramos los canales de comunicacion con ese cliente
            salida.close();
            flujoSalida.close();
        }
        servidor.close();
    }
}
