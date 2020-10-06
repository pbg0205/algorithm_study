package baekjoon2193;
/*
 * @problem		이친수(2193) : https://www.acmicpc.net/problem/2193
 * @author		pbg0205
 */
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		long[][] count = new long[n+1][2];
		long ans = 0;
		
		count[1][0] = 0;
		count[1][1] = 1;
		
		for (int row = 2; row <= n; row++) {
			count[row][0] = count[row-1][0] + count[row-1][1];
			count[row][1] = count[row-1][0];
		}
		
		ans = count[n][0] + count[n][1];
		System.out.println(ans);
		
		sc.close();
	}
}
