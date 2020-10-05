package t10a2_Ejemplo3;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class MarcoBotones extends JInternalFrame{
	JPanel panel;
	ArrayList<JButton> botonera;
	
	MarcoBotones(){
		//constructor que hereda caracteristicas de JInternalFrame
		/*public JInternalFrame(String title,
        boolean resizable,
        boolean closable,
        boolean maximizable,
        boolean iconifiable)*/
		super("JInternalFrame con botones",true, true,true, true);
		//crea un panel
		panel = new JPanel();
		botonera = new ArrayList<JButton>();
		//anañade al panel los botones
		for(int i=0; i<7; i++) {
			botonera.add(new JButton("Boton"+i));
			panel.add(botonera.get(i));
		}
		//tamaño y color que se les va a poner por defecto al panel
		panel.setPreferredSize(new Dimension(400,100));
		panel.setBackground(Color.PINK);
		//que va a tener dentro el panel
		this.setContentPane(panel);
		//cambia el tamaño de los componentes de la interfaz para que
		//se ajusten a el tamaño de la ventana
		this.pack();
		//Hace que sea visible la ventana
		this.setVisible(true);
	}

}
