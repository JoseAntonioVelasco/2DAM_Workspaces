import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorInput implements ActionListener{

	JFrame f;
	public GestorInput(JFrame f) {
		this.f=f;
	}
	public void actionPerformed(ActionEvent e) {
		String seleccion = JOptionPane.showInputDialog(f, "¿Como dices que te llamas?",
			JOptionPane.QUESTION_MESSAGE);
		System.out.println("El usuario ha escrito "+seleccion);
	}
}
