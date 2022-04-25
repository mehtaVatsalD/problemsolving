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
    int k = scan.nextInt();
    System.out.println(sol.kMissingPositives(arr, k).toString());     
  }


  public List<Integer> kMissingPositives(int[] nums, int k) {
    int n = nums.length;
    for(int i=0; i<n; i++) {
      while(nums[i] > 0 && nums[i] != i+1 && nums[i] <= n) {
        int last = nums[i];
        swap(nums, i, nums[i]-1);
        if (last == nums[i]) break;
      }
    }

    List<Integer> res = new ArrayList<>();

    for (int i=0; i<n; i++) {
      if (nums[i] != i+1) {
        res.add(i+1);
        k--;
      };
    }
    int next = n+1;
    while(k > 0) {
      res.add(next++);
      k--;
    }

    return res;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
