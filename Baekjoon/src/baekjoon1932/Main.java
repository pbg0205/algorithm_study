package baekjoon1932;
/*
 * @problem		정수 삼각형(1932) : https://www.acmicpc.net/problem/1932
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		arr = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		
		for (int row = 1; row <= n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int col = 1; col <= row; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = arr[1][1];
		if(n > 1) {
			for (int row = 2; row <= n; row++) {
				for (int col = 1; col <= row; col++) {
					dp[row][col] = Math.max(dp[row-1][col-1], dp[row-1][col]) + arr[row][col];
				}
			}
		}
		
		for (int col = 1; col <= n; col++) {
			if(max < dp[n][col])	max = dp[n][col];
		}
		
		System.out.println(max);
		
		br.close();
	}
}
