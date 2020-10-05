package t10a2_Ejemplo1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame{

	public BorderLayoutDemo() {
		String[] nombre = {"Norte","Sur","E","O","Centro"};
		String[] posicion = {BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST,BorderLayout.CENTER};
		//lo que tiene que hacer el programa cuando cierre la interfaz
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//crea los botones con su nombre y posicion y los va añadiendo a la interfaz
		for(int i=0; i<nombre.length; i++) {
			this.add(new JButton(nombre[i]),posicion[i]);
		}
		//tamaño de la interfaz que aparece por predeterminado
		this.setPreferredSize(new Dimension(400,200));
		//cambia el tamaño de los componentes de la interfaz para que se ajusten a el tamaño de la ventana
		this.pack();
		//dice donde va a aparecer la ventana de la aplicacion en relacion a algo, cuando esta en null aparece en el centro de la pantalla
		this.setLocationRelativeTo(null);
	}
}
