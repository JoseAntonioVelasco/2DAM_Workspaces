package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GestorAceptar implements ActionListener{
	private JTextArea textArea;
	private JTextField textField;
	private JCheckBox ckbox;
	public GestorAceptar(JTextArea textArea,JTextField textField,JCheckBox ckbox) {
		this.textArea=textArea;
		this.textField=textField;
		this.ckbox=ckbox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer posicion;
		if(this.ckbox.isSelected()) {
			posicion=this.textArea.getText().indexOf(this.textField.getText());
		}else {
			posicion=this.textArea.getText().indexOf(this.textField.getText().toLowerCase());
		}
		Mensaje mens = new Mensaje(posicion);
		mens.setVisible(true);
		
	}
}
