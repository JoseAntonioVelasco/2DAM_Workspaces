package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	/*Tomando de base el ejercicio anterior, en lugar de mostrar por pantalla los datos tal como
	se especifica, mostrarlos por pantalla generando un XML válido. Es decir, la estructura y
	sintaxis XML que represente al equipo con sus jugadores y los datos de cada jugador, para
	poder transmitir esa información a otros.*/
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		HashMap <String,ArrayList<Float>> jugador_caracteristica = new HashMap<String,ArrayList<Float>>();
		String nombre;
		Float estatura,peso,edad;
		int i=0;
		//pedir datos
		System.out.println("Introduce datos jugador, para terminar escribe como nombre de jugador: fin ");
		while(i==0)
		{
			ArrayList <Float> caracteristica = new ArrayList<Float>();
			System.out.println("Introduce nombre jugador: ");
			nombre = sc1.nextLine();
			if(nombre.toLowerCase().contentEquals("fin"))
			{
				System.out.println("Saliendo...");
				break;
			}
			System.out.printf("Introduce estatura de %s: ", nombre);
			estatura = sc2.nextFloat();
			System.out.printf("\nIntroduce peso de %s: ", nombre);
			peso = sc3.nextFloat();
			System.out.printf("\nIntroduce edad de %s: ", nombre);
			edad = sc4.nextFloat();
			caracteristica.add(estatura);
			caracteristica.add(peso);
			caracteristica.add(edad);
			jugador_caracteristica.put(nombre,caracteristica);
			//caracteristica.removeAll(caracteristica);
					
		}
		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		//mostramos los jugadores y sus caracteristicas
		System.out.println("\tCaracteristicas jugadores");
		System.out.println("\t-------------------------");
		System.out.println("\tnombre=[estatura,peso,edad]");
		System.out.println(jugador_caracteristica);
		System.out.println("\tMostramos datos de los jugadores en formato xml");
		System.out.printf("<equipo>\n");
		
			for(String s : jugador_caracteristica.keySet())
			{
				System.out.printf("\t<jugador>\n");
				
				
					System.out.printf("\t\t<nombre>\n");
						System.out.printf("\t\t\t%s\n",s);
					System.out.printf("\t\t</nombre>\n");
					System.out.printf("\t\t<estatura>\n");
						ArrayList<Float> aux = new ArrayList<Float>();
						aux=jugador_caracteristica.get(s);
						System.out.printf("\t\t\t%.2f\n",aux.get(0));
					System.out.printf("\t\t</estatura>\n");
					System.out.printf("\t\t<peso>\n");
						System.out.printf("\t\t\t%.2f\n",aux.get(1));
					System.out.printf("\t\t</peso>\n");
					System.out.printf("\t\t<edad>\n");
						System.out.printf("\t\t\t%.2f\n",aux.get(2));
					System.out.printf("\t\t</edad>\n");
				
				
				System.out.printf("\t</jugador>\n");
			}
	
		System.out.printf("</equipo>");
		
		//calcular maximos
/*		Float max_peso=0f, max_estatura=0f;
		Integer max_edad=0;
		for(Float max : jugador_peso.values())
		{
			if(max>max_peso)
			{
				max_peso = max;
			}
		}
		for(Float max : jugador_estatura.values())
		{
			if(max>max_estatura)
			{
				max_estatura = max;
			}
		}
		for(Integer max : jugador_edad.values())
		{
			if(max>max_edad)
			{
				max_edad = max;
			}
		}
		//calcular minimos
		Float min_peso=999999f, min_estatura=999999f;
		Integer min_edad=999999;
		for(Float min : jugador_peso.values())
		{
			if(min<min_peso)
			{
				min_peso = min;
			}
		}
		for(Float min : jugador_estatura.values())
		{
			if(min<min_estatura)
			{
				min_estatura = min;
			}
		}
		for(Integer min : jugador_edad.values())
		{
			if(min<min_edad)
			{
				min_edad = min;
			}
		}
		
		//calcular medias
		
		Float sumatorio=0f;
		Float media_peso, media_estatura, media_edad;
		Float cont=0f;
		for(Float val : jugador_peso.values())
		{
			sumatorio += val;
			cont++;
		}
		media_peso = sumatorio/cont;
		sumatorio=0f;
		cont=0f;
		for(Float val : jugador_estatura.values())
		{
			sumatorio += val;
			cont++;
		}
		media_estatura = sumatorio/cont;
		sumatorio=0f;
		cont=0f;
		for(Integer val : jugador_edad.values())
		{
			sumatorio += val;
			cont++;
		}
		media_edad = sumatorio/cont;
		sumatorio=0f;
		cont=0f;
		
		//mostrar datos calculados
		
		System.out.println("Media estatura jugadores: "+media_estatura);
		System.out.println("Media peso jugadores: "+media_peso);
		System.out.println("Media edad jugadores: "+media_edad);
		
		System.out.println("Max estatura jugador/es: "+max_estatura);
		for(String s : jugador_estatura.keySet()) 
		{
			float aux=jugador_estatura.get(s);
			if(aux==max_estatura)
			{
				System.out.println(s);
			}
		}
		System.out.println("Max peso jugador/es: "+max_peso);
		for(String s : jugador_peso.keySet()) 
		{
			float aux=jugador_peso.get(s);
			if(aux==max_peso)
			{
				System.out.println(s);
			}
		}
		System.out.println("Max edad jugador/es: "+max_edad);
		for(String s : jugador_edad.keySet()) 
		{
			if(jugador_edad.get(s)==max_edad)
			{
				System.out.println(s);
			}
		}
		
		/////////////////////////////////////////////////////////////
		
		System.out.println("Min estatura jugador/es: "+min_estatura);
		for(String s : jugador_estatura.keySet()) 
		{
			float aux=jugador_estatura.get(s);
			if(aux==min_estatura)
			{
				System.out.println(s);
			}
		}
		System.out.println("Min peso jugador/es: "+min_peso);
		for(String s : jugador_peso.keySet()) 
		{
			float aux=jugador_peso.get(s);
			if(aux==min_peso)
			{
				System.out.println(s);
			}
		}
		System.out.println("Min edad jugador/es: "+min_edad);
		for(String s : jugador_edad.keySet()) 
		{
			if(jugador_edad.get(s)==min_edad)
			{
				System.out.println(s);
			}
		}
		*/
	}

}