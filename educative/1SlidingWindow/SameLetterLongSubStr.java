import java.util.*;
public class SameLetterLongSubStr{

	public static void main(String[] args){
//			abacb
			System.out.println(getSameLetterLongSubStr("aabcde", 2));
			System.out.println(getSameLetterLongSubStr("aabccbb", 2));
			System.out.println(getSameLetterLongSubStr("abbcb", 1));
			System.out.println(getSameLetterLongSubStr("abccde", 1));
													//	012345
	}
	
	public static int getSameLetterLongSubStr(String str, int k){
		System.out.println("Str: " + str + " k: " + k);
		if(str == null && "".equals(str)){
			return 0;
		}
		
		int start = 0;
		int end = 0;
		char c;
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = str.toCharArray();
		while(end<chars.length){
			c = chars[end];
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			if(end - start + 1 - map.get(chars[start]) <= k){
				end++;
			}
			else{
				map.put(c, map.get(c) - 1);
				map.put(chars[start], map.get(chars[start]) - 1);
				start++;
			}
			
			if(end - start > max){
				max = end - start;
			}
		}
		return max;
	}
	
}
