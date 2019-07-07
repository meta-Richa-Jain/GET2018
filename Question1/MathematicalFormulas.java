public class MathematicalFormulas {
	
	private static int lcm = 1;
	/**
	 * Find highest common factor of two numbers x and y
	 * @param x, requires to be positive integer
	 * @param y, requires to be positive integer
	 * @return hcf of the two numbers
	 */
	int findHcf(int x, int y){
		if(x==0){
			return y;
		}
		return findHcf(y%x, x);
	}
	
	/**
	 * find lowest common multiple of two numbers x and y
	 * @param x, requires to be a positive integer
	 * @param y, requires to be a negative integer
	 * @return lcm of two numbers
	 */
	int findLcm(int x, int y){
		if(lcm%x == 0 && lcm%y==0){
			return lcm;
		}
		lcm++;
		return findLcm(x,y);
	}	
}
