package baekjoon15998;
/*
 * @problem		1, 2, 3더하기3(15988) : https://www.acmicpc.net/problem/15988
 * @author		pbg0205
 */
import java.util.Scanner;

public class Main {
	static long div = 1000000009;
	static long [] dp = new long[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int tc = 1; tc <= T; tc++) {
			int	data = Integer.parseInt(sc.nextLine());
			
			for (int row = 4; row <= data; row++) {
				dp[row] = (dp[row-1] + dp[row-2] + dp[row-3]) % div;
			}
			
			long sum = dp[data];
			System.out.println(sum);
		}

		sc.close();
	}
}
