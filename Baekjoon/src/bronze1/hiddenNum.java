package bronze1;

import java.util.*;

public class hiddenNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int str_len = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		long answer = 0;
		
		int digit = 0;
		
		for(int i = str_len - 1 ; i >= 0 ; i--) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				answer += (str.charAt(i) - '0') * Math.pow(10, digit);
				digit++;
			}else {
				digit = 0;
			}
		}
		
		System.out.println(answer);
	}
	// 자릿수 6자리 이상 -> long type을 사용해야 한다.(이것 떄문에 시간 오래걸림)
}
