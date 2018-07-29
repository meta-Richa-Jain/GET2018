import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SparseMatrixTest {

	SparseMatrix sparse1 = new SparseMatrix(
			new int[][] { { 0, 0, 0, 0 }, { 0, 0, 10, 12 }, { 1, 0, 0, 2 }, { 0, 0, 0, 0 } });

	SparseMatrix sparse2 = new SparseMatrix(
			new int[][] { { 0, 0, 0, 0 }, { 0, 2, 5, 0 }, { 0, 0, 1, 0 }, { 0, 8, 0, 0 } });

	@Test
	public void testSymmetricPositive() {
		SparseMatrix sparse3 = new SparseMatrix(
				new int[][] { { 0, 0, 0, 1 }, { 0, 2, 0, 0 }, { 0, 0, 3, 0 }, { 1, 0, 0, 0 } });
		boolean result1 = sparse3.symmetric();
		assertEquals(true, result1);
	}
	
	@Test
	public void testSymmetricZeroMatrix() {
		SparseMatrix sparse3 = new SparseMatrix(
				new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } });
		boolean result1 = sparse3.symmetric();
		assertEquals(true, result1);
	}

	@Test
	public void testNotSymmetric() {
		SparseMatrix sparse4 = new SparseMatrix(
				new int[][] { { 0, 0, 0, 1 }, { 0, 2, 5, 0 }, { 0, 0, 3, 0 }, { 1, 0, 0, 1 } });
		boolean result2 = sparse4.symmetric();
		assertEquals(false, result2);
	}

	@Test(expected = AssertionError.class)
	public void testSymmetricUnequalRowColumn() {
		SparseMatrix sparse4 = new SparseMatrix(
				new int[][] { { 0, 0, 0, 1, 8 }, { 0, 2, 5, 0, 0 }, { 0, 0, 3, 0, 7 }, { 1, 0, 0, 1, 2 } });
		boolean result2 = sparse4.symmetric();
	}

	@Test
	public void testTransposePositive() {
		SparseMatrix sparse3 = sparse1.transpose();
		int matrix[][] = sparse3.getSparseMatrix();
		int result[][] = new int[][] { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 10, 0, 0 }, { 0, 12, 2, 0 } };
		assertTrue(Arrays.deepEquals(result, matrix));
	}

	@Test
	public void testAddition() {
		SparseMatrix sparse3 = sparse1.addition(sparse2);
		int matrix[][] = sparse3.getSparseMatrix();
		int result[][] = new int[][] { { 0, 0, 0, 0 }, { 0, 2, 15, 12 }, { 1, 0, 1, 2 }, { 0, 8, 0, 0 } };
		assertTrue(Arrays.deepEquals(result, matrix));
	}

	@Test(expected = AssertionError.class)
	public void testAdditionUnequalRowColumn() {
		SparseMatrix sparse4 = new SparseMatrix(new int[][] { { 0, 0, 0 }, { 0, 0, 10 }, { 1, 0, 2 }, { 0, 0, 0 } });

		SparseMatrix sparse5 = new SparseMatrix(
				new int[][] { { 0, 0, 0, 0 }, { 0, 2, 5, 0 }, { 0, 0, 1, 0 }, { 0, 8, 0, 0 } });
		SparseMatrix sparse3 = sparse4.addition(sparse5);
	}
	
	@Test(expected = AssertionError.class)
	public void testAdditionNullMatrix() {
		SparseMatrix sparse4 = new SparseMatrix(new int[][] { { 0, 0, 0 }, { 0, 0, 10 }, { 1, 0, 2 }, { 0, 0, 0 } });

		SparseMatrix sparse5 = new SparseMatrix(
				new int[][] { {} });
		SparseMatrix sparse3 = sparse4.addition(sparse5);
	}

	@Test
	public void testMultiplication() {
		SparseMatrix sparse3 = sparse1.multiplication(sparse2);
		int matrix[][] = sparse3.getSparseMatrix();
		int result[][] = new int[][] { { 0, 0, 0, 0 }, { 0, 96, 10, 0 }, { 0, 16, 0, 0 }, { 0, 0, 0, 0 } };
		assertTrue(Arrays.deepEquals(result, matrix));
	}

	@Test(expected = AssertionError.class)
	public void testMultiplicationUnequalRowColumn() {
		SparseMatrix sparse4 = new SparseMatrix(new int[][] { { 0, 0, 0 }, { 0, 0, 10 }, { 1, 0, 2 }, { 0, 0, 0 } });

		SparseMatrix sparse5 = new SparseMatrix(
				new int[][] { { 0, 0, 0, 0 }, { 0, 2, 5, 0 }, { 0, 0, 1, 0 }, { 0, 8, 0, 0 } });
		SparseMatrix sparse3 = sparse4.multiplication(sparse5);
	}
	
	@Test(expected = AssertionError.class)
	public void testMultiplicationNullMatrix() {
		SparseMatrix sparse4 = new SparseMatrix(new int[][] { { 0, 0, 0 }, { 0, 0, 10 }, { 1, 0, 2 }, { 0, 0, 0 } });

		SparseMatrix sparse5 = new SparseMatrix(
				new int[][] { {} });
		SparseMatrix sparse3 = sparse4.multiplication(sparse5);
	}

}
