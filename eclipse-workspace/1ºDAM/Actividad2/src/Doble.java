import java.util.Scanner;

public class Doble {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca num: ");
			Integer num = scan.nextInt();
			scan.close();
			num=num*2;
		System.out.println("Su doble es: " +num);
	}

}
