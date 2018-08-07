package Question1;
import java.util.Scanner;

class Check {

	int sumOfAll(Object[] array, int sum) {
		for (Object o : array) {
			if (o instanceof Integer) {
				sum = sum + (int) o;
			} else if(o instanceof Object[]){
				Object[] p = (Object[]) o;
				sum = sumOfAll(p, sum);
			}else{
				throw new AssertionError("Invalid input");
			}
		}

		return sum;
	}

	int greatestValue(Object[] array, int max) {
		for (Object o : array) {
			if (o instanceof Integer) {
				if (max < (int) o) {
					max = (int) o;
				}
			} else{
				Object[] p = (Object[]) o;
				max = greatestValue(p, max);
			}
		}
		return max;
	}

	boolean search(Object[] array, int val) {
		boolean flag = false;
		outerloop: for (Object o : array) {
			if (o instanceof Integer) {
				int check = (int) o;
				if (check == val) {
					System.out.println((check + " WHY??? " + val));
					flag = true;
					return flag;
				}
			} else {
				Object[] p = (Object[]) o;
				flag = search(p, val);
			}
		}
		return flag;
	}
}

public class NLMain {
	/**
	 * @param args
	 */
	public static <E> void main(String[] args) {
		Object[] array = new Object[4];

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			System.out.println("Enter 1 for int and 2 for list");
			int choice = sc.nextInt();
			if (choice == 1) {
				int n = sc.nextInt();
				array[i] = n;
			} else if (choice == 2) {
				Object[] a = new Object[4];
				Object[] b= new Object[2];
				b[0] = 1;
				b[1] = 5;
				a[0] = 2;
				a[1] = new Object[2];
				a[1] = b;
				a[2] = 4;
				a[3] = 5;
				array[i] = a;
			}
		}

		for (Object e : array) {
			if (e instanceof Integer) {
				System.out.println(e);
			} else if (e instanceof Object) {
				Object[] s = (Object[]) e;
				for (int i = 0; i < s.length; i++) {
					System.out.println(s[i]);
				}
			}
		}
		Check c = new Check();
		System.out.println("SUM " + c.sumOfAll(array, 0));
		System.out.println("MAX " + c.greatestValue(array, 0));
		System.out.println("RESULT " + c.search(array, 5));
	}

}
