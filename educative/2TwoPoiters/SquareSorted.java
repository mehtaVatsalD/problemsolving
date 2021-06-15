import java.util.Arrays;

public class SquareSorted {

	public static void main(String...args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6};
		int[] res = squareSortedArray(arr);
		System.out.println(Arrays.toString(res));
		arr = new int[]{-6, -3, -2, -1};
		res = squareSortedArray(arr);
		System.out.println(Arrays.toString(res));
		arr = new int[]{-6, -3, -2, -1, 0, 2, 4, 6, 7};
		res = squareSortedArray(arr);
		System.out.println(Arrays.toString(res));
		
		System.out.println();
		
		arr = new int[]{1, 2, 3, 4, 5, 6};
		res = squareSortedArrayAlternate(arr);
		System.out.println(Arrays.toString(res));
		arr = new int[]{-6, -3, -2, -1};
		res = squareSortedArrayAlternate(arr);
		System.out.println(Arrays.toString(res));
		arr = new int[]{-6, -3, -2, -1, 0, 2, 4, 6, 7};
		res = squareSortedArrayAlternate(arr);
		System.out.println(Arrays.toString(res));
	}
	
	private static int[] squareSortedArray(int[] arr) {
		int n = arr.length;
		int i = findFirstPositive(arr); //positive and zero
		int j = i-1; //negative
		int k = 0; //for storing squares in new array
		int[] res = new int[n];
		while(j>=0 || i<n) {
			if ( i<n && 
				 ( j<0 || Math.abs(arr[i]) < Math.abs(arr[j]) 
				 ) 
			   ) {
				res[k++] = arr[i]*arr[i++];
			}
			else if( j>=0 &&
			         ( i>=n || Math.abs(arr[i]) >= Math.abs(arr[j]) 
			         )
			       ) {
				res[k++] = arr[j]*arr[j--];
			}
		}
		return res;
		
	}

	
	private static int findFirstPositive(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] >= 0) {
				return i;
			}
		}
		return arr.length;
	}
	
	private static int[] squareSortedArrayAlternate(int[] arr) {
		int n = arr.length;
		int i = 0;
		int j = n-1;
		int k = n-1; //for storing squares in new array
		int[] res = new int[n];
		while(i<=j) {
			int leftSquare = arr[i]*arr[i];
			int rightSquare = arr[j]*arr[j];
			if(leftSquare > rightSquare) {
				res[k--] = leftSquare;
				i++;
			}
			else {
				res[k--] = rightSquare;
				j--;
			}
		}
		return res;
		
	}

}
