import java.util.*;

public class QuadrupletsSum {
	
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		int i=0;
		while(n-- > 0) {
			arr[i++] = scan.nextInt();		
		}
		int sum = scan.nextInt();
		List<int[]> res = quadupletsSum(arr, sum);
		res.forEach(resArr-> System.out.println(Arrays.toString(resArr)));
	}
	
	private static List<int[]> quadupletsSum(int[] arr, int sum) {
		List<int[]> res = new ArrayList<>();
		Arrays.sort(arr);
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int k = j+1;
				int l = n-1;
				while(k<l) {
					int thisSum = arr[i] + arr[j] + arr[k] + arr[l];
					if(thisSum == sum) {
						res.add(new int[]{arr[i], arr[j], arr[k], arr[l]});
						k = getNext(arr, k, true);
						l = getNext(arr, l, false);
					}
					else if(thisSum < sum) {
						k = getNext(arr, k, true);
					}
					else {
						l = getNext(arr, l, false);
					}
				}				
			}
		}
		return res;
	}
	
	private static int getNext(int[] arr, int i, boolean inc) {
		int n = arr.length;
		if(inc) {
			do{
				i++;
			}
			while(i<n && arr[i] == arr[i-1]);
			return i;
		}
		do{
			i--;
		}
		while(i>=0 && arr[i] == arr[i+1]);
		return i;
	}
	
}
