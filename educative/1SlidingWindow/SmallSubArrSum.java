public class SmallSubArrSum{


	public static void main(String[] args){
		System.out.println(smallestSubArrayWithGivenSum(new int[]{2, 1, 5, 2, 3, 2}, 7));
		System.out.println(smallestSubArrayWithGivenSum(new int[]{2, 1, 5, 2, 8}, 7));
		System.out.println(smallestSubArrayWithGivenSum(new int[]{3, 4, 1, 1, 6}, 8));
		System.out.println(smallestSubArrayWithGivenSum(new int[]{1, 2, 1}, 8));
	}
	
	private static int smallestSubArrayWithGivenSum(int[] arr, int s){
		int n = arr.length;
		int min = n;
		if(n==0){
			return 0;
		}
		int start = 0;
		int end = 0;
		int wsum = arr[0];
		do{
			if(wsum >= s){
				if(min > end - start + 1){
					min = end - start +1;
				}
				start++;
				if(start<n)
					wsum -= arr[start-1];
			}
			else{
				end++;
				if(end<n)
					wsum += arr[end];
			}
		}
		while(end<n && min!=1);
		
		if(min == n){
			return 0;
		}
		return min;
		
	}

}
