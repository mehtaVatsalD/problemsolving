public class GridTraveller {
	
	public static void main(String...args) {
		System.out.println(noOfWays(2, 2));
		System.out.println(noOfWays(2, 3));
		System.out.println(noOfWays(4, 3));
		System.out.println(noOfWays(3, 3));
		System.out.println(noOfWays(4, 4));
		System.out.println(noOfWays(18, 18));
	}
	
	/**
	 * Solving using memoization
	 */
	private static long noOfWays(int m, int n) {
		int larger = getLarger(m, n);
		return noOfWays(m, n, new long[larger+1][larger+1]);
	}
	
	private static long noOfWays(int m, int n, long[][] memo) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		if (memo[m][n] != 0) {
			return memo[m][n];
		}
		if (memo[n][m] != 0) {
			return memo[n][m];
		}
		long res = noOfWays(m-1, n, memo) + noOfWays(m, n-1, memo);
		memo[m][n] = res;
		memo[n][m] = res;
		return res;
	}
	
	private static int getLarger(int a, int b) {
		return a >= b ? a : b;
	}
	
}
