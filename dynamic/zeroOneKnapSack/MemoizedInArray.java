import java.util.*;

public class MemoizedInArray {

	public static void main(String...args) {
		int[] wts = new int[]{1, 2, 3, 2, 2};
		int[] vals = new int[]{8, 4, 0, 5, 3};
		int maxWt = 4;
		MemoizedInArray sol = new MemoizedInArray();
		int maxVal = sol.solve01KnapSack(wts, vals, 0, maxWt);
		System.out.println(maxVal);
	}

	
	public int solve01KnapSack(int[] wts, int[] vals, int i, int maxWt) {
		int[][] memo = new int[maxWt][wts.length];
		for(int[] arr: memo) {
			Arrays.fill(arr, -1);
		}
		return solve01KnapSack(wts, vals, wts.length-1, maxWt, memo);
	}

	public int solve01KnapSack(int[] wts, int[] vals, int i, int maxWt, int[][] memo) {
		if (i < 0 || maxWt <= 0) {
			return 0;
		}

		if (memo[maxWt-1][i] != -1) {
			return memo[maxWt-1][i];
		}		

		int includedMaxVal = Integer.MIN_VALUE;
		//either include item at i
		if (wts[i] <= maxWt) {
			includedMaxVal = solve01KnapSack(wts, vals, i-1, maxWt - wts[i], memo) + vals[i];
		}
		//OR
		//move ahead without including item i
		int notIncludedMaxVal = solve01KnapSack(wts, vals, i-1, maxWt, memo);
		int maxVal = Math.max(includedMaxVal, notIncludedMaxVal);
		memo[maxWt-1][i] = maxVal;
		return maxVal;
	}

}
