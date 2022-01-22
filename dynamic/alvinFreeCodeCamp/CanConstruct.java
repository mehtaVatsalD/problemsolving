import java.util.*;
public class CanConstruct {
	
	public static void main(String...args) {
		System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
		System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
		
		System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "p"}));
		
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
		
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"ef", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
	}
	
	private static boolean canConstruct(String target, String[] wordBank) {
		return canConstruct(target, wordBank, 0);
	}
	
	private static boolean canConstruct(String target, String[] wordBank, int start) {
		return canConstruct(target, wordBank, start, new HashMap<>());
	}
	
	private static boolean canConstruct(String target, String[] wordBank, int start, Map<Integer, Boolean> memo) {
		if (start == target.length()) {
			return true;
		}
		if (start > target.length()) {
			return false;
		}
		if (memo.containsKey(start)) {
			return memo.get(start);
		}
		for(int i=0; i<wordBank.length; i++) {
			if (isPossible(target, wordBank[i], start)) {
				boolean possibility = canConstruct(
					target, 
					wordBank, 
					start+wordBank[i].length(),
					memo
				);
				if (possibility) {
					memo.put(start, true);
					return true;
				}
			}
		}
		memo.put(start, false);
		return false;
	}
	
	private static boolean isPossible(String target, String word, int start) {
		for(int i=0; i<word.length(); i++) {
			if (start>=target.length() || target.charAt(start) != word.charAt(i)) {
				return false;
			}
			start++;
		}
		return true;
	}
	
}