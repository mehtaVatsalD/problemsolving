import java.util.*;

public class ClosestSum{
	public static void main(String[] args){
	
		int[] a1 = {1, 4, 20, 25};
		int[] a2 = {6, 10, 15, 40, 43};
		
		int t = 29;
		
		Solution solution = new Solution();
		
		int[] ans = solution.findClosestSum(a1, a2, t);
		
		System.out.println(Arrays.toString(ans));
				
	}
}

class Solution{
	public int[] findClosestSum(int[] a1, int[] a2, int t){
		int min = t;
		int a = 0, b = 0;
		int i=0, j=a2.length-1;
		while(i<a1.length && j>=0){
			if(min > Math.abs(t-(a1[i]+a2[j]))){
				min = Math.abs(t-(a1[i]+a2[j]));
				a = a1[i];
				b = a2[j];
			}
			if(a1[i]+a2[j] == t){
				return new int[]{a1[i], a2[j]};
			}
			else if(a1[i]+a2[j] > t){
				j--;
			}
			else{
				i++;
			}
		}
		return new int[]{a, b};
	}
}

class Solution1{
	public int[] findClosestSum(int[] a1, int[] a2, int t){
		int min = t;
		int a = 0, b = 0;
		for(int i=0;i<a1.length;i++){
			for(int j=0;j<a2.length;j++){
				if(Math.abs(t-(a1[i]+a2[j])) < min){
					min = Math.abs(t-(a1[i]+a2[j]));
					a = a1[i];
					b = a2[j];
				}
			}
		}
		return new int[]{a, b};
	}
}
