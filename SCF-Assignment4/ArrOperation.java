public class ArrOperation {


	// helper function to check if an array is empty or not
	private boolean isEmptyArray(int inputArray[]){
		if (inputArray.length == 0) {
			throw new AssertionError("Error: Array is empty");
		}
		return false;
	}

	// helper function for fixXY method to check if X == Y
	private boolean isXYEquals(int inputArray[],int X,int Y) {
		if (X == Y) {
			throw new AssertionError("Wrong input: Both numbers can't be equal");
		}
		return false;
	}

	/**
	 * Find number of clumps in an array
	 * 
	 * @param clumpsArray
	 *            , contains positive integers
	 * @return countClumps, such that number of clumps in an array = countClumps
	 */
	int totalClumps(int clumpsArray[]) {
		int countClumps = 0;
		if (!isEmptyArray(clumpsArray)) {
			for (int count = 0; count < clumpsArray.length - 1; count++) {
				if (clumpsArray[count] == clumpsArray[count + 1]
						&& (count == 0 || clumpsArray[count - 1] != clumpsArray[count])) {
					countClumps++;
				}

			}
		}
		return countClumps;

	}

	/**
	 * Find the index so that the splitArray can be split into two equal halves
	 * so, that sum of array of first half is equals to the sum of array of the
	 * other half
	 * 
	 * @param splitArray
	 *            , contains positive integers
	 * @return index, such that sum of elements of splitArray before index is
	 *         equals to the sum of elements after index
	 */
	int splitArrayFunction(int splitArray[]) {
		int arraySum = 0;
		int arrayLength = splitArray.length;
		if (!isEmptyArray(splitArray)) {
			for (int count = 0; count < arrayLength; count++) {
				arraySum += splitArray[count];
			}
			if (arraySum % 2 == 0) {
				int firstHalfSum = 0;
				int secondHalfSum = arraySum;
				int index = -1;
				for (int count = 0; count < arrayLength; count++) {
					firstHalfSum += splitArray[count];
					secondHalfSum -= splitArray[count];
					if (firstHalfSum == secondHalfSum) {
						index = count + 1;
						return index;
					}
				}
			}
		}
		return -1;
	}

	// helper function to check if two X are adjacent to each other
	private boolean adjacentX(int inputArray[],int X) {
		for (int count = 0; count < inputArray.length; count++) {
			if (inputArray[count] == X && inputArray[count + 1] == X) {
				throw new AssertionError("Wrong Input: Two adjacent " + X
						+ "are not allowed");
			}
		}
		return false;
	}

	// helper function to check if number of X and Y are equal or not
	private boolean isNoXYEquals(int inputArray[], int X, int Y) {
		if (noOfX(inputArray,X) != noOfY(inputArray,Y)) {
			throw new AssertionError(
					"Wrong Input: nos of X and Y should be equal");
		}
		return true;
	}

	// helper function to count the number of X
	private int noOfX(int inputArray[],int X) {
		int countX = 0;
		for (int count = 0; count < inputArray.length; count++) {
			if (inputArray[count] == X) {
				countX++;
			}
		}
		return countX;
	}

	// helper function to count the number of Y
	private int noOfY(int inputArray[], int Y) {
		int countY = 0;
		for (int count = 0; count < inputArray.length; count++) {
			if (inputArray[count] == Y) {
				countY++;
			}
		}
		return countY;
	}

	// helper function to check if X is present at last or not
	private boolean isXLast(int inputArray[],int X) {
		if (inputArray[inputArray.length - 1] == X) {
			throw new AssertionError("Wrong Input: " + X
					+ " cannot be at last index");
		}
		return false;
	}

	// helper function to get the index of Y
	private int indexOfY(int inputArray[],int Y, int X,int count2) {
		while(inputArray[count2]!=Y || (count2!=0 && inputArray[count2-1]==X)){
			count2++;
		}
		return count2;
	}

	/**
	 * Rearrange the fixArray so that every X is immediately followed by every Y.
	 * @param fixArray, contains all positive integers
	 * @param X, requires to be positive
	 * @param Y, requires to be positive, it is immediately followed by X
	 * @return fixArray, rearranged so that every X is immediately followed by every Y.
	 */
	int[] fixXY(int fixArray[], int X, int Y) {
		int count2 = 0;
		if (!isEmptyArray(fixArray) && isNoXYEquals(fixArray,X,Y) && !isXLast(fixArray,X) && !isXYEquals(fixArray,X,Y)
				&& !adjacentX(fixArray,X)) {
			for (int count = 0; count < fixArray.length - 1; count++) {
				if (fixArray[count] == X && fixArray[count + 1] != Y) {
					count2 = indexOfY(fixArray, Y, X, count2);
						fixArray[count2] = fixArray[count + 1];
						fixArray[count + 1] = Y;
					
				}
			}
		}
		return fixArray;

	}

	/**
	 * find the largest mirror section in the array
	 * 
	 * @param mirrorArray
	 *            , contains all positive integers
	 * @return max, largest length of the mirror section
	 */
	public int maxMirror(int[] mirrorArray) {
		int max = 0;
		if (!isEmptyArray(mirrorArray)) {
			for (int count1 = 0; count1 < mirrorArray.length; count1++) {
				int count = 0;
				for (int count2 = mirrorArray.length - 1; count2 >= 0
						&& count1 + count < mirrorArray.length; count2--) {
					if (mirrorArray[count1 + count] == mirrorArray[count2]) {
						count++;
					} else {
						max = Math.max(max, count);
						count = 0;
					}
				}

				max = Math.max(max, count);
			}
		}
		return max;
	}
}
