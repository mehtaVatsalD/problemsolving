import java.util.*;

public class SameDifferences {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			int i=0;
			while(i<n) {
				arr[i++] = scan.nextInt();
			}
			System.out.println(sameDiffCount(arr));
		}
	}
	
	private static long sameDiffCount(int[] arr) {
		int n = arr.length;
		Map<Integer, Long> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			int key = arr[i] - i;
			map.put(key, map.getOrDefault(key, 0L)+1L);
		}
		
		long cnt = 0;
		for(Long val:map.values()){
			if(val>1) {
				cnt+=nc2(val);
			}
		}
		return cnt;
	}
	
	private static long nc2(long n) {
		return n*(n-1)/2;
	}
	
}
