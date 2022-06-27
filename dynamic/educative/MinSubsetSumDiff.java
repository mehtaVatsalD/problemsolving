import java.util.*;

// this problem is solved using method of finding 0-1 knapsack.
// it can also be solved by subset sum problem. 
// See MinSubsetSumDiff2 for same.
public class MinSubsetSumDiff {
	
	public static void main(String...args) {
		int n = InputCommons.ipIntNum(); //number of items	
		
		int[] vals = InputCommons.ipIntArr(n);
		
		int sum = Arrays.stream(vals).sum();
		
		System.out.println("Brute force solution output: " + new BruteForce().solveMinSubsetSumDiff(vals, sum));
		System.out.println("Memoization solution output: " + new Memoization().solveMinSubsetSumDiff(vals, sum));
		System.out.println("Tabulation solution output: " + new Tabulation().solveMinSubsetSumDiff(vals, sum));
	}
	
	public static class BruteForce {
	
		public int solveMinSubsetSumDiff(int[] vals, int sum) {
			return Math.abs(sum-2*solveMinSubsetSumDiff(vals, sum/2, vals.length-1));
		}
		
		private int solveMinSubsetSumDiff(int[] vals, int sum, int i) {
			if (i < 0 || sum <= 0) {
				return 0;
			}
			
			if (vals[i] <= sum) {
				return Math.max(
					vals[i] + solveMinSubsetSumDiff(vals, sum-vals[i], i-1),
					solveMinSubsetSumDiff(vals, sum, i-1)
				);
			} else {
				return solveMinSubsetSumDiff(vals, sum, i-1);
			}
		}
		
	}
	
	public static class Memoization {
	
		public int solveMinSubsetSumDiff(int[] vals, int sum) {
			return Math.abs(sum-2*solveMinSubsetSumDiff(vals, sum/2, vals.length-1, new Integer[vals.length][sum/2+1]));
		}
		
		private int solveMinSubsetSumDiff(int[] vals, int sum, int i, Integer[][] memo) {
			if (i < 0 || sum <= 0) {
				return 0;
			}
			
			if (memo[i][sum] != null) {
				return memo[i][sum];
			}
			
			if (vals[i] <= sum) {
				return memo[i][sum] = Math.max(
					vals[i] + solveMinSubsetSumDiff(vals, sum-vals[i], i-1, memo),
					solveMinSubsetSumDiff(vals, sum, i-1, memo)
				);
			} else {
				return memo[i][sum] = solveMinSubsetSumDiff(vals, sum, i-1, memo);
			}
		}
		
	}
	
	
	public static class Tabulation {

		public int solveMinSubsetSumDiff(int[] vals, int w) {
			int sum = w;
			w = w/2;
			int[] memo = new int[w+1];
			for (int i=0; i<=vals.length; i++) {
				for (int j=w; j>=0; j--) {
					if (i == 0 || j == 0) {
						memo[j] = 0;
					} else if (vals[i-1] <= j) {
						memo[j] = Math.max(
							vals[i-1] + memo[j-vals[i-1]],
							memo[j]
						);
					} else {
						memo[j] = memo[j];
					}
				}
			}
			return Math.abs(sum - 2*memo[w]);
		}
		
	}

}
