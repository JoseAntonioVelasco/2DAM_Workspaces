package piramide;

import java.util.Scanner;

public class Piramide {
	
	public static void main(String[] args) {
		System.out.print("Introduce la alura de la piramide: ");
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		
		for(int i=1; i<=num; i++) {

			String fila = ""+calculaEspacios(num,i)+""+hacerFila(i)+""+calculaEspacios(num,i)+"";
			System.out.print(fila);
		
			
			System.out.println("");
		}
		sc.close();
	}
	
	public static String hacerFila(int num) {
		String fila="";
		for(int i=0;i<num-1;i++) {
			fila+=num+" ";
		}
		fila+=num;
	
		return fila;
	}
	public static String calculaEspacios(int altura,int fila) {
		String espacios="";
		for(int i=0; i<altura-fila; i++) {
			espacios+=" ";
		}
		
		return espacios;
	}
}
