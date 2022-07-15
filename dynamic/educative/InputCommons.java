import java.util.*;

public class InputCommons {

	private static final Scanner scanner = new Scanner(System.in);
	
	private InputCommons() {}

	public static int ipIntNum() {
		return scanner.nextInt();
	}
	
	public static int[] ipIntArr(int size) {
		int[] arr = new int[size];
		int i = 0;
		while(i<size) {
			arr[i++] = ipIntNum();
		}
		return arr;
	}
	
	public static int[] ipIntArrAndSize() {
		int size = ipIntNum();
		return ipIntArr(size);
	}
	
	public static String ipStr() {
		return scanner.next();
	}

}
