public class RemAllInstanceOfKey{
	public static void main(String[] args){
		int[] arr = {3, 2, 3, 6, 3, 10, 9, 3};
		int l = removeKeys(arr, 3);
		printArrTill(arr, l);
		
		arr = new int[]{2, 11, 2, 2, 1};
		l = removeKeys(arr, 2);
		printArrTill(arr, l);
	}
	
	private static int removeKeys(int[] arr, int key){
		int i=0;
		for(int j=0;j<arr.length;j++){
			if(arr[j]!=key){
				arr[i++] = arr[j];
			}
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
