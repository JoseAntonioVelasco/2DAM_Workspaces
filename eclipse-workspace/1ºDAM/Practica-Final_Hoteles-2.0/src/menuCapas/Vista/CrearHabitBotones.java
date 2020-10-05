package menuCapas.Vista;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import menuCapas.Controlador.GestorBotonesCrearHabit;

public class CrearHabitBotones extends JPanel{
	private JRadioButton t1;
	private JRadioButton t2;
	private JRadioButton t3;
	private JRadioButton t4;
	
	public CrearHabitBotones() {
		ButtonGroup grupo_tipos = new ButtonGroup();
		t1= new JRadioButton("Individual");
		t2= new JRadioButton("Doble");
		t3= new JRadioButton("Familiar");
		t4= new JRadioButton("Suite");
		
		t1.addActionListener(new GestorBotonesCrearHabit());
		
		grupo_tipos.add(t1);grupo_tipos.add(t2);
		grupo_tipos.add(t3);grupo_tipos.add(t4);
		
		//JPanel radiobuttons = new JPanel();
		this.setBorder(new TitledBorder("Tipos de habitacion"));
		this.add(t1);this.add(t2);
		this.add(t3);this.add(t4);
		this.setLayout(new GridLayout(2,2));
	}

	public JRadioButton getT1() {
		return t1;
	}

	public void setT1(JRadioButton t1) {
		this.t1 = t1;
	}

	public JRadioButton getT2() {
		return t2;
	}

	public void setT2(JRadioButton t2) {
		this.t2 = t2;
	}

	public JRadioButton getT3() {
		return t3;
	}

	public void setT3(JRadioButton t3) {
		this.t3 = t3;
	}

	public JRadioButton getT4() {
		return t4;
	}

	public void setT4(JRadioButton t4) {
		this.t4 = t4;
	}
	
	
}
