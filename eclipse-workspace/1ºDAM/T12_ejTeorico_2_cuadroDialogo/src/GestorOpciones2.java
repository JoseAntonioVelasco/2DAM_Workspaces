import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorOpciones2 implements ActionListener{
	JFrame f;
	public GestorOpciones2(JFrame f) {
		this.f=f;
	}
	public void actionPerformed(ActionEvent e) {
		Object seleccion= JOptionPane.showInputDialog(f, "Selecciona opcion", "Selector de opciones", JOptionPane.QUESTION_MESSAGE,
				null, new Object[] {"opcion 1","opcion 2","opcion 3"}, "opcion 1");
		
		System.out.println("El usuario ha elegido "+seleccion);
	}
}
