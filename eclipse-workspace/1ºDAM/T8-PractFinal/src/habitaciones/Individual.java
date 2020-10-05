package habitaciones;

import java.io.IOException;

import cargarGuardarDatos.Guardar;

public class Individual extends Habitacion{
	//atributos
	//constructor 
	public Individual(int piso ,int num_habitacion, double precio_dia) {
		super(piso ,num_habitacion, precio_dia);
		// TODO Auto-generated constructor stub
	}
	//metodos

	public Individual() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void guardarDatos() {
		super.guardarDatos();
		try {
			Guardar.fileWriter.write("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
