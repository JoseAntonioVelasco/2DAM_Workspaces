package empresa;
// Generated 29 dic. 2020 19:47:50 by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Departamento generated by hbm2java
 */
public class Departamento implements java.io.Serializable {

	private int idDepto;
	private Sede sede;
	private String nomDepto;
	private Set empleados = new HashSet(0);

	public Departamento() {
	}

	public Departamento(int idDepto, Sede sede, String nomDepto) {
		this.idDepto = idDepto;
		this.sede = sede;
		this.nomDepto = nomDepto;
	}

	public Departamento(int idDepto, Sede sede, String nomDepto, Set empleados) {
		this.idDepto = idDepto;
		this.sede = sede;
		this.nomDepto = nomDepto;
		this.empleados = empleados;
	}

	public int getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(int idDepto) {
		this.idDepto = idDepto;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public String getNomDepto() {
		return this.nomDepto;
	}

	public void setNomDepto(String nomDepto) {
		this.nomDepto = nomDepto;
	}

	public Set getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set empleados) {
		this.empleados = empleados;
	}

}
