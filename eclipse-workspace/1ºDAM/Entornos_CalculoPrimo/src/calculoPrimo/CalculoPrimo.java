package calculoPrimo;

import java.util.Scanner;

public class CalculoPrimo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Cuantos numeros primos quieres hallar: ");
		int n = sc.nextInt();
		int contador=0;
		int numero=2;
		while(contador!=n) {
			
			Boolean primo=true;
			for(int d=2;d<numero;d++) {
				
				if(numero%d==0) {
					primo=false;
					break;
				}
			}
			
			if(primo) {
				System.out.println("Primo!: "+numero);
				contador++;
			}
			numero++;
		}
		
	
	}

}
