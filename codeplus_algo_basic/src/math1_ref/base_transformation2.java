package math1_ref;

import java.util.Scanner;
//문제 : 진법 변환2(11005)
public class base_transformation2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int base = sc.nextInt();
		char[] mod = {'0','1','2','3','4','5','6','7','8','9',
						  'A','B','C','D','E','F','G','H','I',
						  'J','K','L','M','N','O','P','Q','R',
						  'S','T','U','V','W','X','Y','Z'};
		
		String answer = "";
		while(input > 0) {
			answer = mod[input % base] + answer;
			input /= base;
		}
		
		System.out.println(answer);
		sc.close();
	}
}
