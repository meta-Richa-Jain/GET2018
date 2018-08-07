package Question1;


public interface NestedList {
	
	public int sumOfAll(Object[] list, int sum) throws InvalidInput;
	public int largestValue(Object[] list, int max) throws InvalidInput;
	public boolean search(Object[] list,int val) throws InvalidInput; 
	public int getValue(Object[] list, String pattern, int index) throws InvalidInput;

}
