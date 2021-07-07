package Graph;

/**
 * This class is used to store information about a vertex such as its name and
 * weight
 * 
 * @author Richa Jain
 *
 */
public class Node {

	private int vertex;
	private int weight;

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	public int getVertex() {
		return vertex;
	}

	public int getWeight() {
		return weight;
	}

}
