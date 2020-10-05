package menuCapas.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import menuCapas.Vista;
import menuCapas.Controlador.GestorAlta;
import menuCapas.Controlador.GestorArticulo;
import menuCapas.Controlador.GestorCerrar;
import menuCapas.Controlador.GestorCliente;
import menuCapas.Controlador.GestorPedido;

public class VMenu extends JMenuBar {
	public VMenu(final Vista v) {
		ResourceBundle vista = v.getVista();
		
		JMenu menuA = new JMenu("Archivo");
		JMenuItem A1 = new JMenuItem("Cerrar");
		JMenuItem A2 = new JMenuItem("Salir");
		A1.addActionListener(new GestorCerrar(v));
		menuA.add(A1); menuA.add(A2);
		
		JMenu menuB = new JMenu("Altas");
		JMenuItem B1 = new JMenuItem("Alta");
		B1.addActionListener(new GestorAlta(v));
		menuB.add(B1);
		
		JMenu menuC = new JMenu("Busquedas");
		JMenuItem C1 = new JMenuItem("Articulo");
		JMenuItem C2 = new JMenuItem("Cliente");
		JMenuItem C3 = new JMenuItem("Pedido");
		C1.addActionListener(new GestorArticulo(v));
		C2.addActionListener(new GestorCliente(v));
		C3.addActionListener(new GestorPedido(v));
		menuC.add(C1); menuC.add(C2); menuC.add(C3);
		
		A2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {System.exit(0);}
		});
		this.add(menuA); this.add(menuB); this.add(menuC);
	}
}
