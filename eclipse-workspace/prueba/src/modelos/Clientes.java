package modelos;
// Generated 23-nov-2020 12:29:30 by Hibernate Tools 5.4.21.Final

/**
 * Clientes generated by hbm2java
 */
public class Clientes implements java.io.Serializable {

	private String dni;
	private String apellidos;
	private String cp;

	public Clientes() {
	}

	public Clientes(String dni, String apellidos) {
		this.dni = dni;
		this.apellidos = apellidos;
	}

	public Clientes(String dni, String apellidos, String cp) {
		this.dni = dni;
		this.apellidos = apellidos;
		this.cp = cp;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

}
