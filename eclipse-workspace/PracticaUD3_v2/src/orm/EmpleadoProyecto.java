package orm;
// Generated 22-dic-2020 9:10:51 by Hibernate Tools 5.4.21.Final

/**
 * EmpleadoProyecto generated by hbm2java
 */
public class EmpleadoProyecto implements java.io.Serializable {

	private EmpleadoProyectoId id;
	private Empleados empleados;
	private Proyectos proyectos;

	public EmpleadoProyecto() {
	}

	public EmpleadoProyecto(EmpleadoProyectoId id, Empleados empleados, Proyectos proyectos) {
		this.id = id;
		this.empleados = empleados;
		this.proyectos = proyectos;
	}

	public EmpleadoProyectoId getId() {
		return this.id;
	}

	public void setId(EmpleadoProyectoId id) {
		this.id = id;
	}

	public Empleados getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
	}

	public Proyectos getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Proyectos proyectos) {
		this.proyectos = proyectos;
	}

}