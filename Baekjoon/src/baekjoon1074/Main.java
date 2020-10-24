package baekjoon1074;
/*
 * @problem		Z(1074)
 * @url			https://www.acmicpc.net/problem/1074
 * @author		pbg0205
 */


import java.io.*;
import java.util.*;


class Main {
	
	static int[][] map;
	static int r, c;
	
	static int[] dy = {0, 0, 1, 1};
	static int[] dx = {0, 1, 0, 1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, n);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		divide(0, 0, 0, size);
		
	}
	
	private static void divide(int y, int x, int cnt, int size) {
		if( y + size <= r || y > r
				|| x + size <= c || x > c )	return ;
		
		if(size == 2) {
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + y;
				int nx = dx[i] + x;
				
				if(ny == r && nx == c)
					System.out.println(cnt + i);
			}
			return ;
		}
		
		int newSize = size / 2;
		
		divide(y, x, cnt, newSize);
		divide(y, x + newSize, cnt + (newSize * newSize), newSize);
		divide(y + newSize, x, cnt + (newSize * newSize * 2), newSize);
		divide(y + newSize, x + newSize, cnt + (newSize * newSize * 3), newSize);
	}
}
