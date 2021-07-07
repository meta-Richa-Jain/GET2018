package Dictionary;

import java.util.List;

/**
 * Dictionary interface consisting of mathods that has to be implemented
 * 
 * @author Richa Jain
 *
 */
public interface Dictionary<E> {

	/**
	 * Method to add tree node to a tree
	 * 
	 * @param key
	 * @param value
	 * @return true if tree node is added successfully else false when user
	 *         tries to enter duplicate key
	 * @throws InvalidEntries  if key is invalid
	 */
	public boolean addNode(String key, E value) throws InvalidEntries;

	/**
	 * Method to delete tree node with a given key
	 * 
	 * @param key,
	 *            key to be deleted
	 * @return root node of the resultant tree
	 * @throws InvalidEntries if key is invalid  
	 */
	public TreeNode<E> deleteNode(String key) throws InvalidEntries;

	/**
	 * Method to return the value mapped to the given key
	 * 
	 * @param key,
	 *            whose value is to be search
	 * @return the value mapped to the given key
	 * @throws InvalidEntries if key is invalid
	 * @throws EmptyTree if tree is empty 
	 */
	public E getValue(String key) throws InvalidEntries, EmptyTree;

	/**
	 * Method to return the list of nodes sorted in lexicographical order
	 * 
	 * @return the list of forted nodes
	 * @throws EmptyTree if tree is empty
	 */
	public List<Node<E>> sortedOrder() throws EmptyTree;

	/**
	 * Method to return the list of sorted nodes lying between the given two key
	 * values
	 * 
	 * @param key1
	 *            is smaller than key2
	 * @param key2
	 *            requires to greater than key2
	 * @return list of sorted nodes
	 * @throws EmptyTree if tree is empty
	 * @throws InvalidEntries if key is invalid
	 */
	public List<Node<E>> sortBetweenTwoKeyValue(String key1, String key2) throws EmptyTree, InvalidEntries;

}
