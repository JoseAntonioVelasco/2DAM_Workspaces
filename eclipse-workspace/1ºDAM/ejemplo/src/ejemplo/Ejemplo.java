package ejemplo;

import java.util.ArrayList;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for(i=0;i<5; i++)
		{
			lista.add(i); //añade numeros del 0-4 (0,1,2,3,4)
		}
		lista.add(100); //añade en la posicion 3 el numero 100 (0,1,2,100,3,4) al añadir se incrementa en 1 el tamaño del array
		System.out.println("Se encuentra el 100 en la lista: "+lista.contains(100)); //100 en la posicion 3 de la lista
		System.out.println("El 100 se encuentra en la posicion: "+lista.indexOf(100));
		
		for(i=0; i<lista.size();i++)
		{
			System.out.print(lista.get(i));
			System.out.println("");
		}
		lista.remove(3);
		
		for(i=0; i<lista.size(); i++)
		{
			System.out.print(lista.get(i)+" ");
		}
	}

}
