package principal;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Buscar extends JFrame{
	public Buscar(JTextArea textArea) {
		super("Informacion a buscar");
		
		JPanel panel = new JPanel();
		
		JTextField textField = new JTextField(20);
		JLabel label = new JLabel("texto: ");
		JPanel textofieldo = new JPanel();
		textofieldo.add(label);
		textofieldo.add(textField);
		
		
		JCheckBox ckbox= new JCheckBox("Distinguir mayusculas y minusculas");
		JButton aceptar = new JButton("Aceptar");
		
		System.out.println("imprimiendoasd"+textField.getText());
		
		aceptar.addActionListener(new GestorAceptar(textArea,textField,ckbox));
		
		panel.add(textofieldo);
		panel.add(ckbox);
		panel.add(aceptar);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		this.setContentPane(panel);
		this.pack();
	}
}
