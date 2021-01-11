package conexion;


import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ORM_relacionesUnoAUno {

	public static void main(String[] args) {

		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = null;

			try {
				t = s.beginTransaction();

				ORM.Departamento depto = s.get(ORM.Departamento.class, 1);

				ORM.Empleado emp = new ORM.Empleado();
				emp.setDni("76543210S");
				emp.setDepartamento(depto);
				emp.setNomEmp("SILVA");
				s.save(emp);

				ORM.EmpleadoDatosProf datosProf = new ORM.EmpleadoDatosProf();
				datosProf.setEmpleado(emp);
				datosProf.setCategoria("A");
				datosProf.setSueldoBrutoAnual(new BigDecimal(52000.0));
				s.save(datosProf);

				t.commit();

				s.refresh(emp);
				System.out.println("Categoría del nuevo empleado: " + emp.getEmpleadoDatosProf().getCategoria()
						+ ", DNI: " + emp.getEmpleadoDatosProf().getDni());

			} catch (Exception e) {
				e.printStackTrace(System.err);
				if (t != null) {
					t.rollback();
				}
			}
		}
	}

}

//		  double a=0.03;
//        double b=0.04;
//        double c=b-a;
//        System.out.println(c);
////Resultado: 0.009999999999999998
//BigDecimal _a = new BigDecimal("0.03");
//        BigDecimal _b = new BigDecimal("0.04");
//        BigDecimal _c = _b.subtract(_a);
//        System.out.println(_c);
////REsultado: 0.01
