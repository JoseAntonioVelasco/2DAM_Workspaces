package t10a2_Ejemplo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ControlBotones implements ActionListener{
	
	private String s;
	private JTextField jtf;
	
	public ControlBotones(String s,JTextField jtf) {
		this.s=s;
		this.jtf=jtf;
	}
	//modificamos el metodo actionPerformed para que devuelva un "Ha pulsado: "
	@Override
	public void actionPerformed(ActionEvent e) {
		this.getJtf().setText("Ha pulsado: "+this.getS());
	}
	//getters y setters
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public JTextField getJtf() {
		return jtf;
	}

	public void setJtf(JTextField jtf) {
		this.jtf = jtf;
	}
	
}
