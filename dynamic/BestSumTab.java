import java.util.*;

public class BestSumTab {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(bestSum(new int[]{5, 3, 4}, 7)));
		System.out.println(Arrays.toString(bestSum(new int[]{5, 3, 4, 7}, 7)));
		System.out.println(Arrays.toString(bestSum(new int[]{5, 3}, 7)));
		System.out.println(Arrays.toString(bestSum(new int[]{2,3, 5}, 8)));
		System.out.println(Arrays.toString(bestSum(new int[]{2,1}, 5)));
		System.out.println(Arrays.toString(bestSum(new int[]{7, 14}, 300)));
		System.out.println(Arrays.toString(bestSum(new int[]{7, 11}, 300)));
		/*
			[7]
			null
			[5, 3]
			[1, 2, 2]
			null
			[11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 7, 7]

		*/
	}
	
	private static int[] bestSum(int[] arr, int n) {
		int[][] table = new int[n+1][];
		table[0] = new int[0];
		for(int i=0; i<n; i++) {
			if (table[i] == null) {
				continue;
			}
			for(int j=0; j<arr.length; j++) {
				if(i+arr[j] <= n) {
					if (table[i + arr[j]] == null || table[i + arr[j]].length > table[i].length + 1) {
						table[i + arr[j]] = Arrays.copyOf(table[i], table[i].length+1);
						table[i + arr[j]][table[i].length] = arr[j];
					}
					
				}
			}
		}
		return table[n];
	}
	
}
