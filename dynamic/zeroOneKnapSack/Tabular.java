import java.util.*;

public class Tabular {

	public static void main(String...args) {
		int[] wts = new int[]{1, 2, 3, 2, 2};
		int[] vals = new int[]{8, 4, 0, 5, 3};
		int maxWt = 4;
		Tabular sol = new Tabular();
		int maxVal = sol.solve01KnapSack(wts, vals, maxWt);
		System.out.println(maxVal);
	}

	
	public int solve01KnapSack(int[] wts, int[] vals, int maxWt) {
		int[][] memo = new int[maxWt][wts.length];
		
		for (int wt=0; wt<maxWt; wt++) {
			for (int item=0; item<wts.length; item++) {
				//either include item for given wt
				int includedVal = 0;
				if (wts[item] <= wt+1) {
					includedVal += vals[item];
					includedVal += (item-1 >= 0 && wt-wts[item] >= 0 ? memo[wt-wts[item]][item-1]  : 0);
				}
				//or
				//don't include
				int notIncludedVal = item-1 >= 0 ? memo[wt][item-1] : 0;
				int maxVal = Math.max(includedVal, notIncludedVal);
				memo[wt][item]=maxVal;
			}  
		}
		return memo[maxWt-1][wts.length-1];
	}

}
