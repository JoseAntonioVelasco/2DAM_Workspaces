package main;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ORM_conexion {

  public static void main(String[] args) {

    try (Session s = HibernateUtil.getSessionFactory().openSession()) {
      Transaction t = null;
      
      try {
        t = s.beginTransaction();
        

        empresa.Sede sede = new empresa.Sede();
//        sede.setIdSede(1);
        sede.setNomSede("MALAGA_3");
        s.save(sede);
        
        System.out.println("Id de sede: "+sede.getIdSede());
//        ORM.Departamento depto = new ORM.Departamento();
//        depto.setNomDepto("INVESTIGACION Y DESARROLLO");
//        depto.setSede(sede);
//        System.out.println("Id de sede en depto: "+depto.getSede().getIdSede());

        empresa.Departamento depto = new empresa.Departamento();
        depto.setNomDepto("INVESTIGACIÓN Y DESARROLLO_3");
        depto.setSede(sede);
        System.out.println("Id de sede en depto: "+depto.getSede().getIdSede());

        s.save(depto);

        empresa.Empleado emp = new empresa.Empleado();
        emp.setDni("56789012Z");
        emp.setNomEmp("SAMPER3");
        emp.setDepartamento(depto);
        s.save(emp);

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
