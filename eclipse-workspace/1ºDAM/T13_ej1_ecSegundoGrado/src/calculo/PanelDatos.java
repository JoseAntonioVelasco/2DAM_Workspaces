package calculo;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDatos extends JPanel{

	private JTextField a;
	private JTextField b;
	private JTextField c;
	
	public PanelDatos() {
		this.setBorder(new TitledBorder("Coeficientes"));
		JLabel coe_a = new JLabel("a= ");
		JLabel coe_b = new JLabel("b= ");
		JLabel coe_c = new JLabel("c= ");
		
		a = new JTextField(8);
		b = new JTextField(8);
		c = new JTextField(8);
		
		this.add(coe_a);this.add(a);
		this.add(coe_b);this.add(b);
		this.add(coe_c);this.add(c);
		
		this.setLayout(new GridLayout(3,2));
	}

	public JTextField getA() {
		return a;
	}

	public void setA(JTextField a) {
		this.a = a;
	}

	public JTextField getB() {
		return b;
	}

	public void setB(JTextField b) {
		this.b = b;
	}

	public JTextField getC() {
		return c;
	}

	public void setC(JTextField c) {
		this.c = c;
	}
	
	
	
}
