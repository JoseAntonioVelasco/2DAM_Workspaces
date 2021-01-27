package problema2;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author JoseAntonioVelasco
 */
public class Cliente1_problema2 {
  //Las clases java para trabajar con objetos son ObjectInputStream, ObjectOutputStream, InputStream, DataInputStream y DataOutputStream
    public static void main(String[] arg) throws IOException, ClassNotFoundException {

        //Datos para generar la lista de alumnos
        Alumno a1 = new Alumno("Pepe", 20, 7.6);
        Alumno a2 = new Alumno("Adrián", 21, 7.7);
        Alumno a3 = new Alumno("Paula", 22, 8.9);
        Alumno a4 = new Alumno("María", 23, 3.6);
        Alumno a5 = new Alumno("Santiago", 24, 9.2);
        ArrayList<Alumno> listadoAlumnos = new ArrayList<Alumno>();
        listadoAlumnos.add(a1);
        listadoAlumnos.add(a2);
        listadoAlumnos.add(a3);
        listadoAlumnos.add(a4);
        listadoAlumnos.add(a5);

        //Mensaje para avisar de que el cliente se ha iniciado
        System.out.println("Programa cliente de envío de datos iniciado....");
        int aleatorio = (int) ((Math.random() * (5 - 3)) + 3); //para generar un número aleatorio entre 3 y 5
        

        //Mensaje para indicar que a continuación se van a enviar los datos de los alumnos
        int puertoConectar = 6000; 
        String hostConectar = InetAddress.getLocalHost().getHostName();
        Socket cliente = new Socket(hostConectar,puertoConectar);
        
        //le pasamos los alumnos
        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
        System.out.println("Enviando los datos de los alumnos...");
        flujoSalida.writeObject(aleatorio);
        for(int i=0 ;i<aleatorio; i++){
            Alumno al = listadoAlumnos.get(i);
            System.out.println("Envio: "+al.getNombre()+","+al.getEdad()+","+al.getNotaMedia());
            flujoSalida.writeObject(al);
        }
        
        flujoSalida.close();
        cliente.close();

    }
}
