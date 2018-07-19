public class StringOperation {

	/**
	 * find if the two strings are equal or not
	 * 
	 * @param inputString1
	 *            , requires inputString1 to be not null
	 * @param inputString2
	 *            , requires inputString2 to be not null
	 * @return 1 if both strings are equal else 0
	 */
	int compareString(String inputString1, String inputString2) {
		String firstInputString = new String(inputString1);
		String secondInputString = new String(inputString2);
		if (firstInputString.length() != secondInputString.length()) {
			return 0;
		} else {
			for (int i = 0; i < firstInputString.length(); i++) {
				if (firstInputString.charAt(i) != secondInputString.charAt(i)) {
					return 0;
				}
			}
			return 1;
		}
	}

	/**
	 * method to reverse the input string
	 * 
	 * @param inputString
	 *            , requires inputString to be not null
	 * @return reverse of the inputString
	 */
	String stringReverse(String inputString) {
		StringBuilder reverseString = new StringBuilder();

		for (int i = inputString.length() - 1; i >= 0; i--) {
			reverseString = reverseString.append(inputString.charAt(i));
		}
		return reverseString.toString();
	}

	/**
	 * method to change the case of string, if a character is uppercase then
	 * convert it to lowercase and vice versa
	 * 
	 * @param inputString
	 *            , requires to be not null
	 * @return change case of the inputString from upper to lower and vice versa
	 */
	String changeCase(String inputString) {
		StringBuilder caseChanged = new StringBuilder();
		for (int i = 0; i < inputString.length(); i++) {
			char indexedChar = inputString.charAt(i);
			if (indexedChar >= 65 && indexedChar <= 90) {
				caseChanged.append((char) (indexedChar + 32));
			} else if (indexedChar >= 97 && indexedChar <= 122) {
				caseChanged.append((char) (indexedChar - 32));
			} else {
				System.out.println("Wrong Input");
			}

		}
		return caseChanged.toString();
	}

	/**
	 * find the largest word appears in a sentence, if two strings are of equal length
	 * then return the last word
	 * @param inputString, requires to be not null
	 * @return largestWord, which has the largest length and has the highest starting index 
	 */
	String getLargestWord(String inputString) {
		StringBuilder largestWord = new StringBuilder();
		int intermediateWordLength = 0;
		int maxLength = 0;
		String intermediateWord ="";
		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i) != ' ') {
				intermediateWord = intermediateWord + (inputString
						.charAt(i));
				intermediateWordLength++;
			} else {
				intermediateWordLength = 0;
				intermediateWord = "";
			}
			if (maxLength <= intermediateWordLength) {
				maxLength = intermediateWordLength;
				largestWord = new StringBuilder(intermediateWord);
			}
		}
		return largestWord.toString();
	}
}
