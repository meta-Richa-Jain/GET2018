
public class NQueenProblem {
	
	/**
	 * Function to check if a queen can be placed at position board[row][col]
	 * @param board, chessboard of dimension dim x dim
	 * @param row, requires to be positive, represents the row upto which 
	 * the queen has been placed
	 * @param col, requires to be positive, represents the column upto 
	 * which the queen has been placed
	 * @param dim, dimension of the chessboard
	 * @return true if the queen can be placed safely at position board[row][col],
	 * else false
	 */
	boolean isQueenSafe(int board[][], int row, int col, int dim) {

		for (int count1 = 0; count1 < row; count1++)
			if (board[count1][col] == 1)
				return false;
		for (int count1 = row, count2 = col; count1 >= 0 && count2 >= 0; count1--, count2--)
			if (board[count1][count2] == 1)
				return false;
		for (int count1 = row, count2 = col; count2 >= 0 && count1 < dim; count1++, count2--)
			if (board[count1][count2] == 1)
				return false;

		return true;
	}

	/**
	 * Function to solve NQueen Problem
	 * @param board, chessboard of dimension dim x dim
	 * @param row, requires to be positive, represents where queen is placed
	 * @param dim, dimension of the chessboard
	 * @return true if all the queens can be placed safely, else false
	 */
	boolean solveNQueen(int board[][], int row, int dim) {
		if (dim == 2 || dim == 3) {
			return false;
		}
		if (row == dim) {
			return true;
		}
		for (int count1 = 0; count1 < dim; count1++) {
			if (isQueenSafe(board, row, count1, dim)) {
				board[row][count1] = 1;
				if (solveNQueen(board, row + 1, dim) == true) {
					return true;
				}
				board[row][count1] = 0; 
			}
		}
		return false;
	}
}
