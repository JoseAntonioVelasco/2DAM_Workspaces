package menuCapas.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuCapas.Vista;
import menuCapas.vista.Cerrar;

public class GestorCerrar implements ActionListener{
	private Vista v;
	public GestorCerrar(Vista v) {this.v=v;}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Cerrar p2 = new Cerrar(v);
		this.v.getC().add("pCerrar",p2);
		((CardLayout)this.v.getC().getLayout()).show(this.v.getC(),"pCerrar");
	}

	public Vista getV() {return v;}
	public void setV(Vista v) {this.v = v;}
	
}
