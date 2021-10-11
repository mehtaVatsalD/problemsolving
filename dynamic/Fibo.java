public class Fibo {

	public static void main(String...args) {
		System.out.println(fiboTab(6));
		System.out.println(fiboTab(8));
		System.out.println(fiboTab(50));
	}
	
	/* Brute Force approach
	 * Time complexity - O(2^N)
	 * Space complexity - O(N)
	 */
	private static long fiboBruteForce(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return fiboBruteForce(n-1) + fiboBruteForce(n-2);
	}
	
	/* Dynamic Prog. tabulation approach
	 * Time complexity - O(N)
	 * Space complexity - O(N)
	 */
	private static long fiboTab(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		long[] table = new long[n+1];
		table[0] = 0;
		table[1] = 1;
		for(int i=2; i<=n; i++) {
			table[i] = table[i-1] + table[i-2];
		}
		return table[n];
	}
	
	/* Dynamic Prog. memoization approach
	 * Time complexity - O(N)
	 * Space complexity - O(N)
	 */
	private static long fibo(int n) {
		return fibo(n, new long[n+1], new boolean[n+1]);
	}
	
	private static long fibo(int n, long[] memo, boolean[] isMemoSet) {
		if(isMemoSet[n]) {
			return memo[n];
		}
		if(n == 1 || n == 2) {
			return 1;
		}
		memo[n] = fibo(n-1, memo, isMemoSet) + fibo(n-2, memo, isMemoSet);
		isMemoSet[n] = true;
		return memo[n];
	}

}
