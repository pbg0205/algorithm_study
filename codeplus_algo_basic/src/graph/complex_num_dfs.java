package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class complex_num_dfs {
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int[][] map;
	static boolean[][] visited;
	
	static int n, count;
	static LinkedList<Integer> scale = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		for (int x = 1; x <= n; x++) {
			String line = br.readLine();
			for (int y = 1; y <= n; y++) {
				map[x][y] = Integer.parseInt(line.substring(y-1, y));
			}
		}
		
		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= n; y++) {
				if(map[x][y] == 1 && !visited[x][y]) {
					count = 1;
					visited[x][y] = true;
					dfs(x, y);
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
	
	public static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isBoundary(nx, ny)) {
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					count++;
					dfs(nx, ny);
				}
			}
		}
	}
	
	public static boolean isBoundary(int x, int y) {
		return x >= 1 && y >= 1 && x <= n && y <= n;  
	}
}
