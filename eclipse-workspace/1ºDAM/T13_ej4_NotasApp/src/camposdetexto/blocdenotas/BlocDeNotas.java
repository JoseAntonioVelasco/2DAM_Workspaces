package camposdetexto.blocdenotas;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BlocDeNotas extends JFrame{
	
	public BlocDeNotas() {
		super("Bloc de notas");
		//global
		JPanel global = new JPanel();
		//arriba
		JPanel arriba = new JPanel();
		
		JLabel nom = new JLabel("Nombre ");
		JTextField nom_field = new JTextField(12);
		arriba.add(nom);arriba.add(nom_field);
		
		//texto
		String texto = "\nTexto que viene por defecto\n"
				+ "haciendo deberes\n"
				+ "sdoijgsodigoois\n"
				+ "adios\n";
		JTextArea area_texto = new JTextArea(5,10);
		area_texto.setText(texto);
		area_texto.setEditable(true);
		
		//botones
		JPanel botones = new JPanel();
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new GestorLimpiar(area_texto));
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(new GestorGuardar(area_texto,nom_field));
		JButton salir = new JButton("Salir");
		salir.addActionListener(new GestorSalir());
		
		botones.add(limpiar);botones.add(guardar);botones.add(salir);
		botones.setLayout(new FlowLayout());
		
		//añadimos todo
		global.add(arriba);global.add(area_texto);global.add(botones);
		this.setContentPane(global);
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
	}
	public static void main(String[] args) {
		BlocDeNotas bloc = new BlocDeNotas();
		bloc.setVisible(true);
	}
}
