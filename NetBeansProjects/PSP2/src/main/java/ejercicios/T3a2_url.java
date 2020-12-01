package ejercicios;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author JoseAntonioVelasco
 *
 */
public class T3a2_url {
    /**
    * @param args
    */
    public static void main(String[] args) throws MalformedURLException {
        // TODO Auto-generated method stub
        URL direccion1 = new URL("https://www.google.es/");
        printinfo(direccion1);
        URL direccion2 = new URL("https://www.google.es/");
        printinfo(direccion2);
        URL direccion3 = new URL("https://www.google.es/");
        printinfo(direccion3);
        URL direccion4 = new URL("https://www.google.es/");
        printinfo(direccion4);
        URL direccion5 = new URL("https://www.google.es/");
        printinfo(direccion5);
        

    }
    static private void printinfo(URL direccion){
        System.out.println("==================================================");
        System.out.println("Metodo getAuthority(): "+direccion.getAuthority()); // TODO Auto-generated catch block
        System.out.println("Metodo getDefaultPort(): "+direccion.getDefaultPort());
        System.out.println("Metodo getPort(): "+direccion.getPort());
        System.out.println("Metodo getHost(): "+direccion.getHost());
        System.out.println("Metodo getPath(): "+direccion.getPath());
        System.out.println("Metodo getUserInfo(): "+direccion.getUserInfo());
    }

}

