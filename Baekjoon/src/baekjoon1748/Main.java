package baekjoon1748;
/*
 * @problem		수 이어 쓰기1(1748) : https://www.acmicpc.net/problem/1748
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int cnt = 1;
		int len = 10;
		for (int i = 1; i <= n; i++) {
			if(i == len) {
				cnt++;
				len = len * 10;
			}
			sum += cnt;
		}
		
		System.out.println(sum);
	}
}
