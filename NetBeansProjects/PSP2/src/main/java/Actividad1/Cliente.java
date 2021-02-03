/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad1;

import static Actividad1.EjemploCifradoV3.encriptar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author JoseAntonioVelasco
 */
public class Cliente {
    
    private static Cipher cifrador;
    private static Cipher descifrador;
    private static SecretKey clave;
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
        String Host = "localhost";
        int Puerto = 6000;
        Socket Cliente = new Socket(Host, Puerto);
        
        PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena, respuesta = "";
        //Escribimos el algoritmo de cifrado que queremos usar
        do{
            System.out.println("Introduce el algoritmo que quieres usar para cifrar tus mensajes: ");
            cadena = in.readLine();
            fsalida.println(cadena);
            respuesta = fentrada.readLine();
            System.out.println(" -> Respuesta : "+respuesta);
        } while(!respuesta.equals("OK"));
        //instanciamos el cifrador, descifrador y la clave con el algoritmo seleccionado
        clave = KeyGenerator.getInstance(cadena).generateKey();
        cifrador = Cipher.getInstance(cadena);
        descifrador = Cipher.getInstance(cadena);
        
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        descifrador.init(Cipher.DECRYPT_MODE, clave);
        
        
        
        //Escribimos mensajes
        do{
            System.out.println("Introduce mensaje: ");
            cadena = in.readLine();
            fsalida.println(encriptar(cadena));
            respuesta = fentrada.readLine();
            System.out.println(" -> Respuesta : "+respuesta);
        } while(!cadena.trim().equals("*"));
        
        fsalida.close();
        fentrada.close();
        System.out.println("Fin del envio... ");
        in.close();
        Cliente.close();
    }
    
    public static String encriptar(String mensaje) {
        try {
            byte[] formatoUTF8 = mensaje.getBytes("UTF8");
            byte[] encriptado = cifrador.doFinal(formatoUTF8);
            encriptado = Base64.getEncoder().encode(encriptado);
            String mensajeEncriptado = new String(encriptado);
            return mensajeEncriptado;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
