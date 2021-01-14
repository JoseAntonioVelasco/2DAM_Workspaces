package main;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import empresa.Empleado;
import empresa.Proyecto;
import empresa.Tarea;
import empresa.TareaId;
/**
 * 
 * @author JoseAntonioVelasco
 *
 */
public class Consultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//listadoDetallado(); 
		
		Tarea tar_prueba = new Tarea();
		tar_prueba.setId(new TareaId("Proyecto 0","Analisis"));
		//listadoEmpleadosTarea(tar_prueba);
		//borrarEmpleado("52238279G");
		//borrarTarea(tar_prueba);
		//insertarTarea(tar_prueba);
		//Empleado emp_prueba = new Empleado();
		//emp_prueba.setDni("00000000A");
		//insertarEmpleado(emp_prueba);
		//buscarEmpleado("03153352Z");
		buscarProyecto("Proyecto 1");
		//actualizarTareas("Prueba","Pruebas");
		//eliminarEmpleado("Mediavilla");
	}
	/**
	* Muestra toda la informacion de un proyecto y las tareas que tiene
	*/
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
					System.out.println("\tnombre: "+tarea.getId().getNombre());
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
	/**
	* Muestra los dni de los empleados asignados a esa tarea
	* 
	* @param tarea tarea de lo que queremos ver los dni de los empleados
	*/
	public static void listadoEmpleadosTarea(Tarea tarea) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			Query q = (Query) s.createSQLQuery("SELECT DNI_empleado FROM empleado_tarea WHERE nombre_tarea LIKE ? AND nombre_proyecto_tarea LIKE ?;"
					).setParameter(2,tarea.getId().getNombreProyecto()).setParameter(1, tarea.getId().getNombre());
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
	/**
	 * Borra la tarea que se pase por parametro a la funcion
	 * 
	 * @param tarea tarea que quieres borrar
	 */
	public static void borrarTarea(Tarea tarea) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createSQLQuery("DELETE FROM Tarea WHERE nombre LIKE :nombre AND nombre_proyecto LIKE :nombre_proyecto"
					).setParameter("nombre",tarea.getId().getNombre()).setParameter("nombre_proyecto",tarea.getId().getNombreProyecto());
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
	/**
	 * Borra el empleado que tenga dicho dni
	 * 
	 * @param dni dni del empleado que queremos borrar
	 */
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
	/**
	 * Inserta una tarea a la base de datos
	 * 
	 * @param tarea tarea que quieres insertar
	 */
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
	/**
	 * Inserta un empleado a la base de datos
	 * 
	 * @param empleado empleado que quieres insertar
	 */
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
	/**
	 * Busca empleados con el dni indicado y muestra la informacion sobre ellos y
	 * si tienen tareas asignadas las muestra tambien.
	 * 
	 * @param dni dni del empleado que queremos buscar
	 */
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
	/**
	 * Muestra si es el proyecto esta finalizado y si no lo esta muestra informacion
	 * sobre sus tareas
	 * 
	 * @param nombre nombre del proyecto que queremos buscar
	 */
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
						System.out.println("\tnombre: "+tarea.getId().getNombre());
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
	//HQL
	/**
	 * Cambia el numero de horas de las tareas que tengan el nombre que se indique
	 * 
	 * @param nombre nombre actual de la tarea
	 * @param horas numero de horas que quieres que tenga la tarea
	 */
	public static void actualizarTareas(String nombre,Integer horas) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("UPDATE Tarea SET horas = :horas WHERE nombre LIKE :nombre"
					).setParameter("nombre",nombre).setParameter("horas", horas);

			Integer num=q.executeUpdate();
			System.out.println("Han ocurrido "+num+" cambios");
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
	}
	//HQL
	/**
	 * Elimina todos los empleados que tengan ese apellido
	 * 
	 * @param apellido apellido de los empleado/s que queremos borrar
	 */
	public static void eliminarEmpleado(String apellido) {
		Transaction t = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("DELETE FROM Empleado WHERE apellidos LIKE :apellido"
					).setParameter("apellido",apellido);

			Integer num=q.executeUpdate();
			System.out.println("Han ocurrido "+num+" cambios");

		} catch (Exception e) {
			e.printStackTrace(System.err);
			if (t != null) {
				t.rollback();
			}
		} 
		
	}

}
