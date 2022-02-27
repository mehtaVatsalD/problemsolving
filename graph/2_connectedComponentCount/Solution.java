import java.util.*;


public class Solution {


	public static void main(String...args) {
		Map<Character, List<Character>> graph = new HashMap<>();
		graph.put('0', Arrays.asList('8', '1', '5'));
		graph.put('1', Arrays.asList('0'));
		graph.put('5', Arrays.asList('0', '8'));
		graph.put('8', Arrays.asList('0', '5'));
		graph.put('2', Arrays.asList('3', '4'));
		graph.put('3', Arrays.asList('2', '4'));
		graph.put('4', Arrays.asList('3', '2'));
		
		Solution solution = new Solution();
		System.out.println(solution.connectedComponentCount(graph));
		
	}
	
	public int connectedComponentCount(Map<Character, List<Character>> graph) {
		HashSet<Character> visited = new HashSet<>();
		int count = 0;
		for (Character node: graph.keySet()) {
			if (visited.contains(node)) {
				continue;
			}
			count++;
			dfs(graph, visited, node);
		}
		return count;
	}

	
	public int dfs(Map<Character, List<Character>> graph, HashSet<Character> visitedNodes, Character sourceNode) {
		// for cyclic graphs not to visit already visited nodes again!
		if (visitedNodes.contains(sourceNode)) {
			return 0;
		}
		visitedNodes.add(sourceNode);
		int cnt = 1;
		for(Character neighbour: graph.get(sourceNode)) {
			cnt += dfs(graph, visitedNodes, neighbour);
		}
		return cnt;
	}
	

}
