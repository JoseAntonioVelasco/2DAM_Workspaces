import javax.swing.JButton;
import javax.swing.JFrame;

public class Vista extends JFrame{
	public Vista() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton color = new JButton("Color");
		color.addActionListener(new GestorColor(this));
		
		JButton fichero = new JButton("Fichero");
		fichero.addActionListener(new GestorFichero(this));
		
		JButton opciones1 = new JButton("Opciones 1");
		opciones1.addActionListener(new GestorOpciones1(this));
		
		JButton input = new JButton("Introduce");
		input.addActionListener(new GestorInput(this));
		
		JButton opciones2 = new JButton("Opciones 2");
		opciones2.addActionListener(new GestorOpciones2(this));
		
		JButton aviso = new JButton("Aviso");
		aviso.addActionListener(new GestorAviso(this));
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new GestorAceptar(this));
		
		this.setLayout(null);
		
		color.setBounds(50, 10, 100, 30);
		fichero.setBounds(50,50,100,30);
		opciones1.setBounds(50,90,100,30);
		input.setBounds(50,130,100,30);
		opciones2.setBounds(50,170,100,30);
		aviso.setBounds(50,210,100,30);
		confirmar.setBounds(50,250,100,30);
		
		this.add(color);
		this.add(fichero);
		this.add(opciones1);
		this.add(input);
		this.add(opciones2);
		this.add(aviso);
		this.add(confirmar);
		
		this.setSize(200,310);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
