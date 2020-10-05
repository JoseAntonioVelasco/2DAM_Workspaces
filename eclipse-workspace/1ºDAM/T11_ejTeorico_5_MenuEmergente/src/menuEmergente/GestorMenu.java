package menuEmergente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorMenu implements ActionListener{
	private Menus m;
	private int i;
	
	public GestorMenu(Menus m, int i) {
		this.m=m;
		this.i=i;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.m.getJl().setBackground(m.getColores().get(i));
		this.m.getJl().setText(m.getNombres().get(i));
	}
}
