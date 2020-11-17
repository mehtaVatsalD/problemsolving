import java.util.*;
import java.io.*;
public class Decoding{

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Input string: ");
    String str = scan.nextLine();
    String encoded = decode(str);
    System.out.println(encoded);
  }

  static String decode(String str){
      char[] chars = str.toCharArray();
      StringBuilder stb = new StringBuilder();
      char currC = '0';
      int cnt = 0;
      StringBuilder cntBuilder = new StringBuilder();
      for(int i=0;i<chars.length;i++){
          currC = chars[i];
          while(i+1<chars.length && chars[i+1]>='0' && chars[i+1]<='9'){
            i++;
            cntBuilder.append(chars[i]);
          }
          if(cntBuilder.toString().isEmpty()){
            return "Error no number for char!";
          }
          
          cnt = Integer.valueOf(cntBuilder.toString());
          cntBuilder.setLength(0);
          for(int j=0;j<cnt;j++){
            stb.append(currC);
          }

      }
      return String.valueOf(stb.toString());
  }

}