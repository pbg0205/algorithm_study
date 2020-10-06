package Main;
/*
 * @problem		가장 긴 증가하는 부분 수열(11053) : https://www.acmicpc.net/problem/11053
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)	num[i] = Integer.parseInt(st.nextToken());	
		Arrays.fill(dp, 1);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(num[i] > num[j] && dp[i] <= dp[j])	dp[i] = dp[j] + 1;
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++)	
			if(max < dp[i])	max = dp[i];
		
		System.out.println(max);
	}
}
