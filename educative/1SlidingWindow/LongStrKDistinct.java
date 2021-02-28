import java.util.*;

public class LongStrKDistinct{
	public static void main(String[] args){
		
		Solution s = new Solution();
		
		//longest sub str with at most k sub str
		System.out.println(s.getLongestSubStr("araaci", 2));
		System.out.println(s.getLongestSubStr("araaci", 1));
		System.out.println(s.getLongestSubStr("cbbebi", 3));
		
		//max fruits in two basket problem
		//OR
		//longest sub str with atmost 2 distinct chars
		System.out.println(s.getLongestSubStr("ABCAC", 2));
		System.out.println(s.getLongestSubStr("ABCBBC", 2));
		
		
	}
}

class Solution{

	public int getLongestSubStr(String str, int k){
		System.out.println("Str: " + str + " k: " + k);
		if(str == null || "".equals(str) || k == 0){
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		char[] chars = str.toCharArray();
		char c;
		int cnt;
		map.put(chars[start], 1);
		int max = 0;
		while(end < chars.length-1){
			c = chars[end+1];
			//System.out.println("map: " + map);
			if(map.containsKey(c)){
				end++;
				cnt = map.get(c);
				map.put(c, ++cnt);
			}
			else if(map.size() < k){
				end++;
				map.put(c, 1);
			}
			else{
				cnt = map.get(chars[start]);
				cnt--;
				if(cnt == 0){
					map.remove(chars[start]);
				}
				else{
					map.put(chars[start], cnt);
				}
				start++;
			}
			
			if(end - start + 1 > max){
					max = end - start + 1;
			}		
		}
		return max;
	}
	
}
