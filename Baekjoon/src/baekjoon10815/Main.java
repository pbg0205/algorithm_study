package baekjoon10815;
/*
 * @problem		숫자카드(10815)
 * @url			https://www.acmicpc.net/problem/10815
 * @author		pbg0205
 */

import java.io.*;
import java.util.*;

class Main {
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] inputArr;
	static int[] compareArr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = stoi(br.readLine());
		inputArr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		inputData(n, inputArr);
		
		int m = stoi(br.readLine());
		compareArr = new int[m];

		st = new StringTokenizer(br.readLine());
		inputData(m, compareArr);
	
		Arrays.sort(inputArr);
		
		for (int idx = 0; idx < m; idx++) {
			int left = 0;
			int right = n - 1;
			
			long target = compareArr[idx];
			binarySearch(target, left, right);
		}
		
		System.out.print(sb);
		
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static void binarySearch(long target,int pl, int pr) {
		int ans = 0;
		
		while(pl <= pr){
			int pc = (pl + pr) /2;
			if(inputArr[pc] > target) {
				pr = pc - 1;
				ans = 0;
			}else if(inputArr[pc] < target) {
				pl = pc + 1;
				ans = 0;
			}else {
				ans = 1;
				break;
			}
		}
		sb.append(ans + " ");
	}

	public static void inputData(int length, int[] Arr) {
		for (int idx = 0; idx < length; idx++) {
			Arr[idx] = stoi(st.nextToken());
		}
	}
}
