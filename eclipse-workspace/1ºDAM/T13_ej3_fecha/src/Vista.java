import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vista extends JFrame{
	private JFormattedTextField textField;
	public Vista() {
		super("Texto con formato");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Fecha de nacimiento");
		try {
			textField = new JFormattedTextField(new FormatoFecha());
			textField.setValue(new Date());
			textField.setEditable(true);
			panel.add(label);
			panel.add(textField);
		}catch(ParseException ex) {
			Logger.getLogger(TextoConFormato.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		this.setContentPane(panel);
		this.pack();
	}
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
	}
	
	
}
