package menuCapas.Vista;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class CrearHabitCKboxes extends JPanel{
	private JCheckBox banyo_comp;
	private JCheckBox cam_sup;
	private JCheckBox vip;
	
	public CrearHabitCKboxes() {
		
		this.setBorder(new TitledBorder("Caracteristicas de la habitacion"));
			
		banyo_comp = new JCheckBox("Banyo compartido");
		banyo_comp.setEnabled(false);
		
		cam_sup = new JCheckBox("Camas supletorias");
		cam_sup.setEnabled(false);
		
		vip = new JCheckBox("Vip");
		vip.setEnabled(false);
	
		this.add(banyo_comp);this.add(cam_sup);
		this.add(vip);	
		this.setLayout(new GridLayout(2,2));
	}

	public JCheckBox getBanyo_comp() {
		return banyo_comp;
	}

	public void setBanyo_comp(JCheckBox banyo_comp) {
		this.banyo_comp = banyo_comp;
	}

	public JCheckBox getCam_sup() {
		return cam_sup;
	}

	public void setCam_sup(JCheckBox cam_sup) {
		this.cam_sup = cam_sup;
	}

	public JCheckBox getVip() {
		return vip;
	}

	public void setVip(JCheckBox vip) {
		this.vip = vip;
	}
	
}
