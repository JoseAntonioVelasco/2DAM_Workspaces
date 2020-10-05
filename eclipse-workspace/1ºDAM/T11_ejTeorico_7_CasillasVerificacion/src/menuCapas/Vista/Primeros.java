package menuCapas.Vista;

import java.awt.GridLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Primeros extends JPanel{
	//public static final float PRIMERPLATO1=5.0F;
	//public static final float PRIMERPLATO2=5.0F;
	//public static final float PRIMERPLATO3=5.0F;
	private String orden;
	private ButtonGroup grupo1;
	private JRadioButtonPrecio r1,r2,r3;
	
	public Primeros(String orden,String plato1,String plato2, String plato3,Double precio1,Double precio2,Double precio3) {
		this.setBorder(new TitledBorder(orden));
		this.orden = orden;
		grupo1=new ButtonGroup();
		
		r1= new JRadioButtonPrecio(""+plato1+" ("+precio1+"€)");
		r1.setPrecio(precio1);
		r2= new JRadioButtonPrecio(""+plato2+" ("+precio2+"€)");
		r2.setPrecio(precio2);
		r3= new JRadioButtonPrecio(""+plato3+" ("+precio3+"€)");
		r3.setPrecio(precio3);
		
		grupo1.add(r1); grupo1.add(r2); grupo1.add(r3);
		
		this.setLayout(new GridLayout(3,1));
		this.add(r1); this.add(r2); this.add(r3);
		
	}
	//funcion para sacar el elemento seleccionado del grupo de botones
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
	
}
