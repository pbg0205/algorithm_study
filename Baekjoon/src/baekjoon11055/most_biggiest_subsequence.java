package baekjoon11055;
/*
 * @problem		가장 큰 증가 부분 수열(11055) : https://www.acmicpc.net/problem/11055
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	static int [] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int max = 0;
		arr = new int[n+1];
		dp = new int[n+1];
		
		for (int idx = 1; idx <= n; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		for (int right = 1; right <= n; right++) {
			dp[right] = arr[right];
			for (int left = 1; left < right; left++) {
				if(arr[left] < arr[right] && dp[right] < dp[left] + arr[right])	
					dp[right] = dp[left] + arr[right];
			}
		}
		
		for (int idx = 1; idx <= n; idx++)
			if(max < dp[idx])	max = dp[idx];
		
		System.out.println(max);
		
		br.close(); 
	}
}
