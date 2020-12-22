package conexion;




import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import orm.Empleados;

public class Prueba {
	 public static void main(String[] args) {

		    try (Session s = HibernateUtil.getSessionFactory().openSession()) {
		      Transaction t = null;
		      
		      try {
		        t = s.beginTransaction();


		        orm.Empleados emp = new orm.Empleados();
				emp.setDni("56789012B");
				emp.setNombre("Marco");
				emp.setApellidos("aaa");
				emp.setTelefono(1235);
				s.saveOrUpdate(emp);

				orm.Tareas tar = new orm.Tareas();
				Set setA = new HashSet();
				setA.add(emp);
				tar.setEmpleadoTareas(setA);
				tar.setEstado("Empezado");
				tar.setHoras(2);
				tar.setNombre("aa");
				
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
