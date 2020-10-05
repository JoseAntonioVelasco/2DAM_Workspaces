package menuCapas.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuCapas.Mensaje;

public class GestorAceptar implements ActionListener{
	private Mensaje mens;
	public GestorAceptar(Mensaje mens) {
		this.mens=mens;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.mens.dispose();
	}
}
