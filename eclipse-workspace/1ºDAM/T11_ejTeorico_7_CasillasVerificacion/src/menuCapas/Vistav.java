package menuCapas;

import java.awt.Color;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import menuCapas.Vista.MarcoVarios;
import menuCapas.Vista.Menu;

import menuCapas.Vista.Seleccionado;

public class Vistav extends JFrame{
	
	public Vistav() {
		super("Seleccion de Menu");
	}
	
	public void run() {
		
		setBackground(Color.WHITE);
		
		//inicializar tabmenu
		JTabbedPane menu_superior=new JTabbedPane();
		Menu menu = new Menu();
		MarcoVarios varios= new MarcoVarios("Pan","Agua","Vino","Refrescos",1.0,1.5,8.0,2.5);
		
		menu_superior.addTab("Menu", menu);
		menu_superior.addTab("Varios",varios);
		menu_superior.addTab("Seleccionado",new Seleccionado(menu,varios));
		
		
		this.getContentPane().add(menu_superior);
		this.setLayout(new FlowLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
		this.pack();
	}
	
	public static void main(String[] args)
	{
		Vistav v = new Vistav();
		v.run();
	}
		
}
