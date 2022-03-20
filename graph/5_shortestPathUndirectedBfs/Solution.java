import java.util.*;


public class Solution {

	static class Node {
		Character value;
		int pathIndex;
		
		Node(char c, int pathIndex) {
			this.value = c;
			this.pathIndex = pathIndex;
		}
	}


	public static void main(String...args) {
		Map<Character, List<Character>> graph = new HashMap<>();
		graph.put('w', Arrays.asList('x', 'v'));
		graph.put('x', Arrays.asList('a', 'w'));
		graph.put('a', Arrays.asList('x', 'y'));
		graph.put('v', Arrays.asList('w', 'y'));
		graph.put('y', Arrays.asList('a', 'v'));
		graph.put('z', Arrays.asList('y', 'v'));
		
		Solution solution = new Solution();
		System.out.println(solution.shortestPath(graph, 'w', 'z'));
		
	}
	
	public Integer shortestPath(Map<Character, List<Character>> graph, Character source, Character destination) {
		HashSet<Character> visited = new HashSet<>();
		return shortestPath(graph, visited, source, destination);
	}
	
	public Integer shortestPath(Map<Character, List<Character>> graph, HashSet<Character> visitedNodes, Character source, Character destination) {
		Deque<Node> q = new ArrayDeque<>();
		q.addLast(new Node(source, 0));
		visitedNodes.add(source);
		while(!q.isEmpty()) {
			Node currentNode = q.pollFirst();
			if (currentNode.value == destination) {
				return currentNode.pathIndex;
			}
			visitedNodes.add(currentNode.value);
			for(Character neighbour: graph.get(currentNode.value)) {
				if (visitedNodes.contains(neighbour)) {
					continue;
				}
				q.addLast(new Node(neighbour, currentNode.pathIndex + 1));		
				visitedNodes.add(neighbour);
			}
		}
		
		
		return null;
		
	}
	

}
