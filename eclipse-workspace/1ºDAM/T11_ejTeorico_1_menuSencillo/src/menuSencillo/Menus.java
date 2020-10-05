package menuSencillo;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Menus extends JFrame{
	private JLabel jl;
	private JMenuBar menu;
	
	public Menus() {
		super("Ejemplo Menus");
		
		jl = new JLabel("No accion seleccionada");
		jl.setPreferredSize(new Dimension(300,200));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setBorder(new LineBorder(Color.red));
		jl.setForeground(Color.black);
		jl.setBackground(Color.pink);
		jl.setOpaque(true);
		
		this.getContentPane().add(jl);
		menu = new VMenu(this);
		this.setJMenuBar(menu);
		this.pack();
	}
	
	public static void main(String[] args) {
		Menus m = new Menus();
		m.setVisible(true);
	}
	
	public JLabel getJL() {return jl;}
	public void setJL(JLabel jl) {this.jl=jl;}
	public JMenuBar getMenu() {return menu;}
	public void setMenu(JMenuBar menu) {this.menu=menu;}
	
}
