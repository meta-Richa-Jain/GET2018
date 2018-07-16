import java.util.*;

class StackUsingArray{
	
	private final int[] array;
	private int topIndex;
	private final int size;
	
	public StackUsingArray(final int size) {
		// TODO Auto-generated constructor stub
		topIndex = -1;
		this.size = size;
		array = new int[this.size];
	}
	
	public int top(){
		int topElement = array[topIndex];
		return topElement;
	}
	
	public void push(final int number){
		if(isSafe()){
			topIndex++;
			array[topIndex] = number;
		}else{
			System.out.println("Stack Overflow");
		}	
	}
	
	public int pop(){
	//	assert topIndex > -1;
		if(isSafe()){
		int topElement = array[topIndex];
		topIndex--;
		return topElement;
		} else{
			System.out.println("Stack Underflow");
			return -1;
		}
	}
	
	boolean isSafe(){
		return((topIndex >= -1 && topIndex < size)? true:false);	
	}
	
	boolean isEmpty(){
		return size == 0;
	}
}

public class Stack {
	
	public static void main(String args[]){
		
		final int size = 100;
		StackUsingArray st = new StackUsingArray(size);
		st.push(8);
		System.out.println(st.pop());
		st.push(9);
		System.out.println(st.top());
		System.out.println(st.isEmpty());
	}
}
