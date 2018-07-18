
public class Conversion{
	
	/*
	 *  method to convert hexadecimal number to decimal number
	 *  @param hexadecimal number as string
	 *  @returns decimal value as integer
	 */
	public int hexaToDec(String hexa){
		String indexingString = "0123456789ABCDEF";
		int decValue = 0;
		int base =1;
		int requiredBase = 16;
		for(int i = hexa.length()-1;i>=0;i--){
			char val = hexa.charAt(i);
			int charVal = indexingString.indexOf(val);
			decValue = decValue + charVal*base;
			base = base*requiredBase;
		}
		return decValue;
	}
	/*
	 * method to convert decimal number to hexadecimal 
	 * @param takes decimal number as integer
	 * @returns hexadecimal number as string
	 */
	public String decToHexa(int dec){
		int base =16;
		int decValue = dec;
		int startingIndex = 48;
		int endingIndex = startingIndex + (base-9);
		StringBuilder reversedHexaValue = new StringBuilder();
		int remainder = 0;
		while(decValue!=0){
			remainder = decValue%base;
			if(remainder<10){
				reversedHexaValue.append((char)(remainder+startingIndex));
			} else{
				reversedHexaValue.append((char)(remainder+endingIndex));
			}
			decValue = decValue/base;
		}
		String hexaValue = new String(reversedHexaValue.reverse());
		return hexaValue;
	}

}
