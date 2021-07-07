package Question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackUsingArrayTest {

	StackUsingArray<Integer> stack = new StackUsingArray<Integer>(5);
	
	StackUsingArray<Character> stack2 = new StackUsingArray<Character>(5);
	
	@Test
	public void testTopElementCharacter() throws StackException {
		
		stack2.push('w');
		stack2.push('r');
		stack2.push('e');
		char result = stack2.top();
		assertEquals(result, 'e');
	}
	
	@Test
	public void testTopElement() throws StackException {
		
		stack.push(5);
		stack.push(4);
		stack.push(3);
		int result = stack.top();
		assertEquals(result, 3);
	}
	
	@Test(expected = StackException.class)
	public void testStackOverflow() throws StackException {
		stack.push(5);
		stack.push(4);
		stack.push(6);
		stack.push(2);
		stack.push(3);
		stack.push(7);
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
	
	@Test
	public void testIsFullPositive() throws StackException {
		stack.push(5);
		stack.push(4);
		stack.push(3);
		boolean result = stack.isSafe();
		assertEquals(result, true);
	}
	
	@Test
	public void testIsFullNegative() throws StackException {
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(5);
		stack.push(4);
		boolean result = stack.isSafe();
		assertEquals(result, false);
	}


}
