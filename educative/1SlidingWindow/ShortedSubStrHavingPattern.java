import java.util.*;

public class ShortedSubStrHavingPattern{

	public static void main(String[] args){
		System.out.println(getShortedSubStrHavingPattern("xyblxccfccblag", "abcc"));
		System.out.println(getShortedSubStrHavingPattern("ccghjjhbalccx", "abcc"));
		System.out.println(getShortedSubStrHavingPattern("ccghjjhbalbcjacx", "abcc"));
		System.out.println(getShortedSubStrHavingPattern("aabdec", "abc"));
		System.out.println(getShortedSubStrHavingPattern("abdabca", "abc"));
		System.out.println(getShortedSubStrHavingPattern("adcad", "abc"));
	}
	
	private static String getShortedSubStrHavingPattern(String str, String pattern){
		System.out.println("String: " + str + " Pattern: " + pattern);
		if(str == null || pattern == null || "".equals(str) || "".equals(pattern)){
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		int startMin = -1;
		int endMin = -1;
		char c;
		char[] chars = str.toCharArray();
		int patternLength = pattern.length();
		int matched = 0;
		countAllPatternChars(map, pattern);
		while(end<chars.length){
			c = chars[end];
			if(!map.containsKey(c)){
				if(start == end){
					start++;
				}
				end++;
				continue;
			}
			if(map.containsKey(c)){
				int val = map.get(c);
				if(val <= 0 && chars[start] == c){
					start = goTillNextPatternChar(chars, map, start, end);
					end++;
					continue;
				}
				val--;
				map.put(c, val);
				if(val >= 0){
					matched++;
				}
				end++;
			}
			
			if(matched == patternLength){
				if(end - start < min){
					startMin = start;
					endMin = end;
					min = end - start;
				}
				map.put(chars[start], map.get(chars[start]) + 1);
				start = goTillNextPatternChar(chars, map, start, end);
				matched--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=startMin;i<endMin;i++){
			sb.append(chars[i]);
		}
		if("".equals(sb.toString())){
			return "~NOSUBSTR~";
		}
		return sb.toString();
		
	}
	
	private static int goTillNextPatternChar(char[] chars, Map<Character, Integer> map, int start, int end){
		for(int i = start + 1; i <= end; i++){
			if(map.containsKey(chars[i])){
				int val = map.get(chars[i]);
				if(val >= 0){
					return i;
				}
				else{
					map.put(chars[i], val+1);
				}
			}
		}
		return end;
	}
	
	private static void countAllPatternChars(Map<Character, Integer> map, String pattern){
		for(char c:pattern.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
	}
	
}
