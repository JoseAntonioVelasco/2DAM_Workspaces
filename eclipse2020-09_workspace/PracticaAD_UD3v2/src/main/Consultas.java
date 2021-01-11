package main;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import empresa.Empleado;
import empresa.Proyecto;
import empresa.Tarea;

public class Consultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listadoDetallado();

	}
	public static void listadoDetallado() {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			Query q = s.createQuery("FROM Proyecto");

			List<Proyecto> listaProy = (List<Proyecto>) q.getResultList();

			for (Proyecto unProy : listaProy) {
				System.out.println("Proy");
				System.out.println(unProy.getId());
				System.out.println(unProy.getEmpleadoProyectos().size());
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	public static void listadoEmpleadosTarea() {
		
	}
	public static void borrarTarea(Tarea tarea) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("DELETE Departamento WHERE nomDepto='ESTO NO SE BORRA PORQUE NO EXISTE'");
			int numObj = q.executeUpdate();
			System.out.println(numObj + " objetos borrados.");

			t.commit();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
	}
	public static void borrarEmpleado(String dni) {
		
	}
	public static void insertarTarea(Tarea tarea) {
		
	}
	public static void insertarEmpleado(Empleado empleado) {
		
	}
	public static void buscarEmpleado(String dni) {
		
	}
	public static void buscarProyecto(String nombre) {
		
	}
	public static void actualizarTareas(String nombreActual,String nombreNuevo) {
		
	}
	public static void eliminarEmpleado(String apellido) {
		
	}

}
