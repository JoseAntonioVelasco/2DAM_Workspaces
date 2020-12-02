/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class EjemploURL_InputStream {
    //URL url = null;
   public static void main(String[] args){
       InputStream inputStream = null;
       try {
           URL url = null;
           try {
               url = new URL("https://www.marca.com");
           } catch (MalformedURLException ex) {
               Logger.getLogger(EjemploURL_InputStream.class.getName()).log(Level.SEVERE, null, ex);
           }
           BufferedReader in;
           inputStream = url.openStream();
           in = new BufferedReader(new InputStreamReader(inputStream));
           String inputLine;
           while((inputLine = in.readLine()) != null){
               System.out.println(inputLine);
           }
           in.close();
       } catch (IOException ex) {
           Logger.getLogger(EjemploURL_InputStream.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           try {
               inputStream.close();
           } catch (IOException ex) {
               Logger.getLogger(EjemploURL_InputStream.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
        
        
    
   }

}
