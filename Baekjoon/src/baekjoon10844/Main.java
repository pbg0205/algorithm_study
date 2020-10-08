package baekjoon10844;
/*
 * @problem		쉬운 계단 수(10844) : https://www.acmicpc.net/problem/10844
 * @author		pbg0205
 */
import java.util.Scanner;

class Main {
	static final int div = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		long[][] stair = new long[n+1][10];
		
		for (int col = 1; col <= 9; col++)	stair[1][col] = 1;
		
		for (int row = 2; row <= n; row++) {
			for (int col = 0; col <= 9; col++) {
				if(col == 0)							stair[row][col] = stair[row-1][col+1];
				else if(col == 9)						stair[row][col] = stair[row-1][col-1];
				else									stair[row][col] = stair[row-1][col-1] + stair[row-1][col+1];
				
				stair[row][col] %= div;
			}
		}
		
		long ans = 0;
		for (int i = 0; i <= 9; i++)	ans += stair[n][i];
		System.out.println(ans % div);
		
		sc.close();
	}
}