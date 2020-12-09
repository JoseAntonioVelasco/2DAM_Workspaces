/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class T3a7_cliente {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String Host = "localhost";
        int Puerto = 6000;

        System.out.println("Iniciando el cliente");
        Socket Cliente = new Socket(Host,Puerto);
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

        flujoSalida.writeUTF("El cliente saLuda Al seRvidor");

        flujoSalida.close();
        Cliente.close();
	
    }
}
