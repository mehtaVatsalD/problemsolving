import java.util.*;

public class Solution {

	public static void main(String...args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] edges = new int[m][2];
		int i=0;
		while(m-->0) {
			edges[i][0] = scanner.nextInt();
			edges[i++][1] = scanner.nextInt();
		}
		List<Integer> res = new Solution().minMessageRoute(n, edges);
		if (res == null) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		System.out.println(res.size());
		for(Integer node: res) {
			System.out.print(node + " ");
		}
	}
	
	public List<Integer> minMessageRoute(int n, int[][] edges) {
		Map<Integer, Set<Integer>> adjList = getAdjList(edges);
		
		boolean[] visited = new boolean[n+1];
		int[] parent = new int[n+1];
		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(1);
		visited[1] = true;
		parent[1] = 1;
		while(!q.isEmpty()) {
			Integer node = q.pollFirst();
			if (node == n) {
				return buildPath(n, parent);
			}
			
			if (!adjList.containsKey(node)) continue;
			
			for(Integer neigh: adjList.get(node)) {
				if (visited[neigh]) {
					continue;
				}
				visited[neigh] = true;
				parent[neigh] = node;
				q.addLast(neigh);
			}
			
		}
		
		
		return null;
	}
	
	private List<Integer> buildPath(int n, int[] parent) {
		List<Integer> res = new ArrayList<>();
		int temp = n;
		while(temp != 1) {
			res.add(temp);
			temp = parent[temp];
		}
		res.add(1);
		Collections.reverse(res);
		return res;
		
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
