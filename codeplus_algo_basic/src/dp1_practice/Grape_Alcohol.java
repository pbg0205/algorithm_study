package dp1_practice;

import java.util.Scanner;

public class Grape_Alcohol {
	static int[] arr;
	static int[] dp;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		arr = new int[n+1];
		dp = new int[n+1];
		
		for (int i = 1; i <= n; i++)	arr[i] = Integer.parseInt(sc.nextLine());	
		
		dp[1] = arr[1];
		if(n > 1) {
			dp[2] = arr[1] + arr[2];
			for (int i = 3; i <= n; i++)
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}