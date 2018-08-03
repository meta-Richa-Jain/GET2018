package Question2;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Question1.StackException;

public class InfixToPostfixTest {

	
	@Test
	public void testSmallExpression() throws StackException {
		InfixToPostfix postfix = new InfixToPostfix("A * B");
		String exp = postfix.findPostfixExpression();
		assertEquals(exp, "AB*");
	}
	
	@Test(expected = AssertionError.class)
	public void testInvalidExpression() throws StackException {
		InfixToPostfix postfix = new InfixToPostfix("A * ( B + C * D ) + ");
		String exp = postfix.findPostfixExpression();
	}
	
	
	@Test
	public void test() throws StackException {
		InfixToPostfix postfix = new InfixToPostfix("A * ( B + C * D ) + E");
		String exp = postfix.findPostfixExpression();
		assertEquals(exp, "AB*CD*+E+");
	}

}
