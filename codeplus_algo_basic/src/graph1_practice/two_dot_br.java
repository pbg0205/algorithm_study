package graph1_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class two_dot_br {
	
	static int n,m;
	
	static char[][] data;
	static boolean[][] visited;
	
	static int[] dx = {1,-1, 0, 0};
	static int[] dy = {0, 0, 1,-1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		data = new char[n][m];
		visited = new boolean[n][m];
		
		for (int row = 0; row < n; row++) {
			String str_temp = br.readLine();
			for (int col = 0; col < m; col++) {
				data[row][col] = str_temp.charAt(col);
			}
		}
		
		boolean isCandidate = false;
		
		loop:
		for (int x = 0; x < n; ++x) {
			for (int y = 0; y < m; ++y) {
				if(!visited[x][y]) {
					isCandidate = dfs(x, y, -1, -1, data[x][y]);
					if(isCandidate)	break loop;
				}
			}
		}
		
		if(isCandidate) System.out.println("Yes");
		else			System.out.println("No");
		
		
		br.close();
	}


	private static boolean dfs(int x, int y, int bx, int by, char color) {
		if(visited[x][y])	return true;
		
		visited[x][y] = true;
		
		for (int idx = 0; idx < 4; idx++) {
			int nx = x + dx[idx];
			int ny = y + dy[idx];
			
			if(!isBoundary(nx, ny))					continue;
			if(isOtherColor(nx, ny, color))			continue;
			if(isSameWithPrevNum(nx, ny, bx, by))	continue;
			
			if(dfs(nx,ny, x, y, color))	
				return true;
		}
		
		return false;
	}


	private static boolean isSameWithPrevNum(int nx, int ny, int bx, int by) {
		return nx == bx && ny == by;
	}


	private static boolean isOtherColor(int nx, int ny, char color) {
		return data[nx][ny] != color;
	}

	private static boolean isBoundary(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < m);
	}
}

