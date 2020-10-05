package internacional;

import java.awt.Choice;
import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Dconfigurar extends JDialog{
	private Vista f;
	private JLabel l;
	private Choice c;
	private JButton b;
	
	public Dconfigurar(final Vista f)
	{
		this.f=f;
		ResourceBundle vista=f.getVista();
		
		l= new JLabel(vista.getString("SELECCIONA EL IDIOMA"));
		c= new Choice();
		c.add(vista.getString("SPANISH"));
		c.add(vista.getString("ENGLISH"));
		b = new JButton(vista.getString("ACEPTAR"));
		
		b.addActionListener(new GestorAceptar(this));
		
		setLayout(new GridLayout(3,1));
		add(l);
		add(c);
		add(b);
		setSize(200,100);
		setLocationRelativeTo(null);
	}

	public Vista getF() {return f;}
	public void setF(Vista f) {this.f = f;}
	public JLabel getL() {return l;}
	public void setL(JLabel l) {this.l = l;}
	public Choice getC() {return c;}
	public void setC(Choice c) {this.c = c;}
	public JButton getB() {return b;}
	public void setB(JButton b) {this.b = b;}
	
	
}
