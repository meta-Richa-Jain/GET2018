import static org.junit.Assert.*;

import org.junit.Test;


public class MathematicalFormulasTest {
	
	MathematicalFormulas formula = new MathematicalFormulas();
	private int result;
	
	@Test
	public void test1() {
		result = formula.findHcf(12, 8);
		assertEquals(4,result);
	}
	
	@Test
	public void test2() {
		result = formula.findHcf(0, 8);
		assertEquals(8,result);
	}
	
	@Test
	public void test3() {
		result = formula.findHcf(12, 0);
		assertEquals(12,result);
	}
	

}
