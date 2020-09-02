package codeplus.basic.graph1_practice;

import java.util.Scanner;

public class two_dot_sc {

	static int n, m;

    static char[][] data;
    static boolean[][] visited;
    
    static int[] dx = {0, 0, 1,-1};
    static int[] dy = {1,-1, 0, 0};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        data = new char[n][m];
        visited = new boolean[n][m];

        for (int row = 0; row < n; ++row)
            data[row] = sc.next().toCharArray();
        
        boolean isCandidate = false;
        
        loop:
        for (int row = 0; row < n; ++row)
            for (int col = 0; col < m; ++col) {

                if (!visited[row][col]) {
                    isCandidate = dfs(row,col,-1,-1,data[row][col]);
                    if(isCandidate) {
                    	break loop;
                    }
                }
            }
        
        if(isCandidate)	System.out.println("Yes");
        else			System.out.println("No");
    }

    static boolean dfs(int x, int y, int bx, int by, char color) {

        if (visited[x][y]) return true;

        visited[x][y] = true;

        for (int idx = 0; idx < 4; ++idx) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            
            if (!isBoundary(nx, ny)) continue;
            if (isOtherColor(nx,ny, color)) continue;
            if (isSameWithPervNum(nx, ny, bx, by)) continue;

            if(dfs(nx, ny, x, y, color))
                return true;
        }
        
        return false;
    }

	private static boolean isSameWithPervNum(int nx, int ny, int bx, int by) {
		return nx == bx && ny == by;
	}

	private static boolean isOtherColor(int nx, int ny, char color) {
		return data[nx][ny] != color;
	}

	private static boolean isBoundary(int nx, int ny) {
		return (0 <= nx && nx < n) && (0 <= ny && ny < m);
	}
}

