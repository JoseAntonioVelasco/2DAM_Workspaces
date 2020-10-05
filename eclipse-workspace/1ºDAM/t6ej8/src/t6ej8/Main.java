package t6ej8;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	/*Implementa un programa que parta de dos ArrayList (l1, l2) de 10 elementos de tipo entero. El primero de
	ellos se rellenará con números aleatorios del intervalo [0,10) y mientras en el segundo se encontrará el
	número 5 en todas sus posiciones. A partir de este punto se darán los siguientes pasos:
	• Ordenar la primera lista.
	• Copiar la primera lista en la segunda.
	• Desordenar la primera lista.
	• Invertir el orden de la segunda lista.
	• Intercambiar en ambas listas los elementos de las posiciones 2 y 4.
	• Comprobar la cantidad de apariciones de cada uno de los números.
	• Comprobar que ambas listas tienen elementos comunes.
	Tras cada uno de los pasos anteriormente citados, se deben mostrar ambas listas por pantalla para
	comprobar el correcto funcionamiento del programa.*/
	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList <Integer>();
		ArrayList<Integer> l2 = new ArrayList <Integer>();
		int i;
		//rellenar l1 de num aleatorios del 1 al 10 y en l2 rellenar con 5
		for(i=0;i<10;i++)
		{
			l1.add((int)(Math.random()*10));
			l2.add(5);
		}
		//ordenar primera lista
		Collections.sort(l1);
		System.out.println("mostrar primera lista");
		for(i=0;i<l1.size();i++)
		{
			System.out.printf("%d ",l1.get(i));
		}
		System.out.println("\nmostrar segunda lista");
		for(i=0;i<l2.size();i++)
		{
			System.out.printf("%d ",l2.get(i));
		}
		//copiar la primera lista en la segunda
		Collections.copy(l2, l1);
		System.out.println("\n mostrar primera lista");
		for(i=0;i<l1.size();i++)
		{
			System.out.printf("%d ",l1.get(i));
		}
		System.out.println("\n mostrar segunda lista");
		for(i=0;i<l2.size();i++)
		{
			System.out.printf("%d ",l2.get(i));
		}
		//Desordenar la primera lista
		Collections.shuffle(l1);
		System.out.println("\n mostrar primera lista");
		for(i=0;i<l1.size();i++)
		{
			System.out.printf("%d ",l1.get(i));
		}
		System.out.println("\n mostrar segunda lista");
		for(i=0;i<l2.size();i++)
		{
			System.out.printf("%d ",l2.get(i));
		}
		//Invertir el orden
		Collections.reverse(l2);
		System.out.println("\n mostrar primera lista");
		for(i=0;i<l1.size();i++)
		{
			System.out.printf("%d ",l1.get(i));
		}
		System.out.println("\n mostrar segunda lista");
		for(i=0;i<l2.size();i++)
		{
			System.out.printf("%d ",l2.get(i));
		}
		//Intercambiar en ambas listas los elementos de las posiciones 2 y 4
		Collections.swap(l1, 2, 4);
		Collections.swap(l2, 2, 4);
		System.out.println("\n mostrar primera lista");
		for(i=0;i<l1.size();i++)
		{
			System.out.printf("%d ",l1.get(i));
		}
		System.out.println("\n mostrar segunda lista");
		for(i=0;i<l2.size();i++)
		{
			System.out.printf("%d ",l2.get(i));
		}
		//Comprobar la cantidad de apariciones de cada uno de los números.
		int [] freq1 = new int[10];
		int [] freq2 = new int[10];
		for(i=0;i<10;i++)
		{
			freq1[i]=Collections.frequency(l1, i);
			freq2[i]=Collections.frequency(l2, i);
		}
		System.out.printf("\nfrecuencia 1\n");
		for(i=0;i<10;i++)
		{
			System.out.printf("\n cantidad de %d que aparecen: ",i);
			System.out.printf("%d ",freq1[i]);
		}
		System.out.printf("\nfrecuencia 2\n");
		for(i=0;i<10;i++)
		{
			System.out.printf("\ncantidad de %d que aparecen: ",i);
			System.out.printf("%d ",freq2[i]);
		}
		//Comprobar que ambas listas tienen elementos comunes.
		if(Collections.disjoint(l1, l2))
		{
			System.out.println("\n no tienen elementos comunes");
		}
		else
		{
			System.out.println("\n tienen elementos comunes");
		}
	}

}
