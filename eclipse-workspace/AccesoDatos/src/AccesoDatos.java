import java.io.File;

public class AccesoDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ficheros en el direcftorio actual: ");
		File f = new File(".");
		String[] archivos = f.list();
		for(int i=0; i<archivos.length;i++) {
			System.out.println(archivos[i]);
		}
	}

}
