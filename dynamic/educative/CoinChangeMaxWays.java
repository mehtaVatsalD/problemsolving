public class CoinChangeMaxWays {

	public static void main(String...args) {
	
		int amt = InputCommons.ipIntNum(); //amount
		int n = InputCommons.ipIntNum(); //changes
		int[] changes = InputCommons.ipIntArr(n);
		System.out.println("Brute force solution output: " + new BruteForce().getMaxWaysForChange(changes, amt));
		System.out.println("Memoization solution output: " + new Memoization().getMaxWaysForChange(changes, amt));
		System.out.println("Tabulation solution output: " + new Tabulation().getMaxWaysForChange(changes, amt));
	
	}
	
	private static class BruteForce {
	
		public int getMaxWaysForChange(int[] changes, int amt) {
			return getMaxWaysForChange(changes, amt, changes.length-1);
		}
		
		public int getMaxWaysForChange(int[] changes, int amt, int i) {
			if (amt == 0) {
				return 1;
			} 
			if (i < 0) { // no ways to change coin as don't have any change
				return 0;
			}
			if (changes[i] <= amt) {
				return getMaxWaysForChange(changes, amt-changes[i], i)
					+ getMaxWaysForChange(changes, amt, i-1);
			} else {
				return getMaxWaysForChange(changes, amt, i-1);
			}
		}
	
	}
	
	private static class Memoization {
	
		public int getMaxWaysForChange(int[] changes, int amt) {
			Integer[][] memo = new Integer[changes.length][amt+1];
			int maxProfit = getMaxWaysForChange(changes, amt, changes.length-1, memo);
			return maxProfit;
		}
		
		public int getMaxWaysForChange(int[] changes, int amt, int i, Integer[][] memo) {
			if (amt == 0) {
				return 1;
			} 
			if (i < 0) { // no ways to change coin as don't have any change
				return 0;
			}
			
			if (memo[i][amt] != null) {
				return memo[i][amt];
			}
			
			if (changes[i] <= amt) {
				return memo[i][amt] = 
					getMaxWaysForChange(changes, amt-changes[i], i, memo)
					+ getMaxWaysForChange(changes, amt, i-1, memo);
			} else {
				return memo[i][amt] = getMaxWaysForChange(changes, amt, i-1, memo);
			}
		}
	
	}
	
	private static class Tabulation {
	
		public int getMaxWaysForChange(int[] changes, int amt) {
			int memo[] = new int[amt+1];
			for (int i=0; i<changes.length; i++) {
				for (int j=0; j<=amt; j++) {
					if (j == 0) {
						memo[j] = 1;
					} else if (j >= changes[i]) {
						memo[j] = memo[j - changes[i]] + memo[j];
					}
				}
			}
			return memo[amt];
		}
	
	}
	
}
