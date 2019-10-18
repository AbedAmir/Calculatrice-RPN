package Test;
import default_package.Operation;
import static org.junit.Assert.*;

import org.junit.Test;

public class OperationTest {
	float a=10;
	float b=5;
	@Test
	public void testAddition() {
		assertEquals(a+b, Operation.PLUS.eval(a, b),0);
	}
	
	@Test
	public void testSoustraction() {
		assertEquals(a-b, Operation.MOINS.eval(a, b),0);
	}
	
	@Test
	public void testMultiplication() {
		assertEquals(a*b, Operation.MULT.eval(a, b),0);
	}
	
	@Test
	public void testDivision() {
		assertEquals(a/b, Operation.DIV.eval(a, b),0);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDivisionSurZero() throws ArithmeticException{
		//System.out.println(5/0);
		a=Operation.DIV.eval(a, 0);
	}

}
