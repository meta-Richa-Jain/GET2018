import java.util.Stack;

public class Palindrome {
	public static void main(String args[]){
		
		String inputString = "abcbba";
		Palindrome obj = new Palindrome();
		System.out.println(obj.checkPalindrome(inputString));
		
	}
	
	boolean checkPalindrome(String sampleString){
		
		int stringLength = sampleString.length();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<stringLength;i++){
			stack.push(sampleString.charAt(i));
		}
		String reverseInputString = "";
		while(!stack.isEmpty()){
			reverseInputString = reverseInputString + stack.pop();
		}
		boolean finalResult;
		if(sampleString.equalsIgnoreCase(reverseInputString)){
			finalResult = true;
		} else{
			finalResult = false;
		}
	return finalResult;
	}
}
