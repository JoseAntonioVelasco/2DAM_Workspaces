package principal;



import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{
	public Ventana() {
		super("Buscar una palabra en un texto");
		
		String texto="      TEXTO QUE SALE POR DEFECTO, PUEDES INTRODUCIR EL TUYO PROPIO\n"
				+ "La sal com�n o sal de mesa, conocida popularmente como sal, es un tipo de sal denominada\n"
				+ " cloruro s�dico (o cloruro de sodio), cuya f�rmula qu�mica es NaCl. Existen tres tipos de sal\n"
				+ " com�n, seg�n su procedencia: la sal marina y la de manantial, que se obtienen por evaporaci�n;\n"
				+ " la sal gema, que procede de la extracci�n minera de una roca mineral denominada halita, y la\n"
				+ " sal vegetal, que se obtiene por concentraci�n, al hervir una planta gram�nea (m�todo tambi�n \n"
				+ "utilizado para la obtenci�n de az�car a partir de otra planta gram�nea) que crece en el desierto\n";
		JPanel panel = new JPanel();
		JTextArea textArea = new JTextArea(10,50);
		textArea.setLineWrap(true);
		textArea.setText(texto);
		textArea.setEditable(true);
		
		JPanel panel_texto = new JPanel();
		panel_texto.add(textArea);
		panel_texto.setBorder(new EmptyBorder(10, 20, 5, 20));
		
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new GestorBuscar(textArea));
		panel.setBorder(new EmptyBorder(0, 0, 5, 0));
		
		panel.add(panel_texto);
		panel.add(buscar);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		
		
		this.setContentPane(panel);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.pack();
		
		
	}
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
	}
}
