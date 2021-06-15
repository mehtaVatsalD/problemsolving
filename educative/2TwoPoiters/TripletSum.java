import java.util.*;

public class TripletSum {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int i=0;
		while(n-- > 0) {
			arr[i++] = scan.nextInt();		
		}
		int sum = scan.nextInt();
		List<int[]> res = findTripletWithGivenSum(arr, sum);
		res.forEach(out -> {
			System.out.println(Arrays.toString(out));
		});
	}
	

	private static List<int[]> findTripletWithGivenSum(int[] arr, int sum) {
		int n = arr.length;
		List<int[]> res = new ArrayList<>();
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			int j = i+1;
			int k = n-1;
			int newSum = sum - arr[i];
			while(j<k) {
				if(arr[j] + arr[k] == newSum) {
					res.add(new int[]{arr[i], arr[j], arr[k]});
					j++;
					k--;
				}
				else if(arr[j] + arr[k] < newSum) {
					j++;
				}
				else if(arr[j] + arr[k] > newSum) {
					k--;
				}
			}
		}
		return res;
		
	}	
	
}
