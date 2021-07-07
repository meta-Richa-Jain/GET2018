package Question2;

import Question1.Stack;
import Question1.StackException;
import Question1.StackUsingLinkedList;

/**
 * This class is used to convert an infix expression to postfix expression where
 * tokens are separated using whitespace
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
		String infix[] = infixExp.split("\\s+");

		for (int i = 0; i < infix.length; i++) {

			if (infix[i].matches("[a-z]*[A-Z]*[0-9]*")) {
				postfix.append(infix[i]);
			}
			if ("(".equals(infix[i])) {
				stack.push(infix[i]);
			} else {
				if (")".equals(infix[i]) && !(stack.isEmpty())) {
					while (!(stack.isEmpty()) && !("(".equals(stack.top()))) {
						postfix.append(stack.pop());
					}
					if (!(stack.isEmpty()) && !("(".equals(stack.top()))) {
						throw new AssertionError("invalid expression");
					}
					if (!(stack.isEmpty()) && "(".equals(stack.top())) {
						stack.pop();
					}

				} else {
					if (isOperator(infix[i])) {
						if (stack.isEmpty()) {
							stack.push(infix[i]);
						} else {
							if (((getPrecedence(infix[i])) > (getPrecedence(stack
									.top())))) {
								stack.push(infix[i]);
							} else {
								while (!(stack.isEmpty())
										&& (getPrecedence(infix[i]) <= getPrecedence(stack
												.top()))
										&& !("(".equals(stack.top()))) {
									postfix.append(stack.pop());
								}
								stack.push(infix[i]);
							}
						}

					}

				}
			}
		}
		while (!(stack.isEmpty())) {
			postfix.append(stack.pop());
		}
		return postfix.toString();

	}

	/**
	 * Helper function to check if a current token is an operator or not
	 * 
	 * @param checkToken
	 *            , current token to check
	 * @return true if a token is operator else false
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
	 * @param operator
	 *            , input operator
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

