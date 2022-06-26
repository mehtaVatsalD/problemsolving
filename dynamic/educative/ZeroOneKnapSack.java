public class ZeroOneKnapSack {
	
	public static void main(String...args) {
		int w = InputCommons.ipIntNum(); //capacity
		int n = InputCommons.ipIntNum(); //number of items	
		
		int[] wts = InputCommons.ipIntArr(n);
		int[] vals = InputCommons.ipIntArr(n);
		System.out.println("Brute force solution output: " + new BruteForce().solveZeroOneKnapSack(wts, vals, w));
		System.out.println("Memoization solution output: " + new Memoization().solveZeroOneKnapSack(wts, vals, w));
		System.out.println("Tabulation solution output: " + new Tabulation().solveZeroOneKnapSack(wts, vals, w));
	}
	
	public static class BruteForce {
	
		public int solveZeroOneKnapSack(int[] wts, int[] vals, int w) {
			return solveZeroOneKnapSack(wts, vals, w, vals.length-1);
		}
		
		private int solveZeroOneKnapSack(int[] wts, int[] vals, int w, int i) {
			if (i < 0 || w <= 0) {
				return 0;
			}
			
			if (wts[i] <= w) {
				return Math.max(
					vals[i] + solveZeroOneKnapSack(wts, vals, w-wts[i], i-1),
					solveZeroOneKnapSack(wts, vals, w, i-1)
				);
			} else {
				return solveZeroOneKnapSack(wts, vals, w, i-1);
			}
		}
		
	}
	
	public static class Memoization {
	
		public int solveZeroOneKnapSack(int[] wts, int[] vals, int w) {
			return solveZeroOneKnapSack(wts, vals, w, vals.length-1, new Integer[vals.length][w+1]);
		}
		
		private int solveZeroOneKnapSack(int[] wts, int[] vals, int w, int i, Integer[][] memo) {
			if (i < 0 || w <= 0) {
				return 0;
			}
			
			if (memo[i][w] != null) {
				return memo[i][w];
			}
			
			if (wts[i] <= w) {
				return memo[i][w] = Math.max(
					vals[i] + solveZeroOneKnapSack(wts, vals, w-wts[i], i-1, memo),
					solveZeroOneKnapSack(wts, vals, w, i-1, memo)
				);
			} else {
				return memo[i][w] = solveZeroOneKnapSack(wts, vals, w, i-1, memo);
			}
		}
		
	}
	
	
	public static class Tabulation {
	
		//O(N*W) space
		/*
		public int solveZeroOneKnapSack(int[] wts, int[] vals, int w) {
			int[][] memo = new int[vals.length][w+1];
			for (int i=0; i<vals.length; i++) {
				for (int j=0; j<=w; j++) {
					if (i == 0 || j == 0) {
						memo[i][j] = 0;
					} else if (wts[i] <= j) {
						memo[i][j] = Math.max(
							vals[i] + memo[i-1][j-wts[i]],
							memo[i-1][j]
						);
					} else {
						memo[i][j] = memo[i-1][j];
					}
				}
			}
			printSelectedElements(memo, wts, vals, w);
			return memo[vals.length-1][w];
		}
		*/
		
		//O(N) space - single array
		/*
		public int solveZeroOneKnapSack(int[] wts, int[] vals, int w) {
			int[] memo = new int[w+1];
			for (int i=0; i<vals.length; i++) {
				for (int j=w; j>=0; j--) {
					if (i == 0 || j == 0) {
						memo[j] = 0;
					} else if (wts[i] <= j) {
						memo[j] = Math.max(
							vals[i] + memo[j-wts[i]],
							memo[j]
						);
					} else {
						memo[j] = memo[j];
					}
				}
			}
			return memo[w];
		}
		*/
		
		//O(N) space - two arrays
		public int solveZeroOneKnapSack(int[] wts, int[] vals, int w) {
			int[][] memo = new int[2][w+1];
			for (int i=0; i<vals.length; i++) {
				for (int j=w; j>=0; j--) {
					if (i == 0 || j == 0) {
						memo[i%2][j] = 0;
					} else if (wts[i] <= j) {
						memo[i%2][j] = Math.max(
							vals[i] + memo[(i-1)%2][j-wts[i]],
							memo[(i-1)%2][j]
						);
					} else {
						memo[i%2][j] = memo[(i-1)%2][j];
					}
				}
			}
			return memo[(vals.length-1)%2][w];
		}
		
		
		private void printSelectedElements(int[][] memo, int[] wts, int[] vals, int w) {
			int i = vals.length-1;
			int j = w;
			while(memo[i][j] != 0) {
				if (memo[i][j] == memo[i-1][j]) {
					i--;
				} else {
					System.out.print(wts[i] + " ");
					j -= wts[i];
					i--;
				}
			}
			System.out.println();
		}
		
	}

}
