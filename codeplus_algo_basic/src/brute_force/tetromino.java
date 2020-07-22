package brute_force;

import java.util.Scanner;
import java.util.Stack;

public class tetromino {
	static int n, m;
	static int ans = 0;
	
	static boolean[][] visited;
	static int[][] map;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				map[row][col] = sc.nextInt();
			}
			sc.nextLine();
		}
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
                dfs(row, col, 0, 1);
                check(row, col);
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}
	
	public static void dfs(int row, int col, int sum, int cnt) {
		
		if (cnt > 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			if (isBoundary(nx, ny) && !visited[nx][ny])
				dfs(nx, ny, sum + map[nx][ny], cnt + 1);
		}
		
		visited[row][col] = false;
		
	}
	
    public static void check(int row, int col) {
    	 
        int sum = map[row][col];
        int min = Integer.MAX_VALUE;
        int cnt = 1;
 
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (isBoundary(nx, ny)) {
                sum += map[nx][ny];
                cnt += 1;
                min = Math.min(min, map[nx][ny]);
            }
        }
        if (cnt > 4)
            sum -= min;
 
        ans = Math.max(ans, sum);
 
    }
 
    public static boolean isBoundary(int row, int col) {
        return (0 <= row && row < n) && (0 <= col && col < m);
    }
}

