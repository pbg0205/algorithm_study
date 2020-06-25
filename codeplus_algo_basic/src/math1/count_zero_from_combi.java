package math1;

import java.util.Scanner;

public class count_zero_from_combi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long r = sc.nextLong();
		
		long five_count = 0;
		long two_count = 0;
		
		five_count = fiveCount(n);
		five_count -= fiveCount(n-r);
		five_count -= fiveCount(r);
		
		two_count = twoCount(n);
		two_count -= twoCount(n-r);
		two_count -= twoCount(r);
		
		System.out.println(five_count >= two_count ? two_count : five_count);
		
		sc.close();
	}
	
	public static long fiveCount(long n) {
		long cnt = 0;
		for(long i = 5; i <= n; i *= 5) cnt += n / i;
		
		return cnt;
	}
	
	public static long twoCount(long n) {
		long cnt = 0;
		for(long i = 2; i <= n; i *= 2) cnt += n / i;
		
		return cnt;
	}	
}
