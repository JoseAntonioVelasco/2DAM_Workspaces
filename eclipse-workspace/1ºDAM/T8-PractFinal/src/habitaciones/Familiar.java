package habitaciones;




import java.io.IOException;
import java.util.ArrayList;

import cargarGuardarDatos.Guardar;
import hotel.Hotel;

public class Familiar extends Habitacion{
	//atributos
	private boolean camas_supletorias;
	
	//constructor
	public Familiar(int piso,int num_habitacion, double precio_dia,boolean camas_supletorias) {
		super(piso ,num_habitacion, precio_dia);
		this.camas_supletorias=camas_supletorias;
		// TODO Auto-generated constructor stub
	}

	public Familiar() {
		// TODO Auto-generated constructor stub
	}

	public boolean isCamas_supletorias() {
		return camas_supletorias;
	}

	public void setCamas_supletorias(boolean camas_supletorias) {
		this.camas_supletorias = camas_supletorias;
	}
	
	//metodos
	@Override
	public boolean pedirDatos(ArrayList<Habitacion> habitaciones) {
		super.pedirDatos(habitaciones);
		System.out.print("Tiene camas supletorias (si/no): ");
		String respuesta=Hotel.sc.next();
		if(respuesta.equalsIgnoreCase("si"))
		{
			this.camas_supletorias=true;
		}
		else if(respuesta.equalsIgnoreCase("no"))
		{
			this.camas_supletorias=false;
		}
		return true;
		
	}
	@Override
	public void muestraDatos() {
		super.muestraDatos();
		if(this.camas_supletorias)
		{
			System.out.println("La habitacion tiene camas supletorias");
		}
		else if(this.camas_supletorias==false)
		{
			System.out.println("La habitacion no tiene camas supletorias");
		}
	}
	@Override
	public void guardarDatos() {
		super.guardarDatos();
		try {
			Guardar.fileWriter.write(isCamas_supletorias()+";"); 
			Guardar.fileWriter.write("\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}

