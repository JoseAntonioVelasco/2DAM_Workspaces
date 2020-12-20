package ud1_practicas;

public class Practica_AD_1_23 {
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
			
				
			b = 0;
			//aqui al realizar la operacion salta directamente al catch
			//entonces el 3er println no lo va a ejecutar a diferencia
			//de la practica anterior
			System.out.println(a + "/" + b + "=" +a/b); 
			
			b=3;
			
			System.out.println(a + "/" + b + "=" +a/b);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}
}
