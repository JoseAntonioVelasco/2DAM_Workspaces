package academia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase utilizada para cifrar la cadena de texto pasada como parametro por
 * el metodo sha1
 */
public class Encrypt
{
    static public String cifrar(String mensaje) throws NoSuchAlgorithmException
    {
        MessageDigest md;
        byte[] buffer, digest;
        String hash = "";

        buffer = mensaje.getBytes();
        md = MessageDigest.getInstance("SHA1");
        md.update(buffer);
        digest = md.digest();

        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }

        return hash;
    }
    
}
