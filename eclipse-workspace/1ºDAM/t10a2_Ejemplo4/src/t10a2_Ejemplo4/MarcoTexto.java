package t10a2_Ejemplo4;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcoTexto extends JPanel{
	JPanel panel;
	MarcoTexto(){
		//se pone el texto al panel
		JLabel etiqueta = new JLabel("Texto anadido al panel...");
		this.add(etiqueta);
	}
}
