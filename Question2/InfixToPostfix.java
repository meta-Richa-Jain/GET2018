package Question2;

import Question1.Stack;
import Question1.StackException;
import Question1.StackUsingLinkedList;

/**
 * This class is used to convert an infix expression to postfix expression where
 * tokens are separated using whitespaces
 * 
 * @author Richa Jain
 *
 */
public class InfixToPostfix {

	String infixExp;
	Stack<String> stack = new StackUsingLinkedList<String>();

	public InfixToPostfix(String infixExp) {
		this.infixExp = infixExp;
	}

	/**
	 * Method to find the postfix expression
	 * 
	 * @return postfix expression
	 * @throws StackException
	 */
	String findPostfixExpression() throws StackException {
		StringBuilder postfix = new StringBuilder();

		String tokensArray[] = infixExp.split("\\s+");
		for (String token : tokensArray) {
			if (!isOperator(token) && token != "(" && token != ")") {
				postfix.append(token);
			} else if (token.equals("(")) {
				stack.push("(");
			} else if (token.equals(")")) {
				while (!stack.isEmpty() && stack.top() != "(") {
					postfix.append(stack.pop());
				}
				if (!stack.isEmpty() && stack.top() != "(") {
					throw new AssertionError("Invalid Expression");
				} else if (!stack.isEmpty() && stack.top().equals("(")) {
					stack.pop();
				}
			} else if (isOperator(token)) {
				while (!stack.isEmpty() && getPrecedence(stack.top()) <= getPrecedence(token)) {
					if (stack.top() != "(" || stack.top() != ")") {
						if (stack.top().equals("(")) {
							stack.pop();
						}
						postfix.append(stack.pop());
					}
				}
				stack.push(token);
			}
		}
		while (!stack.isEmpty())
			postfix.append(stack.pop());
		return postfix.toString();
	}

	/**
	 * Helper function to check if a current token is an operator or not
	 * 
	 * @param checkToken,
	 *            current token to check
	 * @return true if a token is operato else false
	 */
	private boolean isOperator(String checkToken) {

		switch (checkToken) {

		case "!":
		case "*":
		case "/":
		case "+":
		case "-":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "==":
		case "!=":
		case "&&":
		case "||":
		case "(":
		case ")":
			return true;
		default:
			return false;
		}
	}

	/**
	 * Helper function to calculate the precedence of a operator
	 * 
	 * @param operator,
	 *            input operator
	 * @return precendence of the operators
	 */
	private int getPrecedence(String operator) {

		switch (operator) {
		case "!":
		case "(":
		case ")":
			return 1;
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 3;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 4;
		case "==":
		case "!=":
			return 5;
		case "&&":
			return 6;
		case "||":
			return 7;
		}
		return -1;
	}
}
