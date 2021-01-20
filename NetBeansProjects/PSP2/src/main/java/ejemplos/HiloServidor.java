/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class HiloServidor {
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;
    
    public HiloServidor(Socket s) throws IOException{
        String cadena = "";
        System.out.println("Estableciendo comunicacion con ..." +socket.toString());
        
        while(!cadena.trim().equals("*")){
            try{
                cadena = fentrada.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            fsalida.println(cadena.trim().toUpperCase());
        }
        System.out.println("Cerrando comunicacion con ..."+socket.toString());
        
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
