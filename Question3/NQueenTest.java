import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NQueenTest {

	NQueenProblem nqueen = new NQueenProblem();
	
	@Test
	public void testNQueenProblemPositive1() {
		int board[][] = new int[4][4];
		boolean result = nqueen.solveNQueen(board, 0, 4);
		assertEquals(true,result);
	}
	
	@Test
	public void testNQueenProblemPositive2() {
		int board[][] = new int[1][1];
		boolean result = nqueen.solveNQueen(board, 0, 1);
		assertEquals(true,result);
	}
	
	@Test
	public void testNQueenProblemPositive3() {
		int board[][] = new int[16][16];
		boolean result = nqueen.solveNQueen(board, 0, 16);
		assertEquals(true,result);
	}

	@Test
	public void testNQueenProblemNegative() {
		int board[][] = new int[3][3];
		boolean result = nqueen.solveNQueen(board, 0, 3);
		assertEquals(false,result);
	}

}
