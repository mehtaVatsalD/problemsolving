import java.util.*;

public class NotSlidingWindow{
	public static void main(String[] args){
		System.out.println(getStartingIndices("catfoxcat", Arrays.asList("cat", "fox")));
		System.out.println(getStartingIndices("catcatfoxfox", Arrays.asList("cat", "fox")));	
	}
	
	private static List<Integer> getStartingIndices(String str, List<String> substrs){
		List<Integer> res = new ArrayList<>();
		if("".equals(str) || substrs.isEmpty()){
			return res;
		}
		
		Map<String, Integer> map = new HashMap<>();
		getMapCount(map, substrs);
		int totalWords = substrs.size();
		int wordLength = substrs.get(0).length();
		for(int start=0;start<=str.length()-wordLength;start++){
			Map<String, Integer> encountered = new HashMap<>();
			int j = 0;
			int matched = 0;
			for(j=0;j<totalWords && start + (j+1)*wordLength <= str.length();j++){
				String inbet = str.substring(start + j*wordLength, start + (j+1)*wordLength);
				
				if(!map.containsKey(inbet)){
					break;
				}
				int val = encountered.getOrDefault(inbet, 0);
				val++;
				encountered.put(inbet, val);
				if(val > map.get(inbet)){
					break;
				}
				matched++;
				
			}
			
			if(matched == totalWords){
				res.add(start);
			}
		}
		return res;
	}
	
	private static void getMapCount(Map<String, Integer> map, List<String> substrs){
		for(String str:substrs){
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
	}
}
