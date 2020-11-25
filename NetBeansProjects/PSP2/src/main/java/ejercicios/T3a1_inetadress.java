/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author ADMIN
 */
public class T3a1_inetadress {
    public static void main(String args[]) throws UnknownHostException {
        
        System.out.println("SALIDA PARA LOCALHOST: ");
        
        
        System.out.println("\tMetodo getByName(): "+InetAddress.getByName(null));
        System.out.println("\tMetodo getLocalHost(): "+InetAddress.getLocalHost());
        System.out.println("\tMetodo getHostName(): "+InetAddress.getLocalHost().getHostName());
        System.out.println("\tMetodo getHostAddress(): "+InetAddress.getLocalHost().getHostAddress());
        System.out.println("\tMetodo toString(): "+InetAddress.getLocalHost().toString());
        System.out.println("\tMetodo getCanonicaHostName(): "+InetAddress.getLocalHost().getCanonicalHostName());
        System.out.println("=======================================");
        InetAddress ip = InetAddress.getByName("www.google.es");
        System.out.println("SALIDA PARA UNA URL: ");
        System.out.println("\tMetodo getByName(): "+InetAddress.getByName("www.google.es"));
        System.out.println("\tMetodo getLocalHost(): "+InetAddress.getLocalHost());
        System.out.println("\tMetodo getHostName(): "+ip.getHostName());
        System.out.println("\tMetodo getHostAddress(): "+ip.getHostAddress());
        System.out.println("\tMetodo toString(): "+ip.toString());
        System.out.println("\tMetodo getCanonicalHostName(): "+ip.getCanonicalHostName());
        System.out.println("\tDIRECCIONES IP PARA: www.google.es");
        System.out.println("\t\t");
        System.out.println("\t\t");
        
    }
    
}
