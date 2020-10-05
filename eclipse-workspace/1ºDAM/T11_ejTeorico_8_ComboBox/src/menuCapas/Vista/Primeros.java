package menuCapas.Vista;


import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class Primeros extends JComboBox<Plato>{
	//public static final float PRIMERPLATO1=5.0F;
	//public static final float PRIMERPLATO2=5.0F;
	//public static final float PRIMERPLATO3=5.0F;
	public Primeros(Plato plato1,Plato plato2,Plato plato3) {
		
		this.addItem(plato1);
		this.addItem(plato2);
		this.addItem(plato3);
		
	}
	//funcion para sacar el elemento seleccionado del grupo de botones
	/*
	public JRadioButtonPrecio getSeleccionado() {
		Enumeration<AbstractButton> botones=this.grupo1.getElements();
		while(botones.hasMoreElements()) {
			JRadioButtonPrecio boton=(JRadioButtonPrecio) botones.nextElement();
			if(boton.isSelected()) {
				return boton;
			}
		}
		return null;
	}
	
	public String getStrSeleccionado() {
		if(this.getSeleccionado()==null) {
			return this.orden.concat(": No hay nada seleccionado");
		}
		return this.orden.concat(": ").concat(this.getSeleccionado().getText());		
		
	}
	
	public Double getSeleccionadoPrecio() {
		if(this.getSeleccionado()==null) {
			return 0.0;
		}
		return this.getSeleccionado().getPrecio();
	}
	
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	*/
	
}
