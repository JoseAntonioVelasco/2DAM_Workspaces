package actividad1;
import java.io.*;


public class Padre {

	public static void main(String[] args) throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		File directorio = new File("C:\\Users\\USER\\Documents\\GitWorkspaces\\2DAM_Workspaces\\eclipse-workspace\\PSP_UD1\\bin\\actividad1");
		ProcessBuilder pb = new ProcessBuilder("java","Hijos");
		pb.directory(directorio);
		
		Process p = pb.start();
		
		p.waitFor();
		
		InputStream is = p.getInputStream();
		int c;
		while((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	
		
		
	}

}
