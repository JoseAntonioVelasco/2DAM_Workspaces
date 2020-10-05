package habitaciones;

import java.io.IOException;
import java.util.ArrayList;

import cargarGuardarDatos.Guardar;
import hotel.Hotel;

public class Doble extends Habitacion{
	
	//atributos
	private boolean comparte_banyo;
	
	//constructor
	public Doble(int piso,int num_habitacion, double precio_dia,boolean comparte_banyo) {
		super(piso ,num_habitacion, precio_dia);
		this.comparte_banyo=comparte_banyo;
		// TODO Auto-generated constructor stub
	}
	
	public Doble() {
		// TODO Auto-generated constructor stub
		
	}

	//metodos
	public boolean isComparte_banyo() {
		return comparte_banyo;
	}
	public void setComparte_banyo(boolean comparte_banyo) {
		this.comparte_banyo = comparte_banyo;
	}
	@Override
	public boolean pedirDatos(ArrayList<Habitacion> habitaciones) {
		super.pedirDatos(habitaciones);
		System.out.print("Comparte banyo (si/no): ");
		String respuesta=Hotel.sc.next();
		if(respuesta.equalsIgnoreCase("si"))
		{
			this.comparte_banyo=true;
		}
		else if(respuesta.equalsIgnoreCase("no"))
		{
			this.comparte_banyo=false;
		}
		return true;
		
	}
	@Override
	public void muestraDatos() {
		super.muestraDatos();
		if(this.comparte_banyo)
		{
			System.out.println("La habitacion comparte banyo");
		}
		else if(this.comparte_banyo==false)
		{
			System.out.println("La habitacion no comparte banyo");
		}
	}
	@Override
	public void guardarDatos() {
		super.guardarDatos();
		try {
			Guardar.fileWriter.write(isComparte_banyo()+";"); 
			Guardar.fileWriter.write("\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
