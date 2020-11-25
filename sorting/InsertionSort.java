import java.util.*;

public class InsertionSort{
    public static void main(String[] args){
        int[] a = {9, 6, 5, 0, 8, 7, 2, 3, 1};
        System.out.println(Arrays.toString(a));

        int key;
        int j;
        for(int i=1;i<a.length;i++){
            key = a[i];
            j = i - 1;
            while(j>=0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1]=key;
        }

        System.out.println(Arrays.toString(a));
    }
}