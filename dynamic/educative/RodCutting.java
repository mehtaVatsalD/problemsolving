public class RodCutting {

	public static void main(String...args) {
	
		int rl = InputCommons.ipIntNum();
		int n = InputCommons.ipIntNum(); //number of items
		int[] cuts = InputCommons.ipIntArr(n);
		int[] prices = InputCommons.ipIntArr(n);
		System.out.println("Brute force solution output: " + new BruteForce().getMaxProfit(cuts, prices, rl));
		System.out.println("Memoization solution output: " + new Memoization().getMaxProfit(cuts, prices, rl));
		System.out.println("Tabulation solution output: " + new Tabulation().getMaxProfit(cuts, prices, rl));
	
	}
	
	private static class BruteForce {
	
		public int getMaxProfit(int[] cuts, int[] prices, int rl) {
			return getMaxProfit(cuts, prices, rl, cuts.length-1);
		}
		
		public int getMaxProfit(int[] cuts, int[] prices, int rl, int i) {
			if (rl == 0 || i < 0) {
				return 0;
			}
			
			if (rl >= cuts[i]) {
				return Math.max(
					prices[i] + getMaxProfit(cuts, prices, rl-cuts[i], i),
					getMaxProfit(cuts, prices, rl, i-1)
				);
			} else {
				return getMaxProfit(cuts, prices, rl, i-1);
			}
		}
	
	}
	
	private static class Memoization {
	
		public int getMaxProfit(int[] cuts, int[] prices, int rl) {
			Integer[][] memo = new Integer[cuts.length][rl+1];
			int maxProfit = getMaxProfit(cuts, prices, rl, cuts.length-1, memo);
			printAllCuts(memo, cuts, rl);
			return maxProfit;
		}
		
		public int getMaxProfit(int[] cuts, int[] prices, int rl, int i, Integer[][] memo) {
			if (rl == 0 || i < 0) {
				return 0;
			}
			
			if (memo[i][rl] != null) {
				return memo[i][rl];
			}
			
			if (rl >= cuts[i]) {
				return memo[i][rl] = Math.max(
					prices[i] + getMaxProfit(cuts, prices, rl-cuts[i], i, memo),
					getMaxProfit(cuts, prices, rl, i-1, memo)
				);
			} else {
				return memo[i][rl] = getMaxProfit(cuts, prices, rl, i-1, memo);
			}
		}
		
		private void printAllCuts(Integer[][] memo, int[] cuts, int rl) {
			int i = cuts.length-1;
			int j = rl;
			
			while(i >= 0 && j >= 0 && memo[i][j] != null) {
				if (i == 0 || memo[i][j] != memo[i-1][j]) {
					System.out.print(cuts[i] + " ");
					j -= cuts[i];
				} else {
					i--;
				}
			}
			System.out.println();
		}
		
	
	}
	
	private static class Tabulation {
	
		public int getMaxProfit(int[] cuts, int[] prices, int rl) {
			int[] memo = new int[rl+1];
			for (int i=0; i<cuts.length; i++) {
				for (int j=0; j<=rl; j++) {
					if (j == 0) {
						memo[j] = 0;
					} else if (j >= cuts[i]) {
						memo[j] = Math.max(prices[i] + memo[j-cuts[i]], memo[j]);
					}
				}
			}
			return memo[rl];
		}
	
	}
	
}
