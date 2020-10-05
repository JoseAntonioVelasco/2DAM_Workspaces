package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class GestorAceptar implements ActionListener{
	private JTextField fld_nombre;
	private JPasswordField fld_pass;
	public GestorAceptar(JTextField fld_nombre, JPasswordField fld_pass) {
		this.fld_nombre=fld_nombre;
		this.fld_pass=fld_pass;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.fld_nombre.setText("");
		this.fld_pass.setText("");
	}
}
