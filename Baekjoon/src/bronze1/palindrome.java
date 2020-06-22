package bronze1;

import java.util.Scanner;

public class palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		for (int left_idx = 0; left_idx < str.length() / 2; left_idx++) {
			int right_idx = str.length() - 1 - left_idx;
			if(str.charAt(left_idx) == str.charAt(right_idx))	continue;
			else{
				System.out.println(0);
				System.exit(0);
				}
		}
		System.out.println(1);
		
		sc.close();
	}
}
