public class QuickUnion implements UnionFind {

	private int[] nodes;
	private int disconnectedComponentsCount;

	public QuickUnion(int n) {
		this.nodes = new int[n];
		initializeNodes(nodes);
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
		nodes[node1Id] = node2Id;
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

        private void initializeNodes(int[] nodes) {
                for (int i=0; i<nodes.length; i++) {
                        nodes[i] = i;
                }
        }

}
