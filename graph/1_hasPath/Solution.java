import java.util.*;


public class Solution {


	public static void main(String...args) {
		Map<Character, List<Character>> graph = new HashMap<>();
		graph.put('f', Arrays.asList('g', 'i'));
		graph.put('g', Arrays.asList('h'));
		graph.put('h', Arrays.asList());
		graph.put('i', Arrays.asList('g', 'k'));
		graph.put('k', Arrays.asList());
		graph.put('j', Arrays.asList('i'));
		
		Solution solution = new Solution();
		
		System.out.println(solution.hasPathDfs(graph, new HashSet<>(), 'j', 'f'));
		System.out.println(solution.hasPathBfs(graph, new HashSet<>(), 'j', 'f'));
		
		System.out.println("----------------");
		
		System.out.println(solution.hasPathDfs(graph, new HashSet<>(), 'f', 'k'));
		System.out.println(solution.hasPathBfs(graph, new HashSet<>(), 'f', 'k'));
		
	}

	
	public boolean hasPathDfs(Map<Character, List<Character>> graph, HashSet<Character> visitedNodes, Character sourceNode, Character destinationNode) {
		// for cyclic graphs not to visit already visited nodes again!
		if (visitedNodes.contains(sourceNode)) {
			return false;
		}
		if (sourceNode == destinationNode) {
			return true;
		}
		visitedNodes.add(sourceNode);
		boolean hasPath = false;
		for(Character neighbour: graph.get(sourceNode)) {
			
			// check for visited can be done here too. 
			// We can check if already visited then we can even stop from calling hasPathDfs 
			// But in this implementation it is made as base case!
			hasPath = hasPathDfs(graph, visitedNodes, neighbour, destinationNode);
			if (hasPath) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPathBfs(Map<Character, List<Character>> graph, HashSet<Character> visitedNodes, Character sourceNode, Character destinationNode) {
		
		Deque<Character> queue = new ArrayDeque<Character>();
		queue.addLast(sourceNode);
		while(!queue.isEmpty()) {

			Character current = queue.pollFirst();
//			System.out.println(current);
			if (current == destinationNode) {
				return true;
			}
			visitedNodes.add(current);
			for(Character neighbour: graph.get(current)) {
				// for cyclic graphs not to visit already visited nodes again!
				if (visitedNodes.contains(neighbour)) {
					continue;
				}
				queue.addLast(neighbour);
			}
		}
		
		return false;
	}
	

}
