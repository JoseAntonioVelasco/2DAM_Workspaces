package cargarGuardarDatos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import habitaciones.*;
import reserva.Reserva;

public class Guardar {
	public static FileWriter fileWriter;
	public static void guardarHabitaciones(ArrayList<Habitacion> habitaciones) {
		try {
			Guardar.fileWriter = new FileWriter("habitaciones.csv");
			for(int i=0;i<habitaciones.size();i++)
			{
				if(habitaciones.get(i).getClass().getSimpleName().equals("Individual")) 
				{
					Individual indv = new Individual();
					indv=(Individual) habitaciones.get(i);
					indv.guardarDatos();
					
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Doble"))
				{
					Doble dob = new Doble();
					dob=(Doble) habitaciones.get(i);
					dob.guardarDatos();
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Familiar"))
				{
					Familiar fam = new Familiar();
					fam=(Familiar) habitaciones.get(i);
					fam.guardarDatos();
				}
				else if(habitaciones.get(i).getClass().getSimpleName().equals("Suite"))
				{
					Suite suit = new Suite();
					suit=(Suite) habitaciones.get(i);
					suit.guardarDatos();
				}
			}
			Guardar.fileWriter.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void guardarReservas(ArrayList<Reserva> reservas) {
		try {
			Guardar.fileWriter= new FileWriter("reservas.csv");
			for(int i=0;i<reservas.size();i++)
			{
				Reserva resv = new Reserva();
				resv=reservas.get(i);
				resv.guardarDatos();
			}
			Guardar.fileWriter.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
