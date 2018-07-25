package Question1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class intSetTest {
	int[] array = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };
	IntSet intSet = new IntSet(array);

	@Test
	public void testIsMemberPositive() {
		assertEquals(true, intSet.isMember(3));
	}

	@Test
	public void testIsMemberNegative() {
		assertNotEquals(true, intSet.isMember(10));
	}

	@Test
	public void testSizePositive() {
		assertEquals(8, intSet.size());
	}

	@Test
	public void testSizeNegative() {
		assertNotEquals(9, intSet.size());
	}

	@Test
	public void testIsSubSetPositive() {
		int[] arraySubSet = new int[] { 2, 3, 4 };
		IntSet subSet = new IntSet(arraySubSet);
		assertEquals(true, intSet.isSubset(subSet));
	}

	@Test
	public void testIsSubSetNegative() {
		int[] arraySubSet = new int[] { 2, 3, 4, 10 };
		IntSet subSet = new IntSet(arraySubSet);
		assertNotEquals(true, intSet.isSubset(subSet));
	}

	@Test
	public void testUnion() {
		int[] set1 = new int[] { 2, 3, 4 };
		int[] set2 = new int[] { 2, 5, 6 };
		int[] set3 = new int[]{2,3,4,5,6};
		IntSet setObj1 = new IntSet(set1);
		IntSet setObj2 = new IntSet(set2);
		IntSet setObj3 = setObj1.union(setObj1, setObj2);
		assertArrayEquals(set3,setObj3.getSet());
	}
	
	@Test
	public void testComplementPositive() {
		int[] array = new int[] { 1,10 };
		IntSet intSet1 = new IntSet(array);
		IntSet comp = intSet1.getComplement();
		int[] result = comp.getSet();
		int check[] = new int[result.length];
		int count=0;
		for(int i=1;i<1001;i++)
		{
			if(!(i==1 || i==10)){
				check[count] = i;
				count++;
			}
		}
		IntSet q = new IntSet(check);
		
		assertArrayEquals(q.getSet(), comp.getSet());
	}

}
