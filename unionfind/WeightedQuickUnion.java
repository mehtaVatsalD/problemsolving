public class WeightedQuickUnion implements UnionFind {

	private int[] nodes;
	private int[] heights;
	private int disconnectedComponentsCount;

	public WeightedQuickUnion(int n) {
		this.nodes = new int[n];
		this.heights = new int[n];
		initializeNodes(nodes, heights);
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

		if (heights[node2Id] >= heights[node1Id]) {	
			nodes[node1Id] = node2Id;
			heights[node2Id] = Math.max(heights[node2Id], heights[node1Id] + 1);
		}
		else {
			nodes[node2Id] = node1Id;
                        heights[node1Id] = Math.max(heights[node1Id], heights[node2Id] + 1);

		}
		disconnectedComponentsCount--;
	}

	@Override
	public int find(int node) {
		while(node != nodes[node]) {
			node = nodes[node];
		}
		return node;
	}

	@Override
        public int getDisconnectedComponentsCount() {
                return disconnectedComponentsCount;
        }

        private void initializeNodes(int[] nodes, int[] heights) {
                for (int i=0; i<nodes.length; i++) {
                        nodes[i] = i;
			heights[i] = 1;
                }
        }

}
