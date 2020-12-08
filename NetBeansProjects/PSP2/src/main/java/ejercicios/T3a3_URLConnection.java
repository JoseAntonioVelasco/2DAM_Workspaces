/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a3_URLConnection {
    
        public static void main(String[] args) throws MalformedURLException, IOException {
            //conectamos a la url
            URL url = new URL("https://aprende-web.net/php/ejemplos/ej5.html");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);
            
            //sacamos info de la url
            System.out.println("Metodo getUrl(): "+conexion.getURL());
            Date d = new Date(conexion.getLastModified());
            System.out.println("Metodo getLastModified(): "+d);
            System.out.println("Metodo getContentType(): "+conexion.getContentType());
            System.out.println("Metodo getHeaderFields(): ");
            
            //recorremos el mapa
            Map map = conexion.getHeaderFields();
            List<String> l = new ArrayList<String>(map.keySet());
            for(int i=0; i<l.size(); i++){
               System.out.println("Campo: "+l.get(i)+"\tContenido: "+map.get(l.get(i)));
            }
            
            //imprimimos en un fichero el html de la url
            FileWriter myWriter = new FileWriter("index.html");
            BufferedReader in;
            InputStream is;
            is = url.openStream();
            in = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                myWriter.write(inputLine);
            }
            in.close();
            myWriter.close();
        }
}
