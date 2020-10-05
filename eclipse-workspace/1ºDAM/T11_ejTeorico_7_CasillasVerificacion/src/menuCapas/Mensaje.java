package menuCapas;



import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import menuCapas.Controlador.GestorAceptar;

public class Mensaje extends JDialog{
	
	public Mensaje(String mensaje) {
		
		JLabel mensa = new JLabel(mensaje);
		JButton aceptar = new JButton("aceptar");
		aceptar.addActionListener(new GestorAceptar(this));
	
		this.setLayout(new FlowLayout());
		this.add(mensa);this.add(aceptar);
		
		
		this.pack();
	}

}
