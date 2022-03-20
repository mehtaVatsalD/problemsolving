import java.util.*;

public class Solution {

	private static final long MODULO_BY = 1000000007;

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] edges = new int[m][2];
		int i=0;
		while(i<m) {
			edges[i][0] = scan.nextInt();
			edges[i][1] = scan.nextInt();	
			i++;
		}
		long ways = dfs(0, n-1, buildAdj(n, edges), new boolean[n], new long[n]);
		System.out.println(ways);
	}

	private static long dfs(int node, int end, List<List<Integer>> adj, boolean[] v, long[] memo) {

		//already at final stage
		if (node == end) {
			return 1;
		}
		//node already explored
		if (v[node]) {
			return memo[node];
		}
		v[node] = true;
		long ways = 0;
		for (int nbr: adj.get(node)) {
			ways += dfs(nbr, end, adj, v, memo);
			ways %= MODULO_BY;
		}
		memo[node] = ways;
		return ways;

	}


	private static List<List<Integer>> buildAdj(int n, int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		for(int[] edge:edges) {
			adj.get(edge[0]-1).add(edge[1]-1);	
		}
		return adj;
	}



}
