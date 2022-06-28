//solving by fan pattern
//seems like not good way
// but to have tool in toolcase
public class RodCutting2 {

	public static void main(String...args) {
	
		int rl = InputCommons.ipIntNum();
		int n = InputCommons.ipIntNum(); //number of items
		int[] cuts = InputCommons.ipIntArr(n);
		int[] prices = InputCommons.ipIntArr(n);
		System.out.println("Brute force solution output: " + new BruteForce().getMaxProfit(cuts, prices, rl));
		System.out.println("Memoization solution output: " + new Memoization().getMaxProfit(cuts, prices, rl));
	
	}
	
	private static class BruteForce {
	
		public int getMaxProfit(int[] cuts, int[] prices, int rl) {
			return getMaxProfit(cuts, prices, rl, 0);
		}
		
		public int getMaxProfit(int[] cuts, int[] prices, int rl, int i) {
			if (rl <= 0 || i >= cuts.length) {
				return 0;
			}
			
			int max = 0;	
			while(i<cuts.length) {
				if (rl >= cuts[i]) {
					int profit = prices[i] + getMaxProfit(cuts, prices, rl - cuts[i], i);
					max = max < profit ? profit : max;
				}
				i++;
			}
			return max;
			
			
		}
	
	}
	
	private static class Memoization {
	
		public int getMaxProfit(int[] cuts, int[] prices, int rl) {
			Integer[][] memo = new Integer[cuts.length][rl+1];
			int maxProfit = getMaxProfit(cuts, prices, rl, cuts.length-1, memo);
			return maxProfit;
		}
		
		public int getMaxProfit(int[] cuts, int[] prices, int rl, int i, Integer[][] memo) {
			if (rl <= 0 || i < 0) {
				return 0;
			}
			
			if (memo[i][rl] != null) {
				return memo[i][rl];
			}
			
			int max = 0;	
			int start = i;
			while(i >= 0) {
				if (rl >= cuts[i]) {
					int profit = prices[i] + getMaxProfit(cuts, prices, rl - cuts[i], i, memo);
					max = max < profit ? profit : max;
				}
				i--;
			}
			return memo[start][rl] = max;
			
			
		}
		
		
	
	}
	
}
