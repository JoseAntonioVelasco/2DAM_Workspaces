package ejemplos;

public class ExcepcionCero {
	public int divide(int a, int b) {
		return a /b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		a = 5;
		b = 2;
		System.out.println(a + "/" + b + "=" +a/b);
		b = 0;
		System.out.println(a + "/" + b + "=" +a/b);
		b=3;
		System.out.println(a + "/" + b + "=" +a/b);
	}

}
