package Question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class is used to count the number of unique characters in a string and
 * cache the results to save time in counting operation
 * 
 * @author Richa Jain
 *
 */
public class UniqueCharacters {

	/* String is stored in cache to save time in counting operation */
	static Map<String, Integer> cache = new HashMap<String, Integer>();

	/**
	 * Method to count the number of unique characters in a string
	 * 
	 * @param string
	 * @return count of unique characters
	 */
	public int CountUniqueCharacters(String string) {
		try {
			if (string == null) {
				throw new NullPointerException("String can't be null");
			}
			string = string.toLowerCase();
			if (cache.containsKey(string)) {
				return cache.get(string);
			} else {
				Set<Character> uniqueCharacter = new HashSet<Character>();
				for (Character character : string.toCharArray()) {
					if (character == ' ') {
						continue;
					}
					if (!uniqueCharacter.contains(character)) {
						uniqueCharacter.add(character);
					}
				}
				cache.put(string, uniqueCharacter.size());
				return uniqueCharacter.size();
			}
		} catch (NullPointerException message) {
			throw new NullPointerException("String can't be null");
		}

	}

}
