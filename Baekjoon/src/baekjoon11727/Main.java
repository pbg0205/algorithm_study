package baekjoon11727;
/*
 * @problem		2xN타일링2(11727) : https://www.acmicpc.net/problem/11727
 * @author		pbg0205
 */
import java.util.Scanner;

public class Main {
	static int[] d = new int[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		
		System.out.println(dp(n));
		
		sc.close();
	}
	

	public static int dp(int n) {
		if(n == 1)	return d[1] = 1;
		if(n == 2)	return d[2] = 3;
		if(d[n] != 0) {
			return d[n];
		}else {
			return d[n] = (2 * dp(n - 2) + dp(n - 1)) % 10007;	
		}
	}
}
