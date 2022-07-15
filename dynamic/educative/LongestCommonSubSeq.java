public class LongestCommonSubSeq {

	public static void main(String...args) {

		
		String s1 = InputCommons.ipStr();
		String s2 = InputCommons.ipStr();
		System.out.println("Brute force solution output: " + new BruteForce().solveLcs(s1, s2));
		System.out.println("Memoization solution output: " + new Memoization().solveLcs(s1, s2));
		System.out.println("Tabulation solution output: " + new Tabulation().solveLcs(s1, s2));
	}
	
	public static class BruteForce {
		
		public int solveLcs(String s1, String s2) {
			return solveLcs(s1, s2, s1.length()-1, s2.length()-1);
		}
		
		public int solveLcs(String s1, String s2, int i, int j) {
			if (i < 0 || j < 0) {
				return 0;
			}
			
			if (s1.charAt(i) == s2.charAt(j)) {
				return 1 + solveLcs(s1, s2, i-1, j-1);
			} else {
				return Math.max(
					solveLcs(s1, s2, i-1, j),
					solveLcs(s1, s2, i, j-1)
				);
			}
		}
		
	}
	
	public static class Memoization {
		
		public int solveLcs(String s1, String s2) {
			int n1 = s1.length();
			int n2 = s2.length();
			Integer[][] memo = new Integer[n1][n2];
			int max = solveLcs(s1, s2, n1-1, n2-1, memo);
			printLongestSubSeq(memo, s1, s2);
			return max;
		}
		
		public int solveLcs(String s1, String s2, int i, int j, Integer[][] memo) {
			if (i < 0 || j < 0) {
				return 0;
			}
			
			if (memo[i][j] != null) {
				return memo[i][j];
			}
			
			if (s1.charAt(i) == s2.charAt(j)) {
				return memo[i][j] = 1 + solveLcs(s1, s2, i-1, j-1, memo);
			} else {
				return memo[i][j] = Math.max(
					solveLcs(s1, s2, i-1, j, memo),
					solveLcs(s1, s2, i, j-1, memo)
				);
			}
		}
		
		private void printLongestSubSeq(Integer[][] memo, String s1, String s2) {
			int i = s1.length()-1;
			int j = s2.length()-1;
			StringBuilder sb = new StringBuilder();
			while(i >= 0 && j >= 0) {
				if (s1.charAt(i) == s2.charAt(j)) {
					sb.append(s1.charAt(i));
					i--;
					j--;
				} else {
					int prev1 = i-1 >= 0 ? memo[i-1][j] : 0;
					int prev2 = j-1 >= 0 ? memo[i][j-1] : 0;
					if (prev1 >= prev2) {
						i--;
					} else {
						j--;
					}
				}
			}
			System.out.println("===============>" + sb.reverse().toString());
		}
		
	}
	
	public static class Tabulation {
		
		//time comp - O(N*M)
		//space comp - O(N*M)
		/*
		public int solveLcs(String s1, String s2) {
			int n1 = s1.length();
			int n2 = s2.length();
			Integer[][] memo = new Integer[n1+1][n2+1];
			for (int i=0; i<=n1; i++) {
				for (int j=0; j<=n2; j++) {
					if (i == 0 || j == 0) {
						memo[i][j] = 0;
					} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
						memo[i][j] = 1 + memo[i-1][j-1];
					} else {
						memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
					}
				}
			}
			return memo[n1][n2];
		}
		*/
		
		//time comp - O(N*M)
		//space comp - O(N)
		public int solveLcs(String s1, String s2) {
			int n1 = s1.length();
			int n2 = s2.length();
			Integer[][] memo = new Integer[2][n2+1];
			for (int i=0; i<=n1; i++) {
				for (int j=0; j<=n2; j++) {
					if (i == 0 || j == 0) {
						memo[i%2][j] = 0;
					} else if (s1.charAt(i-1) == s2.charAt(j-1)) {
						memo[i%2][j] = 1 + memo[(i-1)%2][j-1];
					} else {
						memo[i%2][j] = Math.max(memo[(i-1)%2][j], memo[i%2][j-1]);
					}
				}
			}
			return memo[n1%2][n2];
		}	
		
	}
	
}
