package examenInicial;
import java.io.File;

public class examenInicial
{
	public static void metodo(String[] args)
	{
		File file = new File(args[0]);
		
		if(file.isDirectory())
		{
			String[] ficheros = file.list();

			for(String f: ficheros)
				if(f.endsWith(args[1]))
				System.out.println(f);
		}
	}
	public static void main(String[] args)
	{
		String[] argumentos = {"C:\\Windows", ".exe"};
		metodo(argumentos);
	}
}