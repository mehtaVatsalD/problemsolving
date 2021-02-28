import java.util.*;

public class LongestSubString{

	public static void main(String[] args){
		System.out.println(getLongestSubstring("aabccbb"));
		System.out.println(getLongestSubstring("abbbb"));
		System.out.println(getLongestSubstring("abccde"));
	}
	
	public static int getLongestSubstring(String str){
		System.out.println(str);
		if(str == null || "".equals(str)){
			return 0;
		}
		int start = 0;
		int end = 0;
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = str.toCharArray();
		char c;
		while(end<chars.length){
			c = chars[end];
			if(map.containsKey(c)){
				start = map.get(c) + 1;
			}
			map.put(c, end);
			end++;
			if(end - start > max){
				max = end - start;
			}
		}
		return max;
	}

}
