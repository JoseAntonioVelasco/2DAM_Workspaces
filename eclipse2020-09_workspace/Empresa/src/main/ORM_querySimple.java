package conexion;
import java.util.List;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class ORM_querySimple {



	public static void main(String[] args) {

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {

			System.out.println("Nombre del departamento que quieres buscar: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String nomDepto = br.readLine();

			Query q = s.createQuery("FROM Departamento WHERE nomDepto LIKE :patNombre"
					).setParameter("patNombre", "%" + nomDepto + "%").setReadOnly(true);

			List<ORM.Departamento> listaDep = (List<ORM.Departamento>) q.getResultList();

			for (ORM.Departamento unDepto : listaDep) {
				System.out.println("Depto: [" + unDepto.getIdDepto() + "] (" + unDepto.getNomDepto() + ")");
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
