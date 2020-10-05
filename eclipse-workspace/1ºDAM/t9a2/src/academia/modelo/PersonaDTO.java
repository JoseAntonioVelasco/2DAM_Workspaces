package academia.modelo;

import java.util.ArrayList;

public class PersonaDTO {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String DNI;
	private UsuarioDTO usuActual;
	private ArrayList<MatriculaDTO> matriculas;
	/**
	 * Constructor de la clase PersonaDTO
	 * @param nombre nombre de la persona
	 * @param apellido1 primer apellido de la persona
	 * @param apellido2 segundo apellido de la persona
	 * @param DNI DNI de la persona
	 * @param usuActual usuario de la persona
	 * @param matriculas matriculas a las que esta matriculado esa persona
	 */
	public PersonaDTO(String nombre,String apellido1,String apellido2,String DNI,UsuarioDTO usuActual, ArrayList<MatriculaDTO> matriculas) {
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.DNI=DNI;
		this.usuActual=usuActual;
		this.matriculas=matriculas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public UsuarioDTO getUsuActual() {
		return usuActual;
	}
	
	public void setUsuActual(UsuarioDTO usuActual) {
		this.usuActual = usuActual;
	}
	
	public ArrayList<MatriculaDTO> getMatriculas() {
		return matriculas;
	}
	
	public void setMatriculas(ArrayList<MatriculaDTO> matriculas) {
		this.matriculas = matriculas;
	}


}
