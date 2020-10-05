package menuCapas.Vista;

import java.awt.GridLayout;
import java.util.ArrayList;


import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



public class MarcoVarios extends JPanel{
	
	//public static final float PAN=1.0F;
	//public static final float AGUA=1.5F;
	//public static final float VINO=8.0F;
	//public static final float REFRESCOS=2.5F;
	private ArrayList<JCheckBoxPrecio> checkboxes; 
	
	public MarcoVarios(String nombre1,String nombre2,String nombre3,String nombre4,
			Double precio1,Double precio2, Double precio3, Double precio4){
		this.setBorder(new TitledBorder("Varios"));
		JCheckBoxPrecio c1,c2,c3,c4;
		c1 = new JCheckBoxPrecio(""+nombre1+" ("+precio1+" Euros) ");
		c1.setPrecio(precio1);
		c2 = new JCheckBoxPrecio(""+nombre2+" ("+precio2+" Euros) ");
		c2.setPrecio(precio2);
		c3 = new JCheckBoxPrecio(""+nombre3+" ("+precio3+" Euros) ");
		c3.setPrecio(precio3);
		c4 = new JCheckBoxPrecio(""+nombre4+" ("+precio4+" Euros) ");
		c4.setPrecio(precio4);
		
		this.checkboxes=new ArrayList<JCheckBoxPrecio>();
		
		this.checkboxes.add(c1);
		this.checkboxes.add(c2);
		this.checkboxes.add(c3);
		this.checkboxes.add(c4);
		
		this.setLayout(new GridLayout(2,2));
		for(JCheckBoxPrecio cb : this.checkboxes) {
			this.add(cb);
		}		
	}
	
	public String strCheckSeleccionados() {
		String seleccionados="";
		for(JCheckBoxPrecio checkbox : this.checkboxes) {
			if(checkbox.isSelected()) {
				seleccionados = seleccionados.concat(checkbox.getText());
			}
		}
		return seleccionados;
	}
	public Double sumaCheckSeleccionados() {
		Double precio_total=0.0;
		for(JCheckBoxPrecio checkbox : this.checkboxes) {
			if(checkbox.isSelected()) {
				Double precio_unitario = checkbox.getPrecio();
				precio_total += precio_unitario;
			}
		}
		return precio_total;
	}
	
	
}
