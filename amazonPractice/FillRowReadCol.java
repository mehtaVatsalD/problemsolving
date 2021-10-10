import java.lang.*;
import java.util.*;

public class FillRowReadCol{
	
	public static void main(String[] args){
		
		String s = "abcdefg";
		int r = 3;
		doYourTask(s, r);
		
	}
	
	private static void doYourTask(String s, int r){
		int cols;
		if(s.length()%r == 0){
			cols = (int)(s.length() / r);
		}
		else{
			cols = (int)(s.length() / r) + 1;
		}
		char[][] ca = new char[r][cols];
		char[] sc = s.toCharArray();
		int ri = 0, ci = 0;
		for (char c : sc) {
			ca[ri][ci] = c;
			ri++;
			if (ri == r) {
				ri = 0;
				ci++;
			}
		}
		
		for(ri=0;ri<r;ri++){
			for(ci=0;ci<cols;ci++){
				if(ca[ri][ci] != '\u0000'){
					System.out.print(ca[ri][ci]);
				}
			}
		}
	}
	
}