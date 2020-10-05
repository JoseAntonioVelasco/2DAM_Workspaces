package t10a2_Ejemplo4;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbedSencillo {
	static public void main(String[] args) {
		//se crean dos paneles uno de texto y otro de botones
		JPanel pt = new MarcoTexto();
		JPanel pb = new MarcoBotones();
		//se crea un panel que tenga "tabs" solapas y se les añaden las dos solapas/paneles creados anteriormente
		JTabbedPane jtp = new JTabbedPane();
		jtp.add("Botonera", pb);
		jtp.add("Texto",pt);
		
		//titulo de la ventana que se va a generar
		JFrame fr= new JFrame("Demostracion de panel con solapas");
		//a la ventana creada le añadimos el panel con solapas
		fr.getContentPane().add(jtp, BorderLayout.CENTER);
		//al cerrarse la ventana se cierra el programa
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//cambia el tamaño de los componentes de la interfaz para que se ajusten a el tamaño de la ventana
		fr.pack();
		//hacemos que sea visible la ventana
		fr.setVisible(true);
	}
}
