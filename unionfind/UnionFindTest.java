public class UnionFindTest {
	
	public static void main(String...args) {
		UnionFind uf = new WeightedQuickUnionWithPathCompression(7);
		assert uf.getDisconnectedComponentsCount() == 7 : "Component count should be 7 initially";

		assert !uf.connected(3, 4) : "3 and 4 should not be connected";
		uf.union(3, 4);
		assert uf.connected(3, 4) : "3 and 4 should be connected";
		assert uf.find(3) == 4 : "3's find should return 4 as connected with 4";
		assert uf.getDisconnectedComponentsCount() == 6 : "Component count should be 6 now";

		uf.union(1, 3);
		assert uf.connected(4, 1) : "1 and 4 should be connected";
                assert uf.find(1) == 4 : "1's find should return 4 as connected with 4";
                assert uf.getDisconnectedComponentsCount() == 5 : "Component count should be 6 now";
		
		uf.union(6, 0);
		assert uf.connected(6, 0) : "6 and 0 should be connected";
                assert uf.find(6) == 0 : "6's find should return 0 as connected with 0";
                assert uf.getDisconnectedComponentsCount() == 4 : "Component count should be 4 now";

		uf.union(2, 5);
		assert uf.connected(5, 2) : "2 and 5 should be connected";
                assert uf.find(2) == 5 : "2's find should return 2 as connected with 2";
                assert uf.getDisconnectedComponentsCount() == 3 : "Component count should be 3 now";

		assert !uf.connected(4, 6) : "4 and 6 should not be connected";
		assert !uf.connected(1, 5) : "1 and 5 should not be connected";
		assert !uf.connected(0, 2) : "0 and 2 should not be connected";

		uf.union(3, 5);
		assert !uf.connected(4, 6) : "4 and 6 should be connected";
                assert uf.connected(1, 5) : "1 and 5 should be connected";
		assert uf.connected(1, 2) : "1 and 2 should be connected";
		assert uf.connected(4, 5) : "1 and 5 should be connected";
		assert uf.connected(3, 2) : "3 and 2 should be connected";
                assert !uf.connected(0, 2) : "0 and 2 should not be connected";

		uf.union(6, 5);
		assert uf.getDisconnectedComponentsCount() == 1 : "Component count should be 1 now";

		uf.union(4, 2);
		assert uf.getDisconnectedComponentsCount() == 1 : "Component count should be 1 now";
		uf.union(0, 3);
                assert uf.getDisconnectedComponentsCount() == 1 : "Component count should be 1 now";


		for (int i=0; i<7; i++) {
			for (int j=0; j<7; j++) {
				assert uf.connected(i, j) : i + " and " + j + " should be connected";
			}
		}


		System.out.println("All tests completed successfully!");

	}

}
