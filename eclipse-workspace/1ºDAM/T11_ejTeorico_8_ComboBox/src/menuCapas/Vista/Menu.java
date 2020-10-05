package menuCapas.Vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Menu extends JPanel{
	private ArrayList<Primeros> platos =new ArrayList<Primeros>(); 
	
	public Menu() {
		this.setBorder(new TitledBorder("Menu"));
		JLabel prim = new JLabel("PRIMEROS");
		JLabel segun = new JLabel("SEGUNDOS");
		JLabel post= new JLabel("POSTRES");
		
		Plato p1 = new Plato("Ensalada mixta(5.0€)",5.0); Plato p2 = new Plato("Sopa(3.0€)",3.0); Plato p3 = new Plato("Crema de verduras(6.0€)",6.0);
		Plato s1 = new Plato("Pescado a la plancha(6.0€)",6.0); Plato s2 = new Plato("Filete empanado(6.0€)",6.0); Plato s3 = new Plato("Chuleton a la plancha(12.0€)", 12.0);
		Plato t1 = new Plato("Flan(3.0€)",3.0); Plato t2 = new Plato("Helado(4.5€)",4.5); Plato t3 = new Plato("Fruta(5.25€)",5.25);
		
		Primeros prims = new Primeros(p1,p2,p3);
		Primeros seguns = new Primeros(s1,s2,s3);
		Primeros posts = new Primeros(t1,t2,t3);
		
		platos.add(prims);platos.add(seguns);platos.add(posts);
		
		this.setLayout(new GridLayout(3,2));
		this.add(prim); this.add(prims);
		this.add(segun); this.add(seguns);
		this.add(post); this.add(posts);
	}
	
	
	public String getStrPlatosSeleccionados() {
		
		String platos_seleccionados = "";
		for(Primeros p : this.platos) {
			Plato plat = (Plato) p.getSelectedItem();
			String boton_seleccionado=plat.getNombre();
			platos_seleccionados=platos_seleccionados.concat(boton_seleccionado).concat("<br>");
			
		}
		//platos_seleccionados=platos_seleccionados.concat("TOTAL: "+this.sumaPrecio()+"<br>");
		return platos_seleccionados;
		
	}
	
	public Double sumaPrecio() {
		
		Double precio_total = 0.0;
		for(Primeros p : this.platos) {
			Plato plat = (Plato) p.getSelectedItem();
			Double precio_unitario = plat.getPrecio();
			precio_total += precio_unitario;
			
		}
		return precio_total;
	}
}
