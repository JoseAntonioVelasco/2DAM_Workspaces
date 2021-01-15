package empresa;
// Generated 30 dic. 2020 19:45:34 by Hibernate Tools 5.4.21.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Proyecto generated by hbm2java
 */
public class Proyecto implements java.io.Serializable {

	private int id;
	private String nombre;
	private int duracion;
	private Date fechIn;
	private Date fechFin;
	private Set tareas = new HashSet(0);
	private Set empleadoProyectos = new HashSet(0);

	public Proyecto() {
	}

	public Proyecto(int id, String nombre, int duracion, Date fechIn) {
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.fechIn = fechIn;
	}

	public Proyecto(int id, String nombre, int duracion, Date fechIn, Date fechFin, Set tareas, Set empleadoProyectos) {
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.fechIn = fechIn;
		this.fechFin = fechFin;
		this.tareas = tareas;
		this.empleadoProyectos = empleadoProyectos;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechIn() {
		return this.fechIn;
	}

	public void setFechIn(Date fechIn) {
		this.fechIn = fechIn;
	}

	public Date getFechFin() {
		return this.fechFin;
	}

	public void setFechFin(Date fechFin) {
		this.fechFin = fechFin;
	}

	public Set getTareas() {
		return this.tareas;
	}

	public void setTareas(Set tareas) {
		this.tareas = tareas;
	}

	public Set getEmpleadoProyectos() {
		return this.empleadoProyectos;
	}

	public void setEmpleadoProyectos(Set empleadoProyectos) {
		this.empleadoProyectos = empleadoProyectos;
	}

}