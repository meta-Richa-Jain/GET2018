package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements all the functionality of the graph interface
 * 
 * @author Richa Jain
 *
 */
public class WeightedGraph implements Graph {

	/* no of nodes in a graph */
	private int vertices;
	/* array of linked list to represent the adjacency list */
	public LinkedList<Node> adjacencyList[];

	@SuppressWarnings("unchecked")
	public WeightedGraph(int vertices) {
		if (vertices > 0) {
			this.vertices = vertices;
			adjacencyList = new LinkedList[this.vertices];
			for (int count = 0; count < this.vertices; count++) {
				adjacencyList[count] = new LinkedList<>();
			}
		}
	}

	private boolean checkValidation(int vertices) {
		return vertices > 0 ? true : false;
	}

	/**
	 * Method to add edges to the undirected graph
	 * 
	 * @param source
	 * @param destination
	 * @param weight
	 *            distance between the source and the destination
	 * @return tru if edge is added successfully else false
	 * @throws InvalidInput
	 */
	public boolean addEdge(int source, int destination, int weight)
			throws Validation, InvalidInput {
		try {
			if (!checkValidation(this.vertices)) {
				throw new Validation(
						"number of vertices should be greater than zero");
			}
			if (source < 0 || source >= this.vertices || destination < 0
					|| destination >= this.vertices || weight < 0) {
				throw new InvalidInput("Please enter correct input");
			} else {

				Node node1 = new Node(destination, weight);
				adjacencyList[source].add(node1);
				Node node2 = new Node(source, weight);
				adjacencyList[destination].add(node2);
				return true;
			}
		} catch (Validation e) {
			throw new Validation(
					"number of vertices should be greater than zero");
		} catch (InvalidInput e) {
			throw new InvalidInput("Please enter correct input");
		}
	}

	@Override
	public boolean isConnected() throws Validation {

		try {
			if (!checkValidation(this.vertices)) {
				throw new Validation(
						"number of vertices should be greater than zero");
			} else {
				Node node = adjacencyList[0].get(0);
				int startingVertex = node.getVertex();
				boolean visited[] = new boolean[this.vertices];
				visited = depthFirstSearch(startingVertex, visited);
				boolean connected = false;
				for (int count = 0; count < visited.length; count++) {
					if (visited[count]) {
						connected = true;
					} else {
						connected = false;
					}
				}
				return connected;
			}
		} catch (Validation e) {
			throw new Validation(
					"number of vertices should be greater than zero");
		}
	}

	/**
	 * Helper method to find the depth first traversal of the graph
	 * 
	 * @param startingVertex
	 *            for the traversal
	 * @param visited
	 *            , stores the list of all visited nodes
	 * @return the the list of all visited nodes
	 */
	private boolean[] depthFirstSearch(int startingVertex, boolean visited[]) {
		visited[startingVertex] = true;
		Iterator<Node> iterator = adjacencyList[startingVertex].listIterator();
		while (iterator.hasNext()) {
			Node nextNode = iterator.next();
			int nextVertex = nextNode.getVertex();
			if (!visited[nextVertex]) {
				depthFirstSearch(nextVertex, visited);
			}
		}
		return visited;
	}

	@Override
	public List<Integer> reachable(int source) throws InvalidInput, Validation {
		try {
			if (!checkValidation(this.vertices)) {
				throw new Validation(
						"number of vertices should be greater than zero");
			} else if (source < 0 || source >= this.vertices) {
				throw new InvalidInput("Please enter correct input");
			} else {
				boolean visited[] = new boolean[this.vertices];
				boolean[] reachableNode = depthFirstSearch(source, visited);
				List<Integer> list = new ArrayList<>();
				for (int count = 0; count < reachableNode.length; count++) {
					if (reachableNode[count]) {
						list.add(count);
					}
				}
				return list;
			}
		} catch (InvalidInput e) {
			throw new InvalidInput("Please enter correct input");
		} catch (Validation e) {
			throw new Validation(
					"number of vertices should be greater than zero");
		}

	}

	@Override
	public int[] mst() throws Validation {
		try {
			if (!checkValidation(this.vertices)) {
				throw new Validation(
						"number of vertices should be greater than zero");
			}
			int tree[] = new int[this.vertices];
			int key[] = new int[this.vertices];
			boolean mstSet[] = new boolean[this.vertices];

			for (int count = 0; count < this.vertices; count++) {
				key[count] = Integer.MAX_VALUE;
			}

			key[0] = 0;
			tree[0] = -1;

			for (int count = 0; count < this.vertices; count++) {
				int index[] = minDistance(key, mstSet);

				mstSet[index[1]] = true;

				for (int count2 = 0; count2 < this.vertices; count2++) {

					int dist = index[0];
					if (dist != 0 && mstSet[count2] == false
							&& dist < key[count2]) {
						tree[count2] = index[1];
						key[count2] = dist;
						System.out.println(dist);
					}

				}
			}
			return tree;
		} catch (Validation e) {
			throw new Validation(
					"number of vertices should be greater than zero");
		}

	}

	/**
	 * Method to find the index of the node with minimum edge weight and is
	 * unvisited
	 * 
	 * @param distance
	 * @param shortestPath
	 * @return the index and weight of the node with minimum edge weight
	 */
	private int[] minDistance(int distance[], boolean shortestPath[]) {

		int minNode[] = new int[2];
		minNode[0] = Integer.MAX_VALUE; // minimum weight
		minNode[1] = -1; // node's index

		for (int count = 0; count < this.vertices; count++) {
			if ((!shortestPath[count]) && distance[count] <= minNode[0]) {
				minNode[1] = count;
				minNode[0] = distance[count];
			}
		}
		return minNode;
	}

	@Override
	public int shortestPath(int source, int destination) throws Validation,
			InvalidInput {

		try {
			if (!checkValidation(this.vertices)) {
				throw new Validation(
						"number of vertices should be greater than zero");
			} else if (source < 0 || source >= this.vertices || destination < 0
					|| destination >= this.vertices) {
				throw new InvalidInput("Please enter correct input");
			}
			int shortestDistance = 0;

			int distance[] = new int[this.vertices];
			boolean shortestPath[] = new boolean[this.vertices];

			for (int count = 0; count < this.vertices; count++) {
				distance[count] = Integer.MAX_VALUE;
			}

			distance[source] = 0;

			outerloop: for (int count1 = 0; count1 < this.vertices - 1; count1++) {

				int[] nextVertex = minDistance(distance, shortestPath);

				shortestPath[nextVertex[1]] = true;

				for (int count2 = 0; count2 < this.vertices; count2++) {
					int dist = nextVertex[0];
					if ((!shortestPath[count2])
							&& dist != 0
							&& distance[nextVertex[1]] != Integer.MAX_VALUE
							&& distance[nextVertex[1]] + dist < distance[count2]) {
						distance[count2] = distance[nextVertex[1]] + dist;
						if (count2 == destination) {
							shortestDistance = distance[count2];
							break outerloop;
						}
					}

				}
			}

			return shortestDistance;
		} catch (Validation e) {
			throw new Validation(
					"number of vertices should be greater than zero");
		} catch (InvalidInput e) {
			throw new InvalidInput("Please enter correct input");
		}
	}

}
