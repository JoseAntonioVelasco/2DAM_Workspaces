package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mensaje extends JDialog{
	public Mensaje(Integer posicion) {
		JLabel label = new JLabel("La palabra se encuentra en la posicion "+posicion);
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(aceptar);
		this.add(panel);
		this.pack();
	}
}
