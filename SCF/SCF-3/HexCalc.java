
public class HexCalc {
	public static void main(String args[]){
		
		Calculator calc = new Calculator();
		System.out.println("Addition : " + calc.addHexaNum("A", "5"));
		System.out.println("Division : " +calc.divideHexaNum("A", "5"));
		System.out.println("Multiplication : " +calc.multiplyHexaNum("A", "5"));
		System.out.println("Subtraction : " +calc.subtractHexaNum("A", "5"));
		System.out.println("Equals : " +calc.equalsHexaNum("A", "5"));
		System.out.println("Is no1 greater than no2 : " +calc.greaterThanHexaNum("A", "5"));
		System.out.println("Is no1 less than no2 : " +calc.lessThanHexaNum("A", "5"));
	}
}
