package t10a1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CuatroBotones {
	public CuatroBotones() {
		//Ventana
		JFrame j = new JFrame("Titulo"); //se crea una ventana que se llama titulo
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Disposicion
		j.setLayout(new GridLayout(2,2)); //la ventana tiene un 4 espacios ordenados en un 2x2
		
		//Anadimos los botones
		for(int i=0; i<4; i++) {
			j.add(new JButton("B"+i));
		}
		
		j.pack();
		j.setLocationRelativeTo(null); 
		j.setVisible(true);
	}
}
