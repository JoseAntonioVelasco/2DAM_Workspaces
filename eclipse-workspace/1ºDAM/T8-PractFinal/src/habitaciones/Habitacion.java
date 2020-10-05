package habitaciones;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import cargarGuardarDatos.Guardar;
import hotel.Hotel;
import reserva.Reserva;

public class Habitacion {
	//atributos
	private int num_habitacion;
	private Double precio_dia;
	private int piso;
	private int cod_hab;
	//constructor
	public Habitacion(int piso,int num_habitacion,Double precio_dia){
		this.num_habitacion=num_habitacion;
		this.precio_dia=precio_dia;
		this.piso=piso;
		this.cod_hab=(piso*100)+num_habitacion;
	}
	public Habitacion() {
		//pedirDatos();
	}
	//metodos
	
	public int getPiso() {
		return piso;
	}

	public boolean setPiso(int piso) {
		if(piso<=0) {
			System.out.println("El piso no puede ser menor o igual a 0");
			return false;
		}
		this.piso = piso;
		return true;
	}
	public int getNum_habitacion() {
		return num_habitacion;
	}
	public boolean setNum_habitacion(int num_habitacion) {
		if(num_habitacion<=0)
		{
			System.out.println("El numero no puede ser menor o igual a 0");
			return false;
		}
		this.num_habitacion = num_habitacion;
		return true;
	}

	public Double getPrecio_dia() {
		return precio_dia;
	}

	public void setPrecio_dia(double precio_dia) {
		if(precio_dia<=0)
		{
			System.out.println("El precio no puede ser menor o igual a 0");
			return;
		}
		this.precio_dia = precio_dia;
	}
	
	public void setCod_hab(int cod_hab) {
		this.cod_hab = cod_hab;
	}
	public int getCod_hab() {
		return cod_hab;
	}
	//metodos aparte
	public boolean pedirDatos(ArrayList<Habitacion> habitaciones){
		System.out.print("Numero de habitacion: ");
		int num_habitacion=Hotel.sc.nextInt();
		if(setNum_habitacion(num_habitacion)==false)
		{
			
			return false;
		}
		System.out.print("En que piso se encuentra: ");
		int piso=Hotel.sc.nextInt();
		if(setPiso(piso)==false)
		{
			
			return false;
		}
		
		this.cod_hab=(piso*100)+num_habitacion;
		if(existe(habitaciones,this.cod_hab))
		{
			System.out.println("Ya existe una habitacion con ese numero");
			return false;
		}
		System.out.print("Precio por dia: ");
		this.precio_dia=Hotel.sc.nextDouble();
		return true;
	}
	public void muestraDatos(){
		System.out.println("Numero de habitacion: "+this.cod_hab);
		System.out.println("Precio por dia: "+this.precio_dia);
	}
	public void guardarDatos(){
		try {
			Guardar.fileWriter.write(getClass().getSimpleName()+";");
			Guardar.fileWriter.write(getNum_habitacion()+";"); 
			Guardar.fileWriter.write(getPiso()+";");
			Guardar.fileWriter.write(getPrecio_dia().toString()+";");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public boolean estaOcupada(Date fechIn,Date fechOut,ArrayList<Reserva> reservas, int cod_hab)
	{
		//Con esto consigo dos arraylist con las fechas de IN y OUT de todo
		ArrayList<Date> FechIn = new ArrayList<Date>();
		ArrayList<Date> FechOut = new ArrayList<Date>();

		for(int i=0;i<reservas.size();i++)
		{
			if(cod_hab==reservas.get(i).getCod_hab())
			{
				try {
					Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(reservas.get(i).getFechInic());
					FechIn.add(fecha);
					fecha = new SimpleDateFormat("dd/MM/yyyy").parse(reservas.get(i).getFechFin());
					FechOut.add(fecha);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//Con esto consigo comprobar que no hay colisiones entre rangos de fechas
		for(int i=0;i<FechIn.size();i++)
		{
			if((fechIn.compareTo(FechOut.get(i))<=0 && fechOut.compareTo(FechIn.get(i))>=0))
			{
				return true;
			}
		}
		return false;
	}
	public boolean existe(ArrayList<Habitacion> habitaciones,int cod_hab) {
		boolean hab_encontrada=false;
		
		while(hab_encontrada==false)
		{
			for(int i=0;i<habitaciones.size();i++)
			{
				if(habitaciones.get(i).getCod_hab()==cod_hab)
				{
					return true;
				}
			}
			
			if(hab_encontrada==false)
			{
				return false;
			}
		}
		return false;
	}
	
}
