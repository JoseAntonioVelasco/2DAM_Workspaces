package menuCapas.Vista;

import javax.swing.JButton;
import javax.swing.JPanel;

import menuCapas.Controlador.GestorCalcular;

public class Seleccionado extends JPanel{
	private JButton calc;
	
	public Seleccionado(Menu menu,MarcoVarios varios) {
		calc= new JButton("Calcular");
		calc.addActionListener(new GestorCalcular(menu,varios));
		this.add(calc);
	}
}
