package codeplus.basic.brute_force_nm;

import java.util.Scanner;

public class N_and_M_1 {
	static int n, m;
	static int[] data;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		data = new int[n];
		visited = new boolean[n+1];
		
		permutation_dfs(0);
		sc.close();
	}
	
	private static void permutation_dfs(int num) {
		if(num == m) {
			for (int i = 0; i < m; i++)
				System.out.print(data[i] + " ");
			
			System.out.println();
			return ;
		}
		//깊은 depth로 들어간 다음, 탈출하는 method - permutation
		//시작 : 1 → permutation 형태로 접근
		for (int idx = 1; idx <= n; idx++) {
			if(!visited[idx]) {
				visited[idx] = true;
				data[num] = idx;
				permutation_dfs(num + 1);
				visited[idx] = false;
			}
		}
	}
	
}
