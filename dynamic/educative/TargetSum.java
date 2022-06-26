import java.util.Arrays;

public class TargetSum {
	
	public static void main(String...args) {
		int diff = InputCommons.ipIntNum(); //difference
		int n = InputCommons.ipIntNum(); //number of items in set	
	
		int[] vals = InputCommons.ipIntArr(n);
		int sum = Arrays.stream(vals).sum();
		
		/*
			s1 - s2 = diff
			s1 + s2 = sum
			
			s1 = (diff + sum) / 2
		*/
		
		if ((diff + sum)%2 != 0) {
			System.out.println("Not possible to find subsets with given difference");
		}
		
		int val = (diff + sum) / 2;
		
		
		System.out.println("Brute force solution output: " + new BruteForce().countSubsetsWithGivenSum(vals, val));
		System.out.println("Memoization solution output: " + new Memoization().countSubsetsWithGivenSum(vals, val));
		System.out.println("Tabulation solution output: " + new Tabulation().countSubsetsWithGivenSum(vals, val));
	}
	
	public static class BruteForce {
	
		public int countSubsetsWithGivenSum(int[] vals, int sum) {
			return countSubsetsWithGivenSum(vals, sum, vals.length-1);
		}
		
		public int countSubsetsWithGivenSum(int[] vals, int sum, int i) {
			if (sum == 0) {
				return 1;
			}
			if (i < 0) {
				return 0;
			}
			
			if (vals[i] <= sum) {
				return countSubsetsWithGivenSum(vals, sum - vals[i], i-1)
					+ countSubsetsWithGivenSum(vals, sum, i-1);
			} else {
				return countSubsetsWithGivenSum(vals, sum, i-1);
			}
		}
		
	}
	
	public static class Memoization {
	
		public int countSubsetsWithGivenSum(int[] vals, int sum) {
			return countSubsetsWithGivenSum(vals, sum, vals.length-1, new Integer[vals.length][sum+1]);
		}
		
		public int countSubsetsWithGivenSum(int[] vals, int sum, int i, Integer[][] memo) {
			if (sum == 0) {
				return 1;
			}
			if (i < 0) {
				return 0;
			}
			
			if (memo[i][sum] != null) {
				return memo[i][sum];
			}
			
			if (vals[i] <= sum) {
				return memo[i][sum] = countSubsetsWithGivenSum(vals, sum - vals[i], i-1, memo)
					+ countSubsetsWithGivenSum(vals, sum, i-1, memo);
			} else {
				return memo[i][sum] = countSubsetsWithGivenSum(vals, sum, i-1, memo);
			}
		}
		
		
		
	}
	
	
	public static class Tabulation {
	
		public int countSubsetsWithGivenSum(int[] vals, int sum) {
			int[] memo = new int[sum+1];
			for (int i=0; i<=vals.length; i++) {
				for(int j=sum; j>=0; j--) {
					if (j == 0) {
						memo[j] = 1;
					} else if (i == 0) {
						memo[j] = 0;
					} else if (vals[i-1] <= j) {
						memo[j] = memo[j - vals[i-1]]
							+ memo[j];
					} else {
						memo[j] = memo[j];
					}
				}
			}
			return memo[sum];
		}
	
		
	}

}
