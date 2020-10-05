package menuCapas;

import javax.swing.JFrame;

import menuCapas.Vista.TabCrearHabit;

public class Vistav extends JFrame{
	
	public Vistav() {
		super("Hotel Agaporni");
		TabCrearHabit a = new TabCrearHabit();
		this.add(a);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
	}
	public static void main(String[] args)
	{
		Vistav v = new Vistav();
		v.setVisible(true);
	}
}
