import java.util.*;
public class CountConstructTab {
	
	public static void main(String...args) {
		System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
		System.out.println(canConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
		System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
		
		System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "p"}));
		
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
		
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"ef", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
		
		/*
			1
			2
			0
			4
			0
			13829188
		*/
	}
	
	private static long canConstruct(String target, String[] wordBank) {
		long[] table = new long[target.length() + 1];
		table[0] = 1;
		for (int i=0; i<table.length; i++) {
			if (table[i] == 0) {
				continue;
			}
			for (int j=0; j<wordBank.length; j++) {
				if(isPossible(target, wordBank[j], i)) {
					table[i+wordBank[j].length()] += table[i];
				}
			}
		}
		return table[table.length-1];
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
