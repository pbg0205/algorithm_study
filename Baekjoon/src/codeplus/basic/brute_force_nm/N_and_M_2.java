package codeplus.basic.brute_force_nm;

import java.util.Scanner;

public class N_and_M_2 {
	static int N, M;
	static int data[];
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		data = new int[N+1];
		visited = new boolean[N+1];
		
		combination_dfs(1,0);
		
		
		sc.close();
	}
	//재귀함수를 이용한 dfs방법
	private static void combination_dfs(int start, int num) {
		if(num == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//깊은 depth 탐색 → 탈출 → 이전 depth 탐색 순으로 진행(dfs)
		//시작 : start : combination 형태로 접근 가능
		for (int idx = start; idx <= N; idx++) {
			if(!visited[idx]) {
				visited[idx] = true;
				data[num] = idx;
				combination_dfs(idx+1, num+1);
				visited[idx] = false;
			}
		}
		
	}
}
