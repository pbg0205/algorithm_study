package math1_practice;

import java.util.Arrays;
import java.util.Scanner;

public class hide_and_seek {
	//동생의 위치의 차이의 최대공약수를 구하는 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int younger_number = sc.nextInt();
		int older_location = sc.nextInt(); 
		sc.nextLine();
		
		int[] distance_from_older = new int[younger_number];
		for (int idx = 0; idx < younger_number; idx++) {
			long younger_location = sc.nextInt();
			distance_from_older[idx] = (int) Math.abs(younger_location - older_location);
		}
		int gcd = 0;
		if(younger_number == 1)	gcd = distance_from_older[0];
		else{
			gcd = distance_from_older[0];
			for (int idx = 0; idx < younger_number - 1; idx++) {
				gcd = getGCD2(gcd, distance_from_older[idx]);
			}
//			gcd = getGCD2(distance_from_older[(int)younger_number - 1], distance_from_older[0]);
		}
		
		System.out.println(gcd);
		
		
		sc.close();
	}
	
	public static long getGCD(long left_num, long right_num) {
		if(left_num < right_num) {
			long temp = left_num;
			left_num = right_num;
			right_num = temp;
		}
		
		while(left_num % right_num != 0) {
			long temp = right_num;
			right_num = left_num % right_num;
			left_num = temp;
		}
		
		return right_num;
	}
	
	public static int getGCD2(int x, int y) {
		if(y == 0)	return x;
		else return getGCD2(y, x % y);
	}
}

