package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import empresa.Empleado;
import empresa.Proyecto;
import empresa.Tarea;
import empresa.TareaId;
/**
 * 
 * @author JoseAntonioVelasco
 *
 */
public class GenerarDatos {
	private static ArrayList<String> nombres = new ArrayList<String>();
	private static ArrayList<String> apellidos = new ArrayList<String>();
	private static ArrayList<String> nombres_tareas = new ArrayList<String>();
	private static ArrayList<String> estados_tarea = new ArrayList<String>();
	private static ArrayList<Tarea> tareas = new ArrayList<Tarea>();
	private static ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	public static void main(String[] args) {
		llenarNombresApellidosTareas();
		creacionProyectos();
		creacionEmpleados();
		creacionTareas();
		poblarBase();
	}
	/**
	 * Crea y guarda los proyectos en el arraylist de proyectos
	 */
	public static void creacionProyectos() {
		Integer numProyectos = (int)(Math.random() * ((6 - 3) + 1)) + 3;
		long week_ms = 604800000;
		for(int i=0; i<numProyectos; i++) {
			Proyecto proyectoNuevo = new Proyecto();
			//nombre
			String nombre = "Proyecto "+i;
			//duracion
			int duracion = (int)(Math.random() * ((12 - 4) + 1)) + 4;
			//fechIn
			Date fechIn = new Date();
			long ms_fechIn =fechIn.getTime();
			long resta = (long)(Math.random() * (((week_ms*8) - (week_ms*6)) + 1)) + (week_ms*6);
			fechIn.setTime(ms_fechIn-resta);
			//fechFin
			long ms2 = fechIn.getTime();
			long ms_fin = ms2 + week_ms*duracion;
			Date current = new Date();
			if(current.getTime()>ms_fin) {
				Date fechFin = new Date(ms_fin);
				proyectoNuevo.setFechFin(fechFin);
			}
			//añadir al arraylist
			proyectoNuevo.setNombre(nombre);
			proyectoNuevo.setDuracion(duracion);
			proyectoNuevo.setFechIn(fechIn);
			
			if(nombreProyectoRepetido(proyectoNuevo.getNombre())) {
				renombrarProyecto(proyectoNuevo);
				proyectos.add(proyectoNuevo);
			}else {
				proyectos.add(proyectoNuevo);
			}
		}
		
	}
	/**
	 * rellena los arraylist que sirven para generar informacion aleatoria
	 */
	public static void llenarNombresApellidosTareas() {
		nombres.add("Adrian");nombres.add("Gonzalo");nombres.add("Juan");nombres.add("Marco");nombres.add("Diego");
		nombres.add("Maria");nombres.add("Paula");nombres.add("Jose");nombres.add("Elisa");nombres.add("Marina");
		apellidos.add("Montero");apellidos.add("Garcia");apellidos.add("Crespo");apellidos.add("Perez");apellidos.add("Rosina");
		apellidos.add("Velasco");apellidos.add("Rodriguez");apellidos.add("Vaquerizo");apellidos.add("Gonzalez");apellidos.add("Mediavilla");
		nombres_tareas.add("Analisis");nombres_tareas.add("Diseno");nombres_tareas.add("Codificacion");nombres_tareas.add("Pruebas");nombres_tareas.add("Documentacion");
		estados_tarea.add("planificado");estados_tarea.add("empezado");estados_tarea.add("finalizado");
	}
	/**
	 * crea empleados y los guarda en el arraylist de empleados
	 */
	public static void creacionEmpleados() {
		for(int j=0; j<100; j++) {
			Empleado nuevo_empleado = new Empleado();
			
			String[] abcd = {"A","B","C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			int index_nombre = (int)(Math.random() * ((9 - 0) + 1)) + 0;
			int index_apellido = (int)(Math.random() * ((9 - 0) + 1)) + 0;
			
			int num_dni = (int)(Math.random() * ((99999999 - 0) + 1)) + 0;
			String strNum_dni = String.format("%08d", num_dni);
			int index_letra = (int)(Math.random() * ((abcd.length-1 - 0) + 1)) + 0;
			strNum_dni = strNum_dni + abcd[index_letra];
			
			int num_tlfno = (int)(Math.random() * ((999999999 - 0) + 1)) + 0;
			String str_tlfno = String.format("%09d", num_tlfno);
			

			nuevo_empleado.setDni(strNum_dni);
			nuevo_empleado.setNombre(nombres.get(index_nombre));
			nuevo_empleado.setApellidos(apellidos.get(index_apellido));
			nuevo_empleado.setTelefono(str_tlfno);
			//asignar a proyectos aleatoriamente
			int num_proyectos = (int)(Math.random() * ((3 - 0) + 1)) + 0;
			for(int i=0; i<num_proyectos; i++) {
				int index_proyecto = (int)(Math.random() * ((proyectos.size()-1 - 0) + 1)) + 0;
				nuevo_empleado.getProyectos().add(proyectos.get(index_proyecto));
			}
			if(dniRepetido(nuevo_empleado.getDni())) {
				return;
			}
			empleados.add(nuevo_empleado);
		}
	}
	/**
	 * crea tareas y los guarda en el arraylist de tareas
	 */
	public static void creacionTareas() {
		for(int i=0; i<proyectos.size(); i++) {
			int num_tareas = (int)(Math.random() * ((8 - 5) + 1)) + 5;
			Proyecto proyecto = proyectos.get(i);
			for(int j=0; j<num_tareas; j++) {
				Tarea tarea = new Tarea();
				int index_tarea = (int)(Math.random() * ((4 - 0) + 1)) + 0;
				String nombre = nombres_tareas.get(index_tarea);
				int horas = (int)(Math.random() * ((10 - 2) + 1)) + 2;
				String estado = null;
				if(proyecto.getFechFin()!=null) {
					estado = "finalizado";
				}else {
					int index_estado = (int)(Math.random() * ((2 - 0) + 1)) + 0;
					estado = estados_tarea.get(index_estado);
				}
				TareaId tareaid = new TareaId();
				tareaid.setNombre(nombre);
				tareaid.setNombreProyecto(proyecto.getNombre());
				tarea.setHoras(horas);
				
				tarea.setId(tareaid);
				tarea.setEstado(estado);
				tarea.setProyecto(proyecto);
				//empleados
				int num_empleados = (int)(Math.random() * ((2 - 0) + 1)) + 0;
				for(int k=0; k<num_empleados; k++) {
					int index_empleado = (int)(Math.random() * ((empleados.size()-1 - 0) + 1)) + 0;
					//añadimos a la tarea el empleado
					tarea.getEmpleados().add(empleados.get(index_empleado));
				}
				if(nombreTareaProyRepetido(tarea.getId().getNombre(),proyecto)) {
					renombrarTarea(tarea, proyecto);
					tareas.add(tarea);
				}else {
					tareas.add(tarea);
				}
				//añadir la tarea al proyecto
				proyecto.getTareas().add(tarea);
			}
			
		}
		
	}
	
	/**
	 * detecta si un dni esta repetido en los arraylist
	 * 
	 * @param dni dni a buscar si esta repetido
	 * @return true si esta repetido, false si no esta repetido
	 */
	public static boolean dniRepetido(String dni) {
		for(int i=0; i<empleados.size(); i++) {
			Empleado emp = empleados.get(i);
			if(emp.getDni().equals(dni)) {
				return true;
			}	
		}
		return false;
	}
	/**
	 * detecta si un nombre de proyecta esta repetido en los arraylist
	 * 
	 * @param nombre nombre a buscar si esta repetido
	 * @return true si esta repetido, false si no esta repetido
	 */
	public static boolean nombreProyectoRepetido(String nombre) {
		for(int i=0; i<proyectos.size(); i++) {
			Proyecto pryct = proyectos.get(i);
			if(pryct.getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * renombra un proyecto recursivamente hasta que no este repetido
	 * 
	 * @param proy proyecto que queremos renombrar
	 */
	public static void renombrarProyecto(Proyecto proy) {
		proy.setNombre(proy.getNombre().concat(".1"));
		if(nombreProyectoRepetido(proy.getNombre())) {
			renombrarProyecto(proy);
		}
	}
	/**
	 * detecta si el nombre de la tarea esta repetido dentro de dicho proyecto
	 * 
	 * @param nombre nombre de la tarea
	 * @param proy proyecto al que pertenece esa tarea
	 * @return true si esta repetido, false si no esta repetido
	 */
	public static boolean nombreTareaProyRepetido(String nombre,Proyecto proy) {
		Iterator<Tarea> it = proy.getTareas().iterator();
		while(it.hasNext()) {
			Tarea tar = it.next();
			if(tar.getId().getNombre().equals(nombre)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * renombra una tarea recursivamente hasta que no este repetido esa tarea
	 * de ese proyecto.
	 * 
	 * @param tar tarea a renombrar
	 * @param proy proyecto al que pertenece esa tarea
	 */
	public static void renombrarTarea(Tarea tar,Proyecto proy) {
		tar.getId().setNombre(tar.getId().getNombre().concat(" Fase 2"));
		if(nombreTareaProyRepetido(tar.getId().getNombre(),proy)) {
			renombrarTarea(tar,proy);
		}
	}
	/**
	 * Con los arraylist previamente rellenados, los va recorriendo y
	 * guardando en la base de datos
	 */
	public static void poblarBase() {
		//añadir proyectos
		//añadir empleados
		//añadir tareas
	    try (Session s = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction t = null;
	        
	        try {
	          t = s.beginTransaction();
	          
	          for(int i=0; i<proyectos.size();i++) {
	        	  s.save(proyectos.get(i));
	          }
	          for(int i=0; i<empleados.size();i++) {
	        	  s.save(empleados.get(i));
	          }
	          for(int i=0; i<tareas.size();i++) {
	        	  s.save(tareas.get(i));
	          }

	          t.commit();

	        } catch (Exception e) {
	          e.printStackTrace(System.err);
	          if (t != null) {
	            t.rollback();
	          }
	        } finally {
	        	s.close();
	        }
	      }
		
	}
}
