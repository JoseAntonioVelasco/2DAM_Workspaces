package t6ej3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Crea un ArrayList de longitud 50 con números aleatorios comprendidos en el intervalo [0, 10).
		Posteriormente muéstralo por pantalla en filas de 10 de 10 elementos.
		Pide al usuario un número del rango y comprueba, primero, que el elemento se encuentra en el array y,
		después, la primera y ú:ión en que se halla. Se pide, además, implemetar una función que
		devuelva la cantidad de veces que se repite el número dentro del array. Se debe mostrar por pantalla toda
		la información obtenida.
		Finalmente, utiliza el método sort() para ordenar la lista de números y vuelve a mostrarla por pantalla para
		comprobar su correcto funcionamiento.*/
		
		ArrayList<Integer> numsAl = new ArrayList<Integer>();
		int i,repeticiones;
		//Array list con 50 num aleatorios entre 0 y 10
		for(i=0;i<50;i++)
		{
			numsAl.add((int)(Math.random()*10));
		}
		//mostrar en pantalla en filas de 10 elementos.
		for(i=1;i<51;i++)
		{
			System.out.printf("%d ",numsAl.get(i-1));
			if(i%10==0)
			{
				System.out.printf("\n");
			}
			
		}
		
		//pedir numero de rango
		Scanner sc = new Scanner(System.in);
		int num;
		int indice=0,indexfirst=0;
		System.out.printf("\n");
		System.out.println("Introduce un numero: ");
		num=sc.nextInt();
		sc.close();
		//comprobar que el num esta en el array
		
		if(numsAl.contains(num))
		{
			System.out.println("El elemento se encuentra en la lista");
			indexfirst=numsAl.indexOf(num); //guardo el primer encuentro
		}
		else if(numsAl.contains(num)== false)
		{
			System.out.println("El elemento NO se encuentra en la lista");
		}
		
		for(i=0;i<numsAl.size();i++)
		{
			if(numsAl.contains(num))
			{
				indice=numsAl.indexOf(num);
				numsAl.set(indice,-1);
				
				//guardar indice del ultimo encuentro
			}
		}
		System.out.println("Indice del primer encuentro: "+indexfirst);
		System.out.println("Indice del ultimo encuentro: "+indice);
		//restauro el array a su forma original
		for(i=0;i<numsAl.size();i++)
		{
			if(numsAl.contains(-1))
			{
				indice=numsAl.indexOf(-1);
				numsAl.set(indice,num);
				
				//guardar indice del ultimo encuentro
			}
		}
		
		repeticiones=repeticiones(numsAl,num);
		for(i=0;i<numsAl.size();i++)
		{
			if(numsAl.contains(-1))
			{
				indice=numsAl.indexOf(-1);
				numsAl.set(indice,num);
				
				//guardar indice del ultimo encuentro
			}
		}
		System.out.println("Numero de encuentros: "+repeticiones);
		//ordenar array
		Collections.sort(numsAl);
		System.out.println("----ARRAY LIST ORDENADO----");
		for(i=1;i<51;i++)
		{
			System.out.printf("%d ",numsAl.get(i-1));
			if(i%10==0)
			{
				System.out.printf("\n");
			}
			
		}
		
	}
	public static int repeticiones(ArrayList<Integer> numsAl,int num) {
		int repeticiones=0;
		int i;
		int indice;
		
		for(i=0;i<numsAl.size();i++)
		{
			if(numsAl.contains(num))
			{
				indice=numsAl.indexOf(num);
				numsAl.set(indice,-1);
				repeticiones++;
				//guardar indice del ultimo encuentro
			}
		}
		return repeticiones;
	}
	
	
}
