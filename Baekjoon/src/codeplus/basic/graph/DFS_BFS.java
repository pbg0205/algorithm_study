package codeplus.basic.graph;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS {

	static int[][] check;
	static boolean[] checked;
	static int n;
	static int m;
	static int start;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();

		check = new int[1001][1001]; 
		checked = new boolean[1001]; 

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			check[x][y] = check[y][x] = 1;
		}

		dfs(start);

		checked = new boolean[1001];
		System.out.println();

		bfs();
	}

	public static void dfs(int x) {
		checked[x] = true;
		System.out.print(x + " ");

		for (int y = 1; y <= n; y++) {
			if (check[x][y] == 1 && checked[y] == false) {
				dfs(y);
			}
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		checked[start] = true;
		System.out.print(start + " ");

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int y = 1; y <= n; y++) {
				if (check[temp][y] == 1 && checked[y] == false) {
					queue.offer(y);
					checked[y] = true;
					System.out.print(y + " ");
				}
			}
		}
	}
}
