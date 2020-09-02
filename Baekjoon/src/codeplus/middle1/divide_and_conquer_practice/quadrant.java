package codeplus.middle1.divide_and_conquer_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class quadrant {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int d, n;
	static long x_now = 0, y_now = 0;
	static long x_move, y_move;
	
	static String quad_str;
	
	static int[] dx = {0, 0, 1, 1};
	static int[] dy = {1, 0, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		quad_str = st.nextToken();
		n = quad_str.length();
		
		st = new StringTokenizer(br.readLine());
		x_move = Long.parseLong(st.nextToken());
		y_move = Long.parseLong(st.nextToken());
		
		findNow(0, 0, n - 1);//현재 위치의 좌표를 찾는다.
		move(x_move, y_move);//이동
		if(isBoundary(x_now, y_now)) {
			findNumber(x_now, y_now, n - 1, 0);
		}else {
			bw.write("-1");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	private static boolean isBoundary(long x, long y) {
		return (0 <= x && x < Math.pow(2, n)) && (0 <= y && y < Math.pow(2, n));
	}
	
	private static void findNow(long x, long y, int cnt) {
		
		for (int i = 0; i < quad_str.length(); i++) {
			int now_location = quad_str.charAt(i) - '0';
			if(now_location == 1) {
				x += dx[0] * Math.pow(2, cnt);
				y += dy[0] * Math.pow(2, cnt);
			}
			if(now_location == 2) {
				x += dx[1] * Math.pow(2, cnt);
				y += dy[1] * Math.pow(2, cnt);
			}
			if(now_location == 3) {
				x += dx[2] * Math.pow(2, cnt);
				y += dy[2] * Math.pow(2, cnt);
				
			}
			if(now_location == 4) {
				x += dx[3] * Math.pow(2, cnt);
				y += dy[3] * Math.pow(2, cnt);
			}
			cnt--;
		}
		
		x_now = x;
		y_now = y;
	}

	private static void move(long x_move, long y_move) {
		x_now -= y_move;
		y_now += x_move;
	}
	
	private static void findNumber(long x, long y, int size, int cnt) throws IOException {
		if(cnt == n) {
			return;
		}
		
		long divide = (long)Math.pow(2, size);
		
		long tmp_x = x / divide;
		long tmp_y = y / divide;
		
		x %= divide;
		y %= divide;
		
		if(tmp_x == 1 && tmp_y == 0)	bw.write("1");
		if(tmp_x == 0 && tmp_y == 0)	bw.write("2");
		if(tmp_x == 0 && tmp_y == 1)	bw.write("3");
		if(tmp_x == 1 && tmp_y == 1)	bw.write("4");
		
		size--;
		cnt++;
		
		findNumber(x, y, size, cnt);
	}
}
