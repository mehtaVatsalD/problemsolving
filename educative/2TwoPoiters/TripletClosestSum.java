import java.util.*;

public class TripletClosestSum{

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int i=0;
		while(n-- > 0) {
			arr[i++] = scan.nextInt();		
		}
		int sum = scan.nextInt();
		int minDiffSum = findTripletSumClosestToTarget(arr, sum);
		System.out.println(minDiffSum);
	}


	private static int findTripletSumClosestToTarget(int[] arr, int sum) {
		int minDiff = Integer.MAX_VALUE;
		int minDiffSum = Integer.MAX_VALUE;
		Arrays.sort(arr);
		int n = arr.length;
		for(int i=0; i<n; i++) {
			int j = i+1;
			int k = n-1;
			while(j<k) {
				int thisSum = arr[j] + arr[k] + arr[i];
				int diff = Math.abs(sum - thisSum);
				if(thisSum == sum) {
					return thisSum;
				}
				else if (thisSum < sum) {
					if( diff < minDiff || (diff == minDiff && thisSum < minDiffSum) ) {
						minDiff = Math.abs(sum - thisSum);
						minDiffSum = thisSum;
					}
					j++;
				}
				else if (thisSum > sum) {
					if( diff < minDiff || (diff == minDiff && thisSum < minDiffSum) ) {
						minDiff = Math.abs(sum - thisSum);
						minDiffSum = thisSum;
					}
					k--;				
				}
			}
		}
		return minDiffSum;
	}

}
