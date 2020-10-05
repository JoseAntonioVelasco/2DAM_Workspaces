package t6ej2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Completar un ArrayList de tipo String con los nombres de los alumnos de un aula. El usuario introducirá
		nombres hasta que indique que ha terminado. Posteriormente se ordenará el listado de forma alfabética
		haciendo uso del método sort() de las colecciones de Java: Collections.sort(lista);
		Se pide imprimir por pantalla la lista antes y después de ordenarla para comprobar su correcto
		funcionamiento.*/
		
		Scanner sc = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		ArrayList<String> nombres = new ArrayList <String>();
		String nombre;
		String opcion="s";
		int i;
		
		//conseguir nombres
		
		while(opcion.equalsIgnoreCase("s")) 
		{
			System.out.println("Introduce nombre de alumno");
			nombre = sc.nextLine();
			nombres.add(nombre);
			System.out.println("Seguir: s/n");
			opcion = scan.next();
		}
		sc.close();
		scan.close();
		
		//mostrar nombres sin ordenar
		
		System.out.println("nombres sin ordenar");
		for(i=0;i<nombres.size();i++)
		{
			System.out.println("alumno " +i +": "+ nombres.get(i));
		}
		
		//mostar nombres ordenados
		
		System.out.println("nombres ordenados");
		Collections.sort(nombres);
		for(i=0;i<nombres.size();i++)
		{
			System.out.println("alumno " +i +": "+ nombres.get(i));
		}
		
	}

}
