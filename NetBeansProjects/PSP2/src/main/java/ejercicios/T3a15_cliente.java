/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author JoseAntonioVelasco
 */
class Numero implements Serializable{
    private Integer valor;
    private Integer cuadrado;
    private Integer cubo;

    public Numero(Integer valor, Integer cuadrado, Integer cubo) {
        this.valor = valor;
        this.cuadrado = cuadrado;
        this.cubo = cubo;
    }
    public Numero(){
        
    }
    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getCuadrado() {
        return cuadrado;
    }

    public void setCuadrado(Integer cuadrado) {
        this.cuadrado = cuadrado;
    }

    public Integer getCubo() {
        return cubo;
    }

    public void setCubo(Integer cubo) {
        this.cubo = cubo;
    }
    
}
public class T3a15_cliente {
    public static void main(String[] arg) throws IOException, ClassNotFoundException{
        //creamos el objeto incompleto
        Numero num = new Numero();
        num.setValor(3);
        
        //conectamos a el server indicado
        String Host = "localhost";
        int Puerto = 6000;
        
        System.out.println("PROGRAMA CLIENTE INICIADO.....");
        Socket cliente = new Socket(Host,Puerto);
        
        //enviamos el numero
        ObjectOutputStream alumnoSaliente = new ObjectOutputStream(cliente.getOutputStream());
        alumnoSaliente.writeObject(num);
        System.out.println("Envio: "+num.getValor());
        
        
        //nos devuelve el objeto completo
        ObjectInputStream alumnoEntrante = new ObjectInputStream(cliente.getInputStream());
        
        Numero p = (Numero) alumnoEntrante.readObject();
        System.out.println("Recibo: ^1 "+p.getValor()+"   *^3 "+p.getCubo()+"   *^2 "+p.getCuadrado());
        
        
        //cerramos
        alumnoEntrante.close();
        alumnoSaliente.close();
        cliente.close();
    }
}
