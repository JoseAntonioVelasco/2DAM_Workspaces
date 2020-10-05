package calculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;



public class Gestor_Calcular implements ActionListener{
	private PanelDatos panel_datos;
	private PanelResultados resul;
	public Gestor_Calcular(PanelDatos panel_datos, PanelResultados resul) {
		this.panel_datos=panel_datos;
		this.resul=resul;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Double a= Double.parseDouble(this.panel_datos.getA().getText());
		Double b= Double.parseDouble(this.panel_datos.getB().getText());
		Double c= Double.parseDouble(this.panel_datos.getC().getText());
		
		Double resul1 = (-b + Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
		Double resul2 = (-b - Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
		
		this.resul.getRes1().setText(Double.toString(resul1));
		this.resul.getRes2().setText(Double.toString(resul2));
	}
}
