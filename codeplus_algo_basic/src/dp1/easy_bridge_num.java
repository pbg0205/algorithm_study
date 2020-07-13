package dp1;

import java.util.Scanner;

public class easy_bridge_num {
	static final int mod = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		long[][] stair = new long[n+1][10];
		
		for (int i = 1; i <= 9; i++)	stair[1][i] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if(j == 0)			stair[i][j] = stair[i-1][j+1];
				else if(j == 9)		stair[i][j] = stair[i-1][j-1];
				else				stair[i][j] = stair[i-1][j-1] + stair[i-1][j+1];
				
				stair[i][j] %= mod;
			}
		}
		
		long ans = 0;
		for (int i = 0; i <= 9; i++)	ans += stair[n][i];
		System.out.println(ans % mod);
		
		sc.close();
	}
}
