package conexion;

import java.util.List;
import java.util.Random;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class ORM_queryConsultaYModificacion {

	public static void main(String[] args) {

		Transaction t = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {

			t = s.beginTransaction();

			Query q = s.createQuery("FROM Empleado");
			List<modelos.Empleado> listaEmp = (List<modelos.Empleado>) q.getResultList();
			Random rand = new Random();
			for (modelos.Empleado unEmp : listaEmp) {
				modelos.EmpleadoDatosProf datosProf = unEmp.getEmpleadoDatosProf();
				if (datosProf == null) {
					datosProf = new modelos.EmpleadoDatosProf();
					datosProf.setEmpleado(unEmp);
					unEmp.setEmpleadoDatosProf(datosProf);
				}
				datosProf.setCategoria("A");
				datosProf.setSueldoBrutoAnual(
						BigDecimal.valueOf(2000000 +
								rand.nextInt(6000000)).movePointLeft(2)
						);
				s.saveOrUpdate(datosProf);
				s.update(unEmp);
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