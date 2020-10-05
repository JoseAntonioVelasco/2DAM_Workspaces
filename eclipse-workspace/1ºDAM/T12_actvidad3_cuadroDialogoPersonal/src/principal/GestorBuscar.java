package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;


public class GestorBuscar implements ActionListener{
	private JTextArea textArea;
	public GestorBuscar(JTextArea textArea) {
		this.textArea=textArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Buscar busc = new Buscar(this.textArea);
		busc.setVisible(true);		
	}
}
