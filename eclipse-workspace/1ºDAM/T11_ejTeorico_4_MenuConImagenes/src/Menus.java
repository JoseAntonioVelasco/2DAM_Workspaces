import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Menus extends JFrame{
	private JLabel jl;
	private JMenuBar menu;
	
	public Menus()
	{
		super("Ejemplo Menus");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jl = new JLabel("No accion seleccionada");
		jl.setPreferredSize(new Dimension(300,200));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		
		menu = new VMenu(this);
		this.setJMenuBar(menu);
		
		JPanel botonera = new JPanel();
		jl.setBorder(new LineBorder(Color.black));
		JButton b1 = new JButton("Alpha", new ImageIcon("img/alpha.png")); botonera.add(b1);
		JButton b2 = new JButton("Beta", new ImageIcon("img/beta.png")); botonera.add(b2);
		JButton b3 = new JButton("Gamma", new ImageIcon("img/gamma.png")); botonera.add(b3);
		JButton b4 = new JButton("Delta", new ImageIcon("img/delta.png")); botonera.add(b4);
		
		b1.addActionListener(new GestorMenu(b1.getText(),this));
		b2.addActionListener(new GestorMenu(b2.getText(),this));
		b3.addActionListener(new GestorMenu(b3.getText(),this));
		b4.addActionListener(new GestorMenu(b4.getText(),this));
		
		this.add(botonera, BorderLayout.NORTH);
		this.getContentPane().add(jl);
		
		this.pack();
	}
	
	public static void main(String[] args)
	{
		Menus m = new Menus();
		m.setVisible(true);
	}

	public JLabel getJl() {return jl;}
	public void setJl(JLabel jl) {this.jl = jl;}
	public JMenuBar getMenu() {return menu;}
	public void setMenu(JMenuBar menu) {this.menu = menu;}
	
	
}
