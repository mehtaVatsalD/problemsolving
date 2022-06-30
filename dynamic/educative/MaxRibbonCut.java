import java.util.*;

public class MaxRibbonCut {

	public static void main(String...args) {
	
		int rl = InputCommons.ipIntNum();
		int n = InputCommons.ipIntNum(); //number of cuts
		int[] cuts = InputCommons.ipIntArr(n);
		System.out.println("Brute force solution output: " + new BruteForce().getMaxPieces(cuts, rl));
		System.out.println("Memoization solution output: " + new Memoization().getMaxPieces(cuts, rl));
		System.out.println("Tabulation solution output: " + new Tabulation().getMaxPieces(cuts, rl));
	
	}
	
	private static class BruteForce {
	
		public int getMaxPieces(int[] cuts, int rl) {
			return getMaxPieces(cuts, rl, cuts.length-1);
		}
		
		public int getMaxPieces(int[] cuts, int rl, int i) {
			if (rl <= 0) {
				return 0;
			} 
			if (i < 0) {
				return Integer.MIN_VALUE;
			}
			
			if (cuts[i] <= rl) {
				int val = getMaxPieces(cuts, rl - cuts[i], i);
				if (val != Integer.MIN_VALUE) val++;
				return Math.max(
					val,
					getMaxPieces(cuts, rl, i-1)
				);
			} else {
				return getMaxPieces(cuts, rl, i-1);
			}
			
		}
	
	}
	
	private static class Memoization {
	
		public int getMaxPieces(int[] cuts, int rl) {
			Integer[][] memo = new Integer[cuts.length][rl+1];
			int maxProfit = getMaxPieces(cuts, rl, cuts.length-1, memo);
			return maxProfit;
		}
		
		public int getMaxPieces(int[] cuts, int rl, int i, Integer[][] memo) {
			if (rl <= 0) {
				return 0;
			} 
			if (i < 0) {
				return Integer.MIN_VALUE;
			}
			
			if (memo[i][rl] != null)  {
				return memo[i][rl];
			}
			
			if (cuts[i] <= rl) {
				int val = getMaxPieces(cuts, rl - cuts[i], i, memo);
				if (val != Integer.MIN_VALUE) val++;
				return memo[i][rl] = Math.max(
					val,
					getMaxPieces(cuts, rl, i-1, memo)
				);
			} else {
				return memo[i][rl] = getMaxPieces(cuts, rl, i-1, memo);
			}
			
		}
		
	
	}
	
	private static class Tabulation {
	
		public int getMaxPieces(int[] cuts, int rl) {
			int[] memo = new int[rl+1];
			
			for (int i=0; i<=cuts.length; i++) {
				for (int j=0; j<=rl; j++) {
					if (j == 0) {
						memo[j] = 0;
					} else if (i == 0) {
						memo[j] = Integer.MIN_VALUE;
					} else if (cuts[i-1] <= j) {
						int val = memo[j - cuts[i-1]];
						if (val != Integer.MIN_VALUE) {
							val++;
						}
						memo[j] = Math.max(val, memo[j]);
					}
				}
			}
			return memo[rl];
		}
	
	}
	
}
