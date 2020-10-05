package menuCapas.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import menuCapas.Mensaje;

import menuCapas.Vista.MarcoVarios;
import menuCapas.Vista.Menu;

public class GestorCalcular implements ActionListener{
	private Mensaje mens;
	private MarcoVarios varios;
	private Menu menu;
	
	public GestorCalcular(Menu menu) {
		this.menu=menu;
	}
	public GestorCalcular(MarcoVarios varios) {
		this.varios=varios;
	}
	public GestorCalcular(Menu menu,MarcoVarios varios) {
		this.menu=menu;
		this.varios=varios;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String texto = "<html>El menu seleccionado es: <br>"
				+this.menu.getStrPlatosSeleccionados()
				+this.varios.strCheckSeleccionados()+"<br>";
		texto+="TOTAL: "+(this.menu.sumaPrecio()+this.varios.sumaCheckSeleccionados())+"€"+"<br></html>";
		mens = new Mensaje(texto);
		mens.setVisible(true);
	}


}
