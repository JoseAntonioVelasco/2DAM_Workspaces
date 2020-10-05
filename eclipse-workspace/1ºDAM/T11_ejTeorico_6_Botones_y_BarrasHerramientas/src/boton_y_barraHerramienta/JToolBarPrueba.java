package boton_y_barraHerramienta;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class JToolBarPrueba extends JFrame{
	private JToolBar barraBotones;
	private JLabel jl;
	
	public JToolBarPrueba() {
		super("Prueba JToolBar");
		
		jl = new JLabel();
		jl.setPreferredSize(new Dimension(300,200));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setOpaque(true);
		
		barraBotones = new Botonera(jl);
		
		this.getContentPane().add(jl);
		this.getContentPane().add(barraBotones, BorderLayout.NORTH);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JToolBarPrueba();
	}

	public JLabel getJl() {return jl;}
	public void setJl(JLabel jl) {this.jl = jl;}
	
}
