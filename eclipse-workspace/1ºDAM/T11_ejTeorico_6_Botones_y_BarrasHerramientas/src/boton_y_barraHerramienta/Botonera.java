package boton_y_barraHerramienta;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class Botonera extends JToolBar{
	private JButton b1,b2,b3,b4;
	private JLabel jl;
	
	public Botonera(JLabel jl) {
		this.jl=jl;
		
		b1 = new JButton("Boton 1"); b2 = new JButton("Boton 2");
		b3 = new JButton("Boton 3"); b4 = new JButton("Boton 4");
		
		b1.addActionListener(new GestorMenu(jl, b1.getText()));
		b2.addActionListener(new GestorMenu(jl, b2.getText()));
		b3.addActionListener(new GestorMenu(jl, b3.getText()));
		b4.addActionListener(new GestorMenu(jl, b4.getText()));
		
		this.add(b1); this.add(b2);
		this.add(b3); this.add(b4);
	}

}
