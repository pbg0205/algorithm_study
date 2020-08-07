package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class hide_and_seek4 {

	static int n, k;

	static int[] min;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		min = new int[100005];
		Arrays.fill(min, -1);

		parent = new int[100005];

		bfs(n, k, min);
		printPath(parent);
		
		br.close();
	}

	private static void printPath(int[] parent) {
		Stack<Integer> stack = new Stack<>();
		stack.push(k);
		int index = k;
		
		while(index != n) {
			stack.push(parent[index]);
			index = parent[index];
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	private static void bfs(int n, int k, int[] min) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
		int n_now = n;
		min[n_now] = 0;
		
		while (!q.isEmpty() && n_now != k) {
			n_now = q.poll();
			
			for (int location = 0; location < 3; location++) {
				int n_next = 0;

				if(location == 0)	n_next = n_now - 1;
				if(location == 1)	n_next = n_now + 1;
				if(location == 2)	n_next = n_now * 2;
				
				if (!isBoundary(n_next, location))	continue;

				if (min[n_next] == -1) {
					q.add(n_next);
					min[n_next] = min[n_now] + 1;
					parent[n_next] = n_now;
				}
			}
		}

		System.out.println(min[k]);
	}

	private static boolean isBoundary(int n_next , int location) {
		return 0 <= n_next && n_next <= 100000;
	}
}
