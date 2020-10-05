import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

public class TablaEnterosTest {
	private static  TablaEnteros tabla;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Integer[] enteros = {1,2,3};
		tabla = new TablaEnteros(enteros);
		
	}
	@Test
	public void testConstructorNulo() {
		Integer[] enteros = {};
		tabla = new TablaEnteros(enteros);
	}
	@Test
	public void testConstructorLon0() {
		Integer[] enteros=null;
		tabla = new TablaEnteros(enteros);
	}
	@Test
	public void testSumaTabla() {
		int suma=tabla.sumaTabla();
		assertEquals(6, suma);
	}
	@Test
	public void testMayorTabla() {
		int mayor=tabla.mayorTabla();
		assertEquals(3, mayor);
	}
	@Test
	public void testPosicionTabla() {
		int pos=tabla.posicionTabla(1);
		assertEquals(0, pos);
	}

}
