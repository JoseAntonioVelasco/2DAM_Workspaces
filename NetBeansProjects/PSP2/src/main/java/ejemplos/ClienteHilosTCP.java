/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class ClienteHilosTCP {
    public static void main(String[] args) throws IOException{
        String Host = "localhost";
        int Puerto = 6000;
        Socket Cliente = new Socket(Host, Puerto);
        
        PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena, respuesta = "";
        
        do{
            System.out.println("Introduce cadena: ");
            cadena = in.readLine();
            fsalida.println(cadena);
            respuesta = fentrada.readLine();
            System.out.println(" -> Respuesta : "+respuesta);
        } while(!cadena.trim().equals("*"));
        
        fsalida.close();
        fentrada.close();
        System.out.println("Fin del envio... ");
        in.close();
        Cliente.close();
    }
}
