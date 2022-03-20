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
		
		hpnc(n, edges, 0);
		
	}
	
	private static void hpnc(int n, int[][] edges, int start) {
		Set<Integer>[] adj = buildAdj(n, edges);
		//System.out.println(Arrays.toString(adj));
		Set<Integer> nv = new HashSet<>();
		for(int i=0; i<n; i++) {
			nv.add(i);
		}
		List<Integer> currPath = new ArrayList<>();
		currPath.add(start);
		nv.remove(start);
		hpnc(adj, start, start, nv, currPath);
	}
	
	private static void hpnc(Set<Integer>[] adj, int start, int node, Set<Integer> nv, List<Integer> currPath) {
		
		if (nv.isEmpty()) {
			currPath.forEach(System.out::print);
			if (adj[start].contains(node) || adj[node].contains(start)) {
				System.out.println("*");
			}
			else System.out.println(".");
			return;
		}
		
		

		for(int neigh: adj[node]) {
			if (!nv.contains(neigh)) {
				continue;
			}
			currPath.add(neigh);
			nv.remove(neigh);	
			hpnc(adj, start, neigh, nv, currPath);
			nv.add(neigh);
			currPath.remove(currPath.size()-1);
		}
		
	
	}
	

	
	private static Set<Integer>[] buildAdj(int n, int[][] edges) {
        Set<Integer>[] adj = new TreeSet[n];
        for(int i=0; i<n; i++) {
            adj[i] = new TreeSet<>();
        }
        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }

}
