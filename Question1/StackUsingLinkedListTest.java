package Question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackUsingLinkedListTest {

	StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>();
	
	@Test
	public void testTopElement() throws StackException {
		stack.push(5);
		stack.push(4);
		stack.push(3);
		int result = stack.top();
		assertEquals(result, 3);
	}
	
	
	@Test(expected = StackException.class)
	public void testStackUnderflow() throws StackException {
		stack.push(5);
		stack.pop();
		stack.pop();
	}
	
	@Test
	public void testIsEmptyPositive() throws StackException {
		stack.push(5);
		stack.push(4);
		stack.push(3);
		boolean result = stack.isEmpty();
		assertEquals(result,false);
	}
	
	@Test
	public void testIsEmptyNegative() throws StackException {

		boolean result = stack.isEmpty();
		assertEquals(result,true);
	}
	
	

}
