package baekjoon11724;
/*
 * @problem		연결 요소의 개수(11724) : https://www.acmicpc.net/problem/11724
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_recur {
	
	static int[][] map;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int element_cnt = 0;
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = map[y][x] = 1;
		}
		
		for (int x = 1; x <= n; x++) {
			if(!visited[x]) {
				System.out.println(x);
				dfs(x);
				element_cnt++;
			}
		}
		
		System.out.println(element_cnt);
	}
	
	public static void dfs(int index) {
		Stack<Integer> stack = new Stack<>();
		if(visited[index]) {
			return ;
		}
		
		stack.push(index);
		visited[index] = true;
		
		for (int y = 1; y <= n; y++) {
			if(map[index][y] == 1 && !visited[y]) {
				stack.push(y);
			}
		}
		
		while(!stack.isEmpty()) {
			dfs(stack.pop());
		}
	}
}
