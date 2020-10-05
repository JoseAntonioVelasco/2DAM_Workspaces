import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorMenu implements ActionListener {
	private String name;
	private Menus mens;
	
	public GestorMenu(String name, Menus mens) {
		this.name=name;
		this.mens=mens;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mens.getJl().setText("Has pulsado "+name);
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}

}