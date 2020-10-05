package login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Vista extends JFrame{
	
	public Vista() {
		super("Seguridad");
		JPanel panel_con = new JPanel();
		panel_con.setBorder(new TitledBorder("Panel de conexion"));
		JLabel nombre = new JLabel("Nombre de usuario: ");
		JLabel pass = new JLabel("Password: ");
		
		JTextField fld_nombre = new JTextField(10);
		JPasswordField fld_pass = new JPasswordField(10);
		
		JButton accept = new JButton("Aceptar");
		accept.addActionListener(new GestorAceptar(fld_nombre,fld_pass));
		
		panel_con.add(nombre);panel_con.add(fld_nombre);
		panel_con.add(pass);panel_con.add(fld_pass);
		panel_con.add(accept);
		
		this.setContentPane(panel_con);
		
		this.pack();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vista v = new Vista();
		v.setVisible(true);

	}

}
