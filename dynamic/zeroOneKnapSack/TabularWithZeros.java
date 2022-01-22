import java.util.*;

public class TabularWithZeros {

	public static void main(String...args) {
		int[] wts = new int[]{1, 2, 3, 2, 2};
		int[] vals = new int[]{8, 4, 0, 5, 3};
		int maxWt = 4;
		TabularWithZeros sol = new TabularWithZeros();
		int maxVal = sol.solve01KnapSack(wts, vals, maxWt);
		System.out.println(maxVal);
	}

	
	public int solve01KnapSack(int[] wts, int[] vals, int maxWt) {
		int[][] memo = new int[maxWt+1][wts.length+1];
		
		for (int wt=0; wt<=maxWt; wt++) {
			for (int item=0; item<=wts.length; item++) {
				if (wt == 0 || item == 0) {
					memo[wt][item] = 0;
					continue;
				}
				//either include item for given wt
				int includedVal = 0;
				if (wts[item-1] <= wt) {
					includedVal += (memo[wt-wts[item-1]][item-1] + vals[item-1]);
				}
				//or
				//don't include
				int notIncludedVal = memo[wt][item-1];
				int maxVal = Math.max(includedVal, notIncludedVal);
				memo[wt][item] = maxVal;
			}  
		}
		return memo[maxWt][wts.length];
	}

}
