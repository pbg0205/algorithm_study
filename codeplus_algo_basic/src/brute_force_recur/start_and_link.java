package brute_force_recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class start_and_link {
	
	static int[][] matches;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		matches = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for (int row = 1; row <= n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int col = 1; col <= n; col++)
				matches[row][col] = Integer.parseInt(st.nextToken());
		}
		
		combination(1, 0, n);
		
		System.out.println(min);
		
		br.close();
	}
	
	public static void combination(int start, int depth, int n) {
		if(depth == n/2) {
			min = Math.min(min, getDifference(n));
			return;
		}
		
		for (int idx = start; idx <= n; idx++) {
			if(visited[idx] != true) {
				visited[idx] = true;
				combination(idx+1, depth+1, n);
				visited[idx] = false;
			}
		}
	}

	private static int getDifference(int n) {
		int sum_start = 0;
		int sum_link = 0;
		
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if(visited[row] && visited[col])
					sum_start += matches[row][col];
				
				if(visited[row] == false && visited[col] == false)
					sum_link += matches[row][col];
				
			}
		}			
		
        return Math.abs(sum_start - sum_link);
	}
}
