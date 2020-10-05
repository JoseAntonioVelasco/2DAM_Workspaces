package internacional;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class GestorAceptar implements ActionListener {
	private Dconfigurar d;
	public GestorAceptar(Dconfigurar d) {this.d=d;}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		ResourceBundle vista;
		
		if(d.getC().getSelectedItem().equals("Spanish"))
			vista = ResourceBundle.getBundle("propiedades/spanish_bundle");
		else
			vista = ResourceBundle.getBundle("propiedades/english_bundle");
		
		d.getF().setVista(vista);
		d.getF().setJMenuBar(new VMenu(d));
		d.getF().getL1().setText(vista.getString("ESTO ES UN PROGRAMA INTERNACIONAL"));
		
		d.getL().setText(vista.getString("SELECCIONA EL IDIOMA"));
		d.getB().setText(vista.getString("ACEPTAR"));
		
		d.getF().validate();
		d.setVisible(false);
	}
	
}
