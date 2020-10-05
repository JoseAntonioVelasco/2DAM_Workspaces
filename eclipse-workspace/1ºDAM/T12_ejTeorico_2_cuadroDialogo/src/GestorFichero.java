import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class GestorFichero implements ActionListener{
	JFrame f;
	public GestorFichero(JFrame f) {
		this.f=f;
	}
	public void actionPerformed(ActionEvent e) {
		JFileChooser selector = new JFileChooser();
		ImgFileFilter filtro = new ImgFileFilter();
		selector.setFileFilter(filtro);
		int returnVal = selector.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("Se eligió el archivo "+selector.getSelectedFile().getName());
		}
	}
}
