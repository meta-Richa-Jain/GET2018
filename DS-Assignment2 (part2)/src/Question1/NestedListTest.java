package Question1;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NestedListTest {

	NestedListOperations list = new NestedListOperations();
	
	
	@Test
	public void testSum() throws InvalidInput {
		
		Object[] array = new Object[4];
		array[0] = 1;
		Object[] sublist = new Object[4];
		sublist[0] = 2;
		sublist[1] = 3;
		sublist[2] = 4;
		sublist[3] = 5;
		array[1] = sublist;
		array[2] = 2;
		array[3] = 3;
		
		int result = list.sumOfAll(array, 0);
		assertEquals(20, result);
	}
	
	@Test
	public void testSumMultiLevel() throws InvalidInput {
		
		Object[] array = new Object[4];
		array[0] = 1;
		Object[] sublist = new Object[4];
		Object[] sublist2 = new Object[2];
		sublist2[0] = 1;
		sublist2[1] = 5;
		sublist[0] = 2;
		sublist[1] = new Object[2];
		sublist[1] = sublist2;
		sublist[2] = 4;
		sublist[3] = 5;
		array[1] = sublist;
		array[2] = 2;
		array[3] = 3;
		
		int result = list.sumOfAll(array, 0);
		assertEquals(23, result);
	}
	
	@Test
	public void testLargestValue() throws InvalidInput {
		
		Object[] array = new Object[4];
		array[0] = 1;
		Object[] sublist = new Object[4];
		sublist[0] = 2;
		sublist[1] = 3;
		sublist[2] = 4;
		sublist[3] = 5;
		array[1] = sublist;
		array[2] = 2;
		array[3] = 3;
		
		int result = list.largestValue(array, 0);
		assertEquals(5, result);
	}

	@Test
	public void testSearchElementPresent() throws InvalidInput {
		
		Object[] array = new Object[4];
		array[0] = 1;
		Object[] sublist = new Object[4];
		sublist[0] = 2;
		sublist[1] = 3;
		sublist[2] = 4;
		sublist[3] = 5;
		array[1] = sublist;
		array[2] = 2;
		array[3] = 3;
		
		boolean result = list.search(array, 5);
		assertEquals(true, result);
	}
	
	@Test
	public void testSearchElementNotPresent() throws InvalidInput {
		
		Object[] array = new Object[4];
		array[0] = 1;
		Object[] sublist = new Object[4];
		sublist[0] = 2;
		sublist[1] = 3;
		sublist[2] = 4;
		sublist[3] = 5;
		array[1] = sublist;
		array[2] = 2;
		array[3] = 3;
		
		boolean result = list.search(array, 6);
		assertEquals(false, result);
	}

	
}
