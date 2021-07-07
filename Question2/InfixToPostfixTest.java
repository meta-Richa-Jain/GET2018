package Question2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Question1.StackException;

public class InfixToPostfixTest {

	
	@Test
	public void testWithoutParanthesis() throws StackException {
		InfixToPostfix postfix = new InfixToPostfix("a + b");
		String result=postfix.findPostfixExpression();
		assertEquals("ab+",result);
	}
	
	
	@Test
	public void testWithParanthesis() throws StackException {
		InfixToPostfix postfix = new InfixToPostfix("( a + b ) * ( c + d )");
		String exp = postfix.findPostfixExpression();
		assertEquals(exp, "ab+cd+*");
	}
	
	

}
