package calculadora;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculadoraTest4Resta {
	public static Calculadora instance;
	private int num1, num2, result;
	
	public CalculadoraTest4Resta(int num1, int num2, int result) {
		this.num1=num1;
		this.num2=num2;
		this.result=result;
	}
	
	@Parameters
	public static Collection<Object[]> numeros(){
		return Arrays.asList(new Object[][] {{2,2,0},{12,11,3},{3,5,-2}});
	}
	
	@BeforeClass
	public static void creaCalculadora() {instance = new Calculadora();}
	
	@Test
	public void testResta() {
		//fail("Not yet implemented");
		System.out.println("Prueba resta varios parametros: "+this.num1+" - "+this.num2+" = "+this.result);
		int result = instance.resta(this.num1, this.num2);
		assertEquals(this.result, result);
	}

}

