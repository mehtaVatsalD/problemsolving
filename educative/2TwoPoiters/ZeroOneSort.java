import java.util.*;

public class ZeroOneSort {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int i=0;
		while(n-- > 0) {
			arr[i++] = scan.nextInt();		
		}
		sortArrayOfZerosAndOnes(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	private static void sortArrayOfZerosAndOnes(int[] arr) {
		int n = arr.length;
		int j = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == 0) {
				swapInArray(arr, i, j);
				j++;
			}
		}
	}
	
	private static void swapInArray(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}

