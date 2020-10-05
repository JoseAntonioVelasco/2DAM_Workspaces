import java.util.Scanner;

public class Vectores {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int a1,a2,b1,b2;
	int vector[] = new int[2];
	float vectorunit[] = new float[2];
	float modulo;

	System.out.println("Introduce Punto A");
	a1=scan.nextInt();
	a2=scan.nextInt();
	System.out.println("Introduce Punto B");
	b1=scan.nextInt();
	b2=scan.nextInt();
	scan.close();
	
	vector[0]=a2-a1;
	vector[1]=b2-b1;
	
	System.out.println("El vector AB es:("+vector[0]+","+vector[1]+")");
	modulo=(float)Math.sqrt(Math.pow(vector[0], 2)+Math.pow(vector[1], 2));
	System.out.println("El modulo del vector es: "+modulo);
	
	vectorunit[0]=(float)vector[0]/modulo;
	vectorunit[1]=(float)vector[1]/modulo;
	
	System.out.println("El vector unitario es ("+vectorunit[0]+","+vectorunit[1]+")");
	
			

	}

}
