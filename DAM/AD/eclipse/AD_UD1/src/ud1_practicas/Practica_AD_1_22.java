package ud1_practicas;

public class Practica_AD_1_22 {
	public int divide(int a, int b) {
		return a /b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			int a, b;
			a = 5;
			b = 2;
			try {
			System.out.println(a + "/" + b + "=" +a/b);
			}catch(Exception e) {
				e.printStackTrace();
			}
			b = 0;
			try {
			System.out.println(a + "/" + b + "=" +a/b);
			}catch(Exception e) {
				e.printStackTrace();
			}
			b=3;
			try {
			System.out.println(a + "/" + b + "=" +a/b);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}
}
