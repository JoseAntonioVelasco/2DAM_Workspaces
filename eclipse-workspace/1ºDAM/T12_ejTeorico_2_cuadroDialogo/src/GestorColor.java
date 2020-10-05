import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class GestorColor implements ActionListener{
	JFrame f;
	public GestorColor(JFrame f) {
		this.f=f;
	}
	public void actionPerformed(ActionEvent e) {
		Color c = JColorChooser.showDialog(f,"Cambiarfondo",Color.RED);
		if(c!=null)
		System.out.println("color = RED: "+c.getRed()+ " GREEN: "+c.getGreen()+ "BLUE: "+c.getBlue());
	}
}
