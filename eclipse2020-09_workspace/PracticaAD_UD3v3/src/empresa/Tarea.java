package empresa;
// Generated 5 ene. 2021 20:44:22 by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Tarea generated by hbm2java
 */
public class Tarea implements java.io.Serializable {

	private int id;
	private Proyecto proyecto;
	private String nombre;
	private String estado;
	private int horas;
	private Set empleados = new HashSet(0);

	public Tarea() {
	}

	public Tarea(int id, Proyecto proyecto, String nombre, int horas) {
		this.id = id;
		this.proyecto = proyecto;
		this.nombre = nombre;
		this.horas = horas;
	}

	public Tarea(int id, Proyecto proyecto, String nombre, String estado, int horas, Set empleados) {
		this.id = id;
		this.proyecto = proyecto;
		this.nombre = nombre;
		this.estado = estado;
		this.horas = horas;
		this.empleados = empleados;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getHoras() {
		return this.horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Set getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set empleados) {
		this.empleados = empleados;
	}

}