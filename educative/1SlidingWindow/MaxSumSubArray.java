public class MaxSumSubArray{

	public static void main(String[] args){
		System.out.println(findMaxSumSubArray(new int[]{2, 1, 5, 1, 3, 2}, 3));
		System.out.println(findMaxSumSubArray(new int[]{2, 3, 4, 1, 5}, 2));
	}
	
	private static int findMaxSumSubArray(int[] arr, int k){
		if(k>arr.length){
			System.out.println("K should be greater than array size");
			return -1;
		}
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		int start = 0, end = k-1;
		
		for(int i=0;i<k;i++){
			sum += arr[i];
		}
		max = sum;
		
		for(int i=k;i<n;i++){
			sum = sum - arr[i-k] + arr[i];
			if(sum > max){
				max = sum;
				start = i-k+1;
				end = i;
			}
		}
		for(int i=start;i<=end;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return max;	
	}

}
