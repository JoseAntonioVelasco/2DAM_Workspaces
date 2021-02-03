/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author JoseAntonioVelasco
 */
public class Server {
    
    public static void main(String args[]) throws IOException{
        ServerSocket servidor;
        //servidor escuchando en el puerto...6000
        servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");

        for(int i=0; i<10; i++){
            Socket cliente = new Socket();
            cliente = servidor.accept();
            
            hiloServidor hilo = new hiloServidor(cliente);
            hilo.start();
        }
    }
}

class hiloServidor extends Thread{
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;
    
    private static Cipher descifrador;
    private static SecretKey clave;
    
    public hiloServidor(Socket s) throws IOException{
        socket = s;
        fsalida = new PrintWriter(socket.getOutputStream(), true);
        fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    
    public void run(){
        try {
            System.out.println("Estableciendo comunicacion con ..." +socket.toString());

            //Esperamos a que el cliente nos pase el algoritmo
            String alg = fentrada.readLine();
            System.out.println("Recibido: "+alg);
            while(true){
                if(!"DES".equals(alg) && !"AES".equals(alg)){
                    fsalida.println("Algoritmo no encontrado, introduce de nuevo: ");
                    alg = fentrada.readLine();
                    System.out.println("Recibido: "+alg);
                }
                else{
                   fsalida.println("OK");
                   break;
                }
            }
            
            //Instanciamos el descifrador y clave
            clave = KeyGenerator.getInstance(alg).generateKey();
            descifrador = Cipher.getInstance(alg);
            descifrador.init(Cipher.DECRYPT_MODE, clave);
            
            
            
            //Podemos empezar a recibir mensajes
            fsalida.println("Puede empezar a escribir mensajes");
            String cadena = "";
            while(!cadena.trim().equals("*")){
                cadena = fentrada.readLine();
                System.out.println(cadena);
            }


            //cerramos
            System.out.println("Cerrando flujo de entrada...");
            fentrada.close();
            System.out.println("Cerando conexion con el cliente...");
            socket.close();
        
        
            System.out.println("Cerrando comunicacion con ..."+socket.toString());

            fsalida.close();
            fentrada.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String desencriptar(String mensaje) {
        try {
            byte[] decoder = Base64.getDecoder().decode(mensaje.getBytes());
            byte[] formatoUTF8 = descifrador.doFinal(decoder);
            String mensajeDesencriptado = new String(formatoUTF8, "UTF8");
            return mensajeDesencriptado;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
