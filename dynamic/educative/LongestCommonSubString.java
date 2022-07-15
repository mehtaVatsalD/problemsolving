public class LongestCommonSubString {

	public static void main(String...args) {

		
		String s1 = InputCommons.ipStr();
		String s2 = InputCommons.ipStr();
		System.out.println("Brute force solution output: " + new BruteForce().solveLcs(s1, s2));
		System.out.println("Memoization solution output: " + new Memoization().solveLcs(s1, s2));
		System.out.println("Tabulation solution output: " + new Tabulation().solveLcs(s1, s2));
	}
	
	public static class Value {
		int max;
		int it;
		
		Value(int max, int it) {
			this.max = max;
			this.it = it;
		}
	}
	
	public static class BruteForce {
		
		public int solveLcs(String s1, String s2) {
			return solveLcs(s1, s2, s1.length()-1, s2.length()-1).max;
		}
		
		public Value solveLcs(String s1, String s2, int i, int j) {
			if (i < 0 || j < 0) {
				return new Value(0, 0);
			}
			
			if (s1.charAt(i) == s2.charAt(j)) {
				Value val = solveLcs(s1, s2, i-1, j-1);
				int it = 1 + val.it;
				int max = Math.max(it, val.max);
				return new Value(max, it);
			} else {
				Value val1 = solveLcs(s1, s2, i-1, j);
				Value val2 = solveLcs(s1, s2, i, j-1);
				int max = Math.max(val1.max, val2.max);
				return new Value(max, 0);
			}
		}
		
	}
	
	public static class Memoization {
		
		public int solveLcs(String s1, String s2) {
			int n1 = s1.length();
			int n2 = s2.length();
			Value[][] memo = new Value[n1][n2];
			int max = solveLcs(s1, s2, n1-1, n2-1, memo).max;
			return max;
		}
		
		public Value solveLcs(String s1, String s2, int i, int j, Value[][] memo) {
			if (i < 0 || j < 0) {
				return new Value(0, 0);
			}
			
			if (memo[i][j] != null) {
				return memo[i][j];
			}
			
			if (s1.charAt(i) == s2.charAt(j)) {
				Value val = solveLcs(s1, s2, i-1, j-1, memo);
				int it = 1 + val.it;
				int max = Math.max(it, val.max);
				return memo[i][j] = new Value(max, it);
			} else {
				Value val1 = solveLcs(s1, s2, i-1, j, memo);
				Value val2 = solveLcs(s1, s2, i, j-1, memo);
				int max = Math.max(val1.max, val2.max);
				return memo[i][j] = new Value(max, 0);
			}
		}
		
	}
	
	public static class Tabulation {
		
		//time comp - O(N*M)
		//space comp - O(N*M)
		///*
		public int solveLcs(String s1, String s2) {
			int n1 = s1.length();
			int n2 = s2.length();
			Value[][] memo = new Value[n1+1][n2+1];
			for (int i=0; i<=n1; i++) {
				for (int j=0; j<=n2; j++) {
					if (i == 0 || j == 0) {
						memo[i][j] = new Value(0, 0);
					} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
						Value val = memo[i-1][j-1];
						int it = 1 + val.it;
						int max = Math.max(it, val.max);
						memo[i][j] = new Value(max, it);
					} else {
						memo[i][j] = new Value(Math.max(memo[i-1][j].max, memo[i][j-1].max), 0);
					}
				}
			}
			return memo[n1][n2].max;
		}
		//*/
		
		/*
		//time comp - O(N*M)
		//space comp - O(N)
		public int solveLcs(String s1, String s2) {
			int n1 = s1.length();
			int n2 = s2.length();
			Value[][] memo = new Value[2][n2+1];
			for (int i=0; i<=n1; i++) {
				for (int j=0; j<=n2; j++) {
					if (i == 0 || j == 0) {
						memo[i%2][j] = new Value(0, 0);
					} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
						Value val = memo[(i-1)%2][j-1];
						int it = 1 + val.it;
						int max = Math.max(it, val.max);
						memo[i%2][j] = new Value(max, it);
					} else {
						memo[i%2][j] = new Value(Math.max(memo[(i-1)%2][j].max, memo[i%2][j-1].max), 0);
					}
				}
			}
			return memo[n1%2][n2].max;
		}	
		*/
		
	}
	
}
