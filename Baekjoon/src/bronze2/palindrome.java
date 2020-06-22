package bronze2;

import java.util.*;

public class palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= test_case; i++) {
			long num = sc.nextLong();
			long digit = sc.nextInt();
			boolean is_palindrome = true;
			sc.nextLine();
			
			String digitCode = "";
			while(num > 0) {
				digitCode = (num % digit) + digitCode;
				num /= digit;				
			}
			
			//System.out.println(digitCode);
			for (int j = 0; j < digitCode.length() / 2; j++) {
				char compare_l = digitCode.charAt(j);
				char compare_r = digitCode.charAt(digitCode.length() - (j+1));
				
				if(compare_l != compare_r) {
					is_palindrome = false;
					break;
				}
			}
			
			if(is_palindrome)	System.out.println(1);
			else 				System.out.println(0);
		}
		
		sc.close();
	}
}
