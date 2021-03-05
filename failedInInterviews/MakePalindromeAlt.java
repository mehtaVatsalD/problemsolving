public class MakePalindromeAlt{
	public static void main(String[] args){
		System.out.println(getStepsReq(args[0]));
	}
	
	private static int getStepsReq(String str){
		char[] chars = str.toCharArray();
		int i = 0;
		int j = chars.length - 1;
		int cnt = 0;
		while(i<j){
			if(chars[i] == chars[j]){
				 i++;
				 j--;
				 continue;
			}
			
			int totalCntTaken = swapTillFound(chars, i, j);
			if(totalCntTaken != -1){
				 i++;
				 j--;
				 cnt+=totalCntTaken;
				 continue;
			}
			swap(chars, i, j);
			totalCntTaken = swapTillFound(chars, i, j);
			if(totalCntTaken != -1){
				 i++;
				 j--;
				 cnt+=totalCntTaken;
				 continue;
			}
			
			return -1;
		}
		return cnt;
	}
	
	private static void swap(char[] chars, int i, int j){
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
	
	private static int swapTillFound(char[] chars, int i, int j){
		int k;
		for(k = i+1;k<j;k++){
			if(chars[k] == chars[j]){
				break;
			}
		}
		
		if(k == j){
			return -1;
		}
		
		char val = chars[k];
		int cnt = k - i;
		for(;k>i;k--){
			chars[k] = chars[k-1];
		}
		return cnt;
	}
}
