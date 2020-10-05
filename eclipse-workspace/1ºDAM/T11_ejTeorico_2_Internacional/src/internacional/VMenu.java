package internacional;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VMenu extends JMenuBar{
	
	public VMenu(final Dconfigurar d_configurar)
	{
		Vista frame=d_configurar.getF();
		ResourceBundle vista = frame.getVista();
		
		JMenu menuA = new JMenu(vista.getString("ARCHIVO"));
		JMenuItem A1 = new JMenuItem(vista.getString("PROPIEDADES"));
		JMenuItem A2 = new JMenuItem(vista.getString("SALIR"));
		
		menuA.add(A1);
		menuA.add(A2);
		
		A1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {d_configurar.setVisible(true);}
		});
		
		A2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {System.exit(0);}
		});
		
		add(menuA);
	}
	
	

}
