import java.util.*;

public class GridTravellerTab {
	
	public static void main(String...args) {
		System.out.println(noOfWays(2, 2));
		System.out.println(noOfWays(2, 3));
		System.out.println(noOfWays(4, 3));
		System.out.println(noOfWays(3, 3));
		System.out.println(noOfWays(4, 4));
		System.out.println(noOfWays(18, 18));
	}
	
	/**
	 * Solving using tabulation
	 */
	private static long noOfWays(int m, int n) {
		long[][] table = new long[m][n];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (i==0 || j == 0) {
					table[i][j] = 1;
					continue;
				}
				table[i][j] = table[i][j-1] + table[i-1][j];
			}
		}
		return table[m-1][n-1];
	}
	
}
