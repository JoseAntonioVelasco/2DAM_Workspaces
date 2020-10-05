package gestionHotel;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import habitaciones.Habitacion;
import hotel.Hotel;
import reserva.Reserva;

public class GestionReservas {
	public static void muestraReservas(ArrayList<Reserva> reservas){
		for(int i=0;i<reservas.size();i++)
		{
			reservas.get(i).muestraDatos();
			System.out.println("");
		}
	}
	public static void muestraInfoReserva(ArrayList<Reserva> reservas){
		System.out.println("--Mostrar informacion Reserva--");
		System.out.print("Dia de la fecha de inicio: ");
		int dia=Hotel.sc.nextInt();
		System.out.print("Mes de la fecha de inicio: ");
		int mes=Hotel.sc.nextInt();
		System.out.print("Anyo de la fecha de inicio: ");
		int anyo=Hotel.sc.nextInt();
		
		System.out.print("Numero de habitacion: ");
		int cod_hab=Hotel.sc.nextInt();
		
		String fechInic = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anyo);
		for(int i=0;i<reservas.size();i++)
		{
			if(reservas.get(i).getFechInic().equals(fechInic)&&reservas.get(i).getCod_hab()==cod_hab)
			{
				reservas.get(i).muestraDatos();
			}
		}
		
	}
	public static void anadirReserva(ArrayList<Reserva> reservas, ArrayList<Habitacion> habitaciones){
		Reserva resv=new Reserva();
		resv.pedirDatos(reservas, habitaciones);
		reservas.add(resv);
	}
	public static void eliminarReserva(ArrayList<Reserva> reservas){
		System.out.println("--Eliminar Reserva--");
		System.out.print("Dia de la fecha de inicio: ");
		int dia=Hotel.sc.nextInt();
		System.out.print("Mes de la fecha de inicio: ");
		int mes=Hotel.sc.nextInt();
		System.out.print("Anyo de la fecha de inicio: ");
		int anyo=Hotel.sc.nextInt();
		
		System.out.print("Numero de habitacion: ");
		int cod_hab=Hotel.sc.nextInt();
		
		String fechInic = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anyo);
		for(int i=0;i<reservas.size();i++)
		{
			if(reservas.get(i).getFechInic().equals(fechInic)&&reservas.get(i).getCod_hab()==cod_hab)
			{
				reservas.remove(i);
			}
		}
		
	}
	public static void modificarReserva(ArrayList<Reserva> reservas,ArrayList<Habitacion> habitaciones){
		System.out.println("--Mostrar informacion Reserva--");
		System.out.print("Dia de la fecha de inicio: ");
		int dia=Hotel.sc.nextInt();
		System.out.print("Mes de la fecha de inicio: ");
		int mes=Hotel.sc.nextInt();
		System.out.print("Anyo de la fecha de inicio: ");
		int anyo=Hotel.sc.nextInt();
		
		System.out.print("Numero de habitacion: ");
		int cod_hab=Hotel.sc.nextInt();
		
		String fechInic = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anyo);
		for(int i=0;i<reservas.size();i++)
		{
			if(reservas.get(i).getFechInic().equals(fechInic)&&reservas.get(i).getCod_hab()==cod_hab)
			{
				reservas.get(i).pedirDatos(reservas, habitaciones);
			}
		}
		
	}
	public static void generaFactura(ArrayList<Reserva> reservas,ArrayList<Habitacion> habitaciones){
		System.out.println("DNI del cliente a generar factura: ");
		String dni =Hotel.sc.next();
		
		for(int i=0;i<reservas.size();i++)
		{
			if(dni.equals(reservas.get(i).getDni()) && reservas.get(i).isPendiente_cobro()==false)
			{
				//generar factura
				System.out.println("Tipo de habitacion: "+reservas.get(i).tipoHabitacion(habitaciones));
				Date fechaIn = null;
				Date fechaOut = null;
				try {
					fechaIn = new SimpleDateFormat("dd/MM/yyyy").parse(reservas.get(i).getFechInic());
					fechaOut = new SimpleDateFormat("dd/MM/yyyy").parse(reservas.get(i).getFechFin());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Error al parsear fechas");
				}
				int ms=(int) (fechaOut.getTime()-fechaIn.getTime());
				int ndias=((((ms/1000)/60)/60)/24);
				System.out.println("Numero de dias: "+ndias);
				System.out.println("Coste total: "+ndias*reservas.get(i).precioDia(habitaciones));
			}
		}
	}
	

}
