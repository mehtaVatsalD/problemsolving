public class RemoveDuplicatesSorted{
	public static void main(String[] args){
			int[] arr = {2, 3, 3, 3, 6, 9, 9};
			int l = removeDuplicatesInSortedArray(arr);
			printArrTill(arr, l);
			
			arr = new int[]{2, 2, 2, 11};
			l = removeDuplicatesInSortedArray(arr);
			printArrTill(arr, l);
	}
	
	private static int removeDuplicatesInSortedArray(int[] arr){
		int i = 1;
		for(int j=1;j<arr.length;j++){
			if(arr[j] == arr[j-1]){
				continue;
			}
			
			arr[i++] = arr[j];
		}
		return i;
	}
	
	private static void printArrTill(int[] arr, int l){
		for(int i=0;i<l;i++){
			System.out.print(arr[i]  + " ");
		}
		System.out.println();
	}
}
