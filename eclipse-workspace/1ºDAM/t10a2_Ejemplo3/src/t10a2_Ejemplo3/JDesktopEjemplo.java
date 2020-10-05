package t10a2_Ejemplo3;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class JDesktopEjemplo extends JDesktopPane{
	//ventanas que se van a crear dentro de una ventana
	JInternalFrame m1,m2;
	
	public JDesktopEjemplo() {
		//ventana que va a tener un MarcoBotones y va a aparecer en esa sitio con respecto a la ventana que lo contiene
		m1= new MarcoBotones();
		m1.setLocation(200,100);
		//ventana que va a tener un MarcoTexto y va a aparecer en esa sitio con respecto a la ventana que lo contiene
		m2=new MarcoTexto();
		m2.setLocation(10,10);
		//se añade los componentes
		add(m1);
		add(m2);
	}
	
	static public void main(String[] args) {
		//el invokeLater hace que despues de que todos los hilos hayan sido procesados se ejecute este
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				//se crea la ventana Escritorio que contendra las otras dos ventanas
				JFrame jf = new JFrame("Escritorio");
				//tamaño de la ventana
				jf.setBounds(10,10,650,300);
				//se cierra el programa al cerrarse la ventana
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//dentro de esta ventana va a ver JDesktopEjemplo que genera las dos ventanas anteriormente dichas
				jf.setContentPane(new JDesktopEjemplo());
				//se hace visible la ventana
				jf.setVisible(true);
			}
		});
		
	}
}
