
public class HexCalc implements GeneralCalculator {
	private int firstDecValue;
	private int secondDecValue;
	Conversion convert = new Conversion();

	/*
	 * method to add two hexadecimal numbers
	 * 
	 * @param firstHexaValue and secondHexaValue as String
	 * 
	 * @returns sum of two hexadecimal numbers as string
	 */
	public String addHexaNum(String firstHexaValue, String secondHexaValue) {
		firstDecValue = convert.baseToDec(firstHexaValue);
		secondDecValue = convert.baseToDec(secondHexaValue);
		int sum = firstDecValue + secondDecValue;
		String hexaSum = convert.decToBase(sum);
		return hexaSum;
	}

	/*
	 * method to subtract two hexadecimal numbers
	 * 
	 * @param firstHexaValue and secondHexaValue as String
	 * 
	 * @returns difference of two hexadecimal numbers as string assume
	 * firstHexaValue is greater than secondHexaValue
	 */
	public String subtractHexaNum(String firstHexaValue, String secondHexaValue) {
		firstDecValue = convert.baseToDec(firstHexaValue);
		secondDecValue = convert.baseToDec(secondHexaValue);
		int diff = firstDecValue - secondDecValue;
		String hexaDiff = convert.decToBase(diff);
		return hexaDiff;
	}

	/*
	 * method to multiply two hexadecimal numbers
	 * 
	 * @param firstHexaValue and secondHexaValue as String
	 * 
	 * @returns multiplication of two hexadecimal numbers as string
	 */
	public String multiplyHexaNum(String firstHexaValue, String secondHexaValue) {
		firstDecValue = convert.baseToDec(firstHexaValue);
		secondDecValue = convert.baseToDec(secondHexaValue);
		int multi = firstDecValue * secondDecValue;
		String hexaMultiply = convert.decToBase(multi);
		return hexaMultiply;
	}

	/*
	 * method to divide two hexadecimal numbers
	 * 
	 * @param firstHexaValue and secondHexaValue as String
	 * 
	 * @returns floor value of division of two hexadecimal numbers as string
	 */
	public String divideHexaNum(String firstHexaValue, String secondHexaValue) {
		firstDecValue = convert.baseToDec(firstHexaValue);
		secondDecValue = convert.baseToDec(secondHexaValue);
		if(secondDecValue!=0){
		int divi = firstDecValue / secondDecValue;
		String hexaDivi = convert.decToBase(divi);
		return hexaDivi;
		} else{
			throw new AssertionError("Error: Cannot divide number by zero");
		}
	}

	/*
	 * method to remove trailing zeroes from hexadecimal string
	 */
	String removeTrailingZeroes(String hexaValue) {
		return hexaValue.replaceFirst("^0+(?!$)", "");
	}

	/*
	 * method to check equality of two hexadecimal numbers first compares their
	 * length and if length is equal then check character by character
	 * 
	 * @param firstHexaValue and secondHexaValue as String
	 * 
	 * @returns true if the numbers are equal else false
	 */
	public boolean equalsHexaNum(String hexaValue1, String hexaValue2) {
		String firstHexaValue = removeTrailingZeroes(hexaValue1.toUpperCase());
		String secondHexaValue = removeTrailingZeroes(hexaValue2.toUpperCase());
		int firstHexaLength = firstHexaValue.length();
		int secondHexaLength = secondHexaValue.length();

		if (firstHexaLength == secondHexaLength) {
			int i = 0;
			while (i < firstHexaLength) {
				if (firstHexaValue.charAt(i) == secondHexaValue.charAt(i)) {
					i++;
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/*
	 * method to check if hexaValue1 is greater than hexaValue2 first compares
	 * their length and if length is equal then check character by character
	 * 
	 * @param firstHexaValue and secondHexaValue as String
	 * 
	 * @returns true if the hexaValue1 is greater than hexaValue2
	 */
	public boolean greaterThanHexaNum(String hexaValue1, String hexaValue2) {
		String firstHexaValue = removeTrailingZeroes(hexaValue1.toUpperCase());
		String secondHexaValue = removeTrailingZeroes(hexaValue2.toUpperCase());
		int firstHexaLength = firstHexaValue.length();
		int secondHexaLength = secondHexaValue.length();
		if (firstHexaLength == secondHexaLength) {
			int i = 0;
			while (i < firstHexaLength) {
				if (firstHexaValue.charAt(i) > secondHexaValue.charAt(i)) {
					i++;
				} else {
					return false;
				}
			}
			return true;
		} else if (firstHexaLength > secondHexaLength) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * method to check if hexaValue1 is less than hexaValue2 first compares
	 * their length and if length is equal then check character by character
	 * 
	 * @param firstHexaValue and secondHexaValue as String
	 * 
	 * @returns true if the hexaValue1 is less than hexaValue2
	 */
	public boolean lessThanHexaNum(String hexaValue1, String hexaValue2) {
		String firstHexaValue = removeTrailingZeroes(hexaValue1.toUpperCase());
		String secondHexaValue = removeTrailingZeroes(hexaValue2.toUpperCase());
		int firstHexaLength = firstHexaValue.length();
		int secondHexaLength = secondHexaValue.length();

		if (firstHexaLength == secondHexaLength) {
			int i = 0;
			while (i < firstHexaLength) {
				if (firstHexaValue.charAt(i) < secondHexaValue.charAt(i)) {
					i++;
				} else {
					return false;
				}
			}
			return true;
		} else if (firstHexaLength < secondHexaLength) {
			return true;
		} else {
			return false;
		}
	}
}
