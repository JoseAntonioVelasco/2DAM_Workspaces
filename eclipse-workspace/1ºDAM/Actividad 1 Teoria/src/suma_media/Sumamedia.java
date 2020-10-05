package suma_media;

import java.util.ArrayList;
import java.util.Scanner;

public class Sumamedia {

	public static void main(String[] args) {
		/*Calcular la suma y media aritmética de los elementos contenidos en un ArrayList. Se pedirá al usuario que
		introduzca valores para rellenarlo.
		Hacer los cálculos en dos funciones independientes a la función main, que recibirán el array como
		parámetro.*/
		Scanner sc = new Scanner(System.in);
		int i,num;
		ArrayList<Integer> numeros = new ArrayList<Integer> ();
		for(i=0;i<4;i++)
		{
			System.out.println("Introduce un num: ");
			num=sc.nextInt();
			numeros.add(num);
		}
		sc.close();
		System.out.println("La suma del array es: "+suma(numeros));
		System.out.println("La media del array es: "+media(numeros));
	}
	
	public static int suma(ArrayList<Integer> numeros) {
		int suma=0;
		int i;
		for(i=0;i<numeros.size();i++)
		{
			suma+=numeros.get(i);
		}
		return suma;
		
	}
	
	public static float media(ArrayList<Integer> numeros) {
		float media;
		int sumatorio;
		
		sumatorio = suma(numeros);
		media=(float)sumatorio/numeros.size();
		
		return media;
	}

}
