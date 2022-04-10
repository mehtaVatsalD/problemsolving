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

	//using Prim's algorithm
	private List<Edge> constructMst(int start, List<List<Edge>> adj, int n) {
		Queue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.wt - e2.wt);
		Set<Integer> notVisitedSet = new HashSet<>();
		for(int i=0; i<n; i++) {
			notVisitedSet.add(i);
		}

		List<Edge> res = new ArrayList<>();

		do {
			notVisitedSet.remove(start);
			for (Edge e: adj.get(start)) {
				if (!notVisitedSet.contains(e.dest)) {
					continue;
				}
				pq.add(e);
			}

			Edge e;
			do {
				e = pq.poll();
			}
			while(e != null && !notVisitedSet.contains(e.src) && !notVisitedSet.contains(e.dest));

			if (e == null) break;
			res.add(e);

			if (notVisitedSet.contains(e.src)) start = e.src;
			else start = e.dest;
			
		}
		while(!notVisitedSet.isEmpty() && !pq.isEmpty());

		if (!notVisitedSet.isEmpty()) return null;

		return res;

	}

	

}
