import java.util.*;

public class MergeSort{

    public static void main(String[] args){
        int[] a = {9, 6, 5, 0, 8, 7, 2, 3, 1};
        System.out.println(Arrays.toString(a));
        mergeSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int a[], int start, int end){
        System.out.println("start: " + start + " end: " + end);
        if(start >= end){
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid+1, end);
        merge(a, start, mid, end);
        return;
    }

    private static void merge(int a[], int start, int mid, int end){
        int[] newA = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while(i<mid+1 && j<end+1){
            if(a[i] < a[j]){
                newA[k++] = a[i++];
            }
            else if(a[j] < a[i]){
                newA[k++] = a[j++];
            }
        }

        while(i<mid+1){
            newA[k++] = a[i++];
        }

        while(j<end+1){
            newA[k++] = a[j++];
        }

        for(int m=start, n=0;m<=end;m++,n++){
            a[m] = newA[n];
        }
        return;
    }

}