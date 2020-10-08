package baekjoon9465;
/*
 * @problem		스티커(9465) : https://www.acmicpc.net/problem/9465
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[][] data;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			data = new int[3][n+1];
			dp = new int[3][n+1];
			
			for (int row = 1; row <= 2; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int col = 1; col <= n; col++) {
					data[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[1][1] = data[1][1];
			dp[2][1] = data[2][1];
			
			for (int k = 2; k <= n; k++) {
				dp[1][k] = Math.max(dp[2][k-1], dp[2][k-2]) + data[1][k];
				dp[2][k] = Math.max(dp[1][k-1], dp[1][k-2]) + data[2][k];
			}
			
			System.out.println(Math.max(dp[1][n], dp[2][n]));
		}
	}
}
