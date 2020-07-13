package dp1;

import java.util.Scanner;

public class n_2_tiling {
	
	static int[] d = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(dp(n));
		
		sc.close();
	}
	
	public static int dp(int n) {
		if(n == 1)	return 1;
		if(n == 2)	return 2;
		if(d[n] > 0) {
			return d[n];	
		}else {
			return d[n] = (dp(n-1) + dp(n-2)) % 10007;	
		}
	}
}
