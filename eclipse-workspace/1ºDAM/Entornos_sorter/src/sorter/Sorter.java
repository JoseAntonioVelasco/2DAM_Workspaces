package sorter;

import java.util.ArrayList;

public class Sorter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		for(int i=0;i<8;i++) {
			numeros.add((int) (Math.random()*100));
		}
		//bubble sort
		Boolean swapped=true;
		while(swapped) {
			swapped=false;
			for(int i=0;i<numeros.size()-1;i++) {
				if(numeros.get(i)>numeros.get(i+1)) {
					numeros=swap(numeros,i,i+1);
					swapped=true;
				}
			}
		}
		//mostrar ordenador
		System.out.println("Ordenado");
		for(int i=0;i<numeros.size();i++) {
			System.out.println(numeros.get(i)+" ");
		}
		
	}
	public static ArrayList<Integer> swap(ArrayList<Integer> numeros,Integer pos1,Integer pos2) {
		Integer posicion2=numeros.get(pos2);
		numeros.set(pos2, numeros.get(pos1));
		numeros.set(pos1, posicion2);
		
		return numeros;
	}

}
