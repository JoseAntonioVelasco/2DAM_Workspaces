package menuCapas.Vista;

import javax.swing.JRadioButton;

public class JRadioButtonPrecio extends JRadioButton{
	
	private Double precio;

	public JRadioButtonPrecio(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
