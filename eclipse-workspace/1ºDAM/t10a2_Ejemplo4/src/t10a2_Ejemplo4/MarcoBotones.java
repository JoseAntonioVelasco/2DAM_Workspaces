package t10a2_Ejemplo4;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MarcoBotones extends JPanel{
	ArrayList<JButton> botonera;
	
	MarcoBotones(){
		botonera = new ArrayList<JButton>();
		//se van poniendo los botones al panel
		for(int i=0; i<7; i++) {
			botonera.add(new JButton("Boton"+i));
			this.add(botonera.get(i));
		}
	}
}
