package camposdetexto.blocdenotas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorSalir implements ActionListener{
	public GestorSalir() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
