package problema2;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
/**
 *
 * @author JoseAntonioVelasco
 */
public class Servidor_problema2 {
//Las clases java para trabajar con objetos son ObjectInputStream, ObjectOutputStream, InputStream, DataInputStream y DataOutputStream
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        
        //Mensaje para indicar que el servidor se ha iniciado
        System.out.println("Esperando al cliente.....");
        Socket cliente1 = servidor.accept();
        
        InputStream entrada = null;
        entrada = cliente1.getInputStream();
        ObjectInputStream flujoEntrada = new ObjectInputStream(entrada);
        Integer num_al = (Integer)flujoEntrada.readObject();
        
        ArrayList<Alumno> listadoAlumnos = new ArrayList<Alumno>();
        for(int i=0; i<num_al; i++){
            Alumno al = (Alumno)flujoEntrada.readObject();
            listadoAlumnos.add(al);
        }
        
        //Mensaje para mostrar después la lista de alumnos recibidos
        System.out.println("Listado de alumnos recibido: ");
        for(int i=0; i<listadoAlumnos.size();i++){
            Alumno al = listadoAlumnos.get(i);
            System.out.println("Alumno "+i+" --> "+"Nombre: "+al.getNombre()+", Edad: "+al.getEdad()+", Nota media: "+al.getNotaMedia());
        }
        
        entrada.close();
        flujoEntrada.close();
        
        
        //Mensaje para informar de que se está construyendo el objeto clase
        System.out.println("Construyendo el objeto clase para enviárselo al cliente 2...");
        Clase clase = new Clase(listadoAlumnos,"Acceso a Datos",2);
        Socket cliente2 = servidor.accept();
        
        //enviamos el objeto clase al cliente 2
        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente2.getOutputStream());
        flujoSalida.writeObject(clase);
        
        //Mensaje previo a cerrar el servidor
        System.out.println("Objeto clase enviado. Cerrando el servidor...");
        flujoSalida.close();
        cliente1.close();
        cliente2.close();
        servidor.close();
    }
}
