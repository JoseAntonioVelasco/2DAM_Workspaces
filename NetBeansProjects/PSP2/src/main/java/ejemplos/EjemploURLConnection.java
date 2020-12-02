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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author ADMIN
 */
public class EjemploURLConnection {
    public static void main(String[] args) throws MalformedURLException, IOException {
            URL url = new URL("https://aprende-web.net/php/ejemplos/ej5.php");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);
            
            String cadena = "nombre=Jose&apellidos=Velasco";
            
            PrintWriter output = new PrintWriter(conexion.getOutputStream());
            output.write(cadena);
            output.close();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }
            reader.close();
        }
}
