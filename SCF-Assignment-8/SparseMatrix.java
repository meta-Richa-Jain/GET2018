import java.util.Arrays;

/**
 * Immutable class SparseMatrix to find transpose of a matrix, a matrix is
 * symmetric or not, addition and multiplication of two matrices
 * 
 * @author Richa Jain
 *
 */
final class SparseMatrix {

	private int[][] sparseMatrix;
	private int noOfRows;
	private int noOfCols;

	public SparseMatrix(int[][] inputMatrix) {
		this.noOfRows = inputMatrix.length;
		this.noOfCols = inputMatrix[0].length;
		this.sparseMatrix = inputMatrix;
	}

	/**
	 * Method to convert a sparse matrix to dense matrix (removing all zeroes
	 * from input matrix)
	 * 
	 * @param inputMatrix,
	 *            a sparse matrix containing zeroes
	 * @return denseMatrix, with first column contains row index, second contains column
	 *         index and third contains value
	 */
	private int[][] sparseToDense(int[][] inputMatrix) {
		int[][] denseMatrix;
		int nonZeroValues = 0;
		for (int row = 0; row < noOfRows; row++) {
			for (int col = 0; col < noOfCols; col++) {
				if (inputMatrix[row][col] != 0) {
					nonZeroValues++;
				}
			}
		}
		denseMatrix = new int[nonZeroValues][3];
		int index = 0;
		for (int row = 0; row < noOfRows; row++) {
			for (int col = 0; col < noOfCols; col++) {
				if (inputMatrix[row][col] != 0) {
					denseMatrix[index][0] = row;
					denseMatrix[index][1] = col;
					denseMatrix[index][2] = inputMatrix[row][col];
					index++;
				}
			}
		}
		return denseMatrix;
	}

	/**
	 * Method to convert dense matrix into sparse matrix (original matrix)
	 * @param inputMatrix, matrix without zeroes
	 * @param row, no of rows in the input matrix
	 * @param col, no of columns in the input matrix
	 * @return sparseMatrix, matrix containing zeroes
	 */
	int[][] denseToSparse(int[][] inputMatrix, int row, int col) {
		int sparseMatrix[][] = new int[row][col];

		for (int count1 = 0; count1 < inputMatrix.length; count1++) {
			int rowIndex = inputMatrix[count1][0];
			int colIndex = inputMatrix[count1][1];
			sparseMatrix[rowIndex][colIndex] = inputMatrix[count1][2];
		}
		return sparseMatrix;
	}

	/**
	 * Method to find transpose of a matrix
	 * @return result, resultant transposed sparse matrix
	 */
	SparseMatrix transpose() {
		int matrix[][] = sparseToDense(this.getSparseMatrix());

		int transpose[][] = new int[matrix.length][3];
		for (int count = 0; count < matrix.length; count++) {
			transpose[count][0] = matrix[count][1];
			transpose[count][1] = matrix[count][0];
			transpose[count][2] = matrix[count][2];
		}
		int result[][] = denseToSparse(transpose, this.getNoOfCols(), this.getNoOfRows());
		return new SparseMatrix(result);
	}

	/**
	 * Method to find if a matrix is symmetric or not
	 * @return true if matrix is symmetric else false
	 */
	boolean symmetric() {
		if(this.noOfCols != noOfRows){
			throw new AssertionError("Error: Only square matrices can be symmetric");
		}
		if (this.noOfCols == this.noOfRows) {
			SparseMatrix sparse = this.transpose();
			int matrix1[][] = sparse.getSparseMatrix();
			int matrix2[][] = this.getSparseMatrix();
			if (Arrays.deepEquals(matrix1, matrix2)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	/**
	 * Method to calculate addition of two sparse matrices
	 * @param sparse, sparse matrix
	 * @return result, resultant sparse matrix such that result = this + sparse
	 */
	public SparseMatrix addition(SparseMatrix sparse) {
		
		if(sparse==null){
			throw new AssertionError("Null matrix");
		}
		
		int matrix1[][] = this.sparseToDense(this.sparseMatrix);
		int matrix2[][] = sparse.sparseToDense(sparse.sparseMatrix);

		int result[][] = new int[noOfRows][noOfCols];
		if (this.noOfRows == sparse.noOfRows && this.noOfCols == sparse.noOfCols) {
			int count1 = 0;
			int count2 = 0;
			while (count1 < matrix1.length && count2 < matrix2.length) {
				if (matrix1[count1][0] < matrix2[count2][0]
						|| (matrix1[count1][0] == matrix2[count2][0] && matrix1[count1][1] < matrix2[count2][1])) {
					int row = matrix1[count1][0];
					int col = matrix1[count1][1];
					result[row][col] = matrix1[count1][2];
					count1++;
				} else if (matrix1[count1][0] > matrix2[count2][0]
						|| (matrix1[count1][0] == matrix2[count2][0] && matrix1[count1][1] > matrix2[count2][1])) {
					int row = matrix2[count2][0];
					int col = matrix2[count2][1];
					result[row][col] = matrix2[count2][2];
					count2++;
				} else {
					int row = matrix1[count1][0];
					int col = matrix1[count1][1];
					result[row][col] = matrix1[count1][2] + matrix2[count2][2];
					count1++;
					count2++;
				}
			}
			while (count1 < matrix1.length) {
				int row = matrix1[count1][0];
				int col = matrix1[count1][1];
				result[row][col] = matrix1[count1][2];
				count1++;
			}
			while (count2 < matrix2.length) {
				int row = matrix2[count2][0];
				int col = matrix2[count2][1];
				result[row][col] = matrix2[count2][2];
				count2++;
			}
		} else {
			throw new AssertionError("These matrix cannot be added");
		}
		return new SparseMatrix(result);

	}

	/**
	 * Method to calculate multiplication of two sparse matrices
	 * @param sparse, sparse matrix
	 * @return result, resultant sparse matrix such that result = this*sparse
	 */
	public SparseMatrix multiplication(SparseMatrix sparse) {

		if(sparse==null){
			throw new AssertionError("Null matrix");
		}
		if (noOfCols != sparse.noOfRows) {
			throw new AssertionError("matrices cannot be multiplied");
		}
		int matrix1[][] = this.sparseToDense(this.sparseMatrix);
		SparseMatrix sparseObject = sparse.transpose();
		int matrix2[][] = sparseObject.sparseToDense(sparseObject.getSparseMatrix());

		int result[][] = new int[this.noOfRows][sparse.noOfRows];

		for (int count1 = 0; count1 < matrix1.length;) {
			int row = matrix1[count1][0];
			for (int count2 = 0; count2 < matrix2.length;) {
				int col = matrix2[count2][0];

				int index1 = count1;
				int index2 = count2;

				int sum = 0;
				while (index1 < matrix1.length && matrix1[index1][0] == row && index2 < matrix2.length
						&& matrix2[index2][0] == col) {
					if (matrix1[index1][1] < matrix2[index2][1]) {
						index1++;
					} else if (matrix1[index1][1] > matrix2[index2][1]) {
						index2++;
					} else {
						sum += matrix1[index1++][2] * matrix2[index2++][2];
						
					}
				}
				if (sum != 0) {
					result[row][col] = sum;
				}
				while (count2 < matrix2.length && matrix2[count2][0] == col) {
					count2++;
				}
			}
			while (count1 < matrix1.length && matrix1[count1][0] == row) {
				count1++;
			}
		}
		return new SparseMatrix(result);

	}

	/**
	 * Function to return the sparse matrix
	 * @return sparseMatrix
	 */
	public int[][] getSparseMatrix() {
		return sparseMatrix;
	}

	/**
	 * Helper function to return the no of rows in the matrix
	 * @return noOfRows
	 */
	private int getNoOfRows() {
		return noOfRows;
	}

	/**
	 * Helper function to return the no of columns in the matrix
	 * @return noOfCols
	 */
	private int getNoOfCols() {
		return noOfCols;
	}
}
