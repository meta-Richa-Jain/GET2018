package Graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class WeightedGraphTest {

	@Test
	public void testIsConnectedPositive() throws Validation, InvalidInput {
		WeightedGraph graph = new WeightedGraph(4);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 3, 2);
		graph.addEdge(1, 3, 3);

		assertEquals(true, graph.isConnected());

	}

	@Test(expected = Validation.class)
	public void testValidation() throws Validation, InvalidInput {
		WeightedGraph graph = new WeightedGraph(-4);
		graph.addEdge(0, 1, 1);

	}

	@Test(expected = InvalidInput.class)
	public void testInvalidInputNegativeVertices() throws Validation,
			InvalidInput {
		WeightedGraph graph = new WeightedGraph(4);
		graph.addEdge(0, -1, 1);

	}

	@Test(expected = InvalidInput.class)
	public void testInvalidInputNegativeWeight() throws Validation,
			InvalidInput {
		WeightedGraph graph = new WeightedGraph(4);
		graph.addEdge(0, 1, -1);

	}

	@Test(expected = InvalidInput.class)
	public void testInvalidInputOutOfRangeNodeIndex() throws Validation,
			InvalidInput {
		WeightedGraph graph = new WeightedGraph(4);
		graph.addEdge(0, 5, 1);

	}

	@Test
	public void testIsConnectedNegative() throws Validation, InvalidInput {
		WeightedGraph graph = new WeightedGraph(6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 3, 2);
		graph.addEdge(1, 3, 3);
		graph.addEdge(4, 5, 3);
		assertEquals(false, graph.isConnected());

	}

	@Test
	public void testShortestPath() throws Validation, InvalidInput {
		WeightedGraph graph = new WeightedGraph(6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 3, 2);
		graph.addEdge(1, 3, 0);
		assertEquals(0, graph.shortestPath(1, 3));

	}

	@Test
	public void testMST() throws Validation, InvalidInput {
		WeightedGraph graph = new WeightedGraph(6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 3, 2);
		graph.addEdge(1, 3, 0);
		int actualResult[] = graph.mst();
		int expectedResult[] = new int[4];
		expectedResult[0] = -1;
		expectedResult[1] = 0;
		expectedResult[2] = 0;
		expectedResult[3] = 0;
		for (int count = 0; count < expectedResult.length; count++) {
			assertEquals(expectedResult[count], actualResult[count]);
		}
	}

	@Test
	public void testReachable() throws Validation, InvalidInput {
		WeightedGraph graph = new WeightedGraph(6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 3, 2);
		graph.addEdge(1, 3, 0);
		List<Integer> actualResult = graph.reachable(3);
		List<Integer> expectedResult = new ArrayList<Integer>();
		expectedResult.add(0);
		expectedResult.add(1);
		expectedResult.add(2);
		expectedResult.add(3);
		for (int count = 0; count < actualResult.size(); count++) {
			assertEquals(expectedResult.get(count), actualResult.get(count));
		}
	}

}
