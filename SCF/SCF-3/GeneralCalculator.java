/*
 *  Generalized Calculator
 */
public interface GeneralCalculator {
	String addHexaNum(String firstNumber, String secondNumber);
	String subtractHexaNum(String firstNumber, String secondNumber);
	String multiplyHexaNum(String firstNumber, String secondNumber);
	String divideHexaNum(String firstNumber, String secondNumber);
	boolean equalsHexaNum(String firstNumber, String secondNumber); 
	boolean greaterThanHexaNum(String firstNumber, String secondNumber);
	boolean lessThanHexaNum(String firstNumber, String secondNumber); 
}
