import java.util.*;

public class CountNumberOfSubSetsWithGivenSum {
	
	public static void main(String...args) {
		int sum = InputCommons.ipIntNum(); //total sum
		int n = InputCommons.ipIntNum(); //number of items in set	
	
		int[] vals = InputCommons.ipIntArr(n);
		System.out.println("Brute force solution output: " + new BruteForce().countSubsetsWithGivenSum(vals, sum));
		System.out.println("Memoization solution output: " + new Memoization().countSubsetsWithGivenSum(vals, sum));
		System.out.println("Tabulation solution output: " + new Tabulation().countSubsetsWithGivenSum(vals, sum));
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
	
		/*
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
		}*/
		
		public int countSubsetsWithGivenSum(int[] vals, int sum) {
			int[][] memo = new int[vals.length+1][sum+1];
			for (int i=0; i<=vals.length; i++) {
				for(int j=sum; j>=0; j--) {
					if (j == 0) {
						memo[i][j] = 1;
					} else if (i == 0) {
						memo[i][j] = 0;
					} else if (vals[i-1] <= j) {
						memo[i][j] = memo[i-1][j - vals[i-1]]
							+ memo[i-1][j];
					} else {
						memo[i][j] = memo[i-1][j];
					}
				}
			}
			printAllSubsets(memo, vals, sum);
			return memo[vals.length][sum];
		}
		
		private void printAllSubsets(int[][] memo, int[] vals, int sum) {
			int i = vals.length;
			int j = sum;
			
			printAllSubsets(memo, vals, i, j, new ArrayList<>());		
			
		}
		
		private void printAllSubsets(int[][] memo, int[] vals, int i, int j, List<Integer> res) {
			
			if (i < 0 || j < 0 || memo[i][j] == 0) {
				return;
			}
			
			if ((i == 0 || j == 0) && memo[i][j] != 0) {
				System.out.println(res.toString());
				return;
			}
			
			res.add(vals[i-1]);
			printAllSubsets(memo, vals, i-1, j - vals[i-1], res);
			res.remove(res.size()-1);
			printAllSubsets(memo, vals, i-1, j, res);
			
		}
	
		
	}

}
