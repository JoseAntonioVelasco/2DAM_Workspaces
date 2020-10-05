import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Jose {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Ficheros en el directorio actual: ");
		File f = new File(".");
		String[] archivos = f.list();
		//recursion(archivos,0);
                File[] archivosFile = f.listFiles();
                recursionFicheros(archivosFile,0);

	}
	public static void sacarDatos(File fich,Integer profundidad) throws IOException, InterruptedException {
		String tabulaciones="";
		for(int i=0;i<profundidad;i++) {
			tabulaciones=tabulaciones+"\t";
		}

                System.out.println("Existe o no: "+fich.exists());

		//nombre
		System.out.println(tabulaciones+fich.getName());
		//se puede ejecutar? canExecute()
		System.out.println(tabulaciones+"\tSe puede ejecutar: "+fich.canExecute());
		//se puede leer? canRead()
		System.out.println(tabulaciones+"\tSe puede leer: "+fich.canRead());
		//se puede escribir? canWrite()
		System.out.println(tabulaciones+"\tSe puede escribir: "+fich.canWrite());
		//absulete path
		System.out.println(tabulaciones+"\tRuta absoluta: "+fich.getAbsolutePath());
		//ultima modificacion
		Date d = new Date(fich.lastModified());
		System.out.println(tabulaciones+"\tultima modificacion: "+d);
		//el fichero pesa?
		System.out.println(tabulaciones+"\tEspacio que ocupa: "+fich.length()+"bytes");
                		 Thread.sleep(1000);

	}
	public static void recursion(String[] archivos,Integer profundidad) throws IOException, InterruptedException {
            for(int i=0; i<archivos.length;i++) {

			File fich = new File(archivos[i]);

			if(fich.isDirectory()) {
				String[] arch = fich.list();
				sacarDatos(fich,profundidad);
				System.out.print("\n");
                                profundidad++;
				recursion(arch,profundidad);
				profundidad--;
			}
			else {
				sacarDatos(fich,profundidad);
			}

		}
	}

        public static void recursionFicheros(File[] archivos,Integer profundidad) throws IOException, InterruptedException {
            for(int i=0; i<archivos.length;i++) {



			if(archivos[i].isDirectory()) {
				//String[] arch = fich.list();
                                //File[] arrayFicheros = fich.listFiles();
                                File[] arrayFicheros = archivos[i].listFiles();
				sacarDatos(archivos[i],profundidad);
				System.out.print("\n");
                                profundidad++;
				recursionFicheros(arrayFicheros,profundidad);
				profundidad--;
			}
			else {
				sacarDatos(archivos[i],profundidad);
			}

		}
	}
}