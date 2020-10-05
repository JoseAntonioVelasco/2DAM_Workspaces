package menuCapas.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuCapas.Vista;
import menuCapas.vista.Alta;

public class GestorAlta implements ActionListener{
	private Vista v;
	public GestorAlta(Vista v) {this.v=v;}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Alta p2 = new Alta(v);
		this.v.getC().add("pAlta",p2);
		((CardLayout)this.v.getC().getLayout()).show(this.v.getC(),"pAlta");
	}

	public Vista getV() {return v;}
	public void setV(Vista v) {this.v = v;}
	
}
