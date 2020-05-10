package intermediate;

import java.util.Scanner;

public class Stack1_findRoad {
	static int[][] roadMap;
	static boolean[] road_flag;
	static int find_flag;
	
	public static void dfs(int x) {
		if(find_flag == 1)
			return;
		if(x == 99) {
			find_flag = 1;
			return;
		}
		road_flag[x] = true;
		for(int i = 0; i < 100; i++) {
			if(road_flag[i] == false && roadMap[x][i] == 1) {
				//System.out.println(x);
				dfs(i);
			}
		}
		road_flag[x] = false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
		
		int testNum = sc.nextInt();
		int roadNum = sc.nextInt();
		sc.nextLine();
		
		roadMap = new int[100][100];
		road_flag = new boolean[100];
		find_flag = 0;
		
		for (int i = 0; i < roadNum; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			roadMap[x][y] = 1;
		}
		
		dfs(0);
		System.out.printf("#%d: %d\n",testCase , find_flag);
		
		}
		sc.close();
	}
}
