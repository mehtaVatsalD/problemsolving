import java.util.*;
public class Solution {

	public static void main(String...args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] edges = new int[m][2];
		int i=0;
		while(i<m) {
			edges[i][0] = scanner.nextInt();
			edges[i++][1] = scanner.nextInt();
		}
		
		System.out.println(shortestCycle(n, edges));
		
	}
	
	private static int shortestCycle(int n, int[][] edges) {
		ArrayList<Integer>[] adj = buildAdj(n, edges);
		int[] v = new int[n];
		Arrays.fill(v, -1);
		Optional<Integer> minCycleLen = Optional.empty();
		for(int i=0; i<n; i++) {
			int minCycleLenVal = minCycleLen.isPresent() ? minCycleLen.get() : Integer.MIN_VALUE;
			if (v[i] == -1) {
				v[i] = 1;
				Optional<Integer> minCycleLenFromNode = shortestCycle(adj, v, i, i, 1);
				if (minCycleLenFromNode.isPresent() && minCycleLenFromNode.get() > minCycleLenVal) {
					minCycleLen = minCycleLenFromNode;
				}
			}
		}
		
		return minCycleLen.isPresent() ? minCycleLen.get() : -1;
	}
	
	private static Optional<Integer> shortestCycle(ArrayList<Integer>[] adj, int v[], int node, int parent, int index) {
		
		Optional<Integer> minCycleAtThisNode = Optional.empty();
		for(int neigh: adj[node]) {
			int minCycleLenVal = minCycleAtThisNode.isPresent() ? minCycleAtThisNode.get() : Integer.MIN_VALUE;
			if (v[neigh] != -1) {
				if (neigh == parent || v[neigh] == 0) {
					continue;
				}
				int cycleLength = index - v[neigh] + 1;
				if (cycleLength > minCycleLenVal) {
					minCycleAtThisNode = Optional.of(cycleLength);
				}
				continue;
			}
			v[neigh] = index+1;
			Optional<Integer> minCycleLenFromNbr = shortestCycle(adj, v, neigh, node, index+1);
			
			if (minCycleLenFromNbr.isPresent() && minCycleLenFromNbr.get() > minCycleLenVal) {
				minCycleAtThisNode = minCycleLenFromNbr;
			}
			v[neigh] = 0;
		}
		return minCycleAtThisNode;
		
	
	}
	

	
	private static ArrayList<Integer>[] buildAdj(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }

}
