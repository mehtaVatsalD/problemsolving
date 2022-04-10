public class WeightedQuickUnionWithPathCompression implements UnionFind {

	private int[] nodes;
	private int[] treeSizes;
	private int disconnectedComponentsCount;

	public WeightedQuickUnionWithPathCompression(int n) {
		this.nodes = new int[n];
		this.treeSizes = new int[n];
		initializeNodes(nodes, treeSizes);
		this.disconnectedComponentsCount = n;
	}

	@Override
	public boolean connected(int node1, int node2) {
		return find(node1) == find(node2);
	}

	@Override
	public void union(int node1, int node2) {
		if (connected(node1, node2)) {
			return;
		}
		int node1Id = find(node1);
		int node2Id = find(node2);

		if (treeSizes[node2Id] >= treeSizes[node1Id]) {	
			nodes[node1Id] = node2Id;
			treeSizes[node2Id] += treeSizes[node1Id];
		}
		else {
			nodes[node2Id] = node1Id;
                        treeSizes[node1Id] += treeSizes[node2Id];

		}
		disconnectedComponentsCount--;
	}

	@Override
	public int find(int node) {
		int parent = node;
		while(parent != nodes[parent]) {
			parent = nodes[parent];
		}
		while(node != parent) {
			int directParent = nodes[node];
			nodes[node] = parent;
			node = directParent;
		}
		return parent;
	}

	@Override
        public int getDisconnectedComponentsCount() {
                return disconnectedComponentsCount;
        }

        private void initializeNodes(int[] nodes, int[] treeSizes) {
                for (int i=0; i<nodes.length; i++) {
                        nodes[i] = i;
			treeSizes[i] = 1;
                }
        }

}
