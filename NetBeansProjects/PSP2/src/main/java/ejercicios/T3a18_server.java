/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T3a18_server {
     public static void main(String args[]) throws IOException{
        ServerSocket servidor;
        servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");

        for(int i=0; i<10; i++){
            Socket cliente = new Socket();
            cliente = servidor.accept();
            
            hiloServidor hilo = new hiloServidor(cliente,20);
            hilo.start();
        }
    }
}

class hiloServidor extends Thread{
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;
    Integer creditos;
    
    public hiloServidor(Socket s,Integer creditos) throws IOException{
        socket = s;
        this.creditos = creditos; 
        fsalida = new PrintWriter(socket.getOutputStream(), true);
        fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    
    public void run(){
        try {
            String cadena = "";
            System.out.println("Estableciendo comunicacion con ..." +socket.toString());

            while(creditos>0){
                    cadena = fentrada.readLine();
                    //([0-9]{1,2}|\\-[0-9]{1,2})[\\+\\-\\*\\/]([0-9]{1,2}|\\-[0-9]{1,2}) patron que admite nº negativos
                    while(!Pattern.matches("[0-9]{1,2}[\\+\\-\\*\\/][0-9]{1,2}",cadena)){
                        fsalida.println("La operacion ("+cadena+") no cumple los requisitos, introduzcala de nuevo");
                        cadena = fentrada.readLine();
                    }
                    //Hacer operacion
                    Pattern p = Pattern.compile("[\\+\\-\\*\\/]");
                    String[] operandos = p.split(cadena);
                    Integer operando1 = Integer.parseInt(operandos[0]);
                    Integer operando2 = Integer.parseInt(operandos[1]);
                    String operador = Character.toString(cadena.charAt(operandos[0].length()));
                    
                    System.out.println("Operador: "+operador+" Operandos 1: "+operando1+ " 2: "+operando2);
                    
                    Integer resultado = null;
                    if(operador.equals("+") && creditos >= 5){
                        resultado = suma(operando1,operando2);
                        creditos = creditos -5;
                    }else if(operador.equals("-") && creditos >= 5){
                        resultado = resta(operando1,operando2);
                        creditos = creditos -5;
                    }else if(operador.equals("*") && creditos >= 10){
                        resultado = multiplicacion(operando1,operando2);
                        creditos = creditos -10;
                    }else if(operador.equals("/") && creditos >= 10){
                        creditos = creditos - 10;
                        resultado = division(operando1,operando2);
                    }
                    
                    fsalida.println("La operacion ("+cadena+") tiene el siguiente resultado: "+resultado);
                    fsalida.println("credito de operaciones restante: "+creditos);
            }
        
            System.out.println("Cerrando comunicacion con ..."+socket.toString());

            fsalida.close();
            fentrada.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Integer suma(Integer n1,Integer n2){
        return n1+n2;
    }
    private Integer resta(Integer n1,Integer n2){
        return n1-n2;
    }
    private Integer multiplicacion(Integer n1,Integer n2){
        return n1*n2;
    }
    private Integer division(Integer n1,Integer n2){
        return n1/n2;
    }
}

