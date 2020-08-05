package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class maze_search {

	static int n, m;
	static int moving_cnt;

	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1,  0,-1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		moving_cnt = 0;

		for (int row = 1; row <= n; row++) {
			String line = br.readLine();
			for (int col = 1; col <= m; col++) {
				map[row][col] = Integer.parseInt(line.substring(col - 1, col));
			}
		}
		
		bfs(1, 1);
	}

	//고등학교(최소 길찾기 문제) 개념으로 생각하기
	public static void bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		
		visited[x][y] = true;
		
		qx.add(x);
		qy.add(y);

		while (!qx.isEmpty()) {
			x = qx.poll();
			y = qy.poll();

			if (x == n && y == m) {
				return ;
			}
			
			for (int idx = 0; idx < 4; idx++) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				
				if (isBoundary(nx, ny)) {
					if (!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						qx.add(nx);
						qy.add(ny);
						
						map[nx][ny] = map[x][y] + 1;
					}
				}
			}
		}
	}
	
	private static boolean isBoundary(int x, int y) {
		return 1 <= x && x <= n && 1 <= y && y <= m;
	}
}
