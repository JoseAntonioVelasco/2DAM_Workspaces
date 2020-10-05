import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		
		
		
		Object[] header = new Object[]{"Nombre", "Apellido", "GAY"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		model.addRow(new Object[]{"Paco", "Pedrolo", "Si"});
		model.addRow(new Object[]{"Gorda", "Maricona", "No"});
		
		JTable table = new JTable(model);
		
		p.add(table);
		f.add(p);
		f.pack();
		f.setVisible(true);
	}

}
