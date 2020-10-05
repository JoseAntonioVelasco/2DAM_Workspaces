package t6ej4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
/*El método copyOf copia un array en otro:
Toma como origen el especificado en el primer parámetro y transcribe tantos elementos como los
indicados en el segundo.

static int[ ] copyOf (int[ ] original, int newLength)

En caso de que la longitud del array y el número de elementos especificados no coincidan, el array destino
corresponderá con una versión truncada del original o con más elementos rellenados con valor 0 o NULL,
según su tamaño sea mayor o menor, respectivamente.
Implementa un programa que haga uso de esta función a partir del array original int [ ] lista= { 3, -8, 4, -9};
y otro cuya longitud introduce el usuario.*/
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
		

	}

}
