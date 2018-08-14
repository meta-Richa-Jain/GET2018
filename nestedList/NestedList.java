package nestedList;


/**
 * NestedList Interface will contain different method declaration for sum of all
 * values of list, largest value of list, or searching value in list.
 * 
 * @author Richa Jain
 *
 * @param <E>
 */
public interface NestedList {
	/**
	 * sumOfAllvalues will calculate the sum of all values present in nested
	 * list
	 * 
	 * @param nestedList
	 *            whose values sum is to be calculated
	 * @return sum of all values of nested list
	 * @throws InvalidInput 
	 */
	public long sumOfAllValues() throws InvalidInput;

	/**
	 * largestValue will find the largest value present in nested list
	 * 
	 * @param nestedList
	 *            in which largest value is to be searched
	 * @return largest value in nested list
	 * @throws InvalidInput 
	 */
	public long largestValue() throws InvalidInput;

	/**
	 * searchValue will search the element in nested list
	 * 
	 * @param nestedList
	 *            in which value is to be searched
	 * @param element
	 * @return
	 * @throws InvalidInput 
	 */
	public boolean searchValue(int element) throws InvalidInput;
}