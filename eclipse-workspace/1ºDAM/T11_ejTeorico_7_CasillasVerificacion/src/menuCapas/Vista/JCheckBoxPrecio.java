package menuCapas.Vista;

import javax.swing.JCheckBox;

public class JCheckBoxPrecio extends JCheckBox{
	private Double precio;
	
	public JCheckBoxPrecio(String string) {
		super(string);
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
