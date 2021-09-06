import java.util.*;

public class DontGetDistracted {

	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0) {
			int n = scan.nextInt();
			char[] chars = scan.next().toCharArray();
			String res = isDistracted(chars);
			System.out.println(res);
		}
	}
	
	private static String isDistracted(char[] chars) {
		int[] done = new int[26];
		int i=0;
		while(i<chars.length) {
			char curr = chars[i];
			if(done[curr - 'A'] == 1) {
				return "NO";
			}
			do {
				i++;
			}
			while(i<chars.length && chars[i] == curr);
			done[chars[i-1] - 'A'] = 1;
		}
		return "YES";		
	}
	
}
