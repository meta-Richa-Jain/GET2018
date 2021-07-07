package nestedList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class NestedListTest {
	@Test
	public void testSum() throws IOException, ParseException, InvalidInput {

		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();

		long result = nestedOperations.sumOfAllValues();
		assertEquals(result, 207);
	}

	@Test
	public void testLargest() throws IOException, ParseException, InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		long result = nestedOperations.largestValue();
		assertEquals(result, 99);
	}

	@Test
	public void testSearchPositive() throws IOException, ParseException,
			InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		boolean result = nestedOperations.searchValue(45);
		assertEquals(result, true);
	}

	@Test
	public void testSearchNegative() throws IOException, ParseException,
			InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		boolean result = nestedOperations.searchValue(-8);
		assertEquals(result, false);
	}

	@Test
	public void testGetValuePositive() throws IOException, ParseException,
			InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue("thh");
		assertEquals(result, 1);
	}

	@Test(expected = InvalidInput.class)
	public void testGetValueNegativeOnlyTPresent() throws IOException,
			ParseException, InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue("t");
	}

	@Test
	public void testGetValuePositiveIgnoreCase() throws IOException,
			ParseException, InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue("THH");
		assertEquals(result, 1);
	}

	@Test(expected = InvalidInput.class)
	public void testGetValueNegativeInvalidInput() throws IOException,
			ParseException, InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue("abc@");

	}

	@Test(expected = NullPointerException.class)
	public void testGetValueNullString() throws IOException, ParseException,
			InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue(null);

	}

	@Test(expected = NullPointerException.class)
	public void testGetValueEmptyString() throws IOException, ParseException,
			InvalidInput {
		File file = new File(
				"C:/Users/User12/workspace/DS-Assignment2 (part2)/src/nestedList/input.json.txt");

		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject jsonObject = (JSONObject) object;

		NestedListOperation nestedOperations = new NestedListOperation(
				jsonObject);
		nestedOperations.createNestedList();
		long result = (long) nestedOperations.getValue("  ");

	}

}
