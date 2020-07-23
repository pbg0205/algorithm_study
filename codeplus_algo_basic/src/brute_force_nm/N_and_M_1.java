package brute_force_nm;

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
		
		getPair(0);
		sc.close();
	}
	
	private static void getPair(int num) {
		if(num == m) {
			for (int i = 0; i < m; i++)
				System.out.print(data[i] + " ");
			
			System.out.println();
			return ;
		}
		
		for (int idx = 1; idx <= n; idx++) {
			if(!visited[idx]) {
				visited[idx] = true;
				data[num] = idx;
				getPair(num + 1);
				visited[idx] = false;
			}
		}
	}
	
}
