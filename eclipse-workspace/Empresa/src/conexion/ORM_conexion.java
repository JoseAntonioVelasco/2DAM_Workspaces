package conexion;

import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * 
 * @author JoseAntonioVelasco
 *
 */
public class ORM_conexion {

  public static void main(String[] args) {

    try (Session s = HibernateUtil.getSessionFactory().openSession()) {
      Transaction t = null;
      
      try {
        t = s.beginTransaction();

        modelos.Sede sede = new modelos.Sede();
        sede.setNomSede("MÃ�LAGA");
        s.saveOrUpdate(sede);

        modelos.Departamento depto = new modelos.Departamento();
        depto.setNomDepto("INVESTIGACIÃ“N Y DESARROLLO");
        depto.setSede(sede);
        s.saveOrUpdate(depto);

        
        modelos.Empleado emp = new modelos.Empleado();
		emp.setDni("56789012B");
		emp.setNomEmp("Marco");
		emp.setDepartamento(depto);
		s.saveOrUpdate(emp);

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
