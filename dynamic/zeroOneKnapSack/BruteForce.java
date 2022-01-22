public class BruteForce {

	public static void main(String...args) {
		int[] wts = new int[]{1, 2, 3, 2, 2};
		int[] vals = new int[]{8, 4, 0, 5, 3};
		int maxWt = 4;
		BruteForce sol = new BruteForce();
		int maxVal = sol.solve01KnapSack(wts, vals, 0, maxWt);
		System.out.println(maxVal);
	}

	public int solve01KnapSack(int[] wts, int[] vals, int i, int maxWt) {
		if (i >= wts.length) {
			return 0;
		}
		int includedMaxVal = Integer.MIN_VALUE;
		//either include item at i
		if (wts[i] <= maxWt) {
			includedMaxVal = solve01KnapSack(wts, vals, i+1, maxWt - wts[i]) + vals[i];
		}
		//OR
		//move ahead without including item i
		int notIncludedMaxVal = solve01KnapSack(wts, vals, i+1, maxWt);
		return Math.max(includedMaxVal, notIncludedMaxVal);
	}

}
