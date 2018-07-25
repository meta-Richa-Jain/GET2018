package Question2;

/**
 * implemented immutable class Poly used to evaluate value, calculate degree,
 * addition and multiplication of two polynomials
 * 
 * @author Richa Jain
 *
 */
final class Poly implements Polynomial {

	private int[][] polyArray;

	public Poly(int[][] inputArray) {
		polyArray = new int[inputArray.length][2];
		this.polyArray = inputArray;
	}

	/**
	 * Evaluate the value of polynomial
	 * 
	 * @param xVal,
	 *            value of the variable
	 * @return sum, evaluated value of the polynomial
	 */
	@Override
	public float evaluate(float xVal) {
		float sum = 0;
		for (int count1 = 0; count1 < polyArray.length; count1++) {
			sum += polyArray[count1][0] * Math.pow(xVal, polyArray[count1][1]);
		}
		return sum;
	}

	/**
	 * Display function to display the polynomial function
	 */
	private void display() {
		for (int count1 = 0; count1 < polyArray.length; count1++) {
			System.out.print(polyArray[count1][0] + "x^" + polyArray[count1][1]);
			if (count1 != polyArray.length - 1) {
				System.out.print("+");
			}
		}
	}

	/**
	 * find the degree of the polynomial
	 * 
	 * @return polynomial[0][1], highest degree of the polynomial function
	 */
	@Override
	public int degree() {

		Poly poly = sort(this.getPolyArray());
		int[][] polynomialArray = poly.getPolyArray();
		// first call sort then return
		return polynomialArray[0][1];
	}

	/**
	 * Function to add two polynomial functions
	 * 
	 * @param polynomial1,
	 *            first polynomial function
	 * @param polynomial2,
	 *            second polynomial function
	 * @return new poly object, resultant polynomial function
	 */
	@Override
	public Poly addPoly(Poly polynomial1, Poly polynomial2) {

		int maxDegree = (polynomial1.degree() > polynomial2.degree()) ? polynomial1.degree() : polynomial2.degree();
		int poly1[][] = polynomial1.getPolyArray();
		int poly2[][] = polynomial2.getPolyArray();
		int resultArray[][] = new int[maxDegree + 1][2];
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		while (count1 < poly1.length && count2 < poly2.length) {
			if (poly1[count1][1] == poly2[count2][1]) {
				resultArray[count3][0] = poly1[count1][0] + poly2[count2][0];
				resultArray[count3][1] = poly1[count1][1];
				count2++;
				count1++;
				count3++;
			} else if (poly1[count1][1] > poly2[count2][1]) {
				resultArray[count3][0] = poly1[count1][0];
				resultArray[count3][1] = poly1[count1][1];
				count1++;
				count3++;
			} else {
				resultArray[count3][0] = poly2[count2][0];
				resultArray[count3][1] = poly2[count2][1];
				count2++;
				count3++;
			}
		}
		while (count1 < poly1.length) {
			resultArray[count3][0] = poly1[count1][0];
			resultArray[count3][1] = poly1[count1][1];
			count1++;
			count3++;
		}
		while (count2 < poly2.length) {
			resultArray[count3][0] = poly2[count1][0];
			resultArray[count3][1] = poly2[count1][1];
			count2++;
			count3++;
		}
		int reduceArray[][] = reduce(resultArray);
		return new Poly(reduceArray);
	}

	/**
	 * Function to return the array representation of the polynomial function
	 * 
	 * @return polyArray, array of the polynomial function
	 */
	public int[][] getPolyArray() {
		return polyArray;
	}

	/**
	 * Function to multiply two polynomial functions
	 * 
	 * @param polynomial1,
	 *            first polynomial function
	 * @param polynomial2,
	 *            second polynomial function
	 * @return resultPolynomial, resultant polynomial function
	 */
	@Override
	public Poly multiplyPoly(Poly p1, Poly p2) {
		int polynomial1[][] = p1.getPolyArray();
		int polynomial2[][] = p2.getPolyArray();
		int resultArray[][] = new int[polynomial1.length * polynomial2.length][2];
		int count3 = 0;
		for (int count1 = 0; count1 < polynomial1.length; count1++) {
			for (int count2 = 0; count2 < polynomial2.length; count2++) {
				resultArray[count3][1] = polynomial1[count1][1] + polynomial2[count2][1];
				int index = powerPresent(resultArray[count3][1], resultArray);
				if (index != -1) {
					resultArray[index][0] = resultArray[index][0] + polynomial1[count1][0] * polynomial2[count2][0];
				} else {
					resultArray[count3][0] = polynomial1[count1][0] * polynomial2[count2][0];
				}
				count3++;
			}
		}
		int resultarray[][] = reduce(resultArray);
		Poly resultPolynomial = sort(resultarray);
		return resultPolynomial;

	}

	/**
	 * Function to remove the zero coefficients from the polynomial
	 * 
	 * @param inputArray,
	 *            array representaion of the polynomial
	 * @return reduceArray, array of the reduced polynomial
	 */
	private int[][] reduce(int inputArray[][]) {

		int count2 = 0;
		int zeroCoeff = 0;
		for (int count = 0; count < inputArray.length; count++) {
			if (inputArray[count][0] == 0) {
				zeroCoeff++;
			}
		}
		int reduceArray[][] = new int[inputArray.length - zeroCoeff][2];
		for (int count = 0; count < inputArray.length && count2 < inputArray.length; count++) {
			if (inputArray[count][0] != 0) {
				reduceArray[count2][0] = inputArray[count][0];
				reduceArray[count2][1] = inputArray[count][1];
				count2++;
			}
		}
		return reduceArray;

	}

	/**
	 * Function to sort the array in decreasing power order
	 * 
	 * @param inputArray,
	 *            array representaion of the polynomial
	 * @return new Poly object, in sorted order
	 */
	private Poly sort(int[][] inputArray) {
		for (int count = 0; count < inputArray.length - 1; count++) {
			for (int count2 = 0; count2 < inputArray.length - count - 1; count2++) {
				if (inputArray[count2][1] < inputArray[count2 + 1][1]) {
					int coeff = inputArray[count2][0];
					int power = inputArray[count2][1];
					inputArray[count2][0] = inputArray[count2 + 1][0];
					inputArray[count2][1] = inputArray[count2 + 1][1];
					inputArray[count2 + 1][0] = coeff;
					inputArray[count2 + 1][1] = power;
				}
			}
		}
		return new Poly(inputArray);
	}

	/**
	 * Helper function to check if any coefficient with given power is already
	 * present in the input array
	 * 
	 * @param power,
	 *            power to be checked for in the array
	 * @param reduceArray,
	 *            array to search in
	 * @return index of the postion if same power found else -1
	 */
	private int powerPresent(int power, int[][] reduceArray) {
		for (int count = 0; count < reduceArray.length; count++) {
			if (power == reduceArray[count][1]) {
				return count;
			}
		}
		return -1;
	}
}
