package Question1;

/**
 * This class is used to evaluate the postfix expression
 * 
 * @author Richa Jain
 *
 */
public class EvaluatePostfix {

	Stack<Double> stack = new StackUsingLinkedList<Double>();
	String postfix; // Stores the postfix expression

	public EvaluatePostfix(String postfix) {
		this.postfix = postfix;
	}

	/**
	 * Method to evaluate the postfix expression
	 * @return the final evaluated value
	 * @throws StackException
	 */
	double evaluatePostfixExpression() throws StackException {

		try {
			for (int count = 0; count < postfix.length(); count++) {
				char value1 = postfix.charAt(count);

				if (value1 == ' ') {
					continue;
				} else if (Character.isDigit(value1)) {
					StringBuilder multiDigit = new StringBuilder();
					while (Character.isDigit(value1)) {
						multiDigit.append(value1 - '0');
						count++;
						value1 = postfix.charAt(count);
					}
					count--;
					stack.push(Double.parseDouble(new String(multiDigit)));
				} else {
					double value2 = stack.pop();
					double value3 = stack.pop();

					if (value1 == '+') {
						stack.push(value3 + value2);
					} else if (value1 == '-') {
						stack.push(value3 - value2);
					} else if (value1 == '*') {
						stack.push(value3 * value2);
					} else if (value1 == '/') {
						if (value2 == 0) {
							throw new AssertionError("number cannot be divided by zero ");
						}
						stack.push(value3 / value2);

					} else {
						throw new AssertionError("Enter correct operator");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occurred " + e);
		}

		if (stack.size() != 1) {
			throw new AssertionError("Invalid Expression");
		}
		return stack.pop();
	}

}
