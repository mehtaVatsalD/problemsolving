import java.util.Arrays;

public class ZeroesReplacedOnesLargest{
	public static void main(String[] args){
		System.out.println(getLargestOnesStr(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
		System.out.println(getLargestOnesStr(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
		
	}
	
	private static int getLargestOnesStr(int[] arr, int k){
		System.out.println("Array: " + Arrays.toString(arr) + " k: " + k);
		if(arr.length == 0 || k == 0){
			return 0;
		}
		int cnt = 0;
		int start = 0;
		int end = 0;
		int max = 0;
		while(end<arr.length){
			if(arr[end] == 1){
				end++;
			}
			else if(cnt + 1 <= k){
				cnt++;
				end++;
			}
			else{
				if(arr[start] == 0){
					cnt--;
				}
				start++;
			}
			
			
			if(end - start > max){
				max = end - start;
			}
		}
		return max;
	}
}
