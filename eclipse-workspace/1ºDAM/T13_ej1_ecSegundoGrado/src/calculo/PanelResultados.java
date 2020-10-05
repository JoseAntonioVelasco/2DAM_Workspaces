package calculo;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel{
	
	private JTextField res1 = new JTextField();
	private JTextField res2 = new JTextField();
	public PanelResultados() {
		this.setBorder(new TitledBorder("Resultados"));
		res1 = new JTextField();
		res2 = new JTextField();
		this.add(res1);this.add(res2);
		this.setLayout(new GridLayout(1,2));
	}
	public JTextField getRes1() {
		return res1;
	}
	public void setRes1(JTextField res1) {
		this.res1 = res1;
	}
	public JTextField getRes2() {
		return res2;
	}
	public void setRes2(JTextField res2) {
		this.res2 = res2;
	}
	
}
