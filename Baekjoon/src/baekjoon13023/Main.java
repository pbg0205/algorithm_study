package baekjoon13023;
/*
 * @problem		ABCDE(13023) : https://www.acmicpc.net/problem/13023
 * @author		pbg0205
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adjacent;
	static boolean[] visited;
	static boolean isAvailable;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n+1];
		adjacent = new ArrayList[n+1];

		for (int i = 0; i < n; i++)
			adjacent[i] = new ArrayList<Integer>();
		
		for (int idx = 1; idx <= m; idx++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjacent[a].add(b);
			adjacent[b].add(a);
		}

		for (int idx = 0; idx < n; idx++) {
			dfs(idx, 0);
			if(isAvailable)	break;
		}

		if (isAvailable) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

		br.close();
	}

	public static void dfs(int index, int count) {
		if (count >= 4) {
			isAvailable = true;
			return;
		}

		visited[index] = true;
		
		for (int i = 0; i < adjacent[index].size(); i++) {
			int location = adjacent[index].get(i);
			if (!visited[location]) {
				visited[location] = true;
				dfs(location, count+1);
				visited[location] = false;
			}
		}
		visited[index] = false;
	}
}
