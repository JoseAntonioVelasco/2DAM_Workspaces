package empresa;
// Generated 14-ene-2021 9:43:59 by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado implements java.io.Serializable {

	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private Set proyectos = new HashSet(0);
	private Set tareas = new HashSet(0);

	public Empleado() {
	}

	public Empleado(String dni, String nombre, String apellidos, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	public Empleado(String dni, String nombre, String apellidos, String telefono, Set proyectos, Set tareas) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.proyectos = proyectos;
		this.tareas = tareas;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Set proyectos) {
		this.proyectos = proyectos;
	}

	public Set getTareas() {
		return this.tareas;
	}

	public void setTareas(Set tareas) {
		this.tareas = tareas;
	}

}
