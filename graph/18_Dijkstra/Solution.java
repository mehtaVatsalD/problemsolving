import java.util.*;

public class Solution {

	static class Node {
		int node;
		int distance;
		List<Integer> path;
		
		Node (int node, int distance, List<Integer> path) {
			this.node = node;
			this.distance = distance;
			this.path = path;
		}
	
		public String toString() {
			return "[" + distance + "]: " + path;
		}

	}

	static class Edge {
		int src;
		int dest;
		int wt;

		Edge (int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
	}
	
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] edges = new int[m][3];
		int i=0;
		while(i<m) {
			edges[i][0] = scan.nextInt();
			edges[i][1] = scan.nextInt();
			edges[i][2] = scan.nextInt();
			i++;
		}
		List<List<Edge>> adj = buildAdj(n, edges);
		List<Node> nodes = findShortestPaths(0, n, adj);
//		System.out.println(nodes.toString());
		for(Node node: nodes) {
			System.out.println("0->" + node.node + "::" + node);
		}
	}

	private static List<Node> findShortestPaths(int src, int n, List<List<Edge>> adj) {
		Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
		pq.add(new Node(src, 0, new ArrayList<>(Collections.singletonList(src))));
		List<Node> nodes = new ArrayList<>();
		boolean[] v = new boolean[n];
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if (v[node.node]) continue;
			v[node.node] = true;

			nodes.add(node);
		
			for(Edge nbr: adj.get(node.node)) {
				List<Integer> path = new ArrayList<>(node.path);
				path.add(nbr.dest);
				pq.add(new Node(nbr.dest, node.distance + nbr.wt, path));
			}
		}
		return nodes;
	}

	private static List<List<Edge>> buildAdj(int n, int edges[][]) {
		List<List<Edge>> adj = new ArrayList<>();
		for (int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] edge: edges) {
			adj.get(edge[0]).add(new Edge(edge[0], edge[1], edge[2]));
			adj.get(edge[1]).add(new Edge(edge[1], edge[0], edge[2]));
		}
		return adj;
	}

	

}
