import java.io.*;

public class EjecutaComandos {
	public static void main(String args[]) {
		InputStream inputS= null;
		ByteArrayOutputStream arrayStream= null;
		ProcessBuilder pb = new ProcessBuilder("dir","-B");
		try {
			Process proceso = pb.start();
			
			inputS = proceso.getInputStream();
			byte[] b = new byte[1024];
			int size = 0;
			arrayStream = new ByteArrayOutputStream();
			while((size = inputS.read(b)) != -1) {
				arrayStream.write(b,0,size);
			}
			System.out.println(new String(arrayStream.toByteArray()));
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(inputS != null) inputS.close();
				if(arrayStream != null) arrayStream.close();
			}catch (Exception ex) {}
		}
	}

}
