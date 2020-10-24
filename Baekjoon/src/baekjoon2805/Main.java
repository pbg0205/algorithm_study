package baekjoon2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @Problem		{나무 자르기(2805)}
 * @Author		{pbg0205}
 * @Create by	{08.25.2020}
 * @starTime	{PM 10:00}
 * @endTime		{PM 10:31}
*/
class Main {
	
	static long[] trees_height;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		trees_height = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < n; idx++) {
			trees_height[idx] = Long.parseLong(st.nextToken());
		}		
		
		long pl = 0;
		long pr = -1;
		for (int idx = 0; idx < n; idx++) {
			if(pr < trees_height[idx])	pr = trees_height[idx];
		}
		
		while(pl <= pr) {
			long pc = (pl + pr) / 2;
			long cutSum = 0;
			
			for (int idx = 0; idx < n; idx++) {
				if(trees_height[idx] < pc) {
					continue;
				}
				cutSum += trees_height[idx] - pc;
			}
			
			
			if (cutSum >= m) {
				/* 너무 짧게 잘른 상태이므로,크기를 늘려야 한다. */
				pl = pc + 1;
			}
			
			if(cutSum < m) {
				/* 너무 길게 잘른 상태이므로,크기를 줄여야 한다. */
				pr = pc - 1;
			}
		}
		
		System.out.println(pr);
	}
}
