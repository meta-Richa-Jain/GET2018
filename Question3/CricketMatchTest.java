package Question3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CricketMatchTest {

	@Test
	public void testBowlersPositive() throws checkValidation,
			InvalidBallsError, BowlerOutOfBoundException {
		CricketMatch cricketMatch = new CricketMatch(12, 3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		List<Bowler> actualResult = cricketMatch.chooseBowler();
		List<Bowler> expectedResult = new ArrayList<Bowler>();
		expectedResult.add(new Bowler("a", 6));
		expectedResult.add(new Bowler("b", 1));
		expectedResult.add(new Bowler("a", 1));
		expectedResult.add(new Bowler("b", 1));
		expectedResult.add(new Bowler("a", 1));
		expectedResult.add(new Bowler("b", 1));
		expectedResult.add(new Bowler("c", 1));
		for (int count = 0; count < expectedResult.size(); count++) {
			assertEquals(expectedResult.get(count).getName(),
					actualResult.get(count).getName());
			assertEquals(expectedResult.get(count).getNumOfBalls(),
					actualResult.get(count).getNumOfBalls());
		}
	}

	@Test(expected = checkValidation.class)
	public void testInvalidArgumentsBallsToBePlayed() throws checkValidation,
			InvalidBallsError, BowlerOutOfBoundException {
		CricketMatch cricketMatch = new CricketMatch(-12, 3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		List<Bowler> actualResult = cricketMatch.chooseBowler();

	}

	@Test(expected = checkValidation.class)
	public void testInvalidArgumentsNumBowlers() throws checkValidation,
			InvalidBallsError, BowlerOutOfBoundException {
		CricketMatch cricketMatch = new CricketMatch(12, -3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		List<Bowler> actualResult = cricketMatch.chooseBowler();

	}

	@Test(expected = InvalidBallsError.class)
	public void testInsufficientBalls() throws checkValidation,
			InvalidBallsError, BowlerOutOfBoundException {
		CricketMatch cricketMatch = new CricketMatch(14, 3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		List<Bowler> actualResult = cricketMatch.chooseBowler();

	}

	@Test(expected = BowlerOutOfBoundException.class)
	public void testBowlersOutOfBound() throws checkValidation,
			InvalidBallsError, BowlerOutOfBoundException {
		CricketMatch cricketMatch = new CricketMatch(12, 3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		Bowler bowler4 = new Bowler("d", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		cricketMatch.addBowler(bowler4);
		List<Bowler> actualResult = cricketMatch.chooseBowler();

	}

}
