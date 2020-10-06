package baekjoon10819;
/*
 * @problem		차이를 최대로(10819) : https://www.acmicpc.net/problem/10973
 * @author		pbg0205
 */
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int[] data;
	static int N;
	static int MaxDifference;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new int[N + 1];
		for (int idx = 1; idx <= N; idx++)
			data[idx] = Integer.parseInt(st.nextToken());

		getMaxDiffrence(data, 1);
		bw.write(String.valueOf(MaxDifference));

		br.close();
		bw.flush();
		bw.close();
	}

	private static void getMaxDiffrence(int[] data, int start) {

		if (start == N) {
			return;
		}

		for (int right = start + 1; right <= N; right++) {
			swap(data, start, right);
			
			int temp_max = 0;
			for (int idx = 1; idx <= N-1; idx++)
				temp_max += Math.abs(data[idx] - data[idx+1]);
			
			MaxDifference = Math.max(MaxDifference, temp_max);
			
			getMaxDiffrence(data, start+1);
			
			swap(data, start, right);
		}
	}

	private static void swap(int[] data, int start, int right) {
		int temp = data[right];
		data[right] = data[start];
		data[start] = temp;
	}
}
