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
    System.out.println(Arrays.toString(sol.sort(arr)));

	}

  private int[] sort(int[] arr) {
    int n = arr.length;
    for(int i=0; i<n; i++) {
      while(i+1 != arr[i]) {
        swap(arr, i, arr[i]-1);
      }
    }
    return arr;

  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


}
