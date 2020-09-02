package codeplus.basic.dp1;

import java.util.Scanner;

public class Dividing_Sum {
	static final long div = 1000000000;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		dp = new int[k+1][n+1];
		
		for (int i = 1; i <= n; i++)	dp[1][i] = 1;
		for (int i = 1; i <= k; i++)	dp[i][0] = 1;
		
		for (int row = 1; row <= k; row++) {
			for (int col = 1; col <= n; col++) {
				dp[row][col] = (int) ((dp[row-1][col] + dp[row][col-1]) % div);
			}
		}
		
//		for (int row = 0; row <= k; row++) {
//			for (int col = 0; col <= n; col++) {
//				System.out.print(dp[row][col] +  " ");
//			}
//			System.out.println();
//		}
//		
		System.out.println(dp[k][n]);
		
		sc.close();
	}
}
