import java.util.Arrays;

public class EqualPartition {
	
	public static void main(String...args) {
		int n = InputCommons.ipIntNum(); //number of items in set	
		int[] vals = InputCommons.ipIntArr(n);
		
		int sum = Arrays.stream(vals).sum();
		
		if (sum % 2 != 0) {
			System.out.println("Set's sum is odd so there cannot be equal partition");
			return;
		}
		
		System.out.println("Brute force solution output: " + new BruteForce().solveSubsetSum(vals, sum/2));
		System.out.println("Memoization solution output: " + new Memoization().solveSubsetSum(vals, sum/2));
		System.out.println("Tabulation solution output: " + new Tabulation().solveSubsetSum(vals, sum/2));
	}
	
	public static class BruteForce {
	
		public boolean solveSubsetSum(int[] vals, int sum) {
			return solveSubsetSum(vals, sum, vals.length-1);
		}
		
		public boolean solveSubsetSum(int[] vals, int sum, int i) {
			if (sum == 0) {
				return true;
			}
			if (i < 0) {
				return false;
			}
			
			if (vals[i] <= sum) {
				return solveSubsetSum(vals, sum - vals[i], i-1)
				|| solveSubsetSum(vals, sum, i-1);
			} else {
				return solveSubsetSum(vals, sum, i-1);
			}
		}
		
	}
	
	public static class Memoization {
	
		public boolean solveSubsetSum(int[] vals, int sum) {
			return solveSubsetSum(vals, sum, vals.length-1, new Boolean[vals.length][sum+1]);
		}
		
		public boolean solveSubsetSum(int[] vals, int sum, int i, Boolean[][] memo) {
			if (sum == 0) {
				return true;
			}
			if (i < 0) {
				return false;
			}
			
			if (memo[i][sum] != null) {
				return memo[i][sum];
			}
			
			if (vals[i] <= sum) {
				return memo[i][sum] = solveSubsetSum(vals, sum - vals[i], i-1, memo)
				|| solveSubsetSum(vals, sum, i-1, memo);
			} else {
				return memo[i][sum] = solveSubsetSum(vals, sum, i-1, memo);
			}
		}
		
		
		
	}
	
	
	public static class Tabulation {
	
		//O(N*Sum) space
		public boolean solveSubsetSum(int[] vals, int sum) {
			boolean[][] memo = new boolean[vals.length+1][sum+1];
			for (int i=0; i<=vals.length; i++) {
				for(int j=0; j<=sum; j++) {
					if (j == 0) {
						memo[i][j] = true;
					} else if (i == 0) {
						memo[i][j] = false;
					} else if (vals[i-1] <= j) {
						memo[i][j] = memo[i-1][j - vals[i-1]]
							|| memo[i-1][j];
					} else {
						memo[i][j] = memo[i-1][j];
					}
				}
			}
			printSubset(memo, vals, sum);
			return memo[vals.length][sum];
		}
		
		//printing one such solution (not all!)
		private void printSubset(boolean[][] memo, int[] vals, int sum) {
			int i = vals.length;
			int j = sum;
			
			if (!memo[i][j]) {
				System.out.println("No subset found!");
				return;
			}
			
			while(i>0 && j>0) {
				if (j-vals[i-1] >=0 && memo[i-1][j-vals[i-1]]) {
					System.out.print(vals[i-1] + " ");
					j -= vals[i-1];
					i--;
				} else {
					i--;
				}
			}
			System.out.println();		
			
		}
		
		
		//O(N) space with single array
		// dual array can be done but is not done for this problem
		// refer to 0-1 knapsack solution for dual array solution
		/*
		public boolean solveSubsetSum(int[] vals, int sum) {
			boolean[] memo = new boolean[sum+1];
			for (int i=0; i<=vals.length; i++) {
				for(int j=sum; j>=0; j--) {
					if (j == 0) {
						memo[j] = true;
					} else if (i == 0) {
						memo[j] = false;
					} else if (vals[i-1] <= j) {
						memo[j] = memo[j - vals[i-1]]
							|| memo[j];
					} else {
						memo[j] = memo[j];
					}
				}
			}
			return memo[sum];
		}
		*/
		
	}

}
