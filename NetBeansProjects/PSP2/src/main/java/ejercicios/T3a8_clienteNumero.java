/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class T3a8_clienteNumero {
        public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String Host = "localhost";
        int Puerto = 6000;
         
        System.out.println("Iniciando el cliente");
        System.out.print("Introduce un numero:");
        Socket Cliente = new Socket(Host,Puerto);
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        flujoSalida.write(num);
        //flujoSalida.writeUTF("El cliente saLuda Al seRvidor");
        
        flujoSalida.close();
        Cliente.close();
	
    }
}
