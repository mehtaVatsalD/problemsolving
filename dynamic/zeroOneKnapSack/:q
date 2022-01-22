import java.util.*;

public class Memoized {

	public static void main(String...args) {
		int[] wts = new int[]{1, 2, 3, 2, 2};
		int[] vals = new int[]{8, 4, 0, 5, 3};
		int maxWt = 4;
		Memoized sol = new Memoized();
		int maxVal = sol.solve01KnapSack(wts, vals, 0, maxWt);
		System.out.println(maxVal);
	}

	
	public int solve01KnapSack(int[] wts, int[] vals, int i, int maxWt) {
		return solve01KnapSack(wts, vals, i, maxWt, new HashMap<>());
	}

	public int solve01KnapSack(int[] wts, int[] vals, int i, int maxWt, Map<String, Integer> memo) {
		if (i >= wts.length) {
			return 0;
		}
		String key = i + "#" + maxWt;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int includedMaxVal = Integer.MIN_VALUE;
		//either include item at i
		if (wts[i] <= maxWt) {
			includedMaxVal = solve01KnapSack(wts, vals, i+1, maxWt - wts[i], memo) + vals[i];
		}
		//OR
		//move ahead without including item i
		int notIncludedMaxVal = solve01KnapSack(wts, vals, i+1, maxWt, memo);
		int maxVal = Math.max(includedMaxVal, notIncludedMaxVal);
		memo.put(key, maxVal);
		return maxVal;
	}

}
