package baekjoon10972;
/*
 * @problem		다음 순열(10972) : https://www.acmicpc.net/problem/10972
 * @author		pbg0205
 */
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] data;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx <= N; idx++)
			data[idx] = Integer.parseInt(st.nextToken());
		
		if(isNextPermutation(data)) {
			for (int i = 1; i <= N; i++)
				bw.write(String.valueOf(data[i]) + " ");
		}else {
			bw.write("-1");
		}
		
		br.close(); 
		bw.flush();
		bw.close();
	}
	
	public static boolean isNextPermutation(int[] data) {
		int prev = data.length - 1;
		while(prev > 1 && data[prev-1] >= data[prev]) {
			prev--;
		}
		
		if(prev <= 1) {
			return false;
		}
		
		int after = data.length - 1;
		while(data[prev-1] >= data[after]) {
			after--;
		}
		
		swap(data, prev-1, after);
		
		after = data.length - 1;
		while(prev < after) {
			swap(data, prev, after);
			prev++;
			after--;
		}
		
		return true;
	}
	
	public static void swap(int[] data, int prev, int next) {
		int temp = data[prev];
		data[prev] = data[next];
		data[next] = temp;
	}
}
