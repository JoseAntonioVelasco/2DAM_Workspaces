package ejemplos;
public class Procesos {
	public void ejecutar(String ruta) {
		ProcessBuilder pb;
		try {
			pb= new ProcessBuilder(ruta);
			pb.start();
		} catch(Exception e) {
			e.printStackTrace();		
		}
	}
	public static void main(String[] args) {
		String ruta= "C:\\Windows\\notepad.exe";
		Procesos lp = new Procesos();
		lp.ejecutar(ruta);
		System.out.println("Finalizado");
	}
}
