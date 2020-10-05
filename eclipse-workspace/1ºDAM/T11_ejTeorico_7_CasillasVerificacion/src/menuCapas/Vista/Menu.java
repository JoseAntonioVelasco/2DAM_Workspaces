package menuCapas.Vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Menu extends JPanel{
	private ArrayList<Primeros> platos =new ArrayList<Primeros>(); 
	
	public Menu() {
		Primeros p1 = new Primeros("Primeros","Ensalada mixta","Sopa","Crema de verduras",5.0,3.0,6.0);
		Primeros p2 = new Primeros("Segundos","Pescado a la plancha","Filete empanado","Chuleton a la plancha",6.0,9.0,12.0);
		Primeros p3 = new Primeros("Postre","Flan","Helado","Fruta",3.0,4.5,5.25);
		
		
		platos.add(p1);platos.add(p2);platos.add(p3);
		
		this.setLayout(new GridLayout(1,3));
		this.add(p1); this.add(p2); this.add(p3);
	}
	
	
	public String getStrPlatosSeleccionados() {
		
		String platos_seleccionados = "";
		for(Primeros p : this.platos) {
		
			String boton_seleccionado=p.getStrSeleccionado();
			platos_seleccionados=platos_seleccionados.concat(boton_seleccionado).concat("<br>");
			
		}
		//platos_seleccionados=platos_seleccionados.concat("TOTAL: "+this.sumaPrecio()+"<br>");
		return platos_seleccionados;
		
	}
	
	public Double sumaPrecio() {
		
		Double precio_total = 0.0;
		for(Primeros p : this.platos) {
	
			Double precio_unitario = p.getSeleccionadoPrecio();
			precio_total += precio_unitario;
			
		}
		return precio_total;
	}
}
