package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sum_of_array {
	
	static StringTokenizer st;

	static int arr_prev[];
	static int arr_after[];
	static int arr_result[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		
		arr_prev = new int[n];
		arr_after = new int[m];
		arr_result = new int[n + m];

		insertData(br.readLine(), arr_prev);
		insertData(br.readLine(), arr_after);
		
		solve(arr_prev, arr_after, n, m);
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	private static void insertData(String str, int[] arr) {
		st = new StringTokenizer(str);
		for (int idx = 0; idx < arr.length; idx++) {
			arr[idx] = stoi(st.nextToken());
		}
	}
	
	private static void solve(int[] arr_prev, int[] arr_after, int size_prev, int size_after) {
		arr_result = new int[size_prev + size_after];
		
		int idx = 0;
		for (int i = 0; i < (size_prev + size_after); i++) {
			if(idx < size_prev)	arr_result[idx++] = arr_prev[i];
			else				arr_result[idx++] = arr_after[i - size_prev];	
		}
		
		Arrays.sort(arr_result);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr_result.length; i++) {
			sb.append(arr_result[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
