package menuEmergente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

public class Menus extends JFrame{
	
	private JPopupMenu jpm;
	private JLabel jl;
	private ArrayList<Color> colores;
	private ArrayList<String> nombres;
	
	public Menus() {
		super ("Ejemplo Menus");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jpm= new JPopupMenu();
		
		colores = new ArrayList<Color>();
		colores.add(Color.BLUE); colores.add(Color.ORANGE);
		colores.add(Color.GRAY);colores.add(Color.PINK);
		colores.add(Color.GREEN);colores.add(Color.RED);
		colores.add(Color.MAGENTA);colores.add(Color.YELLOW);
		
		nombres = new ArrayList<String>();
		nombres.add("Azul");nombres.add("Naranja");
		nombres.add("Gris");nombres.add("Rosa");
		nombres.add("Verde");nombres.add("Rojo");
		nombres.add("Naranja");nombres.add("Amarillo");
		
		jl = new JLabel();
		jl.setPreferredSize(new Dimension(300,200));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setBackground(Color.WHITE);
		jl.setOpaque(true);
		
		this.getContentPane().add(jl);
		
		for(int i=0; i<nombres.size(); i++) {
			JMenuItem jmi = new JMenuItem(getNombres().get(i));
			jmi.addActionListener(new GestorMenu(this,i));
			jpm.add(jmi);
		}
		
		MouseListener oyenteRaton = new OyentePopupMenu(this);
		this.addMouseListener(oyenteRaton);
		
		this.pack();
	}
	
	public static void main(String[] args) {
		Menus m = new Menus();
		m.setVisible(true);
	}

	public JPopupMenu getJpm() {return jpm;}
	public void setJpm(JPopupMenu jpm) {this.jpm = jpm;}
	public JLabel getJl() {return jl;}
	public void setJl(JLabel jl) {this.jl = jl;}
	public ArrayList<Color> getColores() {return colores;}
	public void setColores(ArrayList<Color> colores) {this.colores = colores;}
	public ArrayList<String> getNombres() {return nombres;}
	public void setNombres(ArrayList<String> nombres) {this.nombres = nombres;}
	
	
}
