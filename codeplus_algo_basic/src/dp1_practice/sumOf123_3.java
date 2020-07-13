package dp1_practice;

import java.util.Scanner;

public class sumOf123_3 {
	static long div = 1000000009;
	static long [][] dp = new long[1000001][5];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		dp[1][1] = dp[2][1] = dp[2][2] = dp[3][2] = dp[3][3] = 1;
		dp[3][1] = 2;
		
		for (int tc = 1; tc <= T; tc++) {
			int	data = Integer.parseInt(sc.nextLine());
			
			for (int row = 1; row <= data; row++) {
				if(row >= 4) {
					for (int col = 1; col <= 3; col++) {
						if(col == 1)	dp[row][col] = dp[row-1][4] % div;
						if(col == 2)	dp[row][col] = dp[row-2][4] % div;
						if(col == 3)	dp[row][col] = dp[row-3][4] % div;
					}
				}
				
				if(dp[row][4] == 0)	dp[row][4] = dp[row][1] + dp[row][2] + dp[row][3];
			}
			
			long sum = dp[data][4];
			System.out.println(sum);
		}
		
		/*
		 * 이차원 배열 확인
		 */

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 4; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		
		sc.close();
	}
}
//시간 초과 : 중복 연산으로 인한 시간 초과로 예상