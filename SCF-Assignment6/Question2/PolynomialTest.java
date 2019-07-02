package Question2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class PolynomialTest {

Poly polyObj1;
Poly polyObj2;
	
	@Test
	public void testForEvaluate() {
		polyObj1 = new Poly( new int[][]{ { 3, 3 }, { 2, 2 }, { 3, 0 } });
		float value = polyObj1.evaluate(1);
		assertEquals(8, value,0);
	}
	
	@Test
	public void testForEvaluateRandomOrder() {
		polyObj1 = new Poly( new int[][]{  { 2,0 }, { 1, 2 }, { 3, 1 } });
		float value = polyObj1.evaluate(2);
		assertEquals(12, value,0);
	}
	
	@Test
	public void testForDegreeRandomOrder() {
		polyObj1 = new Poly( new int[][]{  { 2,0 }, { 1, 2 }, { 3, 1 } });
		int degree = polyObj1.degree();
		assertEquals(2,degree);
	}
	
	@Test
	public void testForDegree() {
		polyObj1 = new Poly( new int[][]{ { 3, 3 }, { 2, 2 }, { 3, 0 } });
		int degree = polyObj1.degree();
		assertEquals(3,degree);
	}
	
	@Test
	public void testForZeroDegree() {
		polyObj1 = new Poly( new int[][]{ { 0, 0 } });
		int degree = polyObj1.degree();
		assertEquals(0,degree);
	}
	
	@Test
	public void testForAddition() {
		polyObj1 = new Poly( new int[][]{ { 3, 3 }, { 2, 2 }, { 3, 0 } });
		polyObj2 = new Poly( new int[][]{ { 3, 3 }, { 2, 1 } });
		int result[][] = new int[][]{{6,3},{2,2},{2,1},{3,0}};
		Poly poly = polyObj1.addPoly(polyObj1, polyObj2);
		assertTrue(Arrays.deepEquals(result, poly.getPolyArray()));
	}

	@Test
	public void testForAdditionRandomOrder() {
		polyObj1 = new Poly( new int[][]{ { 3, 3 }, { 2, 2 }, { 3, 0 } });
		polyObj2 = new Poly( new int[][]{  { 2, 1 },{ 3, 3 }});
		int result[][] = new int[][]{{6,3},{2,2},{2,1},{3,0}};
		Poly poly = polyObj1.addPoly(polyObj1, polyObj2);
		assertTrue(Arrays.deepEquals(result, poly.getPolyArray()));
	}
	
	@Test
	public void testForMultiplication() {
		polyObj1 = new Poly( new int[][]{ { 3, 3 }, { 2, 2 }, { 3, 0 } });
		polyObj2 = new Poly( new int[][]{ { 3, 3 }, { 2, 1 } });
		int result[][] = new int[][]{{9,6},{6,5},{6,4},{13,3},{6,1}};
		Poly poly = polyObj1.multiplyPoly(polyObj1, polyObj2);
		assertTrue(Arrays.deepEquals(result, poly.getPolyArray()));
	}
	
	@Test
	public void testForMultiplicationRandomOrder() {
		polyObj1 = new Poly( new int[][]{ { 3, 3 }, { 2, 2 }, { 3, 0 } });
		polyObj2 = new Poly( new int[][]{ { 2, 1 }, { 3, 3 } });
		int result[][] = new int[][]{{9,6},{6,5},{6,4},{13,3},{6,1}};
		Poly poly = polyObj1.multiplyPoly(polyObj1, polyObj2);
		assertTrue(Arrays.deepEquals(result, poly.getPolyArray()));
	}

}
