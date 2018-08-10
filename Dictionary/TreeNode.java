package Dictionary;

/**
 * TreeNode class used to store node details and references to left and right
 * child
 * 
 * @author Richa Jain
 *
 */
public class TreeNode<E> {

	private Node<E> node;
	private TreeNode<E> leftChild;
	private TreeNode<E> rightChild;

	public TreeNode(String key, E value) {
		this.node = new Node<E>(key, value);
		this.setLeftChild(null);
		this.setRightChild(null);
	}

	public Node<E> getNode() {
		return node;
	}

	public TreeNode<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<E> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}

}
