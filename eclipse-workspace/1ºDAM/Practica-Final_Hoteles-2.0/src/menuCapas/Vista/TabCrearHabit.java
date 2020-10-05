package menuCapas.Vista;



import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TabCrearHabit extends JPanel{

	public TabCrearHabit() {
		//numero habitacion
		JPanel numero = new JPanel();
		JLabel num_hab = new JLabel("Numero de Habitacion ");
		JTextField f_num_hab = new JTextField(3);
		numero.add(num_hab);numero.add(f_num_hab);
		
		//radio buttons tipo habitacion
		CrearHabitBotones bot = new CrearHabitBotones();
		
		//Caracteristicas de la habitacion (JCheckboxes)
		CrearHabitCKboxes box = new CrearHabitCKboxes();
		
		if(bot.getT2().isSelected()) {
			box.getBanyo_comp().setEnabled(true);
		}
		else if(bot.getT3().isSelected()) {
			box.getCam_sup().setEnabled(true);
		}
		else if(bot.getT4().isSelected()) {
			box.getCam_sup().setEnabled(true);
			box.getVip().setEnabled(true);
		}
		
		
		//precio dia
		JPanel precio = new JPanel();
		JLabel precio_dia = new JLabel("Precio por dia");
		JTextField f_precio_dia = new JTextField(6);
		precio.add(precio_dia);precio.add(f_precio_dia);
		
		//boton crear habitacion
		JPanel boton = new JPanel();
		JButton crear = new JButton("Crear");
		boton.add(crear);
		boton.setAlignmentX(RIGHT_ALIGNMENT);
	
		
		//añadiendo todo a la habitacion
		this.add(numero);
		this.add(bot);
		this.add(box);
		this.add(precio);
		this.add(crear);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//this.setLayout(new GridLayout(5,1));
		
	}
}
