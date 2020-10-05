package t6ej6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
/*El método static void fill (int[ ] a, int fromIndex, int toIndex, int val) asigna el valor val a todas las
posiciones del array a cuyos índices están comprendidos entre fromIndex y toIndex.
Implementa un programa que contenga un array de 30 elementos iniciados a 0, pida al usuario datos
correspondientes con fromIndex, toIndex y val y haga uso de esta función.
Se debe mostrar el resultado por pantalla.*/
	public static void main(String[] args) {
		int [] array = new int[30];
		int desde;
		int hasta;
		int valor;
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("valor");
		valor = sc.nextInt();
		System.out.println("desde");
		desde = sc.nextInt();
		System.out.println("hasta");
		hasta = sc.nextInt();
		sc.close();
		//iniciamos a 0
		for(i=0;i<30;i++)
		{
			array[i]=0;
		}
		//filleamos el array
		Arrays.fill(array,desde,hasta,valor);
		for(i=0;i<30;i++)
		{
			System.out.printf("%d ",array[i]);
		}
		

	}

}
