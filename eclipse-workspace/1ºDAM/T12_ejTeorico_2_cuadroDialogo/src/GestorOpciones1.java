import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorOpciones1 implements ActionListener{
	JFrame f;
	public GestorOpciones1(JFrame f) {
		this.f=f;
	}
	public void actionPerformed(ActionEvent e) {
		int seleccion = JOptionPane.showOptionDialog(f, "Selecciona una opcion", "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new Object[] {"Primera cosa","Segunda cosa","Tercera cosa"}, "opcion 1");
		if(seleccion != -1)
			System.out.println("seleccionada opcion "+(seleccion +1));
	}
}
