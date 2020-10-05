package hotel;



import java.util.ArrayList;
import java.util.Scanner;

import cargarGuardarDatos.Cargar;
import cargarGuardarDatos.Guardar;
import gestionHotel.*;
import habitaciones.*;
import reserva.Reserva;

public class Hotel {
	public static  Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Reserva> reservas = new ArrayList<Reserva>(Cargar.cargarReservas());
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>(Cargar.cargarHabitaciones());
		Hotel.sc=new Scanner(System.in);
	try {
		boolean entrar1=true;
		while(entrar1)
		{
			System.out.println("-----Hotel NombreHotel-----");
			System.out.println("");
			System.out.println("1.Gestion de Habitaciones");
			System.out.println("2.Gestion de Reservas");
			System.out.println("3.Salir");
			System.out.println("");
			System.out.print("Elija opcion: ");
			int opcion = Hotel.sc.nextInt();
			switch(opcion)
			{
				case 1:
					boolean entrar=true;
					int opcion1;
					while(entrar) 
					{
						System.out.println("");
						System.out.println("---Gestion de Habitaciones---");
						System.out.println("1.Obtener listado de habitaciones");
						System.out.println("2.Obtener informacion de una habitacion");
						System.out.println("3.Modificar una habitacion");
						System.out.println("4.Anadir una habitacion");
						System.out.println("5.Eliminar una habitacion");
						System.out.println("6.Mostrar habitaciones no reservadas");
						System.out.println("7.Volver");
						System.out.println("");
						System.out.print("Elija opcion: ");
						opcion1 =Hotel.sc.nextInt();
						switch(opcion1)
						{
							case 1:
								GestionHabitaciones.muestraHabitaciones(habitaciones);
								break;
							case 2:
								GestionHabitaciones.obtenerInfoHabitacion(habitaciones);
								break;
							case 3:
								GestionHabitaciones.modificarHabitacion(habitaciones);
								break;
							case 4:
								GestionHabitaciones.anadirHabitacion(habitaciones);
								break;
							case 5:
								GestionHabitaciones.eliminarHabitacion(habitaciones);
								break;
							case 6:
								GestionHabitaciones.mostrarHabitacionesSinReserva(habitaciones, reservas);
								break;
							case 7:
								entrar=false;
								break;
							default:
								System.out.println("Error");
								return;
						}
					}
					break;
				case 2:
					entrar=true;
					while(entrar)
					{
						System.out.println("---Gestion de Reservas---");
						System.out.println("1.Obtener listado de reservas");
						System.out.println("2.Obtener informacion de una reserva");
						System.out.println("3.Anadir una reserva");
						System.out.println("4.Eliminar una reserva");
						System.out.println("5.Modifica una reserva");
						System.out.println("6.Generar factura");
						System.out.println("7.Volver");
						System.out.print("Elija opcion: ");
						int opcion2 = Hotel.sc.nextInt();
						switch(opcion2)
						{
							case 1:
								GestionReservas.muestraReservas(reservas);
								break;
							case 2:
								GestionReservas.muestraInfoReserva(reservas);
								break;
							case 3:
								GestionReservas.anadirReserva(reservas,habitaciones);
								break;
							case 4:
								GestionReservas.eliminarReserva(reservas);
							case 5:
								GestionReservas.modificarReserva(reservas,habitaciones);
								break;
							case 6:
								GestionReservas.generaFactura(reservas,habitaciones);
								break;
							case 7:
								entrar=false;
								break;
							default:
								System.out.println("Error");
								return;
						}
					}
					break;
				case 3:
					return;
				default:
					System.out.println("Error");
					return;
			}
		
		}
		
	}finally {
		//guardar todos los datos en los ficheros
		Guardar.guardarHabitaciones(habitaciones);
		Guardar.guardarReservas(reservas);
		Hotel.sc.close();
	}
	}
	
}
