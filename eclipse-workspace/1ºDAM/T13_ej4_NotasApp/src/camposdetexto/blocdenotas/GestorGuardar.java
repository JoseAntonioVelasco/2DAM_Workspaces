package camposdetexto.blocdenotas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class GestorGuardar implements ActionListener{
	private JTextArea area;
	private JTextField nombre;
	
	public GestorGuardar(JTextArea area,JTextField nombre) {
		this.area=area;
		this.nombre=nombre;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			FileWriter escribir = new FileWriter(this.nombre.getText());
			escribir.write(this.area.getText());
			escribir.close();
			JOptionPane.showMessageDialog(null, "Guardado correctamente");
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}
}
