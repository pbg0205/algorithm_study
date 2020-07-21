package dp1_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class long_decreasing_sequence {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++)	arr[i] = Integer.parseInt(st.nextToken());
		Arrays.fill(dp, 1);
		
		for (int right_idx = 1; right_idx < n; right_idx++) {
			for (int left_idx = 0; left_idx < right_idx; left_idx++) {
				if(arr[right_idx] < arr[left_idx] && dp[right_idx] <= dp[left_idx]) {
					dp[right_idx] = dp[left_idx] + 1;
				}else if(arr[right_idx] == arr[left_idx]) {
					dp[right_idx] = dp[left_idx];
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++)	if(dp[i] > max)	max = dp[i];
		
		System.out.println(max);
		
		br.close();
	}
}
