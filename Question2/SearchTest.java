import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class SearchTest {
	Search searchNum = new Search();
	private int result;
	
	@Test
	public void test1() {
		
		int searchArray[] = {1,3,2,4};
		result = searchNum.linearSearch(searchArray, 3, 0);
		assertEquals(1,result);
	}
	
	@Test
	public void test2() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.linearSearch(searchArray, 5, 0);
		assertEquals(-1,result);
	}
	
	@Test(expected = AssertionError.class) 
	public void test3() {
		
		int searchArray[] = {};
		result = searchNum.linearSearch(searchArray, 2, 0);
		assertNotEquals(2,result);
	}
	
	@Test
	public void test4() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.binarySearch(searchArray, 2, 0,searchArray.length);
		assertNotEquals(1,result);
	}
	
	@Test
	public void test5() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.binarySearch(searchArray, 5, 0,searchArray.length);
		assertNotEquals(4,result);
	}
	
	@Test
	public void test6() {
		
		int searchArray[] = {1,2,3,4};
		result = searchNum.binarySearch(searchArray, 5, 0,searchArray.length);
		assertEquals(-1,result);
	}
	
	@Test(expected = AssertionError.class) 
	public void test7() {
		
		int searchArray[] = {};
		result = searchNum.binarySearch(searchArray, 2, 0,searchArray.length);
		assertNotEquals(2,result);
	}

}
