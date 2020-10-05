package t6ej7;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	/*Supongamos los conjuntos de números enteros

	A {1, 2, 3, 4, 5} y B {3, 4, 5, 6, 7}
	
	Su unión se expresa como A ꓴ B {1, 2, 3, 4, 5, 6, 7}
	Su intersección se expresa como A ꓵ B {3, 4, 5}
	Su diferencia se expresa como A – B {1, 2} / B – A {6, 7}
	
	Implementar un programa que contenga dos TreeSet<String> y los rellene pidiendo nombres de
	personas al usuario. Posteriormente se mostrarán por pantalla los dos conjuntos originales y su unión,
	intersección y diferencia.
	Es preciso ayudarse de funciones como addAll, removeAll y retainAll.*/
	
	public static void main(String[] args) {
		TreeSet<String> nombres1 = new TreeSet<String>();
		TreeSet<String> nombres2 = new TreeSet<String>();
		TreeSet<String> resultado = new TreeSet<String>();
		String nombre="zzz";
		Scanner scan = new Scanner(System.in);
		//pedir nombres
		System.out.println("Introduce nombres en la lista 1");
		System.out.println("para parar de introducir nombre escribir: fin");
		while(!nombre.toLowerCase().equals("fin"))
		{
			System.out.printf("Introduce nombre: ");
			nombre=scan.nextLine();
			if(nombre.toLowerCase().equals("fin"))
			{
				break;
			}
			nombres1.add(nombre);
	
			
		}
		nombre="zzz";
		System.out.println("Introduce nombres en la lista 2");
		System.out.println("para parar de introducir nombre escribir: fin");
		while(!nombre.toLowerCase().equals("fin"))
		{
			System.out.printf("Introduce nombre: ");
			nombre=scan.nextLine();
			if(nombre.toLowerCase().equals("fin"))
			{
				break;
			}
			nombres2.add(nombre);
			
		}
		scan.close();
		//mostrar conjuntos originales
		System.out.println("Conjunto 1 original");
	
		System.out.println(nombres1);

		System.out.println("Conjunto 2 original");
	
		System.out.println(nombres2);
		
		//mostrar union
		resultado.addAll(nombres1);
		resultado.addAll(nombres2);
		System.out.println("Union nombres 1 y nombres 2 "+resultado);
		//mostrar interseccion
		resultado.removeAll(resultado);
		resultado.addAll(nombres1);
		resultado.retainAll(nombres2);
		System.out.println("Interseccion nombres 1 nombres 2 "+resultado);
		//mostrar diferencia A-B y B-A
		//A-B
		resultado.removeAll(resultado);
		resultado.addAll(nombres1);
		resultado.removeAll(nombres2);
		System.out.println("nombres1 - nombres 2 "+resultado);
		//B-A
		resultado.removeAll(resultado);
		resultado.addAll(nombres2);
		resultado.removeAll(nombres1);
		System.out.println("nombres2 - nombres 1 "+resultado);
		

	}

}
