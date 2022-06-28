import java.util.Arrays;

public class CoinChangeMinCoins {

	public static void main(String...args) {
	
		int amt = InputCommons.ipIntNum(); //amount
		int n = InputCommons.ipIntNum(); //changes
		int[] changes = InputCommons.ipIntArr(n);
		System.out.println("Brute force solution output: " + new BruteForce().getMinCoinsForChange(changes, amt));
		System.out.println("Memoization solution output: " + new Memoization().getMinCoinsForChange(changes, amt));
		System.out.println("Tabulation solution output: " + new Tabulation().getMinCoinsForChange(changes, amt));
	
	}
	
	private static class BruteForce {
	
		public int getMinCoinsForChange(int[] changes, int amt) {
			return getMinCoinsForChange(changes, amt, changes.length-1);
		}
		
		public int getMinCoinsForChange(int[] changes, int amt, int i) {
			if (amt == 0) {
				return 0;
			} 
			if (i < 0) { // no ways to change coin. Hence infinite coins needed
				return Integer.MAX_VALUE-1;
			}
			if (changes[i] <= amt) {
				return Math.min(1 +getMinCoinsForChange(changes, amt-changes[i], i),
					getMinCoinsForChange(changes, amt, i-1));
			} else {
				return getMinCoinsForChange(changes, amt, i-1);
			}
		}
	
	}
	
	private static class Memoization {
	
		public int getMinCoinsForChange(int[] changes, int amt) {
			Integer[][] memo = new Integer[changes.length][amt+1];
			int maxProfit = getMinCoinsForChange(changes, amt, changes.length-1, memo);
			return maxProfit;
		}
		
		public int getMinCoinsForChange(int[] changes, int amt, int i, Integer[][] memo) {
			if (amt == 0) {
				return 0;
			} 
			if (i < 0) { // no ways to change coin. Hence infinite coins needed
				return Integer.MAX_VALUE-1;
			}
			
			if (memo[i][amt] != null) {
				return memo[i][amt];
			}
			
			if (changes[i] <= amt) {
				return memo[i][amt] = Math.min(
					1 + getMinCoinsForChange(changes, amt-changes[i], i, memo),
					getMinCoinsForChange(changes, amt, i-1, memo));
			} else {
				return memo[i][amt] = getMinCoinsForChange(changes, amt, i-1, memo);
			}
		}
	
	}
	
	private static class Tabulation {
	
		public int getMinCoinsForChange(int[] changes, int amt) {
			int memo[] = new int[amt+1];
			Arrays.fill(memo, Integer.MAX_VALUE - 1);
			for (int i=0; i<changes.length; i++) {
				for (int j=0; j<=amt; j++) {
					if (j == 0) {
						memo[j] = 0;
					} else if (j >= changes[i]) {
						memo[j] = Math.min(1 + memo[j - changes[i]], memo[j]);
					}
				}
			}
			return memo[amt];
		}
	
	}
	
}
