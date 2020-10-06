package baekjoon1707;
/*
 * @problem		이분 그래프(1707) : https://www.acmicpc.net/problem/1707
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[] visited_num;
	
	static int V;
	static int E;
	static boolean is_bipartite;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_num = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= test_num; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			map = new int[V+1][V+1];
			visited_num = new int[V+1];
			is_bipartite = true;
			
			int x, y;
			for (int idx = 1; idx <= E; idx++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				map[x][y] = map[y][x] = 1;
			}
			
			for (int idx = 1; idx <= V; idx++)
					dfs(idx);
			
			if(is_bipartite) System.out.println("YES");
			else			 System.out.println("NO");
		}
		
		
		br.close();
	}
	
	public static void dfs(int index) {
		Stack<Integer> stack = new Stack<>();
		stack.push(index);

		visited_num[index]++;
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();

			for (int i = 1; i <= V; i++) {
				if(map[cur][i] == 1 && visited_num[i] == 0){
					visited_num[i]++;
					stack.push(i);
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(i + ":" + visited_num[i]);
			if(visited_num[i] > 2) {
				is_bipartite = false;
			}
		}
		System.out.println();
	}
}
