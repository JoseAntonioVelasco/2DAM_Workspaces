import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorAceptar implements ActionListener{
	JFrame f;
	public GestorAceptar(JFrame f) {
		this.f=f;
	}
	public void actionPerformed(ActionEvent e) {
		int confirmado = JOptionPane.showConfirmDialog(f, "¿Seguro que lo quieres eliminar?");
		
		if(JOptionPane.OK_OPTION == confirmado) System.out.println("confirmado");
		else System.out.println("vale... no borro nada...");
	}
}
