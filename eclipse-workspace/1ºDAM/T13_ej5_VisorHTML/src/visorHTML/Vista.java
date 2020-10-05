package visorHTML;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Vista extends JFrame{
	
	public Vista() {
	
		
	
		JPanel panel = new JPanel();
		JPanel panel_boton = new JPanel();
		
		
		JEditorPane panel_edit = new JEditorPane();
		panel_edit.setContentType("text/html");
		
		//boton
		JButton seleccionar = new JButton("Seleccionar");
		seleccionar.addActionListener(new GestorSeleccionar(panel_edit));
		seleccionar.setAlignmentX(CENTER_ALIGNMENT);
		
		
		panel_boton.add(seleccionar);
		panel_boton.setMaximumSize(new Dimension(400,40));
		panel_boton.setPreferredSize(new Dimension(400,40));
		panel.add(panel_boton);
		
	
		//scroll
	    JScrollPane scroll = new JScrollPane(panel_edit);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    panel.add(scroll);
	    
	    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		this.setMinimumSize(new Dimension(400,500));
		this.setPreferredSize(new Dimension(400,500));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		
	}
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
	}
	
	
}
