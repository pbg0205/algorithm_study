package baekjoon6064;
/*
 * @problem		카잉달력(6064) : https://www.acmicpc.net/problem/6064
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int M, N, x, y;
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			int cnt = x % (M + 1);
			int y_temp = x;
			
			for (int idx = 0; idx < N; idx++) {
				int temp = y_temp % N == 0 ? N : y_temp % N;
				if(temp == y) {
					break;
				}
				
				y_temp = temp + M;
				cnt += M;
			}
			System.out.println(cnt > lcm(M, N) ? "-1" : cnt);
		}
	}

	public static int gcd(int a, int b) {
	    while (b != 0) {
	        int r = a % b;
	        a = b;
	        b = r;
	    }
	    return a;
	}
	 
	public static int lcm(int a, int b) {
	    return a * b / gcd(a, b);
	}
}
