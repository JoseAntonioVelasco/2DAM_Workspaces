package boton_y_barraHerramienta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class GestorMenu implements ActionListener{
	private JLabel jl;
	private String s;
	
	public GestorMenu(JLabel jl,String s) {
		this.jl=jl;
		this.s=s;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.jl.setText(s);
	}
}
