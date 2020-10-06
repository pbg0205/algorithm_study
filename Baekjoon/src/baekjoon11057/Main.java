package baekjoon11057;
/*
 * @problem		오르막 수(11057) : https://www.acmicpc.net/problem/11057
 * @author		pbg0205
 */
import java.util.Scanner;

public class Main {
	
	static final int div = 10007;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		dp = new int[n+1][10];
		int sum = 0;
		
		for (int i = 0; i <= 9; i++)	dp[1][i] = 1;
		
		for (int row = 2; row <= n; row++) {
			for (int col = 9; col >= 0; col--) {
				if(col == 9)	dp[row][col] = 1;
				if(col <= 8)	dp[row][col] = (dp[row-1][col] + dp[row][col+1]) % div;
			}
		}
		
		for (int i = 0; i <= 9 ; i++) sum += dp[n][i] % div;
		
		System.out.println(sum % div);
		
		sc.close();
	}
}
