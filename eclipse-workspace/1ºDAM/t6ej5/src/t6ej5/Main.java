package t6ej5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
/*El método static boolean equals (int[ ] a,int[ ] a2) devuelve true o false dependiendo si los arrays
indicados como parámetros tienen o no una relación de igualdad.
La sintaxis para su correcta utilización es la que sigue:

Arrays.equals (nombreArray1, nombreArray2)

Modifica la actividad anterior añadiendo una comprobación entre el array original y el copiado para
confirmar que ambos son o no iguales.*/
	public static void main(String[] args) {
		int [] lista = {3,-8,4,9};
		int [] copia;
		int lonarray,i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce longitud del nuevo array copia");
		lonarray = sc.nextInt();
		sc.close();
		copia = Arrays.copyOf(lista,lonarray);
		//mostrar array original
		for(i=0;i<4;i++)
		{
			System.out.printf("%d ",lista[i]);
		}
		System.out.printf("\n");
		//mostrar array copia
		for(i=0;i<lonarray;i++)
		{
			System.out.printf("%d ",copia[i]);
		}
		if(Arrays.equals(lista,copia))
		{
			System.out.println("Son iguales");
		}
		else if(Arrays.equals(lista,copia)==false)
		{
			System.out.println("Son diferentes");
		}
		
	}

}
