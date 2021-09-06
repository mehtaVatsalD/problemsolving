public class Fibo {

	public static void main(String...args) {
		System.out.println(fibo(6));
		System.out.println(fibo(8));
		System.out.println(fibo(50));
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
	
	/* Dynamic Prog. memoization approach
	 * Time complexity - O(2^N)
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
