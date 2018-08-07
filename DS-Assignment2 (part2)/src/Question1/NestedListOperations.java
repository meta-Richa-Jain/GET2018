package Question1;

import java.util.Arrays;

public class NestedListOperations implements NestedList {

	public int sumOfAll(Object[] array, int sum) throws InvalidInput {
		for (Object o : array) {
			if (o instanceof Integer) {
				sum = sum + (int) o;
			} else if (o instanceof Object[]) {
				Object[] p = (Object[]) o;
				sum = sumOfAll(p, sum);
			} else {
				throw new InvalidInput("Invalid input");
			}
		}

		return sum;
	}

	public int largestValue(Object[] array, int max) throws InvalidInput {
		for (Object o : array) {
			if (o instanceof Integer) {
				if (max < (int) o) {
					max = (int) o;
				}
			} else if(o instanceof Object[]){
				Object[] p = (Object[]) o;
				max = largestValue(p, max);
			} else{
				throw new InvalidInput("Invalid input");
			}
		}
		return max;
	}

	public boolean search(Object[] array, int val) throws InvalidInput{
		boolean flag = false;
		for (Object o : array) {
			if (o instanceof Integer) {
				int check = (int) o;
				if (check == val) {
					flag = true;
					return flag;
				}
			} else if(o instanceof Object[]){
				Object[] p = (Object[]) o;
				flag = search(p, val);
			}else {
				throw new InvalidInput("Invalid Input");
			}
		}
		return flag;
	}
	
	public int getValue(Object[] list, String pattern, int index) throws InvalidInput{
		for(Object o:list){
			if("T".equals(pattern.charAt(pattern.length()))){
				throw new AssertionError("invalid");
			} else if("T".equals(pattern.charAt(index))){
				Object p[] = (Object[]) o;
				for(int count1=1;count1<p.length;count1++)
			}
			
		}
		
		
	}

}
