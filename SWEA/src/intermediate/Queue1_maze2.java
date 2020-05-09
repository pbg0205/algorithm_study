package intermediate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue1_maze2 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Integer> qx = new LinkedList<>();
	static Queue<Integer> qy = new LinkedList<>();	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int testcase = 1; testcase <=10; testcase++) {
			map = new int[100][100];
			visited = new boolean[100][100];
			int target_x = 0;
			int target_y = 0;
			int test_num = Integer.parseInt(sc.nextLine());
			//1.값을map배열에 입력하고, 방문여부를 visited 배열에 첨부한다.
			//2. 도착지점을 확인하여 값을 입력한다.
			for(int i = 0; i < 100; i++) {
				String line = sc.nextLine();
				for(int j = 0 ; j < 100; j++) {
					map[i][j] = line.charAt(j) - 48;
					if(map[i][j] == 3) {
						target_x = i;
						target_y = j;
					}
				}
			}
			//2.완전 탐색하여 출발점을 확인하고, 시작점의 좌표를 qx,qy queue에 첨가한다.
			for(int i = 0 ; i < 100; i++) {
				for(int j = 0 ; j < 100; j++) {
					if(map[i][j] == 2) {
						visited[i][j] = true;
						qx.add(i);
						qy.add(j);
					}
				}
			}
			//3.값이 방향이 존재하지 않을때까지 방향에 따라서 위치를 찾아간다.
			while(!qy.isEmpty()) {
				int x = qx.poll();
				int y = qy.poll();
				
				for(int i = 0 ; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx >= 0 && ny >= 0 && ny < 100
							&&map[nx][ny] != 1 && visited[nx][ny] == false) {
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
