package conexion;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ORM_conexionLectura {

  public static void main(String[] args) {

    try (Session s = HibernateUtil.getSessionFactory().openSession()) {
      Transaction t = null;
      
      try {
        t = s.beginTransaction();


        modelos.Sede sedeLectura = (modelos.Sede)s.get(modelos.Sede.class, 0);

        

        t.commit();
        System.out.println(sedeLectura.getNomSede());

      } catch (Exception e) {
        e.printStackTrace(System.err);
        if (t != null) {
          t.rollback();
        }
      }
    }
  }
  
}
