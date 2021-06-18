import java.util.*;

public class SameStrBackSpace {
	
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();
		boolean areSame = sameAfterApplyingBackSpace(s1, s2);
		System.out.println(areSame);
	}
	
	private static boolean sameAfterApplyingBackSpace(String s1, String s2) {
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		int newl1 = processString(chars1);
		int newl2 = processString(chars2);
		
		if(newl1 != newl2) {
			return false;
		}
		
		for(int i=0; i<newl1; i++) {
			if(chars1[i] != chars2[i]) {
				return false;
			}
			System.out.print(chars1[i]);
		}
		System.out.println();
		return true;			
		
	}
	
	private static int processString(char[] chars) {
		int n = chars.length;
		int i=0;
		for(int j=0; j<n; j++) {
			int cnt = 0;
			while(j<n && chars[j] == '#') {
				j++;
				cnt++;
			}
			i -= cnt;
			if(i<0) {
				i=0;
			}
			if(j<n) {
				chars[i++] = chars[j];
			}
					
		}
		return i;
	}
	
}
