package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import empresa.Empleado;
import empresa.Proyecto;
import empresa.Tarea;

public class GenerarDatos {
	private static ArrayList<String> nombres;
	private static ArrayList<String> apellidos;
	private static ArrayList<String> nombres_tareas;
	private static ArrayList<String> estados_tarea;
	private static ArrayList<Tarea> tareas;
	private static ArrayList<Proyecto> proyectos;
	private static ArrayList<Empleado> empleados;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		llenarNombresApellidosTareas();
		creacionProyectos();
		creacionEmpleados();
		creacionTareas();
		validacionDatos();
	}
	public static void creacionProyectos() {
		Integer numProyectos = (int)(Math.random() * ((6 - 3) + 1)) + 3;
		long week_ms = 604800000;
		for(int i=0; i<numProyectos; i++) {
			Proyecto proyectoNuevo = new Proyecto();
			//id
			int id = i;
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
			proyectoNuevo.setId(id);
			proyectoNuevo.setNombre(nombre);
			proyectoNuevo.setDuracion(duracion);
			proyectoNuevo.setFechIn(fechIn);
			proyectos.add(proyectoNuevo);
		}
		
	}
	public static void llenarNombresApellidosTareas() {
		nombres.add("Adrian");nombres.add("Gonzalo");nombres.add("Juan");nombres.add("Marco");nombres.add("Diego");
		nombres.add("Maria");nombres.add("Paula");nombres.add("Jose");nombres.add("Elisa");nombres.add("Marina");
		apellidos.add("Montero");apellidos.add("Garcia");apellidos.add("Crespo");apellidos.add("Perez");apellidos.add("Rosina");
		apellidos.add("Velasco");apellidos.add("Rodriguez");apellidos.add("Vaquerizo");apellidos.add("Gonzalez");apellidos.add("Mediavilla");
		nombres_tareas.add("Analisis");nombres_tareas.add("Diseno");nombres_tareas.add("Codificacion");nombres_tareas.add("Pruebas");nombres_tareas.add("Documentacion");
		estados_tarea.add("planificado");estados_tarea.add("empezado");estados_tarea.add("finalizado");
	}
	public static void creacionEmpleados() {
		Empleado nuevo_empleado = new Empleado();
		
		String[] abcd = {"A","B","C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		int index_nombre = (int)(Math.random() * ((9 - 0) + 1)) + 0;
		int index_apellido = (int)(Math.random() * ((9 - 0) + 1)) + 0;
		
		int num_dni = (int)(Math.random() * ((99999999 - 0) + 1)) + 0;
		String strNum_dni = String.format("%8d", num_dni);
		int index_letra = (int)(Math.random() * ((abcd.length - 0) + 1)) + 0;
		strNum_dni = strNum_dni + abcd[index_letra];
		
		int num_tlfno = (int)(Math.random() * ((999999999 - 0) + 1)) + 0;
		String str_tlfno = String.format("%9d", num_tlfno);
		
		
		nuevo_empleado.setId(1);
		nuevo_empleado.setDni(strNum_dni);
		nuevo_empleado.setNombre(nombres.get(index_nombre));
		nuevo_empleado.setApellidos(apellidos.get(index_apellido));
		nuevo_empleado.setTelefono(str_tlfno);
		//asignar a proyectos aleatoriamente
		int num_proyectos = (int)(Math.random() * ((3 - 0) + 1)) + 0;
		HashSet setProyectos = new HashSet();
		//un empleado puede estar asignado dos veces al mismo proyecto?
		for(int i=0; i<num_proyectos; i++) {
			int index_proyecto = (int)(Math.random() * ((proyectos.size() - 0) + 1)) + 0;
			setProyectos.add(proyectos.get(index_proyecto));
		}
		nuevo_empleado.setEmpleadoProyectos(setProyectos);
		empleados.add(nuevo_empleado);
	}
	
	public static void creacionTareas() {
		for(int i=0; i<proyectos.size(); i++) {
			int num_tareas = (int)(Math.random() * ((8 - 5) + 1)) + 5;
			Proyecto proyecto = proyectos.get(i);
			for(int j=0; j<num_tareas; j++) {
				Tarea tarea = new Tarea();
				int index_tarea = (int)(Math.random() * ((4 - 0) + 1)) + 0;
				String nombre = nombres_tareas.get(index_tarea);
				int horas = (int)(Math.random() * ((10 - 2) + 1)) + 2;
				int index_proyecto = (int)(Math.random() * ((proyectos.size() - 0) + 1)) + 0;
				String estado = null;
				if(proyecto.getFechFin()!=null) {
					estado = "finalizado";
				}else {
					int index_estado = (int)(Math.random() * ((2 - 0) + 1)) + 0;
					estado = estados_tarea.get(index_estado);
				}
				tarea.setId(nombres_tareas.size());
				tarea.setHoras(horas);
				tarea.setNombre(nombre);
				tarea.setEstado(estado);
				tarea.setProyecto(proyecto);
				//empleados
				HashSet empleadosTarea = new HashSet();
				int num_empleados = (int)(Math.random() * ((2 - 0) + 1)) + 0;
				for(i=0; i<num_empleados; i++) {
					int index_empleado = (int)(Math.random() * ((empleados.size() - 0) + 1)) + 0;
					empleadosTarea.add(empleados.get(index_empleado));
				}
				tarea.setEmpleadoTareas(empleadosTarea);
				tareas.add(tarea);
			}
			
		}
		
	}
	
	public static void validacionDatos() {
		//Comprobamos que no haya empleados con el mismo DNI
		for(int i=0; i<empleados.size(); i++) {
			Empleado emp = empleados.get(i);
			int contador = 0;
			for(int j=0; j<empleados.size();j++) {
				if(emp.getDni()==empleados.get(j).getDni()){
					contador++;
					if(contador>2) {
						empleados.remove(j);
					}
				}
				
			}
		}
		//Comprobamos que no haya proyectos con el mismo nombre
		for(int i=0; i<proyectos.size();i++) {
			Proyecto pryct = proyectos.get(i);
			int contador = 0;
			for(int j=0; j<proyectos.size();j++) {
				if(pryct.getNombre()==proyectos.get(j).getNombre()) {
					contador++;
					if(contador>2) {
						proyectos.get(j).setNombre(proyectos.get(j).getNombre().concat(".1"));
					}
				}
			}
		}
		//Comprobamos que no haya tareas con el mismo nombre en el mismo proyecto
		for(int i =0; i<proyectos.size(); i++) {
			Proyecto pryct = proyectos.get(i);
			Tarea[] tareas=(Tarea[]) pryct.getTareas().toArray();
			
			for(int j=0; j<tareas.length; j++) {
				int contador = 0;
				for(int k=0;k<tareas.length; k++) {
					if(tareas[j].getNombre()==tareas[k].getNombre()) {
						contador++;
						if(contador>2) {
							tareas[k].setNombre(tareas[k].getNombre().concat(" Fase 2"));
						}
					}
				}
			}
		}
	}
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
	        }
	      }
		
	}
}
