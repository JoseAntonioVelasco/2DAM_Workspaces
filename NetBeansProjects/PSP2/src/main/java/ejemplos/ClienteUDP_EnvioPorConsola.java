/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ClienteUDP_EnvioPorConsola {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException{
        
        DatagramSocket clientSocket = new DatagramSocket();
        
        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345;
        
        System.out.print("Introduce mensaje: ");
        String cadena = sc.nextLine();
        
        byte[] enviados = new byte[1024];
        enviados = cadena.getBytes();
        
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
        clientSocket.send(envio);
        
        byte[] recibidos = new byte[2];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        System.out.println("Esperando mensaje...");
        clientSocket.receive(recibo);
        
        byte[] hh = recibo.getData();
        int numero = hh[0];
        
        System.out.println("Recibo "+numero+" caracteres que son a.");
        
        clientSocket.close();
    }
}
