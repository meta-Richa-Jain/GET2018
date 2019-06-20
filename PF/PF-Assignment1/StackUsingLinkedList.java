/*
 * Node class contains node in which data is stored as int in data
 *  as well as pointer to next Node is stored
 */

class Node{
	
	private int data;
	private Node next;
	
	Node(final int data){
		this.setData(data);
		this.setNext(null);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

/*
 *  Implementation of Stack using linked list in O(1) time constant
 */

class StackLinkedList{
	
	private Node topElement;
	private int size;
	
	StackLinkedList(){
		topElement = null;
		size = 0;
	}
	
	public void push(int data){
		Node newElement = new Node(data);
		if(size == 0){
			topElement = newElement;
		} else{
			newElement.setNext(topElement);
			topElement = newElement;
		}
		size++;
	}
	
	public int pop() throws StackException{
		if(isEmpty()){
			throw new StackException("Stack Underflow");
		} else{
			int topValue = topElement.getData();
			topElement = topElement.getNext();
			size--;
			return topValue;
		}
	}
	
	public int top() throws StackException{
		if(isEmpty()){
			throw new StackException("Stack Overflow");
		} else {
			int topValue = topElement.getData();
			return topValue;
		}
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
}
public class StackUsingLinkedList {
	public static void main(String args[]) throws StackException{
		StackLinkedList stack = new StackLinkedList();
		try{
		/*
		 * Normal case: Covered
		 */
		 stack.push(9);
		 stack.push(8);
		 System.out.println(stack.pop());
		 System.out.println(stack.top());
		 System.out.println(stack.isEmpty());
		  
		 
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
		}
		catch (StackException e){
			System.out.println("Error detected: " + e.getMessage() );
	        System.exit(1);
		}
	}
}
