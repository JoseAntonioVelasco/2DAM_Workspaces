import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class VMenu extends JMenuBar{
	public VMenu(Menus mens)
	{
		JMenu menuA = new JMenu("Archivo");
		JMenuItem A0 = new JMenuItem("SALIR");
		A0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		
		JMenu menuB = new JMenu("Alfabeto");
		
		JMenuItem B1 = new JMenuItem("Alpha");
		B1.setIcon(new ImageIcon("img/alpha.png"));
		B1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		
		JMenuItem B2= new JMenuItem("Beta");
		B2.setIcon(new ImageIcon("img/beta.png"));
		B2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		
		JMenuItem B3 = new JMenuItem("Gamma");
		B3.setIcon(new ImageIcon("img/gamma.png"));
		B3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		
		JMenuItem B4 = new JMenuItem("Delta");
		B4.setIcon(new ImageIcon("img/delta.png"));
		B4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		menuA.add(A0); menuB.add(B1); menuB.add(B2);
		menuB.add(B3); menuB.add(B4);
		
		A0.addActionListener(new GestorSalir());
		B1.addActionListener(new GestorMenu(B1.getText(), mens));
		B2.addActionListener(new GestorMenu(B2.getText(), mens));
		B3.addActionListener(new GestorMenu(B3.getText(), mens));
		B4.addActionListener(new GestorMenu(B4.getText(), mens));
		
		this.add(menuA);
		this.add(menuB);
	}
}
