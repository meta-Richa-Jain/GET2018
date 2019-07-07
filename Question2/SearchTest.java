import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class SearchTest {
	Search searchNum = new Search();
	private int result;
	
	@Test
	public void testLinearSearchNumberPresent() {
		
		int searchArray[] = {1,3,2,4};
		result = searchNum.linearSearch(searchArray, 3, 0);
		assertEquals(1,result);
	}
	
	@Test
	public void testLinearSearchNumberNotPresent() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.linearSearch(searchArray, 5, 0);
		assertEquals(-1,result);
	}
	
	@Test
	public void testLinearSearchNumberPresentLastIndex() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.linearSearch(searchArray, 4, 0);
		assertEquals(3,result);
	}
	
	@Test
	public void testLinearSearchEmptyArray() {
		
		int searchArray[] = {};
		result = searchNum.linearSearch(searchArray, 2, 0);
		assertEquals(-1,result);
	}
	
	@Test
	public void testBinarySearchNumberPresent() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.binarySearch(searchArray, 2, 0,searchArray.length);
		assertNotEquals(1,result);
	}
	
	@Test
	public void testBinarySearchNumberNotPresent() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.binarySearch(searchArray, 5, 0,searchArray.length);
		assertEquals(-1,result);
	}
	
	@Test
	public void testBinarySearchNumberPresentLastIndex() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.binarySearch(searchArray, 4, 0,searchArray.length);
		assertEquals(3,result);
	}
	
	@Test 
	public void testBinarySearchEmptyArray() {
		
		int searchArray[] = {};
		result = searchNum.binarySearch(searchArray, 2, 0,searchArray.length);
		assertEquals(1,result);
	}

}
