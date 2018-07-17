class StackUsingArray{
	
	private final int[] stackArray;
	private int topIndex;
	private final int size;
	
	/**
	 * @param size 
	 * creates array of length size with Index of the top element as -1
	 */
	
	public StackUsingArray(final int size) {
		// TODO Auto-generated constructor stub
		topIndex = -1;
		this.size = size;
		stackArray = new int[this.size];
	}
	
	public int top() throws StackException{
		if(isEmpty()){
			throw new StackException("Stack Underflow");
		} else{
			int topElement = stackArray[topIndex];
			return topElement;
		}
	}
	
	public void push(final int number) throws StackException{
		if(isSafe()){
			topIndex++;
			stackArray[topIndex] = number;
		}else{
			throw new StackException("Stack Overflow");
		}	
	}
	
	public int pop() throws StackException{
		if(isEmpty()){
			throw new StackException("Stack Underflow");
		} else{
			int topElement = stackArray[topIndex];
			topIndex--;
			return topElement;
		}
	}
	
	// checks if the current index is within the range
	
	boolean isSafe(){
		return((topIndex >= -1 && topIndex < size) ? true:false);	
	}
	
	boolean isEmpty(){
		return size == 0;
	}
}


public class Stack {
	
	public static void main(String args[]){
		
		final int size = 100;
		StackUsingArray stack = new StackUsingArray(size);
		try{
		/*
		 * Normal case: Covered
		 */
		 stack.push(9);
		 stack.push(8);
		 stack.pop();
		 stack.pop();
		 System.out.println(stack.pop());
		 System.out.println(stack.top());
		 System.out.println(stack.isEmpty());
		}
		 
		/*
		 * Empty Stack: Covered
		 * stack.pop();
		 */
		
		 /*
		  * More pop() operations than pull : Covered
		  * stack.push(1);
		  * stack.pop();
		  * stack.pop();
		  */
		 catch (StackException e){
				System.out.println("Error detected: " + e.getMessage() );
		        System.exit(1);
		}
	}
}
