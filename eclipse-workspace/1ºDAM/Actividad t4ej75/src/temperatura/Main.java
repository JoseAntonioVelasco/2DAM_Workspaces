package temperatura;

import java.util.Scanner;

/*A lo largo de 4 días se recogen muestras de temperatura (5 por día). Todas ellas se recogen en un array de
dos dimensiones.
Implementar un programa que tras conocer todos los datos, muestre las temperaturas mínimas y máximas
de cada día. Además de las temperaturas mínima y máxima totales.
Al finalizar, se preguntará al usuario si se desea salir del programa y, en caso negativo, se volverá al
principio del mismo.*/
public class Main {
public static final int DIAS =2;
public static final int MUESTRAS =3;
	public static void main(String[] args) {
	
		String opcion;
		do {
		float [][]temperatura = new float[DIAS][MUESTRAS];
		float []tminima = new float[DIAS];
		float []tmaxima = new float[DIAS];
		float ttotalminima=9999;
		float ttotalmaxima=-273;
		Scanner sc = new Scanner(System.in);
		int i,j;
		for(i=0;i<DIAS;i++) //recojemos los datos
		{
			for(j=0;j<MUESTRAS;j++)
			{
				System.out.format("Muestra %d Dia %d: ",j,i);
				temperatura[i][j]=sc.nextFloat();
			}
		}
		
		
		for(i=0;i<DIAS;i++) //inicializamos los arrays
		{	
				tminima[i]=9999;
				tmaxima[i]=-273;
		}
		
		for(i=0;i<DIAS;i++) //hallamos temp minima del dia
		{
			for(j=0;j<MUESTRAS;j++)
			{
				if(temperatura[i][j]<tminima[i])
				{
					tminima[i]=temperatura[i][j];
				}
			}
		}
		
		for(i=0;i<DIAS;i++) //hallamos temp max del dia
		{
			for(j=0;j<MUESTRAS;j++)
			{
				if(temperatura[i][j]>tmaxima[i])
				{
					tmaxima[i]=temperatura[i][j];
				}
			}
		}
		
		for(i=0;i<DIAS;i++) //hallamos temp total
		{
			for(j=0;j<MUESTRAS;j++)
			{
				if(temperatura[i][j]>ttotalmaxima)
				{
					ttotalmaxima=temperatura[i][j];
				}
			}
		}
		
		for(i=0;i<DIAS;i++) //hallamos temp total
		{
			for(j=0;j<MUESTRAS;j++)
			{
				if(temperatura[i][j]<ttotalminima)
				{
					ttotalminima=temperatura[i][j];
				}
			}
		}
		
		//mostramos datos
		
		for(i=0;i<DIAS;i++) 
		{
			for(j=0;j<MUESTRAS;j++)
			{
				System.out.format("%.2f ",temperatura[i][j]);
				//System.out.printf("%.2f ",temperatura[i][j]);
			}
			System.out.printf("\n");
		}
		
		for(i=0;i<DIAS;i++) 
		{
				System.out.format("temperatura maxima dia %d: ",i);
				System.out.format("%.2f\n",tmaxima[i]);
		}
		for(i=0;i<DIAS;i++) 
		{
				System.out.format("temperatura minima dia %d: ",i);
				System.out.format("%.2f\n",tminima[i]);
		}
		
		System.out.format("temperatura minima total: %.2f\n",ttotalminima);
		System.out.format("temperatura maxima total: %.2f\n",ttotalmaxima);
		
		System.out.format("s/n (s para continuar)...");
		sc.nextLine();
		opcion=sc.nextLine();
		sc.close();
		}while(opcion.equalsIgnoreCase("s"));
		
	}

}
