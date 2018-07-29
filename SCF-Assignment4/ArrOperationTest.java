import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Test;

public class ArrOperationTest {

ArrOperation arrOperate = new ArrOperation();
private int result;
private int inputArray[];
private int result2[];
	
	@Test
	public void testSplitArrayPositiveSmallArray() {
		
		inputArray = new int[]{10,10};
		result = arrOperate.splitArrayFunction(inputArray);
		assertEquals(1,result);
	}
	
	@Test
	public void testSplitArraySplitNotPossible() {
		inputArray = new int[]{10,10,1,1};
		result = arrOperate.splitArrayFunction(inputArray);
		assertEquals(-1,result);
	}
	
	@Test(expected = AssertionError.class) 
	public void testSplitArrayEmpty() {
		inputArray = new int[]{};
		result = arrOperate.splitArrayFunction(inputArray);
	}
	
	@Test
	public void testClumpsPositiveSmallArray() {
		inputArray = new int[]{1,2,1,1,5,3};
		result = arrOperate.totalClumps(inputArray);
		assertEquals(1,result);
	}
	
	@Test
	public void testClumpsPositiveLongArray() {
		inputArray = new int[]{1,2,2,2,1,1,5,3};
		result = arrOperate.totalClumps(inputArray);
		assertEquals(2,result);
	}
	
	@Test(expected = AssertionError.class) 
	public void testClumpsPositiveEmpty() {
		inputArray = new int[]{};
		result = arrOperate.totalClumps(inputArray);
	}
	
	@Test
	public void testMaxMirrorPositiveSmallArray() {
		inputArray = new int[]{1,2,3,3,2,1};
		result = arrOperate.maxMirror(inputArray);
		assertEquals(6,result);
	}
	
	@Test
	public void testMaxMirrorPositiveLongArray() {
		inputArray = new int[]{3,2,5,1,2,3,4,2,1};
		result = arrOperate.maxMirror(inputArray);
		assertEquals(2,result);
	}
	
	@Test(expected = AssertionError.class) 
	public void testMaxMirrorEmpty() {
		inputArray = new int[]{};
		result = arrOperate.maxMirror(inputArray);
	}
	
	// fixXY
	
	@Test
	public void testFixXYPositiveSmallArray() {
		inputArray = new int[]{5,4,9};
		result2 = arrOperate.fixXY(inputArray,4,5);
		Assert.assertArrayEquals(new int[]{9,4,5},result2);
	}
	
	@Test(expected = AssertionError.class) 
	public void testAdjacentX() {
		inputArray = new int[]{1,2,3,4,4,5,6,5};
		result2 = arrOperate.fixXY(inputArray,4,5);
	}
	
	@Test(expected = AssertionError.class) 
	public void testLastX() {
		inputArray = new int[]{1,5,3,4,5,6,4};
		result2 = arrOperate.fixXY(inputArray,4,5);
	}
	
	@Test(expected = AssertionError.class) 
	public void testUnequalXY() {
		inputArray = new int[]{1,4,3,4,5,6};
		result2 = arrOperate.fixXY(inputArray,4,5);
	}
	
	@Test(expected = AssertionError.class) 
	public void testXYEquals() {
		inputArray = new int[]{5,4,9};
		result2 = arrOperate.fixXY(inputArray,4,4);
		Assert.assertArrayEquals(new int[]{9,4,5},result2);
	}
	
	@Test(expected = AssertionError.class) 
	public void testEmptyArray() {
		inputArray = new int[]{};
		result2 = arrOperate.fixXY(inputArray,4,5);
	}
	

}
