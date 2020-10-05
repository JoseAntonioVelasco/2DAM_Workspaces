import java.util.Scanner;

public class transformaciontemperatura {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float temp;
		System.out.println("Introduce temperatura en grados centigrados: ");
		temp = scan.nextFloat();
		temp=temp*((float)9/5)+32;//mhhj
		System.out.println("Su temperatura en farhrenheit es: " +temp);
		scan.close();/*jgjh*/

	}

}
