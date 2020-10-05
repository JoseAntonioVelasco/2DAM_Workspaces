package menuCapas.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuCapas.Vista;
import menuCapas.vista.Articulo;

public class GestorArticulo implements ActionListener{
	private Vista v;
	public GestorArticulo(Vista v) {this.v=v;}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Articulo p2 = new Articulo(v);
		this.v.getC().add("pArticulo",p2);
		((CardLayout)this.v.getC().getLayout()).show(this.v.getC(),"pArticulo");
	}

	public Vista getV() {return v;}
	public void setV(Vista v) {this.v = v;}
	
}
