package empresa;
// Generated 14-ene-2021 9:44:48 by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Tarea generated by hbm2java
 */
public class Tarea implements java.io.Serializable {

	private TareaId id;
	private Proyecto proyecto;
	private String estado;
	private int horas;
	private Set empleados = new HashSet(0);

	public Tarea() {
	}

	public Tarea(TareaId id, Proyecto proyecto, int horas) {
		this.id = id;
		this.proyecto = proyecto;
		this.horas = horas;
	}

	public Tarea(TareaId id, Proyecto proyecto, String estado, int horas, Set empleados) {
		this.id = id;
		this.proyecto = proyecto;
		this.estado = estado;
		this.horas = horas;
		this.empleados = empleados;
	}

	public TareaId getId() {
		return this.id;
	}

	public void setId(TareaId id) {
		this.id = id;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
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
