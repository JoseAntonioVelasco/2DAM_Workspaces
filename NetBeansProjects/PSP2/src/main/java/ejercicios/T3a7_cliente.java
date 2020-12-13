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
 * @author JoseAntonioVelasco
 */
public class T3a7_cliente {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        //creamos cliente
        String Host = "localhost";
        int Puerto = 6000;

        System.out.println("Iniciando el cliente");
        //conectamos al server
        Socket Cliente = new Socket(Host,Puerto);
        //mandamos mensaje al servidor
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

        flujoSalida.writeUTF("El cliente saLuda Al seRvidor");
        
        //cerramos cliente
        flujoSalida.close();
        Cliente.close();
	
    }
}
