package cargarGuardarDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import habitaciones.*;
import reserva.Reserva;


public class Cargar {
	private static FileReader fileReader;
	private static BufferedReader readCsv;
	public static ArrayList<Habitacion> cargarHabitaciones() {
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		try {
			fileReader=new FileReader("habitaciones.csv");
			readCsv = new BufferedReader(fileReader);
			String row;
			try {
				while ((row = readCsv.readLine()) != null) {
				    String[] data = row.split(";");
				    //Creo que no se puede hacer un metodo de herencia para 
				    //cargar datos asi que me toca repetir un poco de codigo
				    //supuesta razon: necesito que la herencia una vez retorne 
				    //tipo de dato "Individual","Doble","Familiar"o"Suite" y eso
				    //no lo puedo cambiar
				    if(data[0].equals("Individual")) {
						int num_hab=Integer.parseInt(data[1]);
						int piso=Integer.parseInt(data[2]);
						Double precio_dia=Double.parseDouble(data[3]);
						Individual indv = new Individual(num_hab,piso,precio_dia);
						habitaciones.add(indv);
				    }
				    else if(data[0].equals("Doble")) {
				    	int num_hab=Integer.parseInt(data[1]);
						int piso=Integer.parseInt(data[2]);
						Double precio_dia=Double.parseDouble(data[3]);
						Boolean comparte_banyo=Boolean.parseBoolean(data[4]);
						Doble dob = new Doble(num_hab,piso,precio_dia,comparte_banyo);
						habitaciones.add(dob);
				    }
				    else if(data[0].equals("Familiar")) {
				    	int num_hab=Integer.parseInt(data[1]);
						int piso=Integer.parseInt(data[2]);
						Double precio_dia=Double.parseDouble(data[3]);
						Boolean camas_supletorias=Boolean.parseBoolean(data[4]);
						Familiar fam = new Familiar(num_hab,piso,precio_dia,camas_supletorias);
						habitaciones.add(fam);
				    }
				    else if(data[0].equals("Suite")) {
				    	int num_hab=Integer.parseInt(data[1]);
						int piso=Integer.parseInt(data[2]);
						Double precio_dia=Double.parseDouble(data[3]);
						Boolean camas_supletorias=Boolean.parseBoolean(data[4]);
						Suite suit = new Suite(num_hab,piso,precio_dia,camas_supletorias);
						habitaciones.add(suit);
				    }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return habitaciones;
	}
	public static ArrayList<Reserva> cargarReservas() {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		try {
			fileReader=new FileReader("reservas.csv");
			readCsv = new BufferedReader(fileReader);
			String row;
			
			try {
				while ((row = readCsv.readLine()) != null) {
					   String[] data = row.split(";");
					   //String cod_reserva=data[0]; se calcula insitu
					   int cod_hab=Integer.parseInt(data[0]);
					   String dni=data[1];
					   String fechInic=data[2];
					   String fechFin=data[3];
					   boolean pendiente_cobro=Boolean.parseBoolean(data[4]);
					   Reserva resv=new Reserva(fechInic, fechFin, dni, pendiente_cobro, cod_hab);
					   reservas.add(resv);
				}
			}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservas;
	}

}
