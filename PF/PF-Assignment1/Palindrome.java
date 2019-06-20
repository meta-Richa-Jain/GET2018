class CheckPalindromeUsingStack{
	
	private final char[] stackArray;
	private int topIndex;
	private final int size;
	
	CheckPalindromeUsingStack(int size){
		topIndex = -1;
		this.size = size;
		stackArray = new char[this.size];
	}

	public int top() throws StackException{
		if(isEmpty()){
			throw new StackException("Stack Underflow");
		} else{
			int topElement = stackArray[topIndex];
			return topElement;
		}
	}

	public void push(final char stackElement) throws StackException{
		if(isSafe()){
			topIndex++;
			stackArray[topIndex] = stackElement;
		}else{
			throw new StackException("Stack Overflow");
		}	
	}

	public char pop() throws StackException{
		if(isSafe()){
			char topElement = stackArray[topIndex];
			topIndex--;
			return topElement;
		} else{
			throw new StackException("Stack Underflow");
		}
	}

// checks if the current index is within the range

	boolean isSafe(){
		return((topIndex >= -1 && topIndex < size) ? true:false);	
	}

	boolean isEmpty(){
		return size == 0;
	}
	
/**
 * 
 * @param sampleString
 * @return true if the string is palindrome else not
 */

	boolean checkPalindrome(String sampleString){
		
		int stringLength = sampleString.length();

		if(sampleString == null){
			System.out.println("String is null");
			return false;
		} else if(stringLength == 0){
			return true;
		} else{
			for(int i=0;i<stringLength;i++){
				char ch = sampleString.charAt(i);
				stackArray[i] = ch;
			}
			StringBuilder reverseInputString = new StringBuilder();
			int stackLength = stackArray.length;
			for(int i = topIndex; i>=0 ; i--){
				char topElement = stackArray[i];
				reverseInputString.append(topElement);
			}
			if(sampleString.equals(reverseInputString)){
				return true;
			} else{
				return false;
			}
		}
	}	

}

public class Palindrome {
	public static void main(String args[]){
		
		/**
		 *  String inputString = null;
		 *  String inputString = "";
		 *  String inputString = "abba";
		 */
		
		String inputString = "abcbba";
		final int size = 100;
		CheckPalindromeUsingStack stack = new CheckPalindromeUsingStack(size);
		System.out.println(stack.checkPalindrome(inputString.toLowerCase()));
		
	}
}
