package Dictionary;

/**
 * Generic node class used to store key value pair
 * 
 * @author Richa Jain
 *
 */
public class Node<E> {

	private String key;
	private E value;

	public Node(String key, E value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public E getValue() {
		return value;
	}

}
