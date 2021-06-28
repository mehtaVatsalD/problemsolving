import java.util.Scanner;

public class HappyNumber {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		boolean isIt = isHappyNumber(val);
		System.out.println(isIt);
	}
	
	private static boolean isHappyNumber(int val) {
		int fast= val;
		int slow = val;
		while(fast != 1) {
			slow = moveFwd(slow);
			fast = moveFwd(moveFwd(fast));
			if(fast!= 1 && fast == slow) {
				return false;
			}
		}
		return true;
	}
	
	public static int moveFwd(int val) {
		int sum = 0;
		while(val > 0) {
			int digit = val%10;
			sum+=(digit*digit);
			val/=10;
		}
		return sum;
	}
	
}
