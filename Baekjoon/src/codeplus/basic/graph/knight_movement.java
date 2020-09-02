package codeplus.basic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class knight_movement {
	
	static int l;
	
	static int x_start, y_start;
	static int x_end, y_end;
	
	static boolean[][] visited;
	
	static int[] dx = {2, 2,-2,-2, 1, 1,-1,-1};
	static int[] dy = {1,-1, 1,-1, 2,-2, 2,-2};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_num = Integer.parseInt(br.readLine());
		
		
		for (int test_case = 1; test_case <= test_num; test_case++) {
			l = Integer.parseInt(br.readLine());
			
			visited = new boolean[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			x_start  = Integer.parseInt(st.nextToken());
			y_start  = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			x_end = Integer.parseInt(st.nextToken());
			y_end  = Integer.parseInt(st.nextToken());
			
			bfs(x_start, y_start);
		}
		
	}

	private static void bfs(int x, int y) {
		Queue<knight> queue = new LinkedList<>();
		int count = 0;
		queue.offer(new knight(x, y, 0));
		
		while(!queue.isEmpty()){
			
			knight kn = queue.poll();
			count = kn.count;
			
			if(kn.x == x_end && kn.y == y_end) {
				System.out.println(kn.count);
				return;
			}
			
			for (int idx = 0; idx < 8; idx++) {
				int nx = kn.x + dx[idx];
				int ny = kn.y + dy[idx];
				
				if(isBoundary(nx, ny)) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new knight(nx, ny, count + 1));
					}
				}
			}
		}
	
	}

	private static boolean isBoundary(int x, int y) {
		return 0 <= x && x < l && 0 <= y && y < l;
	}
	
}

class knight{
	int x;
	int y;
	int count;
	
	knight(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
