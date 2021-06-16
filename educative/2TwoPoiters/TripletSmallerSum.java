import java.util.*;

public class TripletSmallerSum {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int i=0;
		while(n-- > 0) {
			arr[i++] = scan.nextInt();		
		}
		int sum = scan.nextInt();
		int count = findTripletWithSmallerSum(arr, sum);
		System.out.println(count);
		System.out.println();
		List<int[]> res = findTripletWithSmallerSumList(arr, sum);
		res.forEach(triplet -> {
			System.out.println(Arrays.toString(triplet));
		});
	}
	
	private static int findTripletWithSmallerSum(int[] arr, int sum) {
		Arrays.sort(arr);
		int n = arr.length;
		int count = 0;
		for(int i = 0; i<n; i++) {
			int j = i+1;
			int k = n-1;
			while(j<k) {
				int thisSum = arr[i] + arr[j] + arr[k];
				if(thisSum < sum) {
					count += (k-j);
					j++;
				}
				else {
					k--;
				}
			}
		}
		return count;
	}
	
	private static List<int[]> findTripletWithSmallerSumList(int[] arr, int sum) {
		List<int[]> res = new ArrayList<>();
		Arrays.sort(arr);
		int n = arr.length;
		for(int i = 0; i<n; i++) {
			int j = i+1;
			int k = n-1;
			while(j<k) {
				int thisSum = arr[i] + arr[j] + arr[k];
				if(thisSum < sum) {
					for(int l=k; l>j; l--) {
						res.add(new int[]{arr[i], arr[j], arr[l]});
					}
					j++;
				}
				else {
					k--;
				}
			}
		}
		return res;
	}
	
}
