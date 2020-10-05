package visorHTML;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GestorSeleccionar implements ActionListener{
	private JEditorPane panel_edit;
	//private JFrame frame;
	public GestorSeleccionar(JEditorPane panel_edit) {
		this.panel_edit=panel_edit;
		//this.frame=frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser gestor_archivos = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("solo HTML", "html");
		gestor_archivos.setFileFilter(filter);
		
	    int returnVal = gestor_archivos.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            gestor_archivos.getSelectedFile().getName());
	    }
	    try {
			this.panel_edit.setPage(gestor_archivos.getSelectedFile().toURI().toURL());
			//this.frame.pack();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
