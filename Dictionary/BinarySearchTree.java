package Dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class is used to implement dictionary consisting of methods to add tree
 * nodes, delete a tree node, return sorted list of tree nodes
 * 
 * @author Richa Jain
 *
 */
public class BinarySearchTree<E> implements Dictionary<E> {

	private TreeNode<E> root;
	private List<Node<E>> sortedList = new ArrayList<Node<E>>();
	private List<Node<E>> sortedBetweenTwoKeys = new ArrayList<Node<E>>();

	@SuppressWarnings("unchecked")
	public BinarySearchTree(JSONObject jObject) throws InvalidEntries {
			this.root = null;
			for (Object key : jObject.keySet()) {
				addNode(key.toString().toLowerCase(), (E) jObject.get(key).toString().toLowerCase());
			}
	}

	@Override
	public boolean addNode(String key, E value) throws InvalidEntries {
		if (key != null && key.length() > 0) {
			root = addNodeRecursively(root, key, value);
		} else {
			try {
				throw new InvalidEntries("Invalid key");
			} catch (InvalidEntries e) {
				throw new InvalidEntries("Invalid Key");
			}
		}
		if (root != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to add nodes recursively to binary search tree
	 * 
	 * @param root
	 * @param key
	 * @param value
	 * @return
	 * @throws InvalidEntries
	 */
	private TreeNode<E> addNodeRecursively(TreeNode<E> root, String key, E value) throws InvalidEntries {
		if (root == null) {
			root = new TreeNode<E>(key, value);
			return root;
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) > 0) {
			root.setRightChild(addNodeRecursively(root.getRightChild(), key, value));
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) < 0) {
			root.setLeftChild(addNodeRecursively(root.getLeftChild(), key, value));
		} else {
			try {
				throw new InvalidEntries("Key must be unique");
			} catch (InvalidEntries e) {
				throw new InvalidEntries("Key must be unique");
			}
		}
		return root;
	}

	@Override
	public TreeNode<E> deleteNode(String key) throws InvalidEntries {
		try {
			if (key == null || key.length() == 0) {
				throw new InvalidEntries("Enter valid key");
			}
			root = deleteRecursive(root, key);
			return root;
		} catch (InvalidEntries e) {
			throw new InvalidEntries("Enter valid key");
		}

	}

	/**
	 * Method to delete tree node from binary search tree
	 * 
	 * @param root
	 * @param key
	 * @return
	 * @throws InvalidEntries
	 */
	private TreeNode<E> deleteRecursive(TreeNode<E> root, String key) throws InvalidEntries {
		TreeNode<E> tempTreeNode1 = null;
		if (root != null) {
			if (key.equalsIgnoreCase(root.getNode().getKey())) {
				TreeNode<E> leftNode = root.getLeftChild();
				TreeNode<E> rightNode = root.getRightChild();
				if (leftNode == null && rightNode == null) {
					return null;
				} else if (leftNode == null) {
					return rightNode;
				} else if (rightNode == null) {
					return leftNode;
				} else {
					tempTreeNode1 = rightNode;
					while (tempTreeNode1.getLeftChild() != null) {
						tempTreeNode1 = tempTreeNode1.getLeftChild();
					}
					tempTreeNode1.setLeftChild(leftNode);
					return rightNode;
				}
			} else if (key.compareToIgnoreCase(root.getNode().getKey()) > 0) {
				root.setRightChild(deleteRecursive(root.getRightChild(), key));
			} else if (key.compareToIgnoreCase(root.getNode().getKey()) < 0) {
				root.setLeftChild(deleteRecursive(root.getLeftChild(), key));
			}
		}
		try {
			if (root == null)
				throw new InvalidEntries("Enter valid key");
			else
				return root;
		} catch (InvalidEntries e) {
			throw new InvalidEntries("Enter valid key");
		}
	}

	@Override
	public E getValue(String key) throws InvalidEntries, EmptyTree {
		try {
			if (key == null || key == "") {
				throw new InvalidEntries("Enter valid key");
			}
			if (root == null) {
				throw new EmptyTree("Tree is empty can't perform any operation");
			} else {
				E value = getValueRecursive(root, key);
				return value;
			}
		} catch (InvalidEntries e) {
			throw new InvalidEntries("Enter valid key");
		} catch (EmptyTree e) {
			throw new EmptyTree("Tree is empty can't perform any operation");
		}
	}

	/**
	 * Method to return the value mapped to the given key
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private E getValueRecursive(TreeNode<E> root, String key) {
		E value;
		if (key.compareToIgnoreCase(root.getNode().getKey()) == 0) {
			return root.getNode().getValue();
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) > 0) {
			value = getValueRecursive(root.getRightChild(), key);
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) < 0) {
			value = getValueRecursive(root.getLeftChild(), key);
		} else {
			throw new AssertionError("Enter valid key");
		}
		return value;
	}

	@Override
	public List<Node<E>> sortedOrder() throws EmptyTree {
		try {
			if (root == null) {
				throw new EmptyTree("Tree is empty can't perform any operation");
			} else {
				sortedOrderRecursively(root);
				return sortedList;
			}
		} catch (EmptyTree e) {
			throw new EmptyTree("Tree is empty can't perform any operation");
		}

	}

	/**
	 * Method to return the sorted order of the tree nodes
	 * 
	 * @param root
	 */
	private void sortedOrderRecursively(TreeNode<E> root) {
		if (root != null) {
			sortedOrderRecursively(root.getLeftChild());
			sortedList.add(root.getNode());
			sortedOrderRecursively(root.getRightChild());
		}
	}

	@Override
	public List<Node<E>> sortBetweenTwoKeyValue(String key1, String key2) throws EmptyTree, InvalidEntries {
		try {
			if (root == null) {
				throw new EmptyTree("Tree is empty can't perform any operation");
			} else if (key1 == null || key2 == null || (key1.compareToIgnoreCase(key2) > 0) || "".equals(key1)
					|| "".equals(key2)) {
				throw new InvalidEntries("Enter valid key");
			} else {
				sortBetweenTwoKeyValueRecursively(this.root, key1, key2);
				return sortedBetweenTwoKeys;
			}

		} catch (EmptyTree e) {
			throw new EmptyTree("Tree is empty can't perform any operation");
		} catch (InvalidEntries e) {
			throw new InvalidEntries("Enter valid key");
		}
	}

	/**
	 * Method to return the sorted order of tree nodes lying between given two
	 * key values
	 * 
	 * @param root
	 * @param key1
	 * @param key2
	 */
	private void sortBetweenTwoKeyValueRecursively(TreeNode<E> root, String key1, String key2) {
		if (root != null) {
			if (key1.compareToIgnoreCase(root.getNode().getKey()) < 0) {
				sortBetweenTwoKeyValueRecursively(root.getLeftChild(), key1, key2);
			}
			if (key1.compareToIgnoreCase(root.getNode().getKey()) <= 0
					&& key2.compareToIgnoreCase(root.getNode().getKey()) >= 0) {
				sortedBetweenTwoKeys.add(root.getNode());
			}
			if (key2.compareToIgnoreCase(root.getNode().getKey()) > 0) {
				sortBetweenTwoKeyValueRecursively(root.getRightChild(), key1, key2);
			}
		}

	}

}
