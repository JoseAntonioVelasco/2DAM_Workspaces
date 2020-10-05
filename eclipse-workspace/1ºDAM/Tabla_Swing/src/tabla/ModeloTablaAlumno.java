package tabla;

import java.util.LinkedList;

import javax.swing.table.TableModel;

public class ModeloTablaAlumno implements TableModel{
	public static int COLUMNAS=5;
	
	private LinkedList datos = new LinkedList();
	private LinkedList listeners = new LinkedList();
	
	public int getColumnCount() {return COLUMNAS;}
	public int getRowCount() {return datos.size();}
	
	public Object getValueAt(int IndiceFila,int IndiceColumna) {
		Alumno aux = (Alumno)(datos.get(IndiceFila));
		
		switch(IndiceColumna) {
		case 0: ret
		}
	}
}
