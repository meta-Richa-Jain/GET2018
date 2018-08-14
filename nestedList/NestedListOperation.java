package nestedList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * NestedListOperation class will define all the methods declared in nestedlist
 * interface
 * 
 * @author Richa Jain
 *
 */
public class NestedListOperation implements NestedList {
	private List<Object> nestedList = new ArrayList<Object>(); // nested List
	private long value; // value evaluated for string input
	private JSONObject jsonObject;

	/**
	 * constructor of class
	 * 
	 * @param inputString
	 *            json file location
	 * @throws IOException
	 * @throws ParseException
	 */
	public NestedListOperation(JSONObject jsonObject) {
		if (jsonObject != null) {
			this.jsonObject = jsonObject;
		}
	}

	public void createNestedList() {
		if (jsonObject != null) {
			this.nestedList = createNestedListRecursive(jsonObject);
		} else {
			throw new NullPointerException("Empty JSON Object");
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
	private List<Object> createNestedListRecursive(JSONObject jsonObject) {
		LinkedList<Object> nestedList = new LinkedList<>();
		try {
			for (Object key : jsonObject.keySet()) {
				if (key != null) {
					if (jsonObject.get(key) instanceof Long) {
						long value = (Long) jsonObject.get(key);
						nestedList.add(value);
					} else {
						JSONObject newJson = (JSONObject) jsonObject.get(key);
						List<Object> list = createNestedListRecursive(newJson);
						nestedList.add(list);
					}
				} else {
					throw new NullPointerException("Empty key value");
				}
			}
			return nestedList;
		} catch (NullPointerException e) {
			throw new NullPointerException("Empty key value");
		}
	}

	@Override
	public long sumOfAllValues() throws InvalidInput {
		try {
			if (nestedList != null) {
				return sumOfAllValues(nestedList);
			} else {
				throw new InvalidInput("Empty nested list");
			}
		} catch (InvalidInput e) {
			throw new InvalidInput("Empty nested list");
		}

	}

	/**
	 * private helper method to get the sum of all values of nested list
	 * 
	 * @param nestedList
	 *            whose value's sum is to be calculated
	 * @return sum of all values of nested list
	 * @throws InvalidInput
	 */
	private long sumOfAllValues(List<Object> nestedList) throws InvalidInput {
		try {
			long sum = 0;
			for (Object object : nestedList) {
				if (object instanceof List) {
					sum += sumOfAllValues((List<Object>) object);
				} else if (object instanceof Long) {
					sum += (long) object;
				} else {
					throw new InvalidInput("Invalid Input");
				}
			}
			return sum;
		} catch (InvalidInput e) {
			throw new InvalidInput("Invalid Input");
		}
	}

	@Override
	public long largestValue() throws InvalidInput {
		try {
			if (nestedList != null) {
				return largestValue(nestedList);
			} else {
				throw new InvalidInput("Empty nested list");
			}
		} catch (InvalidInput e) {
			throw new InvalidInput("Empty nested list");
		}
	}

	/**
	 * largest value from nested list
	 * 
	 * @param nestedList
	 *            whose largest value is to be find
	 * @return largest value of nested list
	 * @throws InvalidInput
	 */
	private long largestValue(List<Object> nestedList) throws InvalidInput {
		try {
			long max = 0;
			long temp = 0;
			for (Object object : nestedList) {
				if (object instanceof List) {
					temp = largestValue((List<Object>) object);
				} else if (object instanceof Long) {
					temp = (long) object;
				} else {
					throw new InvalidInput("Invalid Input");
				}
				if (temp > max) {
					max = temp;
				}
			}
			return max;
		} catch (InvalidInput e) {
			throw new InvalidInput("Invalid Input");
		}
	}

	@Override
	public boolean searchValue(int element) throws InvalidInput {
		try {
			if (nestedList != null) {
				return searchValue(nestedList, element);
			} else {
				throw new InvalidInput("Empty nested list");
			}
		} catch (InvalidInput e) {
			throw new InvalidInput("Empty nested list");
		}

	}

	@SuppressWarnings("unchecked")
	/**
	 * search value in nested list
	 * @param nestedList in which element is to be searched
	 * @param element which is to be searched in list
	 * @return true if element is present in list else false
	 */
	private boolean searchValue(List<Object> nestedList, int element)
			throws InvalidInput {
		try {
			boolean flag = false;
			for (Object object : nestedList) {
				if (object instanceof List) {
					if (searchValue((List<Object>) object, element)) {
						return true;
					}
				} else if (object instanceof Long) {
					if ((long) object == element) {
						flag = true;
						return flag;
					}
				} else {
					throw new InvalidInput("Invalid Input");
				}

			}
			return flag;
		} catch (InvalidInput e) {
			throw new InvalidInput("Invalid Input");
		}
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
	 * @throws InvalidInput
	 */

	public long getValue(String pattern) throws InvalidInput {
		try {
			if (pattern == null) {
				throw new NullPointerException("String can't be null");
			} else if (pattern.trim().isEmpty()) {
				throw new NullPointerException("String is empty");
			} else if (nestedList != null) {
				getvalueRecursive(nestedList, pattern);
				return value;
			} else {
				throw new InvalidInput("empty nested list");
			}
		} catch (NullPointerException e) {
			throw new NullPointerException("String is empty or null");
		} catch (InvalidInput e) {
			throw new InvalidInput("Empty nested list");
		}
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
	 * @throws InvalidInput
	 */
	@SuppressWarnings("unchecked")
	private void getvalueRecursive(List<Object> nestedList, String pattern)
			throws InvalidInput {
		try {
			long lengthOfString = pattern.length();
			if (lengthOfString > 1) {
				if (pattern.charAt(0) == 'H' || pattern.charAt(0) == 'h') {
					if (nestedList.get(0) instanceof List) {
						getvalueRecursive((List) nestedList.get(0),
								pattern.substring(1));
					} else {
						throw new InvalidInput("Wrong input");
					}
				} else if (pattern.charAt(0) == 'T' || pattern.charAt(0) == 't') {
					if (nestedList.get(1) instanceof List) {
						List<Object> newList = new LinkedList<>(nestedList);
						newList.remove(0);
						getvalueRecursive(newList, pattern.substring(1));
					} else {
						throw new InvalidInput("Wrong input");
					}
				} else
					throw new InvalidInput("Wrong input");
			} else {
				if (pattern.charAt(0) == 'H' || pattern.charAt(0) == 'h') {
					if (nestedList.get(0) instanceof Long)
						value = (long) nestedList.get(0);
					else
						throw new InvalidInput("Wrong input");
				} else if (pattern.charAt(0) == 'T' || pattern.charAt(0) == 't') {
					if (nestedList.get(1) instanceof Long)
						value = (long) nestedList.get(1);
					else
						throw new InvalidInput("Wrong input");
				} else
					throw new InvalidInput("Wrong input");
			}
		} catch (InvalidInput e) {
			throw new InvalidInput("Wrong Input");
		}
	}
}
