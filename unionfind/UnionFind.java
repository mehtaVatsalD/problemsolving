public interface UnionFind {

	boolean connected(int node1, int node2);

	void union(int node1, int node2);

	int find(int node);

	int getDisconnectedComponentsCount();

}
