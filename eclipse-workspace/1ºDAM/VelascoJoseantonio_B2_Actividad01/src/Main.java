import java.util.HashMap;
import java.util.Scanner;

public class Main {
	/*Se quiere calcular la estatura, peso y edad máxima, mínima y media de los jugadores de
	un equipo de baloncesto. Además, se quiere conocer quiénes son las personas con dichas
	alturas, pesos y años. Hemos visto a lo largo del primer trimestre, como hacer el ejercicio
	del Equipo de Baloncesto mediante arrays y mediante estructuras. Ahora vamos a hacerlo
	mediante mapas. Investigad los métodos disponibles para recurrir a ellos tanto como sea
	posible en lugar de hacer las cosas “artesanalmente”.
	
	El programa pedirá los datos de cada uno de los componentes del equipo. Un equipo de
	baloncesto se compone de 5 jugadores, pero, en esta ocasión, puesto que la plantilla va
	mas allá de los jugadores que estén en un momento puntual en el campo, vamos a dejar
	que sea el usuario que decida cuando dejar de introducir datos de nuevos jugadores.
	Tras realizar los cálculos, se mostrarán los resultados además del nombre de los
	jugadores a quiénes corresponden. Si hay más de un jugador con el mismo dato, se
	expondrá el nombre de todos ellos.*/
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		HashMap <String,Float> jugador_estatura = new HashMap<String,Float>();
		HashMap <String,Float> jugador_peso = new HashMap<String,Float>();
		HashMap <String,Integer> jugador_edad = new HashMap<String,Integer>();
		String nombre;
		Float estatura,peso;
		Integer edad;
		int i=0;
		//pedir datos
		System.out.println("Introduce datos jugador, para terminar escribe como nombre de jugador: fin ");
		while(i==0)
		{
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
			edad = sc4.nextInt();
			jugador_estatura.put(nombre,estatura);
			jugador_peso.put(nombre,peso);
			jugador_edad.put(nombre,edad);
					
		}
		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		//mostramos los jugadores y sus caracteristicas
		System.out.println("Estaturas");
		System.out.println(jugador_estatura);
		System.out.println("Pesos");
		System.out.println(jugador_peso);
		System.out.println("Edades");
		System.out.println(jugador_edad);
		
		//calcular maximos
		Float max_peso=0f, max_estatura=0f;
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
		
	}

}