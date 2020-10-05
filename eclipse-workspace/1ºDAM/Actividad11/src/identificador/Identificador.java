package identificador;

import java.util.Scanner;

public class Identificador {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String nombre; //= new char[20];
		String apellido1;// = new char[20];
		String apellido2; //= new char[20];
		
		System.out.println("Introduce nombre y apellidos");
		nombre = scan.next();
		apellido1 = scan.next();
		apellido2 = scan.next();
		scan.close();
		System.out.println("Su nombre completo es "+nombre +apellido1 +apellido2 +
				" y su identificador "+nombre.charAt(0)+apellido1.charAt(0)+apellido2.charAt(0));
		
		
		
		

	}

}
