import java.util.*;
public class PermAsSubStr{
	public static void main(String[] args){
		System.out.println(isPermutaionPresentAsSubStr("oidbcaf", "abc"));
		System.out.println(isPermutaionPresentAsSubStr("odicf", "dc"));
		System.out.println(isPermutaionPresentAsSubStr("bcdxabcdy", "bcdyabcdx"));
		System.out.println(isPermutaionPresentAsSubStr("aaacb", "abc"));
	}
	
	private static boolean isPermutaionPresentAsSubStr(String str, String pattern){
		System.out.println("String: " + str + " pattern: " + pattern);
		if(str == null || pattern == null || "".equals(str) || "".equals(pattern)){
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		char c;
		char[] chars = str.toCharArray();
		int start = 0;
		int end = 0;
		int cnt;
		countAllChars(pattern, map);
		while(end<chars.length){
			c = chars[end];
			if(map.containsKey(c)){
				cnt = map.get(c);
				cnt--;
				map.put(c, cnt);
				if(cnt == 0){
					map.remove(c);
					if(map.size() == 0){
						return true;
					}
				}
				end++;
			}
			else{
				while(start<end){
					map.put(chars[start], map.getOrDefault(chars[start], 0) + 1);
					start++;
				}
				if(!map.containsKey(c)){
					start++;
					end++;
				}
			}
		}
		return false;
	}
	
	private static void countAllChars(String pattern, Map<Character, Integer> map){
		for(char c:pattern.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
	} 
}
