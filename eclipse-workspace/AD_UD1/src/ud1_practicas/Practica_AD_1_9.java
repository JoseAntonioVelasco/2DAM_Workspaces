package ud1_practicas;
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

	public static void main(String[] args){
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
	public void escribirObjetos(ArrayList<Alumno> alumnos) {
		ObjectOutputStream objetoOS = null;
		try {
			objetoOS = new ObjectOutputStream(new FileOutputStream("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica9\\src\\ficherosAlumnos.dat"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=0; i<alumnos.size();i++) {
			try {
				objetoOS.writeObject(alumnos.get(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			objetoOS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void leerObjetos(){
		ObjectInputStream objetoIS = null;
		try {
			objetoIS = new ObjectInputStream(new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\AD_Unidad1_Practica9\\src\\ficherosAlumnos.dat"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Alumno al = new Alumno();
		
		try {
			while((al=(Alumno) objetoIS.readObject()) != null) {
				System.out.println("nombre: "+al.getNombre());
				System.out.println("apellidos: "+al.getApellidos());
				System.out.println("nota AD: "+al.getNotaAD());
				System.out.println("nota PSP: "+al.getNotaPSP());
				System.out.println("nota SGE: "+al.getNotaSGE());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objetoIS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
