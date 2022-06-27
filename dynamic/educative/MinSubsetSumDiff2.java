import java.util.*;

public class MinSubsetSumDiff2 {
	
	public static void main(String...args) {
		int n = InputCommons.ipIntNum(); //number of items in set	
	
		int[] vals = InputCommons.ipIntArr(n);
		int sum = Arrays.stream(vals).sum();
		
		System.out.println("Tabulation solution output: " + new Tabulation().minDiff(vals, sum));
	}
	
	
	public static class Tabulation {
		
		
		//O(N) space with single array
		// dual array can be done but is not done for this problem
		// refer to 0-1 knapsack solution for dual array solution
		public int minDiff(int[] vals, int totalSum) {
			int sum = totalSum / 2;
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
			for (int i=sum; i>=0; i--) {
				if (memo[i]) {
					return totalSum - 2*i;
				}
			}
			return totalSum;
		}
		
	}

}
