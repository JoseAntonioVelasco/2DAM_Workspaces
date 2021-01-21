/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a17_hiloServidorMod extends Thread{
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;
    //contador de mensajes
    private static Integer contador_mensajes = 0;
    public T3a17_hiloServidorMod(Socket s) throws IOException{
        socket = s;
        fsalida = new PrintWriter(socket.getOutputStream(), true);
        fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public void run(){
        String cadena = "";
        System.out.println("Estableciendo comunicacion con ..." +socket.toString());
        
        while(!cadena.trim().equals("*")){
            try{
                cadena = fentrada.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            fsalida.println(cadena.trim().toUpperCase());
            //se suma 1 al contador de mensajes
            contador_mensajes++;
        }
        System.out.println("Cerrando comunicacion con ..."+socket.toString());
        System.out.println("Ha enviado esta cantidad de mensajes: "+contador_mensajes);
        fsalida.close();
        try{
            fentrada.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
