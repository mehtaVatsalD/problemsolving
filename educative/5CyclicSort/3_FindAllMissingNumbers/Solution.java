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
    System.out.println(sol.findAllMissingNumbers(arr).toString());

	}

  private List<Integer> findAllMissingNumbers(int[] nums) {
    int n = nums.length;
    List<Integer> res = new ArrayList<>();
    for(int i=0; i<n; i++) {
      int last = nums[i];
      while (i+1 != nums[i]) {
        swap(nums, i, nums[i]-1);
        if (nums[i] == last) break;
        last = nums[i];
      }
    }

     System.out.println(Arrays.toString(nums));

    for(int i=0; i<n; i++) {
      if (nums[i] != i+1) {
        res.add(i+1);
      }
    }
    return res;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


}
