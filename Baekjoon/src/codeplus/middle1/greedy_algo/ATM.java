package codeplus.middle1.greedy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
	
	static int[] time;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int min = 0;
		time = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < n; idx++)
			time[idx] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(time);// Arrays.sort : quickSort로 진행

		int sum = 0;
		for (int idx = 0; idx < n; idx++) {
			min += time[idx];
			sum += min;
		}
		
		System.out.println(sum);
	}
}