import java.util.*;

public class OrdinaryNumbers {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0) {
			long n = scan.nextLong();
			System.out.println(numOfOrdinaryNum(n));
		}
	}
	
	private static int numOfOrdinaryNum(long n) {
		int cnt = 0;
		int digits = numOfDigits(n);
		cnt += 9*(digits-1);
		int first = firstDigit(n);
		long bound = getOrdinaryNumGrtOrEqual(digits, first);
		if(n >= bound) {
			cnt+=first;
		}
		else {
			cnt+=(first-1);
		}
		return cnt;
		
	}
	
	private static long getOrdinaryNumGrtOrEqual(int digits, int first) {
		StringBuilder sb = new StringBuilder();
		while(digits-->0) {
			sb.append(first);
		}
		return Long.valueOf(sb.toString());
	}
	
	private static int numOfDigits(long n) {
		int i=0;
		while(n>0) {
			i++;
			n/=10;
		}
		return i;
	}
	
	private static int firstDigit(long n) {
		int i=0;
		while(n>0) {
			i = (int)n%10;
			n/=10;
		}
		return i;
	}
	
}
