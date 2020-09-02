package codeplus.basic.brute_force_permutation;

import java.io.*;
import java.util.StringTokenizer;

public class prev_permutation {
	static int[] data;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx <= N; idx++)
			data[idx] = Integer.parseInt(st.nextToken());
		
		if(isPreviousPermutation(data)) {
			for (int idx = 1; idx <= N; idx++) {
				bw.write(String.valueOf(data[idx]) + " ");
			}
		}else {
			bw.write("-1");
		}
		
		br.close();
		bw.flush();
		bw.close(); 
	}
	private static boolean isPreviousPermutation(int[] data) {
		int prev = data.length - 1;
		while(prev > 1 && data[prev-1] <= data[prev])
			prev--;
		
		if(prev <= 1) {
			return false;
		}
		
		int after = data.length -1;
		while(data[prev-1] < data[after])
			after--;
		
		swap(data, prev-1, after);
		
		after = data.length - 1;
		while(prev < after) {
			swap(data, prev, after);
			prev++;
			after--;
		}
		
		return true;
	}
	private static void swap(int[] data, int prev, int after) {
		int temp = data[prev];
		data[prev] = data[after];
		data[after] = temp;
	}
}
