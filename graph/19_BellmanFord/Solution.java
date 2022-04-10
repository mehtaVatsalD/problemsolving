import java.util.*;

public class Solution {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] edges = new int[m][3];
		int i=0;
		while(i<m) {
			edges[i][0] = scan.nextInt();
			edges[i][1] = scan.nextInt();
			edges[i++][2] = scan.nextInt();
		}
		int[] d = shortestDistances(n, edges, 0);
		System.out.println(Arrays.toString(d));
	}

	private static int[] shortestDistances(int n, int edges[][], int start) {
		int[] d = new int[n];
		List<List<Integer>> res = new ArrayList<>();
		for (int i=0;i<n;i++) res.add(new ArrayList<>());
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		res.get(start).add(start);
		for(int i=1; i<=n; i++) { //relax all edges n-1 times
			for (int[] e: edges) {
				boolean isRelaxed = relaxEdge(e, d, res);
				if (i==n && isRelaxed) {
					System.out.println("Negative cycle detected");
					return new int[]{};
				}
			}
		}
		System.out.println(res.toString());
		return d;
	
	}

	private static boolean relaxEdge(int[] e, int d[], List<List<Integer>> res) {
		if (d[e[0]] == Integer.MAX_VALUE) 
			return false;

		if (d[e[0]] + e[2] < d[e[1]]) {
			d[e[1]] = d[e[0]] + e[2];
			res.get(e[1]).clear();
			res.get(e[1]).addAll(res.get(e[0]));
			res.get(e[1]).add(e[1]);
			return true;
		}
		return false;
	}

}
