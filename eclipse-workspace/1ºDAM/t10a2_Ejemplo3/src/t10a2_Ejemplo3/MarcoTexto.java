package t10a2_Ejemplo3;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcoTexto extends JInternalFrame{
	JPanel panel;
	MarcoTexto(){
		//constructor que hereda caracteristicas de JInternalFrame
				/*public JInternalFrame(String title,
		        boolean resizable,
		        boolean closable,
		        boolean maximizable,
		        boolean iconifiable)*/
		super("JInternalFrame con texto",true,true,true,true);
		//crea panel y le añade un texto
		panel = new JPanel();
		JLabel etiqueta = new JLabel("Texto anadido");
		panel.add(etiqueta);
		//dimensiones con las que se genera por defecto y color que sale por defecto
		panel.setPreferredSize(new Dimension(250,100));
		panel.setBackground(Color.cyan);
		
		//el contenido que va a tener el panel
		this.setContentPane(panel);
		//cambia el tamaño de los componentes de la interfaz para que se ajusten a el
		//tamaño de la ventana
		this.pack();
		//Hace que sea visible la ventana
		this.setVisible(true);
	}

}
