import java.util.*;
import java.io.*;
public class Encoding{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Input string: ");
		String str = scan.nextLine();
		String encoded = encode(str);
		System.out.println(encoded);
	}

	static String encode(String str){
      char[] chars = str.toCharArray();
      StringBuilder stb = new StringBuilder();
      char currC = '0';
      int cnt = 0;
      for(int i=0;i<chars.length;i++){
          if(i == 0){
              currC = chars[i];
              cnt = 1;
              continue;
          }
          
          if(chars[i] == currC){
              cnt++;
          }
          else{
              stb.append(currC);
              stb.append(cnt);
              currC = chars[i];
              cnt = 1;
          }
      }
      stb.append(currC);
      stb.append(cnt);
      return String.valueOf(stb.toString());
	}

}