package codeplus.middle1.divide_and_conquer_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerOfHanoi {
	
	static int count = 1;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		move(n, 1, 3);
		
		System.out.println(count);
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static void move(int no, int x, int y) { 
		if(no > 1) {
			count++;
			move(no-1, x, 6 - x - y);
		}
		
		sb.append(x + " " + y + "\n");
		
		if(no > 1) {
			count++;
			move(no-1, 6 - x - y, y);
		}
	}
}
