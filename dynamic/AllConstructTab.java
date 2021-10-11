import java.util.*;
import java.util.stream.*;
public class AllConstructTab {
	
	public static void main(String...args) {
		printAll(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
		printAll(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
		printAll(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
		
		printAll(allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
		
		printAll(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
		
		//System.out.println(Arrays.toString(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})));
		
		//System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"ef", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
		
		/**
			[[abc, def]]
			[[purp, le], [p, ur, p, le]]
			[]
			[[enter, a, p, ot, ent, p, ot], [enter, a, p, ot, ent, p, o, t], [enter, a, p, o, t, ent, p, ot], [enter, a, p, o, t, ent, p, o, t]]
			[[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
			[]

		*/
	}
	
	private static String[][] allConstruct(String target, String[] wordBank) {
		int m = target.length();
		String[][][] table = new String[m+1][][];
		table[0] = new String[1][1];
		table[0][0][0] = "";
		for (int i=0; i<table.length; i++) {
			if (table[i] == null) {
				continue;
			}
			for (int j=0; j<wordBank.length; j++) {
				int wordLen = wordBank[j].length();
				if(isPossible(target, wordBank[j], i)) {
					int start = 0;
					if(table[i + wordLen] == null) {
						table[i + wordLen] = new String[table[i].length][];
					}
					else {
						start = table[i + wordLen].length;
						table[i + wordLen] = Arrays.copyOf(table[i + wordLen], table[i].length + table[i + wordLen].length);
					}
					for(int k=0;k<table[i].length;k++) {
						table[i + wordLen][start] = Arrays.copyOf(table[i][k], table[i][k].length+1);
						table[i + wordLen][start][table[i][k].length] = wordBank[j];
						start++;
					}
					
				}
			}
		}
		return table[m];
	}
	
	private static void  printAll(String[][] list) {
		if(list == null) {
			System.out.println("[]");
			return;
		}
		System.out.println("[");
		for(int i=0;i<list.length;i++) {
			System.out.println(Arrays.toString(list[i]));
		}
		System.out.println("]");
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
