public class Search {
	/**
	 * Find element in an array
	 * 
	 * @param searchArray
	 *            array to search
	 * @param element
	 *            value to be search for
	 * @param currentIndex
	 *            current starting index of the array
	 * @return currentIndex i such that searchArray[i] = element else -1
	 */
	int linearSearch(int searchArray[], int element, int currentIndex) {
		if (currentIndex < searchArray.length) {
			if (searchArray[currentIndex] == element) {
				return currentIndex;
			}
			return linearSearch(searchArray, element, currentIndex + 1);
		}

		return -1;
	}

	/**
	 * Find element in an array
	 * 
	 * @param searchArray,
	 *            array to search
	 * @param element,
	 *            value to be search for
	 * @param leftIndex,
	 *            current starting index of the array
	 * @param rightIndex,
	 *            current end index of the array
	 * @return midIndex if element is found else -1
	 */
	int binarySearch(int searchArray[], int element, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex) {
			int midIndex = (leftIndex + rightIndex) / 2;
			if (searchArray[midIndex] == element) {
				return midIndex;
			}
			if (searchArray[midIndex] > element) {
				return binarySearch(searchArray, element, leftIndex, midIndex - 1);
			}
			return binarySearch(searchArray, element, midIndex + 1, rightIndex);
		}
		return -1;
	}

}
