import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MathematicalFormulasTest {
	
	MathematicalFormulas formula = new MathematicalFormulas();
	private int result;
	
	@Test
	public void testHcfFirstGreaterSecondSmaller() {
		result = formula.findHcf(12, 8);
		assertEquals(4,result);
	}
	
	@Test
	public void testHcfFirstNumberZero() {
		result = formula.findHcf(0, 8);
		assertEquals(8,result);
	}
	
	@Test
	public void testHcfSecondNumberZero() {
		result = formula.findHcf(12, 0);
		assertEquals(12,result);
	}
	
	@Test
	public void testHcfFirstSmallerSecondGreater() {
		result = formula.findHcf(8, 12);
		assertEquals(4,result);
	}
	

	
	@Test
	public void testLcmFirstGreaterSecondSmaller() {
		MathematicalFormulas math = new MathematicalFormulas();
		result = math.findLcm(4, 3);
		assertEquals(12,result);
	}
	
//	@Test
//	public void testLcmFirstSmallerSecondGreater() {
//		result = formula.findLcm(6, 7);
//		assertEquals(42,result);
//	}
	

}