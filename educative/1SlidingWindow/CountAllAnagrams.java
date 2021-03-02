import java.util.*;
public class CountAllAnagrams{
	public static void main(String[] args){
		System.out.println(isPermutaionPresentAsSubStr("ppqp", "pq"));
		System.out.println(isPermutaionPresentAsSubStr("abbcabc", "abc"));
	}
	
	private static List<Integer> isPermutaionPresentAsSubStr(String str, String pattern){
		System.out.println("String: " + str + " pattern: " + pattern);
		List<Integer> res = new ArrayList<>();
		if(str == null || pattern == null || "".equals(str) || "".equals(pattern)){
			return res;
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
						res.add(start);
						end++;
						putAllThingsBack(start, end, chars, map);
						start++;
						end = start;
						continue;						
					}
				}
				end++;
			}
			else{
				putAllThingsBack(start, end, chars, map);
				start = end;
				if(!map.containsKey(c)){
					start++;
					end++;
				}
			}
		}
		return res;
	}
	
	private static void putAllThingsBack(int start, int end, char[] chars, Map<Character, Integer> map){
		while(start<end){
			map.put(chars[start], map.getOrDefault(chars[start], 0) + 1);
			start++;
		}
	}
	
	private static void countAllChars(String pattern, Map<Character, Integer> map){
		for(char c:pattern.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
	} 
}
