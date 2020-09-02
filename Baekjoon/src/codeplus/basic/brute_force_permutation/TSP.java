package codeplus.basic.brute_force_permutation;

import java.io.*;
import java.util.StringTokenizer;

public class TSP {

	static int[][] map;
	static int[] path;
	static int min;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		path = new int[N];
		for (int idx = 1; idx < N; idx++)
			path[idx] = idx+1;

		map = new int[N + 1][N + 1];
		for (int row = 1; row <= N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 1; col <= N; col++)
				map[row][col] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE;

		do {
			boolean has_road = true;
			int sum = 0;
			
			for (int i = 1; i <= N-2; i++) {
				if (map[path[i]][path[i + 1]] == 0) {
					has_road = false;
				} else {
					sum += map[path[i]][path[i + 1]];
				}
			}

			if (has_road && map[1][path[1]] != 0 && map[path[N-1]][1] != 0) {
				sum += map[1][path[1]] + map[path[N-1]][1];
				if (min > sum) {
					min = sum;
				}
			}
		} while (isNextPermutation(path));

		bw.write(String.valueOf(min));
		br.close();
		bw.flush();
		bw.close();
	}

	public static boolean isNextPermutation(int[] path) {
		int prev = path.length - 1;
		while (prev > 1 && path[prev - 1] >= path[prev]) {
			prev--;
		}

		if (prev <= 1) {
			return false;
		}

		int after = path.length - 1;
		while (path[prev - 1] >= path[after]) {
			after--;
		}

		swap(path, prev - 1, after);

		after = path.length - 1;
		while (prev < after) {
			swap(path, prev, after);
			prev++;
			after--;
		}

		return true;
	}

	private static void swap(int[] path, int prev, int next) {
		int temp = path[prev];
		path[prev] = path[next];
		path[next] = temp;
	}
}