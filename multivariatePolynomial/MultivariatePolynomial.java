package multivariatePolynomial;

import java.util.List;

/**
 * 
 * This class is used to visualize a multivariate polynomial using nested linked
 * list.
 * 
 * @author Richa Jain
 * 
 */
public class MultivariatePolynomial {

	private List<Term> multivariate;

	public MultivariatePolynomial(List<Term> multivariate) {
		this.multivariate = multivariate;
	}

	/**
	 * This class defines a term of a multivariate polynomial.
	 * 
	 * @author Richa Jain
	 * 
	 */
	public static class Term {
		public double coefficient;
		public List<VariableList> variableList;

		public Term(double coefficient, List<VariableList> variableList) {
			this.coefficient = coefficient;
			this.variableList = variableList;
		}

	}

	/**
	 * This class defines all present variables in a term of multivariate
	 * polynomial.
	 * 
	 * @author Richa Jain
	 * 
	 */
	public static class VariableList {
		private char variable;
		private int power;

		public VariableList(char variable, int power) {
			this.variable = variable;
			this.power = power;
		}

	}

	/**
	 * 
	 * @return multivariate polynomial with all the terms in it.
	 */
	public String visualisedMultivariatePolynomial() {
		String polynomial = "";
		for (Term term : multivariate) {
			polynomial += term.coefficient;
			for (VariableList variables : term.variableList) {
				polynomial += " * " + variables.variable + "^"
						+ variables.power;
			}
			if (term != multivariate.get(multivariate.size() - 1)) {
				polynomial += " + ";
			}
		}
		return polynomial;
	}

}