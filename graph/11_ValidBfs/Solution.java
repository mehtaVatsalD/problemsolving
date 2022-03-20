import java.util.*;

public class Solution {

	public static void main(String...args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] edges = new int[n-1][2];
		int i=0;
		while(i<n-1) {
			edges[i][0] = scanner.nextInt();
			edges[i++][1] = scanner.nextInt();
		}
		i=0;
		int[] expectedBfs = new int[n];
		while(i<n) {
			expectedBfs[i++] = scanner.nextInt();
		}
		String res = new Solution().validBfs(n, edges, expectedBfs);
		System.out.println(res);
	}
	
	public String validBfs(int n, int[][] edges, int[] expectedBfs) {
		if (expectedBfs[0] != 1) {
			return "No";
		}
		Map<Integer, Set<Integer>> adj = getAdjList(edges);
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		visited[0] = true;
		int i=0;
		visited[expectedBfs[i]] = true;
		q.addLast(expectedBfs[i++]);
		List<Integer> res = new ArrayList<>();
		while(!q.isEmpty()) {
			Integer val = q.pollFirst();
			res.add(val);
			Set<Integer> set = adj.getOrDefault(val, new HashSet<>());
			if (set == null) {
				return "No";
			}
			while(i<n && set.contains(expectedBfs[i])) {
				if (visited[expectedBfs[i]]) {
					return "No";
				}
				visited[expectedBfs[i]] = true;
				q.addLast(expectedBfs[i]);
				set.remove(expectedBfs[i]);
				i++;
			}
			
		}
		
		for (boolean vis: visited) {
			if (!vis) {
				return "No";
			}
		}
		int j=0;
		for(Integer val: res) {
			if (val!=expectedBfs[j++]) {
				return "No";
			}
		}
		
		return j==n ? "Yes" : "No";
	}
	
	private Map<Integer, Set<Integer>> getAdjList(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            addConnection(adjList, node1, node2);
            addConnection(adjList, node2, node1);   
        }
        return adjList;
        
    }
    
    private void addConnection(Map<Integer, Set<Integer>> adjList, int src, int dest) {
        if(!adjList.containsKey(src)) {
            adjList.put(src, new HashSet<>());
        }
        Set<Integer> connections = adjList.get(src);
        connections.add(dest);
    }
	

}
