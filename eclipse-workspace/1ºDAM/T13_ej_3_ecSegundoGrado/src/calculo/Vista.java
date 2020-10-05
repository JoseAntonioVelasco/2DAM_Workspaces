package calculo;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista extends JFrame{
	public Vista() {
		super("ax2+bx+c=0");
		

	}
	public void run() {
		PanelDatos panel_dat = new PanelDatos();
		PanelResultados panel_resul = new PanelResultados();
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new Gestor_Calcular(panel_dat,panel_resul));
		//JPanel global = new JPanel();
		//global.add(panel_dat);global.add(panel_resul);
		this.add(panel_dat);this.add(calcular);this.add(panel_resul);
		//this.setContentPane(global);
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.pack();
		//global.add(resu);
		
		//this.setContentPane(global);
	}

}
