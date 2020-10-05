package reserva;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cargarGuardarDatos.Guardar;
import habitaciones.Habitacion;
import hotel.Hotel;

public class Reserva {
	//atributos
	private String fechInic;
	private String fechFin;
	private String dni;
	private boolean pendiente_cobro;
	private int cod_hab;
	//private String cod_reserva;
	//constructor
	public Reserva(String fechInic,String fechFin, String dni, boolean pendiente_cobro,int cod_hab){
		this.fechInic=fechInic;
		this.fechFin=fechFin;
		this.dni=dni;
		this.pendiente_cobro=pendiente_cobro;
		this.cod_hab=cod_hab;
		//this.cod_reserva=fechInic+fechFin+cod_hab;
	}
	public Reserva() {
		
	}
	
	//metodos getters setters
	public String getFechInic() {
		return fechInic;
	}
	public void setFechInic(String fechInic) {
		this.fechInic = fechInic;
	}
	public String getFechFin() {
		return fechFin;
	}
	public void setFechFin(String fechFin) {
		this.fechFin = fechFin;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isPendiente_cobro() {
		return pendiente_cobro;
	}
	public void setPendiente_cobro(boolean pendiente_cobro) {
		this.pendiente_cobro = pendiente_cobro;
	}
	public int getCod_hab() {
		return cod_hab;
	}
	public void setCod_hab(int cod_hab) {
		this.cod_hab = cod_hab;
	}
	/*public String getCod_reserva() {
		return cod_reserva;
	}
	public void setCod_reserva(String cod_reserva) {
		this.cod_reserva = cod_reserva;
	}*/
	
	
	public void pedirDatos(ArrayList<Reserva> reservas,ArrayList<Habitacion> habitaciones) {
		System.out.print("Dni: ");
		this.dni=Hotel.sc.next();
		System.out.print("Numero de habitacion a reservar: ");
		this.cod_hab=Hotel.sc.nextInt();
		Habitacion hab = new Habitacion();
		if(!(hab.existe(habitaciones, this.cod_hab)))
		{
			System.out.println("No existe esa habitacion");
			System.out.println("volviendo...");
			return;
		}
		
		System.out.print("Dia en el que se inicia la reserva: ");
		int dia = Hotel.sc.nextInt();
		System.out.print("Mes en el que se inicia la reserva: ");
		int mes = Hotel.sc.nextInt();
		System.out.print("Anyo en el que se inicia la reserva: ");
		int anyo = Hotel.sc.nextInt();
		
		System.out.print("Dia en el que se finaliza la reserva: ");
		int dia1 = Hotel.sc.nextInt();
		System.out.print("Mes en el que se finaliza la reserva: ");
		int mes1 = Hotel.sc.nextInt();
		System.out.print("Anyo en el que se finaliza la reserva: ");
		int anyo1 = Hotel.sc.nextInt();
		
		Date fechaIn =null;
		Date fechaOut = null;
		this.fechFin = Integer.toString(dia1)+"/"+Integer.toString(mes1)+"/"+Integer.toString(anyo1);
		this.fechInic = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anyo);
		try {
			fechaIn = new SimpleDateFormat("dd/MM/yyyy").parse(this.fechInic);
			fechaOut = new SimpleDateFormat("dd/MM/yyyy").parse(this.fechFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al crear fechas");
		}
		if(fechaOut.before(fechaIn))
		{
			System.out.println("La fecha de finalizacion no puede ser antes de la fecha inicio");
			System.out.println("Volviendo...");
			return;
		}

		
		if(hab.estaOcupada(fechaIn, fechaOut, reservas, this.cod_hab))
		{
			System.out.println("La habitacion esta ocupada durante esas fechas");
			System.out.println("Volviendo...");
			return;
		}
		System.out.print("Pendiente de cobro (si/no): ");
		String respuesta=Hotel.sc.next();
		if(respuesta.equals("si"))
		{
			this.pendiente_cobro=true;
		}
		else if(respuesta.equals("no"))
		{
			this.pendiente_cobro=false;
		}
	}
	public void muestraDatos() {
		//System.out.println("Codigo de reserva: "+getCod_reserva());
		System.out.println("Codigo de habitacion: "+getCod_hab());
		System.out.println("DNI de reserva: "+getDni());
		System.out.println("Fecha de Inicio: "+getFechInic());
		System.out.println("Fecha de Fin: "+getFechFin());
		if(isPendiente_cobro())
		{
			System.out.println("Pendiente de cobro: si");
		}
		else if(isPendiente_cobro()==false)
		{
			System.out.println("Pendiente de cobro: no");
		}
		
	}
	public void guardarDatos() {
		try {
			//Guardar.fileWriter.write(getCod_reserva()+";"); 
			Guardar.fileWriter.write(getCod_hab()+";");
			Guardar.fileWriter.write(getDni()+";");
			Guardar.fileWriter.write(getFechInic()+";");
			Guardar.fileWriter.write(getFechFin()+";");
			Guardar.fileWriter.write(isPendiente_cobro()+";");
			Guardar.fileWriter.write("\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public String tipoHabitacion(ArrayList<Habitacion> habitaciones) {
		for(int i=0;i<habitaciones.size();i++)
		{
			if(habitaciones.get(i).getCod_hab()==this.cod_hab)
			{
				if(habitaciones.get(i).getClass().getSimpleName().equals("Individual"))
				{
					return "Individual";
				}
				if(habitaciones.get(i).getClass().getSimpleName().equals("Doble"))
				{
					return "Doble";
				}
				if(habitaciones.get(i).getClass().getSimpleName().equals("Familiar"))
				{
					return "Familiar";
				}
				if(habitaciones.get(i).getClass().getSimpleName().equals("Suite"))
				{
					return "Suite";
				}
			}
		}
		return "nada";	
	}
	public Double precioDia(ArrayList<Habitacion> habitaciones)
	{
		for(int i=0;i<habitaciones.size();i++)
		{
			if(habitaciones.get(i).getCod_hab()==this.cod_hab)
			{
				return habitaciones.get(i).getPrecio_dia();
			}
		}
		return null;
		
	}
	

}
