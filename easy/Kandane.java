import java.util.*;
import java.io.*;

public class Kandane{

	static class StartEnd{
		int startIndex;
		int endIndex;
		int sum;

		StartEnd(int startIndex, int endIndex, int sum){
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.sum = sum;
		}
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = Integer.valueOf(scan.nextLine());
		int[] a = new int[n];
		String[] inputArr = scan.nextLine().split(" ");
		for(int i=0;i<n;i++){
			a[i] = Integer.valueOf(inputArr[i]);
		}

		int maxSum = kandaneSum(a, a.length);
		Kandane.StartEnd startEnd = kandaneSumWithIndex(a, a.length);
		System.out.println("Max Sum Contg. : " + maxSum);

		System.out.println("Max Sum Contg2" + startEnd.sum);
		System.out.println("Max Sum start. : " + startEnd.startIndex);
		System.out.println("Max Sum end. : " + startEnd.endIndex);


	}

	private static int kandaneSum(int arr[], int n){
		int maxFull = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(maxFull < sum){
                maxFull = sum;
            }
            
            sum = sum < 0 ? 0 : sum;
        }
        return maxFull;
	}

	private static Kandane.StartEnd kandaneSumWithIndex(int arr[], int n){
		int maxFull = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int startedFrom = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(maxFull < sum){
                maxFull = sum;
                start = startedFrom;
                end = i;
            }
            
            if(sum < 0){
            	sum = 0;
            	startedFrom = i+1;
            }
            
        }
        return new Kandane.StartEnd(start, end, maxFull);
	}

}