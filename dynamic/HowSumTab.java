import java.util.*;

public class HowSumTab {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(howSum(new int[]{5, 3, 4}, 7)));
		System.out.println(Arrays.toString(howSum(new int[]{5, 3, 4, 7}, 7)));
		System.out.println(Arrays.toString(howSum(new int[]{5, 3}, 7)));
		System.out.println(Arrays.toString(howSum(new int[]{2,3, 5}, 8)));
		System.out.println(Arrays.toString(howSum(new int[]{2,1}, 5)));
		System.out.println(Arrays.toString(howSum(new int[]{7, 14}, 300)));
		System.out.println(Arrays.toString(howSum(new int[]{7, 11}, 300)));
		//[4, 3]
		//null
		//[2, 2, 2, 2]
		//[1, 2, 2]
		//null
		//[11, 11, 11, 11, 11, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
	}
	
	private static int[] howSum(int[] arr, int n) {
		int[][] table = new int[n+1][];
		table[0] = new int[0];
		for(int i=0; i<n; i++) {
			if (table[i] == null) {
				continue;
			}
			for(int j=0; j<arr.length; j++) {
				if(i+arr[j] <= n && table[i + arr[j]] == null) {
					table[i + arr[j]] = Arrays.copyOf(table[i], table[i].length+1);//new int[table[i].length+1];
					table[i + arr[j]][table[i].length] = arr[j];
					//int k = 0;
					//for (k=0; k<table[i].length; k++) {
					//	table[i + arr[j]][k] = table[i][k];
					//}
					//table[i + arr[j]][k] = arr[j];
				}
			}
		}
		return table[n];
	}
	
}
