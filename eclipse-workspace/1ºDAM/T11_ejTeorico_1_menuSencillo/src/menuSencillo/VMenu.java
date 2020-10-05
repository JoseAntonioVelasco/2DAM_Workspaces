package menuSencillo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class VMenu extends JMenuBar {
	
	public VMenu(Menus mens) {
		
		this.setBackground(Color.white);
		
		JMenu menuA = new JMenu("menu1"); JMenuItem A0 = new JMenuItem("A");
		JMenuItem A1 = new JMenuItem("B"); JMenuItem A2 = new JMenuItem("SALIR");
		
		JMenu menuD = new JMenu("menu2"); JMenu D1 = new JMenu("D");
		JMenuItem D11 = new JMenuItem("D1"); JMenuItem D12 = new JMenuItem("D2");
		
		A0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		A1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		A2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		D11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		D12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		menuA.add(A0); menuA.add(A1); menuA.add(A2);
		menuD.add(D1); D1.add(D11); D1.add(D12);
		
		A0.addActionListener(new GestorMenu(A0.getText(), mens));
		A1.addActionListener(new GestorMenu(A0.getText(), mens));
		A2.addActionListener(new GestorSalir());
		D11.addActionListener(new GestorMenu(D11.getText(), mens));
		D12.addActionListener(new GestorMenu(D12.getText(), mens));
		
		this.add(menuA); this.add(menuD);
	}
}
