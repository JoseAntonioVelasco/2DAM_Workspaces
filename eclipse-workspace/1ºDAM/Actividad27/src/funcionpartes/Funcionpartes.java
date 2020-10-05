package funcionpartes;

import java.util.Scanner;

public class Funcionpartes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float x,y=0;
		System.out.println("Introduce un valor a x");
		x=scan.nextFloat();
		scan.close();
		if(x>2&&x<=5)
		{
			y=(float)Math.log(x);
		}
		if(x>=-1&&x<=2)
		{
			y=(float)Math.pow(Math.E,(x+1));
		}
		if(x>5) 
		{
			y=(float)Math.pow(x,2)-x;
		}
		if(x<-1)
		{
			y=(float)Math.pow(x, 2)-(float)Math.pow(x, 3);
		}
		System.out.println("y es igual a "+y);
	}
		
}
