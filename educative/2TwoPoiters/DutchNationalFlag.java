import java.util.*;

public class DutchNationalFlag {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int i=0;
		while(n-- > 0) {
			arr[i++] = scan.nextInt();		
		}
		sortArrayOfZerosOnesAndTwos(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	private static void sortArrayOfZerosOnesAndTwos(int[] arr) {
		int n = arr.length;
		int one = 0;
		int two = n-1;
		for(int i=0; i<=two; i++) {
			if(arr[i] == 0) {
				swapInArray(arr, i, one);
				one++;
			}
			else if(arr[i] == 2) {
				swapInArray(arr, i, two);
				two--;
				i--;
			}
		}
	}
	
	private static void swapInArray(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}

