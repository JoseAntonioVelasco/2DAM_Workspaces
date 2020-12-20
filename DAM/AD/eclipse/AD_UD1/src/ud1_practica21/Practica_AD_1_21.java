package ud1_practica21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Practica_AD_1_21 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//ProbadorSAX
		
		File ficheroXML = new File("C:\\Users\\USER\\Desktop\\Nueva carpeta (5)\\alumnos.xml");
		
		ParserSAX parserSAX = new ParserSAX();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos = parserSAX.parseXml(new FileInputStream(ficheroXML));
		//System.out.println(alumnos);
		
		//imprimimos el resultado
		for(int i=0; i<alumnos.size();i++) {
			System.out.println(alumnos.get(i).getNombre());
			System.out.println(alumnos.get(i).getApellidos());
			System.out.println(alumnos.get(i).getNotaAD());
			System.out.println(alumnos.get(i).getNotaPSP());
			System.out.println(alumnos.get(i).getNotaSGE());
			System.out.println();
		}
	}

}
