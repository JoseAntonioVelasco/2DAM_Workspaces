package menuCapas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;

import menuCapas.Controlador.GestorVentana;
import menuCapas.vista.Cerrar;
import menuCapas.vista.VMenu;

public class Vista extends JFrame{
	private ResourceBundle vista;
	private JLabel l1;
	private VMenu menu;
	private Cerrar pCerrar;
	private Container c;
	
	public Vista() {
		super("Frame con Niveles");
		this.menu = new VMenu(this);
		this.pCerrar = new Cerrar(this);
	}
	
	public void run() {
		
		setBackground(Color.WHITE);
		
		this.c=this.getContentPane();
		this.c.setLayout(new CardLayout());
		this.c.add("pCerrar",getpCerrar());
		
		this.setJMenuBar(getMenu());
		this.setSize(600,300);
		this.addWindowListener(new GestorVentana());
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}

	public ResourceBundle getVista() {
		return vista;
	}

	public void setVista(ResourceBundle vista) {this.vista = vista;}
	public JLabel getL1() {return l1;}
	public void setL1(JLabel l1) {this.l1 = l1;}
	public VMenu getMenu() {return menu;}
	public void setMenu(VMenu menu) {this.menu = menu;}
	public Cerrar getpCerrar() {return pCerrar;}
	public void setpCerrar(Cerrar pCerrar) {this.pCerrar = pCerrar;}
	public Container getC() {return c;}
	public void setC(Container c) {this.c = c;}
	
}
