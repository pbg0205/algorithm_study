package dp1_practice;

import java.util.Scanner;

public class inclining_num {
	
	static final int div = 10007;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		dp = new int[n+1][10];
		int sum = 0;
		
		for (int i = 0; i <= 9; i++)	dp[1][i] = 1;
		
		for (int row = 2; row <= n; row++) {
			for (int col = 0; col <= 9; col++) {
				for (int move = col; move <= 9; move++) {
					dp[row][col] += dp[row-1][move] % div;
				}
			}
		}
		
		for (int i = 0; i <= 9 ; i++) sum += dp[n][i] % div;
		
		System.out.println(sum % div);
		
		sc.close();
	}
}
