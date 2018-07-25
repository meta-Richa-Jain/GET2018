package Question1;

/**
 * Immutable class used to represent integer numbers in the range 1-1000 and functions to calculate 
 * size of the set, isMember, union of two set and isSubset
 * @author Richa Jain
 *
 */
final class IntSet implements IntegersArray{

	private final int[] set;
	private int SETSIZE;

	public IntSet(int[] inputArray) {
		set = new int[inputArray.length];
		if (inputArray.length < 1001) {
			for (int count = 0; count < inputArray.length; count++) {
				if (inputArray[count] > 0 && inputArray[count] < 1001 && !isMember(inputArray[count])) {
					set[count] = inputArray[count];
					SETSIZE++;
				}
			}
		}
	}

	/*private boolean checkValidation(int inputArray[]){
		for (int count = 0; count < inputArray.length; count++) {
			if(!(inputArray[count]>0 && inputArray[count]<1001)){
				return false;
			}
			if (inputArray[count] > 0 && inputArray[count] < 1001 && !isMember(inputArray[count])) {
				set[count] = inputArray[count];
				SETSIZE++;
			}
		}
		return true;
	}*/
	/**
	 * Display function to display the set of integers
	 */
	private void display() {
		for (int count = 0; count < size(); count++) {
			System.out.print(set[count] + " ");
		}
	}

	/**
	 * Function to return the array of integers
	 * @return set, array of integers
	 */
	public int[] getSet() {
		return set;
	}

	/**
	 * Function to check if xVal is already a memeber of the given set
	 * @param xVal, val to be searched for
	 * @return true if it is a member of the set else false
	 */
	public boolean isMember(int xVal) {
		//checkValidation(this.set);
		for(int count = 0;count<set.length;count++){
			if(set[count] == xVal){
				return true;
			} 
		}
		return false;
	}

	/**
	 * Function to get the size of the set
	 * @return SETSIZE, size of the set
	 */
	public int size() {
		//checkValidation(this.set);
		return SETSIZE;
	}

	/**
	 * To get the complement set of the calling object
	 * @return complementSet
	 */
	public IntSet getComplement() {
		//checkValidation(this.set);
		int compLength = 1001-this.size();
		int complementSet[] = new int[compLength];
		int count2 = 0;
		for (int element = 1; element <1001; element++) {
			if(!isMember(element)){
				complementSet[count2] = element;
				count2++;
			}
		}
		return new IntSet(complementSet);
	}

	/**
	 * Function to find union of two IntSet 
	 * @param set1, first input IntSet
	 * @param set2, second input IntSet
	 * @return resultSet, union of two sets
	 */
	public IntSet union(IntSet set1, IntSet set2){
		//checkValidation(this.set);
		int arraySet1[] = set1.getSet();
		int arraySet2[] = set2.getSet();
		int intermediateSet[] = new int[set1.size() + set2.size()];
		int resultCount =0;
		int common = 0;
		for(int count = 0;count<set1.size();count++){
			intermediateSet[resultCount]=arraySet1[count];
			resultCount++;
		}
		for(int count = 0;count<set2.size();count++){
			if(!isMember(arraySet2[count])){
				intermediateSet[resultCount]= arraySet2[count];
			resultCount++;
			}
			else{
				common++;
			}
		}
		int resultSet[] = new int[intermediateSet.length-common];
		for(int count=0;count<resultSet.length;count++){
			resultSet[count] = intermediateSet[count];
		}
		return new IntSet(resultSet);
	}
	
	/**
	 * Function to find if the given subset is a Subset of the calling set
	 * @param subset, 
	 */
	public boolean isSubset(IntSet subSet){
		//checkValidation(this.set);
		int subArray[] = subSet.getSet();
		if(subArray.length==0 || (this.size()==0 && subArray.length==0)){
			return true;
		}
		for(int count =0;count<subArray.length;count++){
			if(!isMember(subArray[count])){
				return false;
			}
		}
		return true;
	}
}
