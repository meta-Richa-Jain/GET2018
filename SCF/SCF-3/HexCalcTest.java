import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HexCalcTest {

	HexCalc calc = new HexCalc();
	
	@Test
	public void testAddition() {
		String result = calc.addHexaNum("A", "5");
		assertEquals("F", result);
	}

	@Test
	public void testDivision() {
		String result = calc.divideHexaNum("A", "5");
		assertEquals("2", result);
	}
	
	@Test(expected = AssertionError.class)
	public void testDivisionByZero() {
		String result = calc.divideHexaNum("A", "0");
	}

	@Test
	public void testMultiplication() {
		String result = calc.multiplyHexaNum("A", "5");
		assertEquals("32", result);
	}

	@Test
	public void testMultiplicationZero() {
		String result = calc.multiplyHexaNum("A", "0");
		assertEquals("0", result);
	}
	
	@Test
	public void testSubtraction() {
		String result = calc.subtractHexaNum("A", "5");
		assertEquals("5", result);
	}

	@Test
	public void testEquals() {
		boolean result = calc.equalsHexaNum("A", "a");
		assertEquals(true, result);
	}
	
	@Test
	public void testEqualsZero() {
		boolean result = calc.equalsHexaNum("0", "0");
		assertEquals(true, result);
	}

	@Test
	public void testGreater() {
		boolean result = calc.greaterThanHexaNum("A", "a");
		assertEquals(false, result);
	}
	
	@Test
	public void testGreaterZero() {
		boolean result = calc.greaterThanHexaNum("0", "A");
		assertEquals(false, result);
	}
	
	@Test
	public void testLess() {
		boolean result = calc.lessThanHexaNum("A", "a");
		assertEquals(false, result);
	}
	
	@Test
	public void testLessZero() {
		boolean result = calc.lessThanHexaNum("A", "0");
		assertEquals(false, result);
	}

}
