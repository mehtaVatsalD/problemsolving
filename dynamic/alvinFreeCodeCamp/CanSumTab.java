import java.util.*;

public class CanSumTab {

	public static void main(String[] args) {
		System.out.println(canSum2(new int[]{5, 3, 4, 7}, 7));//true
		System.out.println(canSum2(new int[]{5, 3}, 7));//false
		System.out.println(canSum2(new int[]{2,3, 5}, 8)); //true
		System.out.println(canSum2(new int[]{2,1}, 5)); //true
		System.out.println(canSum2(new int[]{7, 14}, 300)); //false
		System.out.println(canSum2(new int[]{7, 11}, 300)); //true
	}
	
	private static boolean canSum(int[] arr, int n) {
		boolean[] table = new boolean[n+1];
		table[0] = true;
		for (int i=0; i<arr.length; i++) {
			int num = arr[i];
			for (int j=1; j<=n; j++) {
				if (j-num < 0) {
					continue;
				}
				table[j] = table[j] || table[j-num];
			}
		}
		return table[n];
	}
	
	private static boolean canSum2(int[] arr, int n) {
		boolean[] table = new boolean[n+1];
		table[0] = true;
		for (int i=0; i<=n; i++) {
			if(!table[i]) {
				continue;
			}
			for (int j=0; j<arr.length; j++) {
				if (i + arr[j] <= n) {
					table[i+arr[j]] = true;
				}
			}
		}
		return table[n];
	}
	
}
