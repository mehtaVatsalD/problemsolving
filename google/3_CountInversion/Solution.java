import java.util.*;

public class Solution {

	public static void main(String...args) {
		inversionCount(new long[]{4, 5, 2, 3, 2, 6}, 6);
	}


	static long inversionCount(long arr[], int n) {
		int[] sortedArr = new int[n];
		long[] invCounts = new long[n];
		inversionCount(arr, sortedArr, invCounts, 0, n-1);
		System.out.println(Arrays.toString(invCounts));
		return Arrays.stream(invCounts).map(num -> num).reduce(Long::sum).orElse(0L);
    }
    
    private static void inversionCount(long[] arr, int[] sa, long[] ic, int start, int end) {
    	if (start > end) {
    		return;
    	}
    	else if(start == end) {
    		sa[start] = start;
    		return;
    	}
    	
    	int mid = (start + end)/2;
    	inversionCount(arr, sa, ic, start, mid);
    	inversionCount(arr, sa, ic, mid+1, end);
    	merge(arr, sa, ic, start, end, mid);
    }
    
    private static void merge(long[] arr, int[] sa, long[] ic, int start, int end, int mid) {
    	int i=start;
    	int j=mid+1;
    	int k=0;
    	int[] A = new int[end-start+1];
    	long[] newIc = new long[mid-start+2];
    	    	    	   	 	
    	
    	while(i<=mid && j<=end) {
    		if( arr[sa[i]] > arr[sa[j]] ) {
    			newIc[i-start] += 1;
    			newIc[mid+1-start] -= 1;	
    			A[k++] = sa[j++];
    			continue;
    		}
    		A[k++] = sa[i++];
    	}
    	
    	while(i<=mid) {
    		A[k++] = sa[i++];
    	}
    	
    	while(j<=end) {
    		A[k++] = sa[j++];

    	}

    	
    	int sum = 0;
    	for (i=0; i<newIc.length-1; i++) {
    		sum += newIc[i];
    		ic[sa[start + i]] += sum;
    	}
    	
    	
    	for (i=0; i<A.length; i++) {
    		sa[start+i] = A[i];
    	}
    
    	
    	
    	
    }

}
