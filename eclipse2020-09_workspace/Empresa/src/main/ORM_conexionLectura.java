package main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ORM.Sede;

public class ORM_conexionLectura {

  public static void main(String[] args) {

    try (Session s = HibernateUtil.getSessionFactory().openSession()) {
      Transaction t = null;
      
      try {
        t = s.beginTransaction();


        Sede sedeLectura = (Sede)s.get(Sede.class, 1);

        

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
