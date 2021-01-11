package main;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import empresa.Empleado;
import empresa.Proyecto;
import empresa.Tarea;
/**
 * 
 * @author JoseAntonioVelasco
 *
 */
public class Consultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listadoDetallado();
		
		Tarea prueba = new Tarea();
		prueba.setId(23);
		listadoEmpleadosTarea(prueba);
		//borrarEmpleado("52238279G");
		//borrarTarea(prueba);

	}
	public static void listadoDetallado() {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			Query q = s.createQuery("FROM Proyecto");

			List<Proyecto> listaProy = (List<Proyecto>) q.getResultList();

			for (Proyecto unProy : listaProy) {
				System.out.println("========================================");
				System.out.println("nombre: "+unProy.getNombre());
				System.out.println("duracion(semanas): "+unProy.getDuracion());
				System.out.println("fecha inicio: "+unProy.getFechIn());
				System.out.println("fecha final: "+unProy.getFechFin());
				System.out.println("Tareas asociadas al proyecto: ");
				Iterator<Tarea> itTarea = unProy.getTareas().iterator();
				while(itTarea.hasNext()) {
					Tarea tarea = itTarea.next();
					System.out.println("-------------------------------");
					System.out.println("\tid: "+tarea.getId());
					System.out.println("\tnombre: "+tarea.getNombre());
					System.out.println("\testado:"+tarea.getEstado());
					System.out.println("-------------------------------");
				}
				System.out.println("========================================");
				
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	//SQL
	public static void listadoEmpleadosTarea(Tarea tarea) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {


			Query q = s.createSQLQuery("SELECT DNI FROM Empleado e "
					+ "INNER JOIN empleado_tarea et ON et.id_empleado=e.id "
					+ "INNER JOIN Tarea t ON et.id_tarea= :idTarea"
					).setParameter("idTarea",tarea.getId()).setReadOnly(true);

			List<Tarea> listaTarea = (List<Tarea>) q.getResultList();
			
			System.out.println("Lista los dni de empleados en esa tarea: ");
			for (Tarea unTarea : listaTarea) {
				Iterator<Empleado> itEmpleado = unTarea.getEmpleados().iterator();
				while(itEmpleado.hasNext()) {
					Empleado empleado = itEmpleado.next();
					System.out.println("dni: "+empleado.getDni());
				}
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	//SQL
	public static void borrarTarea(Tarea tarea) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("DELETE Tarea WHERE id LIKE :patId"
					).setParameter("patId",tarea.getId());
			int numObj = q.executeUpdate();
			System.out.println(numObj + " tareas borradas.");

			t.commit();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
	}
	//SQL
	public static void borrarEmpleado(String dni) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("DELETE Empleado WHERE DNI LIKE :patDni"
					).setParameter("patDni",dni);
			int numObj = q.executeUpdate();
			System.out.println(numObj + " empleados borrados.");

			t.commit();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
		
	}
	//SQL
	public static void insertarTarea(Tarea tarea) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			s.save(tarea);

			t.commit();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
	}
	//SQL
	public static void insertarEmpleado(Empleado empleado) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			s.save(empleado);

			t.commit();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
		
	}
	//HQL
	public static void buscarEmpleado(String dni) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("FROM Empleado WHERE DNI LIKE :patDni"
					).setParameter("patDni",dni);
			//mostrar datos empleado

			t.commit();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
		
	}
	//HQL
	public static void buscarProyecto(String nombre) {
		
	}
	//HQL
	public static void actualizarTareas(String nombreActual,String nombreNuevo) {
		
	}
	//HQL
	public static void eliminarEmpleado(String apellido) {
		
	}

}
