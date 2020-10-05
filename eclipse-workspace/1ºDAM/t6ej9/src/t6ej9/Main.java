package t6ej9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	/*Implementa un programa que realice escritura y lectura, por bytes, de un poema. Como pista, deberás
	utilizar: FileOutputStream y DataOutputStream, para la escritura y FileInputStream y DataInputStream
	para la lectura.*/
	/*Mis pasos en esta calle
	Resuenan
	En otra calle
	Donde
	Oigo mis pasos
	Pasar en esta calle
	Donde
	Sólo es real la niebla.*/
	public static void main(String[] args) 
		throws IOException {
		File poemacopia = new File("C:\\Users\\cagan\\eclipse-workspace\\t6ej9\\poemacopia.txt");
		File poema = new File("C:\\Users\\cagan\\eclipse-workspace\\t6ej9\\poema.txt");
		//poema = new File("poema.txt");
		try 
		{
			FileOutputStream poemacopy = new FileOutputStream(poemacopia);
			FileInputStream poemaorigi = new FileInputStream(poema);
			
			DataOutputStream salidainfo = new DataOutputStream(poemacopy);
			DataInputStream entradainfo = new DataInputStream(poemaorigi);
			
			while(entradainfo.available()>0)
			{
				int caracter = entradainfo.read();
				salidainfo.write(caracter);
			}
			salidainfo.close();
			entradainfo.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
