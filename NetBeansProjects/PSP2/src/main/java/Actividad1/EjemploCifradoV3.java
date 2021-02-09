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
/**
 * 
 * @author JoseAntonioVelasco
 */
public class EjemploCifradoV3 {

    private static Cipher cifrador;
    private static Cipher descifrador;
    private static SecretKey clave;

    public static void main(String[] args) {

        try {
            //con la clave de encriptacion que utiliza el algoritmo DES
            //se crean el cifrador y descifrador en DES
            clave = KeyGenerator.getInstance("DES").generateKey();
            cifrador = Cipher.getInstance("DES");
            descifrador = Cipher.getInstance("DES");
            
            cifrador.init(Cipher.ENCRYPT_MODE, clave);
            descifrador.init(Cipher.DECRYPT_MODE, clave);
            
            //se prueba a cifrar y descifrar el siguiente String
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
    /**
     * cifra el mensaje con la clave establecida al principio del programa
     * @param mensaje mensaje que quieres cifrar
     * @return 
     */
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
    /**
     * descifra el mensaje con la clave establecida al principio del programa
     * @param mensaje mensaje que quieres descifrar
     * @return  mensaje ya cifrado
     */
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
