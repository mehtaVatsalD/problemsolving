import java.util.*;
import java.util.stream.*;
public class AllConstruct {
	
	public static void main(String...args) {
		System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
		System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
		System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
		
		System.out.println(allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
		
		System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
		
		System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
		
		//System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"ef", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
	}
	
	private static List<List<String>> allConstruct(String target, String[] wordBank) {
		return allConstruct(target, wordBank, 0);
	}
	
	private static List<List<String>> allConstruct(String target, String[] wordBank, int start) {
		return allConstruct(target, wordBank, start, new HashMap<>());
	}
	
	private static List<List<String>> allConstruct(String target, String[] wordBank, int start, Map<Integer, List<List<String>>> memo) {
		if (start == target.length()) {
			List<List<String>> listToReturn = new ArrayList<>();
			listToReturn.add(new LinkedList<>());
			return listToReturn;
		}
		if (start > target.length()) {
			return new ArrayList<>();
		}
		if (memo.containsKey(start)) {
			return memo.get(start);
		}
		List<List<String>> allPossibilities = new ArrayList<>();
		for(int i=0; i<wordBank.length; i++) {
			if (isPossible(target, wordBank[i], start)) {
				List<List<String>> possibilities = allConstruct(
					target, 
					wordBank, 
					start+wordBank[i].length(),
					memo
				);
				List<List<String>> newPossibilities = new ArrayList<>(
					possibilities
						.stream()
						.map(list->new ArrayList<>(list))
						.collect(Collectors.toList())
				);
				//System.out.println(possibilities);
				for (List<String> possibility: newPossibilities) {
					possibility.add(0, wordBank[i]);
				}
				allPossibilities.addAll(newPossibilities);
			}
		}
		memo.put(start, allPossibilities);
		return allPossibilities;
	}
	
	private static void  reverse(List<List<String>> list) {
		int j = list.size()-1;
		int i = 0;
		while(i<j) {
			List<String> temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
			i++;
			j--;
		}
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