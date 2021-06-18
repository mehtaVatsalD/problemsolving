import java.util.*;

public class UnSortedSubArray {
	
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int i=0;
		while(n-- > 0) {
			arr[i++] = scan.nextInt();		
		}
		int len = smallestUnSortedSubArrayLength(arr);
		System.out.println(len);
		
	}
	
	private static int smallestUnSortedSubArrayLength(int arr[]) {
		int n = arr.length;
		int start = 0;
		int end = 0;
		boolean startFound = false;
		if(n == 0 || n == 1) {
			return 0;
		}
		int maxTillNow = arr[0];
		for(int i=1; i<n; i++) {
			if(arr[i] >= maxTillNow) {
			maxTillNow = arr[i];
				continue;
			}
			if(!startFound) {
				startFound = true;
				start = i-1;
				start = moveStartBack(arr, i, start);
			}
			else if(start >= 0 && arr[start] > arr[i]) {
				start = moveStartBack(arr, i, start);
			}			
			end = i;
		}
		return end - start;
	}
	
	private static int moveStartBack(int[] arr, int i, int start) {
		while(start >= 0 && arr[start] > arr[i]) {
			start--;
		}
		return start;
	}
	
}
