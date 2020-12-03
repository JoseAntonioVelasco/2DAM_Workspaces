package conexion;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class ORM_relacionesUnoAMuchosv2 {

	public static void main(String[] args) {

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = null;

			try {
				t = s.beginTransaction();

				modelos.Sede sede = new modelos.Sede(5,"VALENCIA");
				s.save(sede);

				modelos.Departamento depto1 = new modelos.Departamento(55,sede, "I+D");
				s.save(depto1);
				sede.getDepartamentos().add(depto1);

				modelos.Departamento depto2 = new modelos.Departamento(56,sede, "MARKETING");
				s.save(depto2);
				sede.getDepartamentos().add(depto2);

				modelos.Departamento depto3 = new modelos.Departamento(57,sede, "QA");
				s.save(depto3);
				sede.getDepartamentos().add(depto3);

				Iterator<modelos.Departamento> itDeptos = sede.getDepartamentos().iterator();

				System.out.println("Nueva sede [" + sede.getIdSede() + "] (" + sede.getNomSede() + ")");
				System.out.println("----------------");

				while (itDeptos.hasNext()) {
					modelos.Departamento unDepto = (modelos.Departamento) itDeptos.next();
					System.out.println("Depto: [" + unDepto.getIdDepto() + "] (" + unDepto.getNomDepto() + ")");
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