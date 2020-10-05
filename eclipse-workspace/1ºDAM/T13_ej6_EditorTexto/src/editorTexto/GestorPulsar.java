package editorTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class GestorPulsar implements ActionListener{

	public GestorPulsar() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Me has pulsado");
	}
}
