public class StringClass {
	public static void main(String args[]) {
		
		StringOperation operation = new StringOperation();
		System.out.println(operation.compareString("abcd", "ABCD"));
		System.out.println(operation.compareString("abcd", "abcd"));
		System.out.println(operation.compareString("abcd", "a"));
		System.out.println(operation.stringReverse("abcd"));
		System.out.println(operation.stringReverse(""));
		System.out.println(operation.stringReverse("aabbaa"));
		System.out.println(operation.changeCase("AAbbaa"));
		System.out.println(operation.changeCase(""));
		System.out.println(operation.changeCase("AbaB"));
		System.out.println(operation.getLargestWord("abc abcd abc"));
		System.out.println(operation.getLargestWord(""));
		System.out.println(operation.getLargestWord("abc ab abcd"));
		System.out.println(operation.getLargestWord("abcde ab abcd"));
	}
}
