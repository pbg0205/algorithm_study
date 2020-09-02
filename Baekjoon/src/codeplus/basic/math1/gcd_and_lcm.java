package codeplus.basic.math1;

import java.util.Scanner;

public class gcd_and_lcm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int prev_num = sc.nextInt();
		int after_num = sc.nextInt();
		
		int gcd = 1;
		int lcm = 1;
		
		if(prev_num < after_num) {
			int temp = prev_num;
			prev_num = after_num;
			after_num = temp;
		}
		
		//최대공배수 = 두 수의 나머지 값이 없는 경우
		for (int i = after_num ; i >= 2 ; i--) {
			if(prev_num % i == 0 && after_num % i == 0) {
				gcd = i;
				break;
			}
		}
		System.out.println(gcd);
		
		//최소 공배수 = 두 수의 곱 / 최대공약수
		lcm = prev_num * after_num / gcd;
		System.out.println(lcm);
		
		
		sc.close();
	}
}
