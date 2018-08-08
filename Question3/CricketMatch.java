package Question3;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to add bowlers to the list and to order them such that
 * Virat Kohli won't win the match
 * 
 * @author Richa Jain
 *
 */
public class CricketMatch {

	/* Initial list of bowlers */
	private List<Bowler> bowlersList = new ArrayList<Bowler>();
	/* Final ordering of all bowlers */
	private List<Bowler> bowlerOrder = new ArrayList<Bowler>();
	/* Number of bowls to be played by the Virat Kohli */
	private int numOfBallsToBePlayed;
	/* Total number of the bowlers */
	private int numOfBowlers;

	/**
	 * Constructor to initialize values
	 * 
	 * @param numOfBallsToBePlayed
	 *            , number of balls to be played by the player
	 * @param numOfBowlers
	 *            , total number of the bowlers
	 * @throws checkValidation
	 *             if any of the two is zero or negative
	 */
	public CricketMatch(int numOfBallsToBePlayed, int numOfBowlers)
			throws checkValidation {
		if (checkValidation(numOfBallsToBePlayed, numOfBowlers)) {
			this.numOfBallsToBePlayed = numOfBallsToBePlayed;
			this.numOfBowlers = numOfBowlers;
		}
	}

	/**
	 * Method to check the validation of the inputs
	 * 
	 * @param numOfBallsToBePlayed
	 * @param numOfBowlers
	 * @return true if neither of the two is negative or zero
	 * @throws checkValidation
	 *             exception if any of the two is negative or zero
	 */
	private boolean checkValidation(int numOfBallsToBePlayed, int numOfBowlers)
			throws checkValidation {
		if (numOfBallsToBePlayed <= 0 || numOfBowlers <= 0) {
			throw new checkValidation("Balls cannot be negative");
		} else {
			return true;
		}
	}

	/**
	 * Method to add bowlers to the bowlersList
	 * 
	 * @param bowler
	 *            object consisting of bowler's details
	 * @throws BowlerOutOfBoundException
	 *             if number of bowlers exceed the given size
	 */
	public void addBowler(Bowler bowler) throws BowlerOutOfBoundException {
		if (bowlersList.size() < this.numOfBowlers) {
			this.bowlersList.add(bowler);
		} else {
			throw new BowlerOutOfBoundException("Cannot add more bowlers");
		}
	}

	/**
	 * Method to make bowlers order so as to win the match
	 * 
	 * @return the ordered list of the bowlers
	 * @throws InvalidBallsError
	 *             if number of balls to be played by the player exceeds the sum
	 *             total balls of all the bowlers
	 */
	public List<Bowler> chooseBowler() throws InvalidBallsError {

		int totalBalls = totalBalls();
		int turn;
		if (totalBalls < numOfBallsToBePlayed) {
			throw new InvalidBallsError(
					"Number of balls to be thrown is less than number of balls to be "
							+ "played by the player");
		}
		while (totalBalls != 0) {
			turn = maxBalls();
			Bowler bowler = bowlersList.get(turn);
			if (bowlerOrder.size() == 0) {
				bowlerOrder.add(new Bowler(bowler.getName(), 1));
			} else {
				int previousIndex = bowlerOrder.size() - 1;
				Bowler previousBowler = bowlerOrder.get(previousIndex);
				if (previousBowler.getName().equals(bowler.getName())) {
					int ballsPlayed = bowlerOrder.get(previousIndex)
							.getNumOfBalls();
					bowlerOrder.get(previousIndex).setNumOfBalls(
							ballsPlayed + 1);
				} else {
					bowlerOrder.add(new Bowler(bowler.getName(), 1));
				}
			}
			bowler.setNumOfBalls(bowler.getNumOfBalls() - 1);
			totalBalls--;
		}

		return bowlerOrder;
	}

	/**
	 * Helper method to find the total sum of the balls of all the bowlers
	 * 
	 * @return totalBalls
	 */
	private int totalBalls() {
		int totalBalls = 0;
		for (Bowler bowler : bowlersList) {
			totalBalls += bowler.getNumOfBalls();
		}
		return totalBalls;
	}

	/**
	 * Helper method to find the index of the bowler who has maximum balls left
	 * to bowl
	 * 
	 * @return index of the bowler
	 */
	private int maxBalls() {
		int max = 0;
		int index = 0;
		int count = 0;
		for (Bowler bowler : bowlersList) {
			if (max < bowler.getNumOfBalls()) {
				max = bowler.getNumOfBalls();
				index = count;
			}
			count++;
		}
		return index;
	}

}
