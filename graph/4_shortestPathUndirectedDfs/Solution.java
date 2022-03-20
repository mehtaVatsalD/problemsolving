import java.util.*;


public class Solution {


	public static void main(String...args) {
		Map<Character, List<Character>> graph = new HashMap<>();
		graph.put('w', Arrays.asList('x', 'v'));
		graph.put('x', Arrays.asList('a', 'w'));
		graph.put('a', Arrays.asList('x', 'y'));
		graph.put('v', Arrays.asList('w', 'y'));
		graph.put('y', Arrays.asList('a', 'v', 'z'));
		graph.put('z', Arrays.asList('y', 'v'));
		
		Solution solution = new Solution();
		System.out.println(solution.shortestPath(graph, 'w', 'z'));
		
	}
	
	public Integer shortestPath(Map<Character, List<Character>> graph, Character source, Character destination) {
		HashSet<Character> visited = new HashSet<>();
		return shortestPath(graph, visited, source, destination);
	}
	
	public Integer shortestPath(Map<Character, List<Character>> graph, HashSet<Character> visitedNodes, Character source, Character destination) {
		if (source == destination) {
			return 0;
		}
		if(visitedNodes.contains(source)) {
			return null;
		}
		visitedNodes.add(source);
		Integer pathLength = null;
		for(Character neighbour: graph.get(source)) {
			Integer subPathLength = shortestPath(graph, visitedNodes, neighbour, destination);
			if (subPathLength!=null && (pathLength == null || subPathLength+1 < pathLength)) {
				pathLength = subPathLength+1;
			}
		}
		visitedNodes.remove(source);
		return pathLength;
		
	}
	

}
