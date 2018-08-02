package LinkedList;

/**
 * Generic node class to implement Linked List
 * 
 * @author Richa Jain
 *
 */
public class Node<E> {

	private E data;
	private Node next;

	public Node(E data) {
		this.data = data;
		this.next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
}