package Actividad1;


import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
public class EjemploCifradoV3 {

    private static Cipher cifrador;
    private static Cipher descifrador;
    private static SecretKey clave;

    public static void main(String[] args) {

        try {
            clave = KeyGenerator.getInstance("DES").generateKey();
            cifrador = Cipher.getInstance("DES");
            descifrador = Cipher.getInstance("DES");
            
            cifrador.init(Cipher.ENCRYPT_MODE, clave);
            descifrador.init(Cipher.DECRYPT_MODE, clave);
            
            String mensajeOriginal = "Esto es el colegio San Viator.";
            String mensajeEncriptado = encriptar(mensajeOriginal);
            String mensajeDesencriptado = desencriptar(mensajeEncriptado);
            System.out.println("Mensaje original: " + mensajeOriginal);
            System.out.println("Mensaje encriptado: " + mensajeEncriptado);
            System.out.println("Mensaje desencriptado: " + mensajeDesencriptado);

        } catch (Exception e) {
            System.out.println("Excepción:" + e.getMessage());
            return; 
        } 
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
