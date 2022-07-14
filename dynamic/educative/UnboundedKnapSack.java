public class UnboundedKnapSack {
	
	public static void main(String...args) {
		int w = InputCommons.ipIntNum(); //capacity
		int n = InputCommons.ipIntNum(); //number of items	
		
		int[] wts = InputCommons.ipIntArr(n);
		int[] vals = InputCommons.ipIntArr(n);
		System.out.println("Brute force solution output: " + new BruteForce().solveUnboundedKnapSack(wts, vals, w));
		System.out.println("Memoization solution output: " + new Memoization().solveUnboundedKnapSack(wts, vals, w));
		System.out.println("Tabulation solution output: " + new Tabulation().solveUnboundedKnapSack(wts, vals, w));
	}
	
	public static class BruteForce {
	
		public int solveUnboundedKnapSack(int[] wts, int[] vals, int w) {
			return solveUnboundedKnapSack(wts, vals, w, vals.length-1);
		}
		
		private int solveUnboundedKnapSack(int[] wts, int[] vals, int w, int i) {
			if (i < 0 || w <= 0) {
				return 0;
			}
			
			if (wts[i] <= w) {
				return Math.max(
					vals[i] + solveUnboundedKnapSack(wts, vals, w-wts[i], i),
					solveUnboundedKnapSack(wts, vals, w, i-1)
				);
			} else {
				return solveUnboundedKnapSack(wts, vals, w, i-1);
			}
		}
		
	}
	
	public static class Memoization {
	
		public int solveUnboundedKnapSack(int[] wts, int[] vals, int w) {
			return solveUnboundedKnapSack(wts, vals, w, vals.length-1, new Integer[vals.length][w+1]);
		}
		
		private int solveUnboundedKnapSack(int[] wts, int[] vals, int w, int i, Integer[][] memo) {
			if (i < 0 || w <= 0) {
				return 0;
			}
			
			if (memo[i][w] != null) {
				return memo[i][w];
			}
			
			if (wts[i] <= w) {
				return memo[i][w] = Math.max(
					vals[i] + solveUnboundedKnapSack(wts, vals, w-wts[i], i, memo),
					solveUnboundedKnapSack(wts, vals, w, i-1, memo)
				);
			} else {
				return memo[i][w] = solveUnboundedKnapSack(wts, vals, w, i-1, memo);
			}
		}
		
	}
	
	
	public static class Tabulation {
	
		//O(N*W) space
		/*
		public int solveUnboundedKnapSack(int[] wts, int[] vals, int w) {
			int[][] memo = new int[vals.length+1][w+1];
			for (int i=0; i<=vals.length; i++) {
				for (int j=0; j<=w; j++) {
					if (i == 0 || j == 0) {
						memo[i][j] = 0;
					} else if (wts[i-1] <= j) {
						memo[i][j] = Math.max(
							vals[i-1] + memo[i][j-wts[i-1]],
							memo[i-1][j]
						);
					} else {
						memo[i][j] = memo[i-1][j];
					}
				}
			}
			printSelectedElements(memo, wts, vals, w);
			return memo[vals.length][w];
		}
		*/
		
		//O(N) space - single array
	
		public int solveUnboundedKnapSack(int[] wts, int[] vals, int w) {
			int[] memo = new int[w+1];
			for (int i=0; i<=vals.length; i++) {
				for (int j=0; j<=w; j++) {
					if (i == 0 || j == 0) {
						memo[j] = 0;
					} else if (wts[i-1] <= j) {
						memo[j] = Math.max(
							vals[i-1] + memo[j-wts[i-1]],
							memo[j]
						);
					} else {
						memo[j] = memo[j];
					}
				}
			}
			return memo[w];
		}
		
		
		//O(N) space - two arrays
		/*
		public int solveUnboundedKnapSack(int[] wts, int[] vals, int w) {
			int[][] memo = new int[2][w+1];
			for (int i=0; i<=vals.length; i++) {
				for (int j=0; j<=w; j++) {
					if (i == 0 || j == 0) {
						memo[i%2][j] = 0;
					} else if (wts[i-1] <= j) {
						memo[i%2][j] = Math.max(
							vals[i-1] + memo[i%2][j-wts[i-1]],
							memo[(i-1)%2][j]
						);
					} else {
						memo[i%2][j] = memo[(i-1)%2][j];
					}
				}
			}
			return memo[(vals.length)%2][w];
		}
		*/
		
		/*
		private void printSelectedElements(int[][] memo, int[] wts, int[] vals, int w) {
			int i = vals.length;
			int j = w;
			while(memo[i][j] != 0) {
				if (memo[i][j] == memo[i-1][j]) {
					i--;
				} else {
					System.out.print(wts[i-1] + " ");
					j -= wts[i-1];
				}
			}
			System.out.println();
		}
		*/
		
	}

}
