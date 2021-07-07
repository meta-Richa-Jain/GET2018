package Graph;

import java.util.List;

/**
 * This class contains the methods related to a graph that has to be implemented
 * 
 * @author Richa Jain
 *
 */
public interface Graph {

	/**
	 * Method used to find if a graph is connected i.e., all nodes are
	 * reachable, or not
	 * 
	 * @return true if graph is connected else false
	 * @throws Validation
	 */
	public boolean isConnected() throws InvalidInput, Validation;

	/**
	 * Method to find list of all nodes that are reachable from the given source
	 * node
	 * 
	 * @param source
	 *            of which all reachable nodes has to find
	 * @return the list of all reachable node
	 * @throws InvalidInput
	 * @throws Validation
	 */
	public List<Integer> reachable(int source) throws InvalidInput, Validation;

	/**
	 * Method to find minimum spanning tree of a graph
	 * 
	 * @return the integer aaray of the node's vertices such as the total sum of
	 *         the edges in minimum
	 * @throws Validation 
	 */
	public int[] mst() throws Validation;

	/**
	 * Method to find the shortest path between the source and the destination
	 * 
	 * @param source
	 *            begining index of the traversal
	 * @param destiination
	 *            end index of the traversal
	 * @return minimum distance
	 * @throws Validation 
	 * @throws InvalidInput 
	 */
	public int shortestPath(int source, int destiination) throws Validation, InvalidInput;

}
