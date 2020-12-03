package conexion;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class ORM_relacionesUnoAMuchos {


	public static void main(String[] args) {

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			Transaction t = null;
			try {

				t = s.beginTransaction();

				modelos.Sede sede = new modelos.Sede(77,"TERUEL");
				s.save(sede);

				modelos.Departamento depto = new modelos.Departamento();
				depto.setNomDepto("I+D");
				depto.setSede(sede);
				s.save(depto);

				depto = new modelos.Departamento(78,sede, "MARKETING");
				s.save(depto);

				depto = new modelos.Departamento(79,sede, "QA");
				s.save(depto);

				//s.refresh(sede);

				Iterator itDeptos = sede.getDepartamentos().iterator();

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