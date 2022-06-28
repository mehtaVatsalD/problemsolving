import java.util.*;

public class CoinChangePrintAllWays {

	public static void main(String...args) {
	
		int amt = InputCommons.ipIntNum(); //amount
		int n = InputCommons.ipIntNum(); //changes
		int[] changes = InputCommons.ipIntArr(n);
		System.out.println("Tabulation solution output: " + new Tabulation().printAllWaysForChange(changes, amt));
	
	}
	
	private static class Tabulation {
	
		public boolean printAllWaysForChange(int[] changes, int amt) {
			boolean memo[][] = new boolean[changes.length+1][amt+1];
			for (int i=0; i<=changes.length; i++) {
				for (int j=0; j<=amt; j++) {
					if (j == 0) {
						memo[i][j] = true;
					} else if (i == 0) {
						memo[i][j] = false;
					} else if (j >= changes[i-1]) {
						memo[i][j] = memo[i][j - changes[i-1]] || memo[i-1][j];
					} else {
						memo[i][j] = memo[i-1][j];
					}
				}
			}
			printAllWays(memo, changes, amt);
			return memo[changes.length][amt];
		}
		
		private void printAllWays(boolean[][] memo, int[] changes, int amt) {
			int i = changes.length;
			int j = amt;
			printAllWays(memo, changes, i, j, new ArrayList<>());
		}
		
		private void printAllWays(boolean[][] memo, int[] changes, int i, int j, List<Integer> res) {
			if (i < 0 || j < 0 || !memo[i][j]) {
				return;
			}
			
			if (i == 0 || j == 0) {
				System.out.println(res.toString());
				return;
			}
			
			res.add(changes[i-1]);
			printAllWays(memo, changes, i, j - changes[i-1], res);
			res.remove(res.size()-1);
			printAllWays(memo, changes, i-1, j, res);
			
		}
	
	}
	
}
