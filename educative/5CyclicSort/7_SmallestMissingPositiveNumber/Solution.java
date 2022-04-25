import java.util.*;


public class Solution {

  public static void main(String...args) {
    Solution sol = new Solution();                                                                                                                                Scanner scan = new Scanner(System.in);                                                                                                                        int n = scan.nextInt();                                                                                                                                       int[] arr = new int[n];                                                                                                                                       int i=0;                                                                                                                                                      while(i<n) {                                                                                                                                                    arr[i] = scan.nextInt();                                                                                                                                      i++;                                                                                                                                                        }                                                                                                                                                             System.out.println(sol.firstMissingPositive(arr));
  }


  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for(int i=0; i<n; i++) {
      while(nums[i] > 0 && nums[i] != i+1 && nums[i] <= n) {
        int last = nums[i];
        swap(nums, i, nums[i]-1);
        if (last == nums[i]) break;
      }
    }

    for (int i=0; i<n; i++) {
      if (nums[i] != i+1) return i+1;
    }

    return n+1;

  
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
