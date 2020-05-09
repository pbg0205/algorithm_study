package intermediate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue1_maze1 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static Queue<Integer> qx = new LinkedList<>();
	static Queue<Integer> qy = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for(int testcase = 1; testcase <= 10; testcase++) {
			map = new int[16][16];
			visited = new boolean[16][16];
			int target_x = 0;
			int target_y = 0;
			int test_num = Integer.parseInt(sc.nextLine());

			for(int i = 0; i < 16; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) -48;
					if(map[i][j] == 3) {
						target_x = i;
						target_y = j;
					}
				}
			}
			
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if(map[i][j] == 2) {
						visited[i][j] = true;
						qx.add(i);
						qy.add(j);
					}
				}
			}
			
			while(!qy.isEmpty()) {
				int x = qx.poll();
				int y = qy.poll();
				
				for(int i = 0 ; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx >= 0 && ny >= 0 && ny <16 
								&& map[nx][ny] != 1 && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						qx.add(nx);
						qy.add(ny);
					}
				}
			}
			
			if(visited[target_x][target_y] == true) {
				System.out.println("#" + testcase +  " " + 1);
			}else {
				System.out.println("#" + testcase + " " + 0);
			}
		}
		
		
		sc.close();
	}
}
