package problema2;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
/**
 *
 * @author JoseAntonioVelasco
 */
public class Cliente2_problema2 {
  //Las clases java para trabajar con objetos son ObjectInputStream, ObjectOutputStream, InputStream, DataInputStream y DataOutputStream
    public static void main(String[] arg) throws IOException, ClassNotFoundException {

        //Mensaje para indicar que el cliente se ha iniciado
        System.out.println("Programa cliente de consulta iniciado....");
        int puertoConectar = 6000; 
        String hostConectar = InetAddress.getLocalHost().getHostName();
        Socket cliente = new Socket(hostConectar,puertoConectar);
        //recibimos la clase
        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
        Clase clase = (Clase)flujoEntrada.readObject();
        

        //Mensajes de salida
        System.out.println("Recibo del servidor los datos de la clase.");
        System.out.println("Curso: "+clase.getCurso());
        System.out.println("Módulo: "+clase.getModulo());
        System.out.println("Número de alumnos: "+clase.getAlumnos().size());
        //calculo media edad
        ArrayList<Alumno> listadoAlumnos = clase.getAlumnos();
        Integer sumatorio = 0;
        double sumatorio2 = 0;
        for (Alumno al : listadoAlumnos) {
            sumatorio=al.getEdad() +sumatorio;
            sumatorio2 = al.getNotaMedia() +sumatorio2;
        }
        double mediaEdad = sumatorio / (double)listadoAlumnos.size();
        System.out.println("Media de edad de los alumnos: "+mediaEdad);
        //calculo nota media
        double mediaNota = sumatorio2 / (double)listadoAlumnos.size();
        System.out.println("Nota media de la clase: "+mediaNota);
        
        flujoEntrada.close();
        cliente.close();

    }
}
