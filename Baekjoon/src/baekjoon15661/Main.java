package baekjoon15661;
/*
 * @problem		링크와스타트(15661) : https://www.acmicpc.net/problem/15661
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static boolean[] visited;
	static int [][] data;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		data = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for (int row = 1; row <= n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 1; col <= n; col++) {
				data[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		combination(1, 0);
		System.out.println(min);
		
		br.close();
	}
	
	static void combination(int start, int depth) {
		if(depth == n/2) {
			min = Math.min(min, getDifference());
			return;
		}
		
		for (int idx = start; idx <= n; idx++) {
			if(visited[idx] != true) {
				visited[idx] = true;
				combination(idx+1,  depth+1);
				visited[idx] = false;
			}
		}
	}

	private static int getDifference() {
		int sum_start = 0;
		int sum_link = 0;
		
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if(visited[row] && visited[col])
					sum_start += data[row][col];
				
				if(visited[row] == false && visited[col] == false)
					sum_link += data[row][col];
				
			}
		}			
		
        return Math.abs(sum_start - sum_link);
	}
}
