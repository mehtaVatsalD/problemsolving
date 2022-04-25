import java.util.*;

public class Solution {

	public static void main(String...args) {
    
    Solution sol = new Solution();
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] arr = new int[n];
    int i=0;
    while(i<n) {
      arr[i] = scan.nextInt();
      i++;
    }
    System.out.println(sol.findMissingNumber(arr));

	}

  private int findMissingNumber(int[] nums) {
    int n = nums.length;
    for(int i=0; i<n; i++) {
      while (i != nums[i] && nums[i] != n) {
        swap(nums, i, nums[i]);
      }
    }

    // System.out.println(Arrays.toString(nums));

    for(int i=0; i<n; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return n;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


}
