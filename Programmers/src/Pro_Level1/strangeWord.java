package Pro_Level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class strangeWord {
	public String solution(String s) {
		String answer = "";
		String[] strArr = s.split(" ",-1);
		
		for(int j = 0; j < strArr.length; j++) {
			char[] charArr =strArr[j].toCharArray();
		    
			for (int i = 0; i < charArr.length; i++) {
		  	  if(i % 2 == 0) {
		  		  if(charArr[i] >= 97 && charArr[i] <= 122)	charArr[i] -= 32;//소문자 >> 대문자
		  	  }else if(i % 2 == 1){
		  		  if(charArr[i] >= 65 && charArr[i] <= 90)	charArr[i] += 32;//대문자 >> 소문자
		  	  }
		  	}
			answer += String.copyValueOf(charArr);
			if(j < strArr.length -1) answer += " ";	 
		}
		
	      return answer;
	  }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test = br.readLine();
		
		strangeWord sol = new strangeWord();
		System.out.println(sol.solution(test));
	}
}
