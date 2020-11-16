import java.io.*;
import java.util.*;
public class StringPermutation{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int t = Integer.valueOf(scan.nextLine());
		String str;
		while(t-->0){
			str = scan.nextLine();
			doPermutation(str.toCharArray());
		}
	}

	private static void doPermutation(char c[]){
		Map<Character, Integer> charMap = new HashMap<>();
		Integer val;
		for(int i=0;i<c.length;i++){
			val = charMap.getOrDefault(c[i], null);
			if(val == null){
				charMap.put(c[i], 1);
			}
			else{
				charMap.put(c[i], ++val);
			}
		}

		char[] unqChars = new char[charMap.size()];
		int[] charAvail = new int[charMap.size()];
		int index = 0;
		for(Map.Entry<Character, Integer> entry:charMap.entrySet()){
			unqChars[index] = entry.getKey();
			charAvail[index] = entry.getValue();
			index++;
		}
		permutationUtil(0, c, unqChars, charAvail);
	}

	private static void permutationUtil(int depth, char[] str, char[] unqChars, int[] charAvail){
		boolean anyThingAvailable = false;
		for(int i=0;i<charAvail.length;i++){
			if(charAvail[i] > 0){
				anyThingAvailable = true;
				str[depth] = unqChars[i];
				charAvail[i] = charAvail[i] - 1;
				permutationUtil(depth+1, str, unqChars, charAvail);
				//backtracking
				charAvail[i] = charAvail[i] + 1;
			}
		}
		//this is part where you get final string
		if(!anyThingAvailable){
			System.out.println(String.valueOf(str));
		}
	}
}