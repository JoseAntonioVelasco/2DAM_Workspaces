import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * 
 * @author Jose Antonio Velasco
 *
 */
public class Practica_AD_1_9 {

	public static void main(String[] args)throws FileNotFoundException,IOException,ClassNotFoundException,EOFException{
		// TODO Auto-generated method stub
		Alumno a1 = new Alumno("aa","AA",1,2,3);
		Alumno a2 = new Alumno("bb","BB",4,5,6);
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.add(a1);
		alumnos.add(a2);
		
		Practica_AD_1_9 prueba = new Practica_AD_1_9();
		prueba.escribirObjetos(alumnos);
		prueba.leerObjetos();
	}
	public void escribirObjetos(ArrayList<Alumno> alumnos) throws FileNotFoundException,IOException{
		ObjectOutputStream objetoOS = new ObjectOutputStream(new FileOutputStream("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica9\\src\\ficherosAlumnos.dat"));
		
		for(int i=0; i<alumnos.size();i++) {
			objetoOS.writeObject(alumnos.get(i));
		}
		objetoOS.close();
	}
	public void leerObjetos()throws FileNotFoundException,IOException,ClassNotFoundException {
		ObjectInputStream objetoIS = new ObjectInputStream(new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica9\\src\\ficherosAlumnos.dat"));
		Alumno al = new Alumno();
		
		try {
			while((al=(Alumno) objetoIS.readObject()) != null) {
				System.out.println("nombre: "+al.getNombre());
				System.out.println("apellidos: "+al.getApellidos());
				System.out.println("nota AD: "+al.getNotaAD());
				System.out.println("nota PSP: "+al.getNotaPSP());
				System.out.println("nota SGE: "+al.getNotaSGE());
			}
			objetoIS.close();
		}catch(EOFException e) {
			
		}
		
	}
}
