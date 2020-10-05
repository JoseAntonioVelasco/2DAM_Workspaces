package gestionHotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import habitaciones.*;
import hotel.Hotel;
import reserva.Reserva;


public class GestionHabitaciones {
	public GestionHabitaciones() {
		
	}
	public static void muestraHabitaciones(ArrayList<Habitacion> habitaciones){
		for(int i=0;i<habitaciones.size();i++)
		{
			System.out.println("");
			if(habitaciones.get(i).getClass().getSimpleName().equals("Individual"))
			{
				System.out.println("Habitacion Individual");
				Individual indv = new Individual(); 
				indv=(Individual) habitaciones.get(i);
				indv.muestraDatos();
			}
			else if(habitaciones.get(i).getClass().getSimpleName().equals("Doble"))
			{
				System.out.println("Habitacion Doble");
				Doble dob = new Doble();
				dob=(Doble) habitaciones.get(i);
				dob.muestraDatos();
			}
			else if(habitaciones.get(i).getClass().getSimpleName().equals("Familiar"))
			{
				System.out.println("Habitacion Familiar");
				Familiar fam = new Familiar();
				fam=(Familiar) habitaciones.get(i);
				fam.muestraDatos();
			}
			else if(habitaciones.get(i).getClass().getSimpleName().equals("Suite"))
			{
				System.out.println("Habitacion Suite");
				Suite suit = new Suite();
				suit=(Suite) habitaciones.get(i);
				suit.muestraDatos();
			}
		}
		
	}
	public static void obtenerInfoHabitacion(ArrayList<Habitacion> habitaciones){
		System.out.print("Introduzca el numero de habitacion para obtener informacion: ");
		int number = Hotel.sc.nextInt();
		boolean hab_encontrada=false;
		for(int i=0;i<habitaciones.size();i++)
		{
			if(habitaciones.get(i).getCod_hab()==number)
			{
				if(habitaciones.get(i).getClass().getSimpleName().equals("Individual"))
				{
					System.out.println("Habitacion Individual");
					Individual indv = new Individual(); 
					indv=(Individual) habitaciones.get(i);
					indv.muestraDatos();
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Doble"))
				{
					System.out.println("Habitacion Doble");
					Doble dob = new Doble();
					dob=(Doble) habitaciones.get(i);
					dob.muestraDatos();
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Familiar"))
				{
					System.out.println("Habitacion Familiar");
					Familiar fam = new Familiar();
					fam=(Familiar) habitaciones.get(i);
					fam.muestraDatos();
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Suite"))
				{
					System.out.println("Habitacion Suite");
					Suite suit = new Suite();
					suit=(Suite) habitaciones.get(i);
					suit.muestraDatos();
				}
				hab_encontrada=true;
			}
		}
		if(hab_encontrada==false)
		{
			System.out.println("No se ha encontrado una habitacion con ese numero");
		}
	}
	public static void modificarHabitacion(ArrayList<Habitacion> habitaciones) {
		System.out.print("Introduzca el numero de habitacion para modificarla: ");
		int number = Hotel.sc.nextInt();
		boolean hab_encontrada=false;
		for(int i=0;i<habitaciones.size();i++)
		{
			if(habitaciones.get(i).getCod_hab()==number)
			{
				if(habitaciones.get(i).getClass().getSimpleName().equals("Individual"))
				{
					Individual indv = new Individual();
					indv=(Individual) habitaciones.get(i);
					indv.pedirDatos(habitaciones);
					habitaciones.set(i, indv);
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Doble"))
				{
					Doble doble = new Doble(); 
					doble = (Doble) habitaciones.get(i);
					doble.pedirDatos(habitaciones);
					habitaciones.set(i, doble);
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Familiar"))
				{
					Familiar fam = new Familiar();
					fam=(Familiar) habitaciones.get(i);
					fam.pedirDatos(habitaciones);
					habitaciones.set(i, fam);;
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Suite"))
				{
					Suite suit = new Suite();
					suit = (Suite) habitaciones.get(i);
					suit.pedirDatos(habitaciones);
					habitaciones.set(i, suit);
				}
				hab_encontrada=true;
			}
		}
		if(hab_encontrada==false)
		{
			System.out.println("No se ha encontrado una habitacion con ese numero");
		}
		

	}
	public static void anadirHabitacion(ArrayList<Habitacion> habitaciones) {
		System.out.println("Que tipo de habitacion quieres anadir");
		System.out.println("1.Individual");
		System.out.println("2.Doble");
		System.out.println("3.Familiar");
		System.out.println("4.Suite");
		System.out.print("Elije opcion: ");
		int opcion=Hotel.sc.nextInt();
		switch(opcion)
		{
			case 1:
				Individual indv = new Individual();
				if(indv.pedirDatos(habitaciones)==false)
					return;
				habitaciones.add(indv);
				break;
			case 2:
				Doble doble = new Doble();
				if(doble.pedirDatos(habitaciones)==false)
					return;
				habitaciones.add(doble);
				break;
			case 3:
				Familiar fam = new Familiar();
				if(fam.pedirDatos(habitaciones)==false)
					return;
				habitaciones.add(fam);
				break;
			case 4:
				Suite suit = new Suite();
				if(suit.pedirDatos(habitaciones)==false)
					return;
				habitaciones.add(suit);
				break;
			default:
				System.out.println("Error");
		}
	}
	public static void eliminarHabitacion(ArrayList<Habitacion> habitaciones){
		System.out.print("Introduzca el numero de habitacion para eliminarla: ");
		int number = Hotel.sc.nextInt();
		boolean hab_encontrada=false;
		for(int i=0;i<habitaciones.size();i++)
		{
			if(habitaciones.get(i).getCod_hab()==number)
			{
				habitaciones.remove(i);
				hab_encontrada=true;
				break;
			}
		}
		if(hab_encontrada==false)
		{
			System.out.println("No se ha encontrado una habitacion con ese numero");
		}
	}
	public static void mostrarHabitacionesSinReserva(ArrayList<Habitacion> habitaciones,ArrayList<Reserva> reservas){
		System.out.println("Tipos de habitacion a reservar");
		System.out.println("1.Individual");
		System.out.println("2.Doble");
		System.out.println("3.Familiar");
		System.out.println("4.Suite");
		System.out.print("Elije: ");
		int opcion = Hotel.sc.nextInt();
		switch(opcion)
		{
			case 1:
				System.out.println("Has elegido Individual");
				break;
			case 2:
				System.out.println("Has elegido Doble");
				break;
			case 3:
				System.out.println("Has elegido Familiar");
				break;
			case 4:
				System.out.println("Has elegido Suite");
				break;
			default:
				System.out.println("Opcion no valida");
				return;
				
			
		}
	
		System.out.print("Dia de la fecha de inicio en el que quieres encontrar habitaciones sin reservar: ");
		int dia = Hotel.sc.nextInt();
		System.out.print("Mes de la fecha de inicio en el que quieres encontrar habitaciones sin reservar: ");
		int mes = Hotel.sc.nextInt();
		System.out.print("Anyo de la fecha de inicio en el que quieres encontrar habitaciones sin reservar: ");
		int anyo = Hotel.sc.nextInt();
		
		String fechaInicio = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anyo);
		
		System.out.print("Dia de la fecha de fin en el que quieres encontrar habitaciones sin reservar: ");
		int dia1 = Hotel.sc.nextInt();
		System.out.print("Mes de la fecha de fin en el que quieres encontrar habitaciones sin reservar: ");
		int mes1 = Hotel.sc.nextInt();
		System.out.print("Anyo de la fecha de fin en el que quieres encontrar habitaciones sin reservar: ");
		int anyo1 = Hotel.sc.nextInt();
		
		String fechaFin = Integer.toString(dia1)+"/"+Integer.toString(mes1)+"/"+Integer.toString(anyo1);
		Date fechaOut = null;
		Date fechaIn = null;
		try {
			fechaIn = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
			fechaOut = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("");
		for(int i=0;i<habitaciones.size();i++)
		{
			if(opcion==1 && habitaciones.get(i).getClass().getSimpleName().equals("Individual"))
			{
				Individual indv=new Individual();
				indv=(Individual) habitaciones.get(i);
				if(indv.estaOcupada(fechaIn, fechaOut, reservas,indv.getCod_hab()))
				{
					indv.muestraDatos();
				}
			}
			if(opcion==2 && habitaciones.get(i).getClass().getSimpleName().equals("Doble"))
			{
				Doble dob=new Doble();
				dob=(Doble) habitaciones.get(i);
				if(dob.estaOcupada(fechaIn, fechaOut, reservas,dob.getCod_hab()))
				{
					dob.muestraDatos();
				}
			}
			if(opcion==3 && habitaciones.get(i).getClass().getSimpleName().equals("Familiar"))
			{
				Familiar fam=new Familiar();
				fam=(Familiar) habitaciones.get(i);
				if(fam.estaOcupada(fechaIn, fechaOut, reservas,fam.getCod_hab()))
				{
					fam.muestraDatos();
				}
			}
			if(opcion==4 && habitaciones.get(i).getClass().getSimpleName().equals("Suite"))
			{
				Suite suit=new Suite();
				suit=(Suite) habitaciones.get(i);
				if(suit.estaOcupada(fechaIn, fechaOut, reservas,suit.getCod_hab()))
				{
					suit.muestraDatos();
				}
			}
			
		}
	}
}
