package ud1_practicas;
import java.io.Serializable;

public class Alumno implements Serializable{
	private String nombre;
	private String apellidos;
	private int notaAD;
	private int notaPSP;
	private int notaSGE;
	public Alumno(String nombre, String apellidos, int notaAD, int notaPSP, int notaSGE) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.notaAD = notaAD;
		this.notaPSP = notaPSP;
		this.notaSGE = notaSGE;
	}
	public Alumno() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getNotaAD() {
		return notaAD;
	}
	public void setNotaAD(int notaAD) {
		this.notaAD = notaAD;
	}
	public int getNotaPSP() {
		return notaPSP;
	}
	public void setNotaPSP(int notaPSP) {
		this.notaPSP = notaPSP;
	}
	public int getNotaSGE() {
		return notaSGE;
	}
	public void setNotaSGE(int notaSGE) {
		this.notaSGE = notaSGE;
	}
	
}