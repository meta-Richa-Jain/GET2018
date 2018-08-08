package Question2;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountUniqueCharacterTest {
	
	UniqueCharacters count = new UniqueCharacters();

	@Test
	public void testOnlyCharacters() {
		int result = count.CountUniqueCharacters("Richa");
		assertEquals(5,result);
	}
	
	@Test
	public void testCharactersAndNumbersAndSpecialCharacters() {
		int result = count.CountUniqueCharacters("Richa@123");
		assertEquals(9,result);
	}
	
	@Test
	public void testCharactersAndNumbersAndSpecialCharactersWithSpace() {
		int result = count.CountUniqueCharacters("Richa @123");
		assertEquals(9,result);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullString() {
		int result = count.CountUniqueCharacters(null);
		
	}

}
