package calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class CalculadoraTest {
	Calculadora instance;
	
	@Before
	public void crearCalculadura() {instance = new Calculadora();}
	@After
	public void borrarCalculadora() {instance = null;}
	@Test
	
	void testSuma() {
		System.out.println("Prueba de suma");
		int a =0;
		int b=0;
		//Calculadora instance = new Calculadora();
		int expResult=0;
		int result=instance.suma(a,b);
		assertEquals(expResult,result);
		//fail("Not yet implemented");
	}
	/*
	@Test
	void testResta() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiplicacion() {
		fail("Not yet implemented");
	}

	@Test
	void testDivision() {
		fail("Not yet implemented");
	}
	*/
}
