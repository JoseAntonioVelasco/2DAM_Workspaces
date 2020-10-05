package menuCapas.Controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menuCapas.Vista;
import menuCapas.vista.Pedido;

public class GestorPedido implements ActionListener{
	private Vista v;
	public GestorPedido(Vista v) {this.v=v;}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Pedido p2 = new Pedido(v);
		this.v.getC().add("pPedido",p2);
		((CardLayout)this.v.getC().getLayout()).show(this.v.getC(),"pPedido");
	}

	public Vista getV() {return v;}
	public void setV(Vista v) {this.v = v;}
	
}
