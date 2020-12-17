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

			Query q = s.createQuery("FROM Departamento WHERE nomDepto LIKE ?0"
					).setParameter(0,nomDepto).setReadOnly(true);

			List<modelos.Departamento> listaDep = (List<modelos.Departamento>) q.getResultList();

			for (modelos.Departamento unDepto : listaDep) {
				System.out.println("Depto: [" + unDepto.getIdDepto() + "] (" + unDepto.getNomDepto() + ")");
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
