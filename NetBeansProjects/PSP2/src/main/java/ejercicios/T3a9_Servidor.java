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
 * @author ADMIN
 */
public class T3a9_Servidor {
     public static void main(String[] args) throws IOException{
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando");
        System.out.println("Introduce para cuantos clientes: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i=0; i<num; i++){
            Socket cliente = servidor.accept();
            OutputStream salida = null;
            salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
        
            flujoSalida.write(i);
            
            salida.close();
            flujoSalida.close();
        }
        servidor.close();
    }
}
