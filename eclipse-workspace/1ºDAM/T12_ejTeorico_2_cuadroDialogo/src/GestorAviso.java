import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorAviso implements ActionListener{
	JFrame f;
	public GestorAviso(JFrame f) {
		this.f=f;
	}
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(f, "Operacion realizada correctamente");
	}

}
