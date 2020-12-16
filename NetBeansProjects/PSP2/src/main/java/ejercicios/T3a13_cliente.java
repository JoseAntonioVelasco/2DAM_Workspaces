/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a13_cliente {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException{
        
        DatagramSocket clientSocket = new DatagramSocket();
        
        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345;
        
        
        System.out.print("Introduce mensaje: ");
        String cadena_completa= "";
        String cadena;
        while(true){
            cadena = sc.nextLine();
            if(cadena.equals("*")){
                break;
            }else{
                cadena_completa += cadena;
            }
        }
        
        byte[] enviados = new byte[1024];
        enviados = cadena_completa.getBytes();
        
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
        clientSocket.send(envio);
        
        byte[] recibidos = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        System.out.println("Esperando mensaje...");
        
        //https://stackoverflow.com/questions/12363078/adding-timeout-to-datagramsocket-receive
        clientSocket.setSoTimeout(5000);
        while(true) {
            try {
                clientSocket.receive(recibo);
                break;
            } catch (SocketTimeoutException e) {
               System.out.println("Se acabo el tiempo");
               System.exit(0);
            }
        }
        
        byte[] hh = recibo.getData();
        System.out.println("len: "+hh.length);
        
        String mensaje = new String(hh,StandardCharsets.UTF_8);
        
        System.out.println("Recibo: "+mensaje);
        
        clientSocket.close();
    }
}
