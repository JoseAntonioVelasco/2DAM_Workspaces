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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a4_URLConnectionMod {
    public static void main(String[] args) throws MalformedURLException, IOException {
        //conectamos a la url
            URL url = new URL("https://aprende-web.net/php/ejemplos/ej5.php");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);
        //pasamos parametros a la url
            String cadena = "nombre=Jose&apellidos=Velasco&email=asuhd@hotmail.com&contras=asd&sexo=M"
                    + "&estudios=basico&musica=on&deportes=on&cine=on&libros=on&ciencia=on&dia=Martes";
            
            PrintWriter output = new PrintWriter(conexion.getOutputStream());
            output.write(cadena);
            output.close();
        //comprobamos que los datos que hemos pasado por parametro han sido recibidos correctamente
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while((linea = reader.readLine()) != null){
                System.out.println(linea);
            }
            reader.close();
        }
}
