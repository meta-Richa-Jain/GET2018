package nestedList;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * NestedListOperation class will define all the methods declared in nestedlist
 * interface
 * 
 * @author Richa Jain
 *
 */
public class NestedListOperation implements NestedList {
	private List<Object> nestedList = new ArrayList<Object>();// nested List
	int value;// value evaluated for string input

	/**
	 * constructor of class
	 * 
	 * @param inputString
	 *            json file location
	 * @throws IOException
	 * @throws ParseException
	 */
	public NestedListOperation(String inputString) throws IOException,
			ParseException {
		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader(inputString));
			JSONObject jsonObject = (JSONObject) object;
			this.nestedList = createNestedList(jsonObject);
			for (int i = 0; i < nestedList.size(); i++) {
				System.out.println(nestedList.get(i));
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("sorry file cannot be found");
		}
	}

	/**
	 * private helper method to create nested list after parsing it from json
	 * file
	 * 
	 * @param jsonObject
	 *            json object which contains input nested list
	 * @return
	 */
	private List<Object> createNestedList(JSONObject jsonObject) {
		LinkedList<Object> nestedList = new LinkedList<>();

		for (Object key : jsonObject.keySet()) {
			if (jsonObject.get(key) instanceof Long) {
				long value = (Long) jsonObject.get(key);
				nestedList.add(value);
			} else {
				JSONObject newJson = (JSONObject) jsonObject.get(key);
				List<Object> list = createNestedList(newJson);
				nestedList.add(list);
			}
		}

		return nestedList;
	}

	@Override
	public int sumOfAllValues() {
		return sumOfAllValues(nestedList);

	}

	/**
	 * private helper method to get the sum of all values of nested list
	 * 
	 * @param nestedList
	 *            whose value's sum is to be calculated
	 * @return sum of all values of nested list
	 */
	private int sumOfAllValues(List<Object> nestedList) {
		int sum = 0;
		for (Object object : nestedList) {
			if (object instanceof List) {
				sum += sumOfAllValues((List<Object>) object);
			} else if (object instanceof Integer) {
				sum += (Integer) object;
			} else {
				throw new AssertionError();
			}
		}
		return sum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int largestValue() {
		return largestValue(nestedList);
	}

	/**
	 * largest value from nested list
	 * 
	 * @param nestedList
	 *            whose largest value is to be find
	 * @return largest value of nested list
	 */
	private int largestValue(List<Object> nestedList) {
		int max = 0;
		int temp = 0;
		for (Object object : nestedList) {
			if (object instanceof List) {
				temp = largestValue((List<Object>) object);
			} else if (object instanceof Integer) {
				temp = (Integer) object;
			} else {
				throw new AssertionError();
			}
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean searchValue(int element) {
		return searchValue(nestedList, element);
	}

	@SuppressWarnings("unchecked")
	/**
	 * search value in nested list
	 * @param nestedList in which element is to be searched
	 * @param element which is to be searched in list
	 * @return true if element is present in list else false
	 */
	private boolean searchValue(List<Object> nestedList, int element) {
		boolean flag = false;
		for (Object object : nestedList) {
			if (object instanceof List) {
				if (searchValue((List<Object>) object, element)) {
					return true;
				}
			} else if (object instanceof Integer) {
				if ((Integer) object == element) {
					flag = true;
					return flag;
				}
			} else {
				throw new AssertionError();
			}

		}
		return flag;
	}

	/**
	 * getValue will find the in nested list according to given string where H
	 * means head of nested list i.e., first element of nested list and T means
	 * tail of nested list i.e., all the elements except for head
	 * 
	 * @param pattern
	 *            according to which value is to be searched
	 * @param index
	 *            of string pattern from which searching is to be done
	 * @return value which is present at required location
	 */
	@SuppressWarnings("unchecked")
	public int getValue(String pattern) {
		getvalueRecursive(nestedList, pattern);
		return value;
	}

	/**
	 * private helper method for getting value in nested list according to given
	 * string
	 * 
	 * @param nestedList
	 *            in which value is to be searched
	 * @param pattern
	 *            according to which value is to be searched
	 * @return value which is present at required location
	 */
	@SuppressWarnings("unchecked")
	private void getvalueRecursive(List<Object> nestedList, String pattern) {
		int lengthOfString = pattern.length();

		if (lengthOfString > 1) {
			if (pattern.charAt(0) == 'H' || pattern.charAt(0) == 'h') {
				if (nestedList.get(0) instanceof List) {
					getvalueRecursive((List) nestedList.get(0),
							pattern.substring(1));
				} else {
					throw new AssertionError("Wrong input1");
				}
			} else if (pattern.charAt(0) == 'T' || pattern.charAt(0) == 't') {
				if (nestedList.get(1) instanceof List) {
					List<Object> newList = new LinkedList<>(nestedList);
					newList.remove(0);
					getvalueRecursive(newList, pattern.substring(1));
				} else {
					throw new AssertionError("Wrong input2");
				}
			} else
				throw new AssertionError("Wrong input3");
		} else {
			if (pattern.charAt(0) == 'H' || pattern.charAt(0) == 'h') {
				if (nestedList.get(0) instanceof Integer)
					value = (int) nestedList.get(0);
				else
					throw new AssertionError("Wrong input4");
			} else if (pattern.charAt(0) == 'T' || pattern.charAt(0) == 't') {
				if (nestedList.get(1) instanceof Integer)
					value = (int) nestedList.get(1);
				else
					throw new AssertionError("Wrong input5");
			} else
				throw new AssertionError("Wrong inpu6t");
		}
	}
}
