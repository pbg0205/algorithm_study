package baekjoon7576;
/*
 * @problem		토마토(7576) : https://www.acmicpc.net/problem/7576
 * @author		pbg0205
 */
import java.io.*;
import java.util.*;

public class Main {

	static int m, n;
	static int[][] map;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];

		for (int row = 1; row <= n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 1; col <= m; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(); 
		
		br.close();
	}

	private static void bfs() {
		Queue<rippedTomato> queue = new LinkedList<>();
		int day = 0;

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= m; col++) {
				if (map[row][col] == 1) {
					queue.offer(new rippedTomato(row, col, 0));
				}
			}
		}

		while (!queue.isEmpty()) {
			rippedTomato rt = queue.poll();
			day = rt.day;

			for (int idx = 0; idx < 4; idx++) {
				int nx = rt.x + dx[idx];
				int ny = rt.y + dy[idx];

				if (isBoundary(nx, ny)) {
					if(map[nx][ny] == 0) {
						map[nx][ny] = 1;
						queue.add(new rippedTomato(nx, ny, day + 1));
					}
				}

			}
		}
		
		if(isAllRipped())	System.out.println(day);
		else				System.out.println(-1);
	}

	private static boolean isAllRipped() {
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= m; col++) {
				if(map[row][col] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isBoundary(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= m;
	}

}

class rippedTomato {
	int x;
	int y;
	int day;

	rippedTomato(int x, int y, int days) {
		this.x = x;
		this.y = y;
		this.day = days;
	}
}
