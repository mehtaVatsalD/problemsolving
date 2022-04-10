public class QuickFind implements UnionFind {

	private int[] nodes;
	private int disconnectedComponentsCount;

	public QuickFind(int n) {
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
		int node1Id = find(node1);
		int node2Id = find(node2);
		if (node1Id == node2Id) {
			return;
		}
		assignId(nodes, node1Id, node2Id);
		disconnectedComponentsCount--;
	}

	@Override
	public int find(int node) {
		return nodes[node];
	}

	@Override
	public int getDisconnectedComponentsCount() {
		return disconnectedComponentsCount;
	}

	private void assignId(int[] nodes, int fromId, int toId) {
		for (int i=0; i<nodes.length; i++) {
			if (nodes[i] == fromId) {
				nodes[i] = toId;
			}
		}
	}

	private void initializeNodes(int[] nodes) {
		for (int i=0; i<nodes.length; i++) {
			nodes[i] = i;
		}
	}

}
