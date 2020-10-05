package t10a2_Ejemplo2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BorderLayoutDemoListener extends JFrame {
	
	private JTextField texto;
	private ArrayList<JButton> botonera;
	
	public BorderLayoutDemoListener() {
		texto= new JTextField();
		botonera = new ArrayList<JButton>();
		//crea los botones y los añade  al arraylist
		botonera.add(new JButton("Norte")); botonera.add(new JButton("Sur"));
		botonera.add(new JButton("Este")); botonera.add(new JButton("Oeste"));
		String[] posicion = {BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST};
		//a cada boton le da un output "Ha pulsado:" que viene en ControlBotones
		for(int i=0; i<botonera.size(); i++) {
			botonera.get(i).addActionListener(new ControlBotones(botonera.get(i).getText(),texto));
			this.add(botonera.get(i),posicion[i]);
		}
		//El texto que va dentro del boton se centra
		this.add(texto, BorderLayout.CENTER);
		//cuando se cierra la ventana se cierra el programa
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//tamaño de la ventana que se genera
		this.setPreferredSize(new Dimension(400,200));
		//cambia el tamaño de los componentes de la interfaz para que se ajusten a el tamaño de la ventana
		this.pack();
		//dice donde va a aparecer la ventana de la aplicacion en relacion a algo,
		//cuando esta en null aparece en el centro de la pantalla
		this.setLocationRelativeTo(null);
	}
	static public void main(String[] args) {
		//En el BorderLayOutDemo viene como va a ser la configuracion de la ventana
		BorderLayoutDemoListener bld = new BorderLayoutDemoListener();
		//Hace que sea visible la ventana
		bld.setVisible(true);
	}
	//getters and setters
	public JTextField getTexto() {
		return texto;
	}

	public void setTexto(JTextField texto) {
		this.texto = texto;
	}

	public ArrayList<JButton> getBotonera() {
		return botonera;
	}

	public void setBotonera(ArrayList<JButton> botonera) {
		this.botonera = botonera;
	}
	
	
}
