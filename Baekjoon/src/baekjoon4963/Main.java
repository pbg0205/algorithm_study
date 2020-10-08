package baekjoon4963;
/*
 * @problem		섬의 개수(4963) : https://www.acmicpc.net/problem/4963
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int island_cnt;
	static int col, row;
	static int map[][];
	static boolean visited[][];

	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());

			island_cnt = 0;
			map = new int[row + 1][col + 1];
			visited = new boolean[row + 1][col + 1];

			for (int x = 1; x <= row; x++) {
				st = new StringTokenizer(br.readLine());
				for (int y = 1; y <= col; y++) {
					map[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int x = 1; x <= row; x++) {
				for (int y = 1; y <= col; y++) {
					if (map[x][y] == 1 && !visited[x][y]) {
						bfs(x, y);
						island_cnt++;
					}
				}
			}
			
			if(col != 0 || row != 0)
				System.out.println(island_cnt);
			
		} while (col != 0 || row != 0);

		
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
			
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isBoudary(nx, ny)) {
					if(!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						qx.add(nx);
						qy.add(ny);
					}
				}
			}
		}
	}

	public static boolean isBoudary(int x, int y) {
		return 1 <= x && x <= row && 1 <= y && y <= col;
	}
}
