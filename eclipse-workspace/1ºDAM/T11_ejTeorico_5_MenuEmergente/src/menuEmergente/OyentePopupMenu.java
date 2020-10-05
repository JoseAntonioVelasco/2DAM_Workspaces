package menuEmergente;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OyentePopupMenu implements MouseListener{
	
	private Menus m;
	public OyentePopupMenu(Menus m) {
		this.m=m;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger())
			m.getJpm().show(e.getComponent(), e.getX(), e.getY());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
}
