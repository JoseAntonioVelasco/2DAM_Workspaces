package camposdetexto.blocdenotas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class GestorLimpiar implements ActionListener{
	private JTextArea area;
	public GestorLimpiar(JTextArea area) {
		this.area=area;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.area.setText("");
	}
}
