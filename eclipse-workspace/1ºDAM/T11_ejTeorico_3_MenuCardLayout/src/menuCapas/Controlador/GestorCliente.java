package menuCapas.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuCapas.Vista;
import menuCapas.vista.Cliente;

public class GestorCliente implements ActionListener{
	private Vista v;
	public GestorCliente(Vista v) {this.v=v;}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Cliente p2 = new Cliente(v);
		this.v.getC().add("pCliente",p2);
		((CardLayout)this.v.getC().getLayout()).show(this.v.getC(),"pCliente");
	}

	public Vista getV() {return v;}
	public void setV(Vista v) {this.v = v;}
	
}
