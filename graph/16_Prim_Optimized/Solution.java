import java.util.*;

public class Solution {

	static class Edge {
		int src;
		int dest;
		int wt;

		Edge(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}

		public String toString() {
			return new StringBuilder().append(src).append("->(").append(wt).append(")->").append(dest).toString();
		}
	}

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		List<List<Edge>> adj = new ArrayList<>();
		for (int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		while(m-->0) {
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			int wt = scan.nextInt();
			adj.get(node1).add(new Edge(node1, node2, wt));
			adj.get(node2).add(new Edge(node2, node1, wt));
		}

		Solution sol = new Solution();
		System.out.println(sol.constructMst(0, adj, n).toString());
	}


	//using Optimized Prim's algorithm
	private List<Edge> constructMst(int start, List<List<Edge>> adj, int n) {
		Set<Integer> notVisitedSet = new HashSet<>();
		int[] minwt = new int[n];
		int[] src = new int[n];
		for(int i=0; i<n; i++) {
			notVisitedSet.add(i);
			minwt[i] = Integer.MAX_VALUE;
			src[i] = -1;
		}

		minwt[start] = 0;
		src[start] = -1;
		List<Edge> res = new ArrayList<>();
		
		while(!notVisitedSet.isEmpty()) {
			
			int min = Integer.MAX_VALUE;
			Integer node = null;
			for (int i=0; i<n; i++) {
				if (min > minwt[i] && notVisitedSet.contains(i) ) {
					min = minwt[i];
					node = i;
				}
			}

			if (node == null) return null;

			notVisitedSet.remove(node);
			res.add(new Edge(src[node], node, min));
			
			for (Edge e: adj.get(node)) {
				if (minwt[e.dest] > e.wt) {
					minwt[e.dest] = e.wt;
					src[e.dest] = node;
				}
			}
		
		}
		return res;

	}

	

}
