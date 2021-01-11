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
		
		Tarea tar_prueba = new Tarea();
		tar_prueba.setId(6);
		listadoEmpleadosTarea(tar_prueba);
		//borrarEmpleado("52238279G");
		//borrarTarea(tar_prueba);
		insertarTarea(tar_prueba);
		Empleado emp_prueba = new Empleado();
		insertarEmpleado(emp_prueba);
		buscarEmpleado();
		buscarProyecto();
		actualizarTareas();
		eliminarEmpleado();
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
					+ "INNER JOIN empleado_tarea et ON et.DNI_empleado=e.DNI "
					+ "INNER JOIN Tarea t ON et.id_tarea= :idTarea GROUP BY DNI"
					).setParameter("idTarea",tarea.getId()).setReadOnly(true);
			List<String> empData = q.getResultList();
			System.out.println("Lista los dni de empleados en esa tarea: ");
			for (String row : empData) {
				System.out.println("dni: "+row);
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

			Query q = s.createSQLQuery("DELETE FROM Tarea WHERE id LIKE :patId"
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

			Query q = s.createSQLQuery("DELETE FROM Empleado WHERE DNI LIKE :patDni"
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
			List<Empleado> listaProy = (List<Empleado>) q.getResultList();
			for (Empleado unProy : listaProy) {
				System.out.println("========================================");
				System.out.println("DNI: "+unProy.getDni());
				System.out.println("nombre: "+unProy.getNombre());
				System.out.println("apellidos: "+unProy.getApellidos());
				System.out.println("telefono: "+unProy.getTelefono());
				System.out.println("Proyectos asociados al empleado: ");
				Iterator<Proyecto> itTarea = unProy.getProyectos().iterator();
				while(itTarea.hasNext()) {
					Proyecto tarea = itTarea.next();
					System.out.println("-------------------------------");
					System.out.println("\tnombre: "+tarea.getNombre());
					System.out.println("-------------------------------");
				}
				System.out.println("========================================");
				
			}
			

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
		
	}
	//HQL
	public static void buscarProyecto(String nombre) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("FROM Proyecto WHERE nombre LIKE :nombre"
					).setParameter("nombre",nombre);
			//mostrar datos empleado
			List<Proyecto> listaProy = (List<Proyecto>) q.getResultList();
			for (Proyecto unProy : listaProy) {
				System.out.println("========================================");
				if(unProy.getFechFin()!=null) {
					System.out.println("Finalizado: si");
				}else {
					System.out.println("Finalizado: no");
					System.out.println("Tareas: ");
					Iterator<Tarea> itTarea = unProy.getTareas().iterator();
					while(itTarea.hasNext()) {
						Tarea tarea = itTarea.next();
						System.out.println("-------------------------------");
						System.out.println("\tnombre: "+tarea.getNombre());
						System.out.println("\testado:"+tarea.getEstado());
						System.out.println("-------------------------------");
					}
					System.out.println("========================================");
				}
				System.out.println("========================================");
				
			}
			

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
			
	}
	//HQL TODO
	public static void actualizarTareas(String nombreActual,String nombreNuevo) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("UPDATE Tarea SET nombre = :nombreNuevo WHERE nombre LIKE :nombreActual"
					).setParameter("nombreActual",nombreActual).setParameter("nombreNuevo", nombreNuevo);

			q.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
	}
	//HQL
	public static void eliminarEmpleado(String apellido) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("DELETE FROM Empleado WHERE apellido LIKE :apellido"
					).setParameter("apellido",apellido);

			q.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
		
	}

}
