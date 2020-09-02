package codeplus.basic.math1_ref;

import java.util.Scanner;

//문제 : 진법 변환(2745)
public class base_transformation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int base = sc.nextInt();
		int idx = input.length() - 1;
		int digit = 0;
		int output = 0;
		char[] mod = {'0','1','2','3','4','5','6','7','8','9',
				  'A','B','C','D','E','F','G','H','I',
				  'J','K','L','M','N','O','P','Q','R',
				  'S','T','U','V','W','X','Y','Z'};

		while(idx >= 0) {
			for (int i = 0; i < mod.length; i++) {
				if(mod[i] == input.charAt(idx)) {
					output += i * Math.pow(base, digit++);
				}
			}
			idx--;
		}
		
		System.out.println(output);
		
		sc.close();
	}
}
