package baekjoon2667;
/*
 * @problem		단지번호붙이기(2667) : https://www.acmicpc.net/problem/2667
 * @author		pbg0205
 */
import java.io.*;
import java.util.*;

class Main_bfs {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int[][] map;
	static boolean[][] visited;

	static int n, count;
	static LinkedList<Integer> scale = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		for (int x = 1; x <= n; x++) {
			String line = br.readLine();
			for (int y = 1; y <= n; y++) {
				map[x][y] = Integer.parseInt(line.substring(y - 1, y));
			}
		}

		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= n; y++) {
				if (map[x][y] == 1 && !visited[x][y]) {
					count = 1;
					visited[x][y] = true;
					bfs(x, y);
					scale.add(count);
				}
			}
		}

		Collections.sort(scale);
		System.out.println(scale.size());
		for (int scaleNum : scale)
			System.out.println(scaleNum);

		br.close();
	}

	public static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.add(x);
		qy.add(y);

		visited[x][y] = true;
		
		while (!qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isBoundary(nx, ny)) {
					if (!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						count++;
						qx.add(nx);
						qy.add(ny);
					}
				}
			}
		}
	}

	public static boolean isBoundary(int x, int y) {
		return x >= 1 && y >= 1 && x <= n && y <= n;
	}
}
