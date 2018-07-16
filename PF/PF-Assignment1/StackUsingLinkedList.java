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

class Stack1{
	
	private Node topElement;
	private int size;
	
	Stack1(){
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
	
	public int pop(){
		int topValue = topElement.getData();
		topElement = topElement.getNext();
		size--;
		return topValue;
	}
	
	public int Top(){
		int topValue = topElement.getData();
		return topValue;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
}
public class StackUsingLinkedList {
	public static void main(String args[]){
		Stack1 st = new Stack1();
		st.push(9);
		st.push(8);
		System.out.println(st.pop());
		System.out.println(st.Top());
		System.out.println(st.isEmpty());
	}
}
