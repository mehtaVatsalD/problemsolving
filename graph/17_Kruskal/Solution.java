import java.util.*;

public class Solution {

	static class UnionFind {
		int components;
		int[] nodes;
		int[] treeSizes;

		UnionFind(int n) {
			this.components = n;
			this.nodes = new int[n];
			this.treeSizes = new int[n];

			for (int i=0; i<n; i++)	{
				nodes[i] = i;
				treeSizes[i] = 1;
			}
		}

		int find(int node) {
			while(node != nodes[node]) {
				node = nodes[node];
			}
			return node;
		}

		boolean connected(int node1, int node2) {
			return find(node1) == find(node2);
		}

		void connect(int node1, int node2) {
			int nodeId1 = find(node1);
			int nodeId2 = find(node2);
			if (nodeId1 == nodeId2) return;
		
			if (treeSizes[nodeId2] >= treeSizes[nodeId1]) {
				nodes[nodeId1] = nodeId2;
				treeSizes[nodeId2] += treeSizes[nodeId1];
			}
			else {
				nodes[nodeId2] = nodeId1;
                treeSizes[nodeId1] += treeSizes[nodeId2];
			}
			components--;
		}
		
	}

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
		
		List<Edge> edges = new ArrayList<>();
		while(m-->0) {
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			int wt = scan.nextInt();
			edges.add(new Edge(node1, node2, wt));
		}

		Solution sol = new Solution();
		System.out.println(sol.constructMst(edges, n).toString());
	}

	//using Prim's algorithm
	private List<Edge> constructMst(List<Edge> edges, int n) {
		
		List<Edge> res = new ArrayList<>();
		UnionFind uf = new UnionFind(n);

		Collections.sort(edges, (e1, e2) -> e1.wt - e2.wt);
		int i=0;
		while(uf.components > 1 && i<edges.size()) {
			Edge e = edges.get(i);

			if (uf.connected(e.src, e.dest)) {
				i++;
				continue;
			}

			res.add(e);
			uf.connect(e.src, e.dest);
			System.out.println(uf.components);
			i++;
			

		}

		if (uf.components != 1) return Collections.emptyList();
		return res;

	}

	

}
