package internacional;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vista extends JFrame{
	private ResourceBundle vista;
	private JLabel l1;
	
	Vista(){vista = ResourceBundle.getBundle("propiedades/english_bundle"); }
	void run() {this.crearVentana(); }
	
	void crearVentana() {
		
		setBackground(Color.WHITE);
		
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		setL1(new JLabel(getVista().getString("ESTO ES UN PROGRAMA INTERNACIONAL")));
		
		p.setLayout(new BorderLayout());
		p.add(getL1(),BorderLayout.CENTER);
		
		Dconfigurar d_configurar = new Dconfigurar(this);
		VMenu menu = new VMenu(d_configurar);
		
		Container c = this.getContentPane();
		c.add(p);
		setJMenuBar(menu);
		setSize(400,80);
		addWindowListener(new GestorVentana());
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}
	public JLabel getL1() {return l1;}
	public void setL1(JLabel l1) {this.l1 = l1;}
	public ResourceBundle getVista() {return vista;}
	public void setVista(ResourceBundle vista) {this.vista = vista;}
	
	
}
