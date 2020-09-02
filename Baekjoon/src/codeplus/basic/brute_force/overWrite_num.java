package codeplus.basic.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class overWrite_num {
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
