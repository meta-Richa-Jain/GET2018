package multivariatePolynomial;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import multivariatePolynomial.MultivariatePolynomial.Term;
import multivariatePolynomial.MultivariatePolynomial.VariableList;

import org.junit.Test;


public class MultivariatePolynomialTest {

	VariableList variable1 = new VariableList('x', 2);
	VariableList variable2 = new VariableList('y', 0);
	VariableList variable3 = new VariableList('z', 1);
	
	@SuppressWarnings("serial")
	List<VariableList> variableList1 = new ArrayList<VariableList>(){{add(variable1); add(variable2);}};
	@SuppressWarnings("serial")
	List<VariableList> variableList2 = new ArrayList<VariableList>(){{add(variable1); add(variable2); add(variable3);}};
	
	Term term1 = new Term(4.00, variableList1);
	Term term2 = new Term(3.00, variableList2);
	
	@SuppressWarnings("serial")
	List<Term> termList = new ArrayList<Term>(){{add(term1); add(term2);}};
	
	@Test
	public void Visualisationtest() {
		MultivariatePolynomial poly = new MultivariatePolynomial(termList);
		String polynomial = poly.visualisedMultivariatePolynomial();
		assertEquals("4.0 * x^2 * y^0 + 3.0 * x^2 * y^0 * z^1", polynomial);
	}
}
